import java.util.IdentityHashMap;
import java.util.Map;
import javax.swing.ImageIcon;

public class PieceRegistry {
    private final Map<Piece, PieceDisplay> displays = new IdentityHashMap<>();
    private ImageIcon[] whitePromotionQueens;
    private ImageIcon[] blackPromotionQueens;

    public void register(Piece piece, ImageIcon icon, String tooltip) {
        displays.put(piece, new PieceDisplay(icon, tooltip));
    }

    public void registerPromotionQueens(ImageIcon[] white, ImageIcon[] black) {
        if (white.length != 8 || black.length != 8) {
            throw new IllegalArgumentException("promotion queen icons must have length 8");
        }
        whitePromotionQueens = white;
        blackPromotionQueens = black;
    }

    public PieceDisplay get(Piece piece) {
        return displays.get(piece);
    }

    public Queen promote(Pawn pawn, Position to, Board board) {
        ImageIcon[] icons = pawn.getColor() == PieceColor.WHITE
                ? whitePromotionQueens
                : blackPromotionQueens;
        if (icons == null) {
            return null;
        }
        int file = pawn.getHomeFile();
        if (file < 0 || file >= icons.length) {
            return null;
        }
        PieceDisplay display = new PieceDisplay(icons[file], promotionTooltip(pawn, file));
        Queen queen = new Queen(to.row(), to.col(), pawn.color);
        board.clear(pawn.getPosition());
        board.set(to, queen);
        displays.put(queen, display);
        return queen;
    }

    private static String promotionTooltip(Pawn pawn, int homeFile) {
        int file = homeFile + 1;
        if (pawn.getColor() == PieceColor.WHITE) {
            return "Queenx" + file;
        }
        return "B.Queenx" + file;
    }
}
