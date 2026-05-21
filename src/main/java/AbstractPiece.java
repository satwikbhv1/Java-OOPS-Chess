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
}
