import java.util.List;

public interface Piece {
    PieceColor getColor();
    PieceType getType();
    Position getPosition();
    void setPosition(Position position);

    default int getRow() { return getPosition().row(); }
    default int getCol() { return getPosition().col(); }

    boolean canMoveTo(Board board, Position to);
    List<Move> getMoves(Board board);
}
