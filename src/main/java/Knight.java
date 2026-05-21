public class Knight extends AbstractPiece
{
	public Knight(int x, int y, PieceColor s)
	{
		super(x, y, s, PieceType.KNIGHT);
	}
	public boolean isValidMove(int desx, int desy)
	{
		int X = Math.abs(desx - x);
		int Y = Math.abs(desy - y);
		if(desx == x || desy == y)
		{
			return false;
		}
		else if(X + Y == 3)
		{
			return true;
		}
		return false;
	}
}
