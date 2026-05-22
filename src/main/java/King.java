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
		if (!isValidMove(to.row(), to.col()) || !isEnemyOrEmpty(board, to)) {
			return false;
		}
		if (isAdjacentToEnemyKing(board, to)) {
			return false;
		}
		PieceColor opponent = getColor() == PieceColor.WHITE ? PieceColor.BLACK : PieceColor.WHITE;
		return !new MoveValidator().isSquareAttacked(board, to, opponent);
	}

	private boolean isAdjacentToEnemyKing(Board board, Position to) {
		for (int dr = -1; dr <= 1; dr++) {
			for (int dc = -1; dc <= 1; dc++) {
				if (dr == 0 && dc == 0) {
					continue;
				}
				int r = to.row() + dr;
				int c = to.col() + dc;
				if (r < 0 || r >= 8 || c < 0 || c >= 8) {
					continue;
				}
				Piece piece = board.get(new Position(r, c));
				if (piece instanceof King && piece.getColor() != getColor()) {
					return true;
				}
			}
		}
		return false;
	}
}
