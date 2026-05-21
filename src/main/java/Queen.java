public class Queen extends Coins
{
	public Queen(int x,int y,String s)
	{
		super(x,y,s);	
	}
	public void setXY(int x,int y)
	{
		super.x=x;
		super.y=y;
	}
	public boolean isValidMove(int desx,int desy)
	{
		int X = Math.abs(desx-x);
		int Y = Math.abs(desy-y);
		if(X == Y)
		{
			return true;
		}
		if(((X*Y)==0)&&((X+Y)!=0))
		{
			return true;
		}
		return false;       
	}
}
