package com.schess.ui;

import com.schess.game.Board;
import com.schess.game.Position;
import com.schess.pieces.Pawn;
import com.schess.pieces.Piece;
import com.schess.pieces.PieceColor;
import com.schess.pieces.PieceType;
import com.schess.pieces.Queen;

import java.util.IdentityHashMap;
import java.util.Map;
import javax.swing.ImageIcon;

public class PieceRegistry {
    private final Map<Piece, PieceDisplay> displays = new IdentityHashMap<>();

    public void register(Piece piece, ImageIcon icon, String tooltip) {
        displays.put(piece, new PieceDisplay(icon, tooltip));
    }

    public PieceDisplay get(Piece piece) {
        return displays.get(piece);
    }

    public void clear() {
        displays.clear();
    }

    public Queen promote(Pawn pawn, Position to, Board board) {
        PieceColor color = pawn.getColor();
        ImageIcon icon = PieceIconFactory.get(PieceType.QUEEN, color);
        String tooltip = color == PieceColor.WHITE ? "Queen" : "B.Queen";
        PieceDisplay display = new PieceDisplay(icon, tooltip);
        Queen queen = new Queen(to.row(), to.col(), pawn.color);
        board.clear(pawn.getPosition());
        board.set(to, queen);
        displays.put(queen, display);
        return queen;
    }
}
