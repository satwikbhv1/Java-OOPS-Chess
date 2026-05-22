public class King extends AbstractPiece
{
	public King(int x, int y, PieceColor s)
	{
		super(x, y, s, PieceType.KING);
	}
	public boolean isValidMove(int desx, int desy)
	{
		int X = Math.abs(desx - getRow());
		int Y = Math.abs(desy - getCol());
		if(X > 1 || Y > 1)
		{
			return false;
		}
		return true;
	}

	@Override
	public boolean canMoveTo(Board board, Position to) {
		return isValidMove(to.row(), to.col()) && isEnemyOrEmpty(board, to);
	}
}
