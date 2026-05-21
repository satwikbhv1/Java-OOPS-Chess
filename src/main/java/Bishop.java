public class Bishop extends Coins
{
	public Bishop(int x,int y,String s)
	{
		super(x,y,s);	
	}
	public boolean isValidMove(int desx,int desy)
	{
		int X = Math.abs(desx-x);
		int Y = Math.abs(desy-y);
		if(X != Y)
		{
			return false;
		}	
		return true;
	}
	public void setXY(int x,int y)
	{
		super.x=x;
		super.y=y;
	}
}
