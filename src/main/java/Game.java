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
}
