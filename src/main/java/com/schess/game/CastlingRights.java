package com.schess.game;

public class CastlingRights {
    private boolean whiteKing = true;
    private boolean whiteKingsideRook = true;
    private boolean whiteQueensideRook = true;
    private boolean blackKing = true;
    private boolean blackKingsideRook = true;
    private boolean blackQueensideRook = true;

    public boolean canWhiteCastleKingside() {
        return whiteKing && whiteKingsideRook;
    }

    public boolean canWhiteCastleQueenside() {
        return whiteKing && whiteQueensideRook;
    }

    public boolean canBlackCastleKingside() {
        return blackKing && blackKingsideRook;
    }

    public boolean canBlackCastleQueenside() {
        return blackKing && blackQueensideRook;
    }

    void revokeWhiteKing() {
        whiteKing = false;
    }

    void revokeWhiteKingsideRook() {
        whiteKingsideRook = false;
    }

    void revokeWhiteQueensideRook() {
        whiteQueensideRook = false;
    }

    void revokeBlackKing() {
        blackKing = false;
    }

    void revokeBlackKingsideRook() {
        blackKingsideRook = false;
    }

    void revokeBlackQueensideRook() {
        blackQueensideRook = false;
    }

    public void reset() {
        whiteKing = true;
        whiteKingsideRook = true;
        whiteQueensideRook = true;
        blackKing = true;
        blackKingsideRook = true;
        blackQueensideRook = true;
    }
}
