public class Rook extends AbstractPiece
{
	Boolean b;
	public Rook(int x, int y, PieceColor s)
	{
		super(x, y, s, PieceType.ROOK);
		b = true;
	}
	public boolean isValidMove(int desx, int desy)
	{
		int X = Math.abs(desx - getRow());
		int Y = Math.abs(desy - getCol());
		if(((X * Y) == 0) && ((X + Y) != 0))
		{
			return true;
		}
		return false;
	}
	@Override
	public void setPosition(Position p)
	{
		super.setPosition(p);
		b = false;
	}
}
