public class Pawn extends AbstractPiece
{
	public Pawn(int x, int y, PieceColor s)
	{
		super(x, y, s, PieceType.PAWN);
	}
	public boolean isValidMove1(int desx, PieceColor s)
	{
		int X = desx - getRow();
		if(s == PieceColor.WHITE)
		{
			if(getRow() == 6 && X == -2)
			{
				return true;
			}
		}
		if(s == PieceColor.BLACK)
		{
			X = X * -1;
			if(getRow() == 1 && X == -2)
			{
				return true;
			}
		}
		if(X == -1)
		{
			return true;
		}
		return false;
	}
	public boolean isValidMove2(int desx, int desy, PieceColor s)
	{
		int X = desx - getRow();
		int Y = desy - getCol();
		if(s == PieceColor.WHITE)
		{
			if(getRow() == 6 && X == -2 && (Y == 1 || Y == -1))
			{
				return true;
			}
		}
		if(s == PieceColor.BLACK && (Y == 1 || Y == -1))
		{
			X = X * -1;
			if(getRow() == 1 && X == -2)
			{
				return true;
			}
		}
		if(X == -1)
		{
			return true;
		}
		return false;
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
