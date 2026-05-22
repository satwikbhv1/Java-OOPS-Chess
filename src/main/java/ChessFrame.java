import java.awt.EventQueue;
import javax.swing.JFrame;

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
        boardPanel.setMoveListener((fromRow, fromCol, toRow, toCol) ->
                controller.handleMove(fromRow, fromCol, toRow, toCol, boardPanel));

        controller.startGame(boardPanel);

        setContentPane(boardPanel);
        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
