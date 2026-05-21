public class Pawn extends Coins
{
	
	public Pawn(int x, int y, PieceColor s) 
	{
		super(x, y, s, PieceType.PAWN);
	}
	public void setXY(int x, int y)
	{
		super.x = x;
		super.y = y;
	}
	public boolean isValidMove1(int desx, PieceColor s)
	{
		int X = desx - x;
		if(s == PieceColor.WHITE)
		{
			if(x == 6 && X == -2) 
			{
				return true;
			}
		}
		if(s == PieceColor.BLACK)
		{
			X = X * -1;
			if(x == 1 && X == -2) 
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
		int X = desx - x;
		int Y = desy - y;
		if(s == PieceColor.WHITE)
		{
			if(x == 6 && X == -2 && (Y == 1 || Y == -1)) 
			{
				return true;
			}
		}
		if(s == PieceColor.BLACK && (Y == 1 || Y == -1))
		{
			X = X * -1;
			if(x == 1 && X == -2) 
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
		if(this.x == 1 && this.color == PieceColor.WHITE)
		{
			return true;
		}
		if(this.x == 6 && this.color == PieceColor.BLACK)
		{
			return true;
		}
		return false;
	}
}
