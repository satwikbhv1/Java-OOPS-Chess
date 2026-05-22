package com.schess.ui;

import com.schess.game.Board;
import com.schess.game.Game;
import com.schess.game.Position;
import com.schess.pieces.Piece;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BoardPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final Color LABEL_COLOR = new Color(0x5c5c5c);
    private static final Color CHECK_HIGHLIGHT = new Color(0xf4a6a6);
    private static final Color SELECTED_HIGHLIGHT = new Color(0xf6f669);
    private static final Color LEGAL_HIGHLIGHT = new Color(0xbaca44);

    private final JButton[][] square = new JButton[8][8];
    private final boolean[][] legalHighlight = new boolean[8][8];
    private MoveListener moveListener;
    private SelectListener selectListener;
    private boolean inputEnabled = true;
    private int fromRow = -1;
    private int fromCol = -1;
    private int selectedRow = -1;
    private int selectedCol = -1;
    private boolean awaitingDestination;
    private Game lastGame;

    public interface MoveListener {
        boolean onMove(int fromRow, int fromCol, int toRow, int toCol);
    }

    public interface SelectListener {
        boolean onSelect(int row, int col);
    }

    public BoardPanel() {
        setLayout(new GridBagLayout());
        buildLabeledBoard();
    }

    private void buildLabeledBoard() {
        GridBagConstraints corner = labelConstraints(0, 0);
        corner.weightx = 0;
        corner.weighty = 0;
        add(new JPanel(), corner);

        for (int col = 0; col < 8; col++) {
            GridBagConstraints top = labelConstraints(col + 1, 0);
            top.weightx = 1;
            add(createLabel(String.valueOf(fileLabel(col))), top);
        }

        GridBagConstraints cornerTopRight = labelConstraints(9, 0);
        add(new JPanel(), cornerTopRight);

        for (int row = 0; row < 8; row++) {
            GridBagConstraints left = labelConstraints(0, row + 1);
            left.weighty = 1;
            add(createLabel(rankLabel(row)), left);

            GridBagConstraints board = new GridBagConstraints();
            board.gridx = 1;
            board.gridy = row + 1;
            if (row == 0) {
                board.gridwidth = 8;
                board.gridheight = 8;
                board.weightx = 1;
                board.weighty = 1;
                board.fill = GridBagConstraints.BOTH;
                add(buildBoardGrid(), board);
            }

            GridBagConstraints right = labelConstraints(9, row + 1);
            right.weighty = 1;
            add(createLabel(rankLabel(row)), right);
        }

        GridBagConstraints cornerBottomLeft = labelConstraints(0, 9);
        add(new JPanel(), cornerBottomLeft);

        for (int col = 0; col < 8; col++) {
            GridBagConstraints bottom = labelConstraints(col + 1, 9);
            bottom.weightx = 1;
            add(createLabel(String.valueOf(fileLabel(col))), bottom);
        }

        GridBagConstraints cornerBottomRight = labelConstraints(9, 9);
        add(new JPanel(), cornerBottomRight);
    }

    private JPanel buildBoardGrid() {
        JPanel boardGrid = new JPanel(new GridLayout(8, 8));
        MouseAdapter handler = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                handlePress(e.getSource());
            }
        };

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                square[row][col] = new JButton();
                square[row][col].setOpaque(true);
                square[row][col].setBorderPainted(false);
                square[row][col].setBackground(squareColor(row, col));
                square[row][col].addMouseListener(handler);
                boardGrid.add(square[row][col]);
            }
        }
        return boardGrid;
    }

    private static GridBagConstraints labelConstraints(int gridx, int gridy) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.anchor = GridBagConstraints.CENTER;
        return gbc;
    }

    private static JLabel createLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setForeground(LABEL_COLOR);
        label.setFont(label.getFont().deriveFont(Font.PLAIN, 13f));
        return label;
    }

    private static char fileLabel(int col) {
        return (char) ('a' + col);
    }

    private static String rankLabel(int row) {
        return Integer.toString(8 - row);
    }

    public void setMoveListener(MoveListener listener) {
        this.moveListener = listener;
    }

    public void setSelectListener(SelectListener listener) {
        this.selectListener = listener;
    }

    public void setInputEnabled(boolean enabled) {
        this.inputEnabled = enabled;
        if (!enabled) {
            awaitingDestination = false;
            clearSelection();
        }
    }

    public void resetClickState() {
        awaitingDestination = false;
        fromRow = -1;
        fromCol = -1;
        clearSelection();
    }

    public void setSelection(int fromRow, int fromCol, Set<Position> legalDestinations) {
        clearLegalHighlights();
        this.selectedRow = fromRow;
        this.selectedCol = fromCol;
        if (legalDestinations != null) {
            for (Position pos : legalDestinations) {
                legalHighlight[pos.row()][pos.col()] = true;
            }
        }
        repaintSquareBackgrounds();
    }

    public void clearSelection() {
        selectedRow = -1;
        selectedCol = -1;
        clearLegalHighlights();
        repaintSquareBackgrounds();
    }

    private void clearLegalHighlights() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                legalHighlight[row][col] = false;
            }
        }
    }

    public void syncFromBoard(Board board, PieceRegistry registry, Game game) {
        lastGame = game;
        Position kingInCheck = game.isInCheck() ? game.getKingPosition(game.getSideToMove()) : null;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Position pos = new Position(row, col);
                square[row][col].setBackground(
                        backgroundColor(row, col, pos, kingInCheck));

                Piece piece = board.get(pos);
                if (piece == null) {
                    square[row][col].setIcon(null);
                    square[row][col].setToolTipText(null);
                } else {
                    PieceDisplay display = registry.get(piece);
                    if (display != null) {
                        square[row][col].setIcon(display.icon());
                        square[row][col].setToolTipText(display.tooltip());
                    }
                }
            }
        }
    }

    private void repaintSquareBackgrounds() {
        if (lastGame == null) {
            for (int row = 0; row < 8; row++) {
                for (int col = 0; col < 8; col++) {
                    square[row][col].setBackground(backgroundColor(row, col, new Position(row, col), null));
                }
            }
            return;
        }
        Position kingInCheck = lastGame.isInCheck()
                ? lastGame.getKingPosition(lastGame.getSideToMove())
                : null;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                square[row][col].setBackground(
                        backgroundColor(row, col, new Position(row, col), kingInCheck));
            }
        }
    }

    private Color backgroundColor(int row, int col, Position pos, Position kingInCheck) {
        if (kingInCheck != null && pos.equals(kingInCheck)) {
            return CHECK_HIGHLIGHT;
        }
        if (row == selectedRow && col == selectedCol) {
            return SELECTED_HIGHLIGHT;
        }
        if (legalHighlight[row][col]) {
            return LEGAL_HIGHLIGHT;
        }
        return squareColor(row, col);
    }

    private void handlePress(Object source) {
        if (!inputEnabled) {
            return;
        }
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (source == square[row][col]) {
                    if (!awaitingDestination) {
                        if (selectListener != null && selectListener.onSelect(row, col)) {
                            fromRow = row;
                            fromCol = col;
                            awaitingDestination = true;
                        } else {
                            resetClickState();
                        }
                    } else if (row == fromRow && col == fromCol) {
                        resetClickState();
                    } else {
                        boolean played = moveListener != null
                                && moveListener.onMove(fromRow, fromCol, row, col);
                        if (played) {
                            resetClickState();
                        }
                    }
                    return;
                }
            }
        }
    }

    private static Color squareColor(int row, int col) {
        return (row + col) % 2 == 0 ? Color.WHITE : new Color(0x81b64c);
    }
}
