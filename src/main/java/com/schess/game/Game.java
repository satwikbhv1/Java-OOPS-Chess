package com.schess.game;

import com.schess.pieces.King;
import com.schess.pieces.Pawn;
import com.schess.pieces.Piece;
import com.schess.pieces.PieceColor;
import com.schess.pieces.Rook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private final Board board = new Board();
    private PieceColor sideToMove = PieceColor.WHITE;
    private final List<Piece> captured = new ArrayList<>();
    private final CastlingRights castling = new CastlingRights();
    private final MoveValidator moveValidator = new MoveValidator();

    public Board getBoard() {
        return board;
    }

    public PieceColor getSideToMove() {
        return sideToMove;
    }

    public int getSideFlag() {
        return sideToMove == PieceColor.WHITE ? 0 : 1;
    }

    public boolean isWhiteToMove() {
        return sideToMove == PieceColor.WHITE;
    }

    public CastlingRights getCastling() {
        return castling;
    }

    public MoveValidator getMoveValidator() {
        return moveValidator;
    }

    public List<Piece> getCaptured() {
        return Collections.unmodifiableList(captured);
    }

    public void reset() {
        board.clearAll();
        captured.clear();
        sideToMove = PieceColor.WHITE;
        castling.reset();
    }

    public boolean isInCheck(PieceColor side) {
        return moveValidator.isInCheck(board, side);
    }

    public boolean isInCheck() {
        return isInCheck(sideToMove);
    }

    public List<Move> getLegalMoves() {
        List<Move> legal = new ArrayList<>();
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Piece piece = board.get(new Position(r, c));
                if (piece != null && piece.getColor() == sideToMove) {
                    legal.addAll(moveValidator.filterLegal(
                            board, moveValidator.collectCandidateMoves(board, piece),
                            sideToMove, castling));
                }
            }
        }
        return legal;
    }

    public List<Move> getLegalMovesFrom(Position from) {
        Piece piece = board.get(from);
        if (piece == null || piece.getColor() != sideToMove) {
            return List.of();
        }
        return moveValidator.filterLegal(
                board, moveValidator.collectCandidateMoves(board, piece), sideToMove, castling);
    }

    public boolean isCheckmate() {
        return isInCheck(sideToMove) && !hasLegalMove();
    }

    public boolean isStalemate() {
        return !isInCheck(sideToMove) && !hasLegalMove();
    }

    public boolean isGameOver() {
        return !hasLegalMove();
    }

    public boolean hasLegalMove() {
        return moveValidator.hasLegalMove(board, sideToMove, castling);
    }

    public PieceColor getWinner() {
        if (!isCheckmate()) {
            return null;
        }
        return sideToMove == PieceColor.WHITE ? PieceColor.BLACK : PieceColor.WHITE;
    }

    public Position getKingPosition(PieceColor side) {
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

    public String getStatusMessage() {
        if (isGameOver()) {
            if (isInCheck()) {
                String winner = sideToMove == PieceColor.WHITE ? "Black" : "White";
                return winner + " wins by checkmate!";
            }
            return "Stalemate — draw.";
        }
        String side = sideToMove == PieceColor.WHITE ? "White" : "Black";
        if (isInCheck()) {
            return side + " to move — Check!";
        }
        return side + " to move";
    }

    public void applyMove(Move move) {
        Piece target = board.get(move.to());
        if (target != null) {
            captured.add(target);
        }
        board.move(move);
        updateCastling(move);
    }

    private void updateCastling(Move move) {
        Piece piece = board.get(move.to());
        if (piece == null) {
            return;
        }
        if (piece instanceof King) {
            if (piece.getColor() == PieceColor.WHITE) {
                castling.revokeWhiteKing();
            } else {
                castling.revokeBlackKing();
            }
        }
        if (piece instanceof Rook) {
            int col = move.from().col();
            if (piece.getColor() == PieceColor.WHITE) {
                if (col == 0) {
                    castling.revokeWhiteQueensideRook();
                } else if (col == 7) {
                    castling.revokeWhiteKingsideRook();
                }
            } else {
                if (col == 0) {
                    castling.revokeBlackQueensideRook();
                } else if (col == 7) {
                    castling.revokeBlackKingsideRook();
                }
            }
        }
    }

    public void completeTurn() {
        sideToMove = sideToMove == PieceColor.WHITE ? PieceColor.BLACK : PieceColor.WHITE;
    }

    public boolean tryPlayMove(Move move, PromotionHandler promotionHandler) {
        if (!moveValidator.isLegal(board, move, sideToMove, castling)) {
            return false;
        }

        Piece piece = board.get(move.from());

        if (piece instanceof King && isCastlingMove(move)) {
            applyCastling(move);
            completeTurn();
            return true;
        }

        if (piece instanceof Pawn pawn && pawn.isqueen()) {
            if (promotionHandler == null) {
                return false;
            }
            promotionHandler.promote(pawn, move.to());
            completeTurn();
            return true;
        }

        applyMove(move);
        completeTurn();
        return true;
    }

    private boolean isCastlingMove(Move move) {
        Position from = move.from();
        Position to = move.to();
        return from.row() == to.row() && Math.abs(to.col() - from.col()) == 2;
    }

    private void applyCastling(Move move) {
        Position from = move.from();
        Position to = move.to();
        int row = from.row();
        int dc = to.col() - from.col();

        applyMove(move);
        if (dc == 2) {
            applyMove(new Move(new Position(row, 7), new Position(row, to.col() - 1)));
        } else {
            applyMove(new Move(new Position(row, 0), new Position(row, to.col() + 1)));
        }
    }
}
