public interface Piece {
    PieceColor getColor();
    PieceType getType();
    Position getPosition();
    void setPosition(Position position);

    default int getRow() { return getPosition().row(); }
    default int getCol() { return getPosition().col(); }
}
