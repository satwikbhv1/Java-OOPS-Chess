package com.schess.pieces;

import com.schess.game.Board;
import com.schess.game.Position;

public class Knight extends AbstractPiece
{
	public Knight(int x, int y, PieceColor s)
	{
		super(x, y, s, PieceType.KNIGHT);
	}
	public boolean isValidMove(int desx, int desy)
	{
		int X = Math.abs(desx - getRow());
		int Y = Math.abs(desy - getCol());
		if(desx == getRow() || desy == getCol())
		{
			return false;
		}
		else if(X + Y == 3)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean canMoveTo(Board board, Position to) {
		return isValidMove(to.row(), to.col()) && isEnemyOrEmpty(board, to);
	}
}
