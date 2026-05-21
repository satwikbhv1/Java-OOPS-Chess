public class Knight extends Coins
{
	public Knight(int x,int y,String s)
	{
		super(x,y,s);	
	}
	public boolean isValidMove(int desx,int desy)
	{
		int X = Math.abs(desx-x);
		int Y = Math.abs(desy-y);
		if(desx==x||desy==y)
		{
			return false;
		}
		else if (X+Y==3)
		{
			return true;
		}
		return false;
	}
	public void setXY(int x,int y)
	{
		super.x=x;
		super.y=y;
	}
}
