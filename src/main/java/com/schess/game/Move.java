package com.schess.game;

import com.schess.pieces.Piece;

public record Move(Position from, Position to, Piece captured) {
    public Move(Position from, Position to) {
        this(from, to, null);
    }
}
