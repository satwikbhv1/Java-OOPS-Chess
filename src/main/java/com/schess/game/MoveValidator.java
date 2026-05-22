package com.schess.game;

import com.schess.pieces.King;
import com.schess.pieces.Pawn;
import com.schess.pieces.Piece;
import com.schess.pieces.PieceColor;
import com.schess.pieces.Queen;
import com.schess.pieces.Rook;

import java.util.ArrayList;
import java.util.List;

public class MoveValidator {

    public boolean isInCheck(Board board, PieceColor side) {
        Position kingSquare = findKing(board, side);
        if (kingSquare == null) {
            return false;
        }
        return isSquareAttacked(board, kingSquare, opposite(side));
    }

    public boolean hasLegalMove(Board board, PieceColor side, CastlingRights castling) {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Piece piece = board.get(new Position(r, c));
                if (piece == null || piece.getColor() != side) {
                    continue;
                }
                for (Move move : collectCandidateMoves(board, piece)) {
                    if (isLegal(board, move, side, castling)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<Move> collectCandidateMoves(Board board, Piece piece) {
        List<Move> moves = new ArrayList<>(piece.getMoves(board));
        if (piece instanceof King) {
            Position from = board.findPosition(piece);
            if (from != null) {
                int row = from.row();
                int col = from.col();
                moves.add(new Move(from, new Position(row, col + 2)));
                moves.add(new Move(from, new Position(row, col - 2)));
            }
        }
        return moves;
    }

    public boolean isSquareAttacked(Board board, Position square, PieceColor attackerColor) {
        return isSquareAttackedBy(board, square, attackerColor);
    }

    public boolean isLegal(Board board, Move move, PieceColor side, CastlingRights castling) {
        Piece piece = board.get(move.from());
        if (piece == null || piece.getColor() != side) {
            return false;
        }

        if (!isPseudoLegal(board, move, piece, side, castling)) {
            return false;
        }

        BoardSnapshot snapshot = board.snapshot();
        try {
            applyForCheckTest(board, move, piece, side, castling);
            return !isInCheck(board, side);
        } finally {
            board.restore(snapshot);
        }
    }

    public List<Move> filterLegal(Board board, List<Move> moves, PieceColor side, CastlingRights castling) {
        List<Move> legal = new ArrayList<>();
        for (Move move : moves) {
            if (isLegal(board, move, side, castling)) {
                legal.add(move);
            }
        }
        return legal;
    }

    private boolean isPseudoLegal(Board board, Move move, Piece piece, PieceColor side, CastlingRights castling) {
        if (!isValidDestination(board, move, side)) {
            return false;
        }
        if (piece instanceof King king) {
            if (isCastlingMove(move)) {
                return isCastlingPseudoLegal(board, king, move, castling);
            }
        }
        return piece.canMoveTo(board, move.to());
    }

    private boolean isValidDestination(Board board, Move move, PieceColor side) {
        if (!board.isOccupied(move.to())) {
            return true;
        }
        Piece target = board.get(move.to());
        return target != null && target.getColor() != side;
    }

    private boolean isCastlingMove(Move move) {
        Position from = move.from();
        Position to = move.to();
        return from.row() == to.row() && Math.abs(to.col() - from.col()) == 2;
    }

    private boolean isCastlingPseudoLegal(Board board, King king, Move move, CastlingRights castling) {
        Position from = move.from();
        Position to = move.to();
        if (from.row() != to.row()) {
            return false;
        }

        int dc = to.col() - from.col();
        if (Math.abs(dc) != 2) {
            return false;
        }

        PieceColor color = king.getColor();
        int row = from.row();

        if (dc == 2) {
            if (color == PieceColor.WHITE && !castling.canWhiteCastleKingside()) {
                return false;
            }
            if (color == PieceColor.BLACK && !castling.canBlackCastleKingside()) {
                return false;
            }
            if (board.isOccupied(new Position(row, from.col() + 1))) {
                return false;
            }
            return rookAt(board, row, 7, color) != null;
        }

        if (color == PieceColor.WHITE && !castling.canWhiteCastleQueenside()) {
            return false;
        }
        if (color == PieceColor.BLACK && !castling.canBlackCastleQueenside()) {
            return false;
        }
        if (board.isOccupied(new Position(row, from.col() - 1))
                || board.isOccupied(new Position(row, from.col() - 2))
                || board.isOccupied(new Position(row, from.col() - 3))) {
            return false;
        }
        return rookAt(board, row, 0, color) != null;
    }

    private void applyForCheckTest(Board board, Move move, Piece piece, PieceColor side, CastlingRights castling) {
        if (piece instanceof King king && isCastlingMove(move)) {
            if (!isCastlingPseudoLegal(board, king, move, castling)) {
                return;
            }
            if (isInCheck(board, side)) {
                return;
            }
            if (!castlingPathSafe(board, move, side)) {
                return;
            }
            applyCastling(board, move, side);
            return;
        }
        if (piece instanceof Pawn pawn && pawn.isqueen()) {
            board.clear(move.from());
            board.set(move.to(), new Queen(move.to().row(), move.to().col(), pawn.getColor()));
            return;
        }
        board.move(move);
    }

    private boolean castlingPathSafe(Board board, Move move, PieceColor side) {
        Position from = move.from();
        int row = from.row();
        int dc = move.to().col() - from.col();
        PieceColor opponent = opposite(side);
        if (dc == 2) {
            for (int col = from.col(); col <= from.col() + 2; col++) {
                if (isSquareAttacked(board, new Position(row, col), opponent)) {
                    return false;
                }
            }
        } else {
            for (int col = from.col(); col >= from.col() - 2; col--) {
                if (isSquareAttacked(board, new Position(row, col), opponent)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void applyCastling(Board board, Move move, PieceColor side) {
        Position from = move.from();
        Position to = move.to();
        int row = from.row();
        int dc = to.col() - from.col();

        board.move(move);
        if (dc == 2) {
            board.move(new Move(new Position(row, 7), new Position(row, to.col() - 1)));
        } else {
            board.move(new Move(new Position(row, 0), new Position(row, to.col() + 1)));
        }
    }

    private Rook rookAt(Board board, int row, int col, PieceColor color) {
        Piece piece = board.get(new Position(row, col));
        if (piece instanceof Rook rook && rook.getColor() == color) {
            return rook;
        }
        return null;
    }

    private boolean isSquareAttackedBy(Board board, Position square, PieceColor attackerColor) {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Piece piece = board.get(new Position(r, c));
                if (piece == null || piece.getColor() != attackerColor) {
                    continue;
                }
                if (piece instanceof King) {
                    if (isKingAttackingSquare(piece.getPosition(), square)) {
                        return true;
                    }
                    continue;
                }
                if (piece.canMoveTo(board, square)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isKingAttackingSquare(Position from, Position to) {
        return Math.abs(from.row() - to.row()) <= 1
                && Math.abs(from.col() - to.col()) <= 1
                && !from.equals(to);
    }

    private Position findKing(Board board, PieceColor side) {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Piece piece = board.get(new Position(r, c));
                if (piece instanceof King && piece.getColor() == side) {
                    return new Position(r, c);
                }
            }
        }
        return null;
    }

    private static PieceColor opposite(PieceColor color) {
        return color == PieceColor.WHITE ? PieceColor.BLACK : PieceColor.WHITE;
    }
}
