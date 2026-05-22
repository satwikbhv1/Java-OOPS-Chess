package com.schess.ui;

import com.schess.pieces.Piece;
import com.schess.pieces.PieceColor;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CapturedPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int ICON_SIZE = 28;
    private static final int STRIP_HEIGHT = ICON_SIZE + 12;

    public CapturedPanel() {
        super(new FlowLayout(FlowLayout.LEFT, 4, 4));
        Dimension fixed = new Dimension(0, STRIP_HEIGHT);
        setPreferredSize(fixed);
        setMinimumSize(fixed);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, STRIP_HEIGHT));
    }

    public void sync(List<Piece> captured, PieceRegistry registry, PieceColor takenBy) {
        removeAll();
        for (Piece piece : captured) {
            if (piece.getColor() == takenBy) {
                continue;
            }
            ImageIcon icon = resolveIcon(piece, registry);
            if (icon != null) {
                add(new JLabel(scale(icon)));
            }
        }
        repaint();
    }

    public void clear() {
        removeAll();
        repaint();
    }

    private static ImageIcon resolveIcon(Piece piece, PieceRegistry registry) {
        PieceDisplay display = registry.get(piece);
        if (display != null) {
            return display.icon();
        }
        return PieceIconFactory.get(piece.getType(), piece.getColor());
    }

    private static ImageIcon scale(ImageIcon icon) {
        Image scaled = icon.getImage().getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH);
        return new ImageIcon(scaled);
    }
}
