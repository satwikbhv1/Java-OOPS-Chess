package com.schess;

import com.schess.game.Game;
import com.schess.ui.BoardPanel;
import com.schess.ui.CapturedPanel;
import com.schess.ui.ChessController;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
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
        CapturedPanel capturedByBlack = new CapturedPanel();
        CapturedPanel capturedByWhite = new CapturedPanel();
        controller.setCapturedPanels(capturedByWhite, capturedByBlack);

        JLabel statusLabel = new JLabel("", SwingConstants.CENTER);
        statusLabel.setFont(statusLabel.getFont().deriveFont(Font.BOLD, 14f));

        boardPanel.setSelectListener((row, col) -> controller.handleSelect(row, col, boardPanel));
        boardPanel.setMoveListener((fromRow, fromCol, toRow, toCol) -> {
            boolean played = controller.handleMove(fromRow, fromCol, toRow, toCol, boardPanel);
            statusLabel.setText(controller.getStatusMessage());
            return played;
        });

        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(e -> {
            controller.newGame(boardPanel);
            statusLabel.setText(controller.getStatusMessage());
        });

        controller.startGame(boardPanel);
        statusLabel.setText(controller.getStatusMessage());

        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 8));
        topBar.add(newGameButton);
        north.add(topBar);
        north.add(capturedByBlack);

        JPanel south = new JPanel();
        south.setLayout(new BoxLayout(south, BoxLayout.Y_AXIS));
        south.add(capturedByWhite);
        south.add(statusLabel);

        JPanel root = new JPanel(new BorderLayout());
        root.add(north, BorderLayout.NORTH);
        root.add(boardPanel, BorderLayout.CENTER);
        root.add(south, BorderLayout.SOUTH);

        setContentPane(root);
        setSize(700, 780);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
