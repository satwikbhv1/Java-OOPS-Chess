public class Rook extends Coins 
{
	Boolean b;
	public Rook(int x,int y,PieceColor s)
	{
		super(x, y, s, PieceType.ROOK);
		b= true;
	}
	public boolean isValidMove(int desx,int desy)
	{
		int X = Math.abs(desx-x);
		int Y = Math.abs(desy-y);
		if(((X*Y)==0)&&((X+Y)!=0))
		{
			return true;
		}
		return false;
	}
	public void setXY(int x,int y)
	{
		super.x=x;
		super.y=y;
		b = false;
	}
}
