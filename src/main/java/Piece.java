public interface Piece {
    PieceColor getColor();
    PieceType getType();
    int getRow();
    int getCol();
    void setPosition(int row, int col);
}
