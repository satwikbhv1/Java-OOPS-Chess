import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ChessFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ChessFrame frame = new ChessFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ChessFrame() {
        super("SChess");

        ChessController controller = new ChessController();
        BoardPanel boardPanel = new BoardPanel();
        JLabel statusLabel = new JLabel("", SwingConstants.CENTER);
        statusLabel.setFont(statusLabel.getFont().deriveFont(Font.BOLD, 14f));

        boardPanel.setMoveListener((fromRow, fromCol, toRow, toCol) -> {
            controller.handleMove(fromRow, fromCol, toRow, toCol, boardPanel);
            statusLabel.setText(controller.getStatusMessage());
        });

        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(e -> {
            controller.newGame(boardPanel);
            statusLabel.setText(controller.getStatusMessage());
        });

        controller.startGame(boardPanel);
        statusLabel.setText(controller.getStatusMessage());

        JPanel root = new JPanel(new BorderLayout());
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 8));
        topBar.add(newGameButton);
        root.add(topBar, BorderLayout.NORTH);
        root.add(boardPanel, BorderLayout.CENTER);
        root.add(statusLabel, BorderLayout.SOUTH);

        setContentPane(root);
        setSize(650, 720);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
