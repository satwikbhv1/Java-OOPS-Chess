import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BoardPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private final JButton[][] square = new JButton[8][8];
    private MoveListener moveListener;
    private int fromRow = -1;
    private int fromCol = -1;
    private boolean awaitingDestination;

    public interface MoveListener {
        void onMove(int fromRow, int fromCol, int toRow, int toCol);
    }

    public BoardPanel() {
        setLayout(new GridLayout(8, 8));
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
                add(square[row][col]);
            }
        }
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
