import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private final Board board = new Board();
    private PieceColor sideToMove = PieceColor.WHITE;
    private final List<Piece> captured = new ArrayList<>();
    private final CastlingRights castling = new CastlingRights();

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

    public List<Piece> getCaptured() {
        return Collections.unmodifiableList(captured);
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
        if (!isValidDestination(move)) {
            return false;
        }

        Piece piece = board.get(move.from());
        if (piece == null || piece.getColor() != sideToMove) {
            return false;
        }

        if (piece instanceof King king) {
            if (tryCastling(king, move)) {
                completeTurn();
                return true;
            }
        }

        if (!piece.canMoveTo(board, move.to())) {
            return false;
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

    private boolean isValidDestination(Move move) {
        if (!board.isOccupied(move.to())) {
            return true;
        }
        Piece target = board.get(move.to());
        return target != null && target.getColor() != sideToMove;
    }

    private boolean tryCastling(King king, Move move) {
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
            Rook rook = rookAt(row, 7, color);
            if (rook == null) {
                return false;
            }
            applyMove(move);
            applyMove(new Move(new Position(row, 7), new Position(row, to.col() - 1)));
            return true;
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
        Rook rook = rookAt(row, 0, color);
        if (rook == null) {
            return false;
        }
        applyMove(move);
        applyMove(new Move(new Position(row, 0), new Position(row, to.col() + 1)));
        return true;
    }

    private Rook rookAt(int row, int col, PieceColor color) {
        Piece piece = board.get(new Position(row, col));
        if (piece instanceof Rook rook && rook.getColor() == color) {
            return rook;
        }
        return null;
    }
}
