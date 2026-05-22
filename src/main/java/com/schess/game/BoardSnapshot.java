package com.schess.game;

import com.schess.pieces.Piece;

import java.util.IdentityHashMap;
import java.util.Map;

public record BoardSnapshot(Piece[][] grid, Map<Piece, Position> positions) {
    public BoardSnapshot(Piece[][] grid, Map<Piece, Position> positions) {
        this.grid = copyGrid(grid);
        this.positions = new IdentityHashMap<>(positions);
    }

    private static Piece[][] copyGrid(Piece[][] source) {
        Piece[][] copy = new Piece[8][8];
        for (int r = 0; r < 8; r++) {
            System.arraycopy(source[r], 0, copy[r], 0, 8);
        }
        return copy;
    }
}
