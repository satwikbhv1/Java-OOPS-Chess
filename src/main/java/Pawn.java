public class Pawn extends AbstractPiece
{
	public Pawn(int x, int y, PieceColor s)
	{
		super(x, y, s, PieceType.PAWN);
	}
	public boolean isValidMove1(int desx, PieceColor s)
	{
		int dr = desx - getRow();
		if (s == PieceColor.WHITE) {
			if (getRow() == 6 && dr == -2) {
				return true;
			}
			return dr == -1;
		}
		if (getRow() == 1 && dr == 2) {
			return true;
		}
		return dr == 1;
	}

	public boolean isValidMove2(int desx, int desy, PieceColor s)
	{
		int dr = desx - getRow();
		int dc = Math.abs(desy - getCol());
		if (dc != 1) {
			return false;
		}
		// both colors capture one rank toward the opponent (decreasing row index)
		return dr == -1;
	}
	public boolean isqueen()
	{
		if(getRow() == 1 && this.color == PieceColor.WHITE)
		{
			return true;
		}
		if(getRow() == 6 && this.color == PieceColor.BLACK)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean canMoveTo(Board board, Position to) {
		Position from = getPosition();
		if (to.col() == from.col()) {
			return !board.isOccupied(to) && isValidMove1(to.row(), color);
		}
		if (board.isOccupied(to) && isValidMove2(to.row(), to.col(), color)) {
			Piece target = board.get(to);
			return target != null && target.getColor() != getColor();
		}
		return false;
	}
}
