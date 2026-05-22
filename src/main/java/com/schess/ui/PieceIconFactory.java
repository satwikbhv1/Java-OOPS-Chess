package com.schess.ui;

import com.schess.pieces.PieceColor;
import com.schess.pieces.PieceType;
import com.schess.pieces.Rook;

import java.util.EnumMap;
import java.util.Map;
import javax.swing.ImageIcon;

public final class PieceIconFactory {
    private static final Map<PieceType, Map<PieceColor, ImageIcon>> ICONS = new EnumMap<>(PieceType.class);

    static {
        loadIcons();
    }

    private PieceIconFactory() {}

    private static void loadIcons() {
        put(PieceType.KING, PieceColor.WHITE, "/images/king.png");
        put(PieceType.QUEEN, PieceColor.WHITE, "/images/queen.png");
        put(PieceType.ROOK, PieceColor.WHITE, "/images/Rook.png");
        put(PieceType.BISHOP, PieceColor.WHITE, "/images/bishop.png");
        put(PieceType.KNIGHT, PieceColor.WHITE, "/images/knight.png");
        put(PieceType.PAWN, PieceColor.WHITE, "/images/pawn.png");

        put(PieceType.KING, PieceColor.BLACK, "/images/blackking.png");
        put(PieceType.QUEEN, PieceColor.BLACK, "/images/blackqueen.png");
        put(PieceType.ROOK, PieceColor.BLACK, "/images/blackrook1.png");
        put(PieceType.BISHOP, PieceColor.BLACK, "/images/blackbishop.png");
        put(PieceType.KNIGHT, PieceColor.BLACK, "/images/blackknight1.jpg");
        put(PieceType.PAWN, PieceColor.BLACK, "/images/blackpawn1.jpg");
    }

    private static void put(PieceType type, PieceColor color, String resourcePath) {
        ICONS.computeIfAbsent(type, t -> new EnumMap<>(PieceColor.class))
                .put(color, load(resourcePath));
    }

    private static ImageIcon load(String resourcePath) {
        return new ImageIcon(PieceIconFactory.class.getResource(resourcePath));
    }

    public static ImageIcon get(PieceType type, PieceColor color) {
        return ICONS.get(type).get(color);
    }
}
