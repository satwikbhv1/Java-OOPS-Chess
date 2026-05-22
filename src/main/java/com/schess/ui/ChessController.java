package com.schess.ui;

import com.schess.game.Board;
import com.schess.game.Game;
import com.schess.game.Move;
import com.schess.game.Position;
import com.schess.game.PromotionHandler;
import com.schess.pieces.Bishop;
import com.schess.pieces.King;
import com.schess.pieces.Knight;
import com.schess.pieces.Pawn;
import com.schess.pieces.Piece;
import com.schess.pieces.PieceColor;
import com.schess.pieces.Queen;
import com.schess.pieces.Rook;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChessController {
    private final Game game = new Game();
    private final PieceRegistry pieceRegistry = new PieceRegistry();
    private CapturedPanel capturedByWhite;
    private CapturedPanel capturedByBlack;

    private final Knight k1 = new Knight(7, 1, PieceColor.WHITE);
    private final Knight k2 = new Knight(7, 6, PieceColor.WHITE);
    private final Bishop b1 = new Bishop(7, 2, PieceColor.WHITE);
    private final Bishop b2 = new Bishop(7, 5, PieceColor.WHITE);
    private final Rook r1 = new Rook(7, 0, PieceColor.WHITE);
    private final Rook r2 = new Rook(7, 7, PieceColor.WHITE);
    private final King k = new King(7, 4, PieceColor.WHITE);
    private final Queen q = new Queen(7, 3, PieceColor.WHITE);
    private final Pawn p1 = new Pawn(6, 0, PieceColor.WHITE);
    private final Pawn p2 = new Pawn(6, 1, PieceColor.WHITE);
    private final Pawn p3 = new Pawn(6, 2, PieceColor.WHITE);
    private final Pawn p4 = new Pawn(6, 3, PieceColor.WHITE);
    private final Pawn p5 = new Pawn(6, 4, PieceColor.WHITE);
    private final Pawn p6 = new Pawn(6, 5, PieceColor.WHITE);
    private final Pawn p7 = new Pawn(6, 6, PieceColor.WHITE);
    private final Pawn p8 = new Pawn(6, 7, PieceColor.WHITE);

    private final Knight bk1 = new Knight(0, 1, PieceColor.BLACK);
    private final Knight bk2 = new Knight(0, 6, PieceColor.BLACK);
    private final Bishop bb1 = new Bishop(0, 2, PieceColor.BLACK);
    private final Bishop bb2 = new Bishop(0, 5, PieceColor.BLACK);
    private final Rook br1 = new Rook(0, 0, PieceColor.BLACK);
    private final Rook br2 = new Rook(0, 7, PieceColor.BLACK);
    private final King bk = new King(0, 4, PieceColor.BLACK);
    private final Queen bq = new Queen(0, 3, PieceColor.BLACK);
    private final Pawn bp1 = new Pawn(1, 0, PieceColor.BLACK);
    private final Pawn bp2 = new Pawn(1, 1, PieceColor.BLACK);
    private final Pawn bp3 = new Pawn(1, 2, PieceColor.BLACK);
    private final Pawn bp4 = new Pawn(1, 3, PieceColor.BLACK);
    private final Pawn bp5 = new Pawn(1, 4, PieceColor.BLACK);
    private final Pawn bp6 = new Pawn(1, 5, PieceColor.BLACK);
    private final Pawn bp7 = new Pawn(1, 6, PieceColor.BLACK);
    private final Pawn bp8 = new Pawn(1, 7, PieceColor.BLACK);

    public Game getGame() {
        return game;
    }

    public void setCapturedPanels(CapturedPanel capturedByWhite, CapturedPanel capturedByBlack) {
        this.capturedByWhite = capturedByWhite;
        this.capturedByBlack = capturedByBlack;
    }

    public void startGame(BoardPanel boardPanel) {
        newGame(boardPanel);
    }

    public void newGame(BoardPanel boardPanel) {
        game.reset();
        pieceRegistry.clear();
        setupBoard();
        registerPieces();
        boardPanel.resetClickState();
        refreshBoard(boardPanel);
    }

    public boolean handleSelect(int row, int col, BoardPanel boardPanel) {
        if (game.isGameOver()) {
            boardPanel.clearSelection();
            return false;
        }
        Position from = new Position(row, col);
        List<Move> legal = game.getLegalMovesFrom(from);
        if (legal.isEmpty()) {
            boardPanel.clearSelection();
            return false;
        }
        boardPanel.setSelection(row, col, destinations(legal));
        return true;
    }

    public boolean handleMove(int fromRow, int fromCol, int toRow, int toCol, BoardPanel boardPanel) {
        if (game.isGameOver()) {
            return false;
        }
        Move move = new Move(new Position(fromRow, fromCol), new Position(toRow, toCol));
        PromotionHandler promotionHandler = (pawn, to) ->
                pieceRegistry.promote(pawn, to, game.getBoard());
        if (game.tryPlayMove(move, promotionHandler)) {
            refreshBoard(boardPanel);
            return true;
        }
        handleSelect(fromRow, fromCol, boardPanel);
        return false;
    }

    public String getStatusMessage() {
        return game.getStatusMessage();
    }

    public boolean isGameOver() {
        return game.isGameOver();
    }

    private static Set<Position> destinations(List<Move> moves) {
        Set<Position> dests = new HashSet<>();
        for (Move move : moves) {
            dests.add(move.to());
        }
        return dests;
    }

    private void refreshBoard(BoardPanel boardPanel) {
        boardPanel.clearSelection();
        boardPanel.syncFromBoard(game.getBoard(), pieceRegistry, game);
        boardPanel.setInputEnabled(!game.isGameOver());
        syncCapturedPanels();
    }

    private void syncCapturedPanels() {
        if (capturedByWhite != null) {
            capturedByWhite.sync(game.getCaptured(), pieceRegistry, PieceColor.WHITE);
        }
        if (capturedByBlack != null) {
            capturedByBlack.sync(game.getCaptured(), pieceRegistry, PieceColor.BLACK);
        }
    }

    private void setupBoard() {
        Board board = game.getBoard();
        board.set(new Position(7, 4), k);
        board.set(new Position(7, 3), q);
        board.set(new Position(7, 1), k1);
        board.set(new Position(7, 6), k2);
        board.set(new Position(7, 2), b1);
        board.set(new Position(7, 5), b2);
        board.set(new Position(7, 0), r1);
        board.set(new Position(7, 7), r2);
        board.set(new Position(6, 0), p1);
        board.set(new Position(6, 1), p2);
        board.set(new Position(6, 2), p3);
        board.set(new Position(6, 3), p4);
        board.set(new Position(6, 4), p5);
        board.set(new Position(6, 5), p6);
        board.set(new Position(6, 6), p7);
        board.set(new Position(6, 7), p8);
        board.set(new Position(0, 4), bk);
        board.set(new Position(0, 3), bq);
        board.set(new Position(0, 1), bk1);
        board.set(new Position(0, 6), bk2);
        board.set(new Position(0, 2), bb1);
        board.set(new Position(0, 5), bb2);
        board.set(new Position(0, 0), br1);
        board.set(new Position(0, 7), br2);
        board.set(new Position(1, 0), bp1);
        board.set(new Position(1, 1), bp2);
        board.set(new Position(1, 2), bp3);
        board.set(new Position(1, 3), bp4);
        board.set(new Position(1, 4), bp5);
        board.set(new Position(1, 5), bp6);
        board.set(new Position(1, 6), bp7);
        board.set(new Position(1, 7), bp8);
    }

    private void registerPieces() {
        registerPiece(k, "King");
        registerPiece(q, "Queen");
        registerPiece(k1, "Knight1");
        registerPiece(k2, "Knight2");
        registerPiece(b1, "Bishop1");
        registerPiece(b2, "Bishop2");
        registerPiece(r1, "Rook1");
        registerPiece(r2, "Rook2");
        registerPiece(p1, "Pawn1");
        registerPiece(p2, "Pawn2");
        registerPiece(p3, "Pawn3");
        registerPiece(p4, "Pawn4");
        registerPiece(p5, "Pawn5");
        registerPiece(p6, "Pawn6");
        registerPiece(p7, "Pawn7");
        registerPiece(p8, "Pawn8");
        registerPiece(bk, "B.King");
        registerPiece(bq, "B.Queen");
        registerPiece(bk1, "B.Knight1");
        registerPiece(bk2, "B.Knight2");
        registerPiece(bb1, "B.Bishop1");
        registerPiece(bb2, "B.Bishop2");
        registerPiece(br1, "B.Rook1");
        registerPiece(br2, "B.Rook2");
        registerPiece(bp1, "B.Pawn1");
        registerPiece(bp2, "B.Pawn2");
        registerPiece(bp3, "B.Pawn3");
        registerPiece(bp4, "B.Pawn4");
        registerPiece(bp5, "B.Pawn5");
        registerPiece(bp6, "B.Pawn6");
        registerPiece(bp7, "B.Pawn7");
        registerPiece(bp8, "B.Pawn8");
    }

    private void registerPiece(Piece piece, String tooltip) {
        pieceRegistry.register(
                piece,
                PieceIconFactory.get(piece.getType(), piece.getColor()),
                tooltip);
    }
}
