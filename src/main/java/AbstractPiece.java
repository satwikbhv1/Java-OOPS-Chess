public abstract class AbstractPiece implements Piece {
    public int x;
    public int y;
    public PieceColor color;
    public PieceType type;

    public AbstractPiece(int x, int y, PieceColor color, PieceType type) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.type = type;
    }

    @Override public PieceColor getColor() { return color; }
    @Override public PieceType getType() { return type; }
    @Override public int getRow() { return x; }
    @Override public int getCol() { return y; }

    @Override
    public void setPosition(int row, int col) {
        this.x = row;
        this.y = col;
    }
}
