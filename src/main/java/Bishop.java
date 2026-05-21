public class Bishop extends AbstractPiece
{
	public Bishop(int x, int y, PieceColor s)
	{
		super(x, y, s, PieceType.BISHOP);
	}
	public boolean isValidMove(int desx, int desy)
	{
		int X = Math.abs(desx - getRow());
		int Y = Math.abs(desy - getCol());
		if(X != Y)
		{
			return false;
		}
		return true;
	}
}
