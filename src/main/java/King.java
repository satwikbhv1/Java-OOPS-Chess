public class King extends Coins 
{
	Boolean b;
	public King(int x,int y,String s)
	{
		super(x,y,s);	
		b = true;
	}
	public boolean isValidMove(int desx,int desy)
	{
		int X = Math.abs(desx-x);
		int Y = Math.abs(desy-y);
		if(X>1 || Y>1)
		{
			return false;
		}
		return true;
	}
	public void setXY(int x,int y)
	{
		super.x=x;
		super.y=y;
		b = false;
	}
	public boolean check()
	{
		//yet to be completed
		return false;
	}
	public boolean checkmate()
	{
		//yet to be completed
		return false;
	}
}
