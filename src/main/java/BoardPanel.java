import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BoardPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final Color LABEL_COLOR = new Color(0x5c5c5c);

    private final JButton[][] square = new JButton[8][8];
    private MoveListener moveListener;
    private int fromRow = -1;
    private int fromCol = -1;
    private boolean awaitingDestination;

    public interface MoveListener {
        void onMove(int fromRow, int fromCol, int toRow, int toCol);
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

    public void syncFromBoard(Board board, PieceRegistry registry) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board.get(new Position(row, col));
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

    private void handlePress(Object source) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (source == square[row][col]) {
                    if (!awaitingDestination) {
                        fromRow = row;
                        fromCol = col;
                        awaitingDestination = true;
                    } else {
                        awaitingDestination = false;
                        if (moveListener != null) {
                            moveListener.onMove(fromRow, fromCol, row, col);
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
