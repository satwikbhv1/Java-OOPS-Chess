package com.schess.game;

import com.schess.pieces.Pawn;
import com.schess.pieces.Queen;

@FunctionalInterface
public interface PromotionHandler {
    Queen promote(Pawn pawn, Position to);
}
