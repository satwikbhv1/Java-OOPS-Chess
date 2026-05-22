import java.util.IdentityHashMap;
import java.util.Map;
import javax.swing.ImageIcon;

public class PieceRegistry {
    private final Map<Piece, PieceDisplay> displays = new IdentityHashMap<>();
    private final Map<Pawn, PieceDisplay> promotionDisplays = new IdentityHashMap<>();

    public void register(Piece piece, ImageIcon icon, String tooltip) {
        displays.put(piece, new PieceDisplay(icon, tooltip));
    }

    public void registerPromotion(Pawn pawn, ImageIcon queenIcon, String queenTooltip) {
        promotionDisplays.put(pawn, new PieceDisplay(queenIcon, queenTooltip));
    }

    public PieceDisplay get(Piece piece) {
        return displays.get(piece);
    }

    public Queen promote(Pawn pawn, Position to, Board board) {
        PieceDisplay display = promotionDisplays.get(pawn);
        if (display == null) {
            return null;
        }
        Queen queen = new Queen(to.row(), to.col(), pawn.color);
        board.clear(pawn.getPosition());
        board.set(to, queen);
        displays.put(queen, display);
        return queen;
    }
}
