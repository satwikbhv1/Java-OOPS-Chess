public class Queen extends AbstractPiece
{
	public Queen(int x, int y, PieceColor s)
	{
		super(x, y, s, PieceType.QUEEN);
	}
	public boolean isValidMove(int desx, int desy)
	{
		int X = Math.abs(desx - getRow());
		int Y = Math.abs(desy - getCol());
		if(X == Y)
		{
			return true;
		}
		if(((X * Y) == 0) && ((X + Y) != 0))
		{
			return true;
		}
		return false;
	}
}
