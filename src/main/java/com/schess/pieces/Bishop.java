package com.schess.pieces;

import com.schess.game.Board;
import com.schess.game.Position;

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

	@Override
	public boolean canMoveTo(Board board, Position to) {
		return isValidMove(to.row(), to.col())
				&& board.isPathClear(getPosition(), to)
				&& isEnemyOrEmpty(board, to);
	}
}
