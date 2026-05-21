import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPiece implements Piece {
    private Position position;
    public PieceColor color;
    public PieceType type;

    public AbstractPiece(int row, int col, PieceColor color, PieceType type) {
        this.position = new Position(row, col);
        this.color = color;
        this.type = type;
    }

    @Override public PieceColor getColor() { return color; }
    @Override public PieceType getType() { return type; }
    @Override public Position getPosition() { return position; }

    @Override
    public void setPosition(Position p) {
        this.position = p;
    }

    @Override
    public List<Move> getMoves(Board board) {
        List<Move> moves = new ArrayList<>();
        Position from = getPosition();
        if (from.equals(Position.OFF_BOARD)) {
            return moves;
        }
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Position to = new Position(r, c);
                if (canMoveTo(board, to)) {
                    moves.add(new Move(from, to));
                }
            }
        }
        return moves;
    }

    protected boolean isEnemyOrEmpty(Board board, Position to) {
        if (!board.isOccupied(to)) {
            return true;
        }
        Piece target = board.get(to);
        return target.getColor() != getColor();
    }
}
