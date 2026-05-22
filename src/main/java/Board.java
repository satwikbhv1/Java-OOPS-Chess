import java.util.IdentityHashMap;

public class Board {
    private final Piece[][] grid = new Piece[8][8];

    public Piece get(Position pos) {
        return grid[pos.row()][pos.col()];
    }

    public void set(Position pos, Piece piece) {
        Piece existing = grid[pos.row()][pos.col()];
        if (existing != null && existing != piece) {
            existing.setPosition(Position.OFF_BOARD);
        }
        grid[pos.row()][pos.col()] = piece;
        if (piece != null) {
            piece.setPosition(pos);
        }
    }

    public void clear(Position pos) {
        Piece piece = grid[pos.row()][pos.col()];
        if (piece != null) {
            piece.setPosition(Position.OFF_BOARD);
        }
        grid[pos.row()][pos.col()] = null;
    }

    public boolean isOccupied(Position pos) {
        return grid[pos.row()][pos.col()] != null;
    }

    public void clearAll() {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                clear(new Position(r, c));
            }
        }
    }

    public Position findPosition(Piece piece) {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (grid[r][c] == piece) {
                    return new Position(r, c);
                }
            }
        }
        return null;
    }

    public void move(Move move) {
        move(move.from(), move.to());
    }

    public void move(Position from, Position to) {
        Piece captured = grid[to.row()][to.col()];
        if (captured != null) {
            captured.setPosition(Position.OFF_BOARD);
        }
        Piece piece = grid[from.row()][from.col()];
        grid[to.row()][to.col()] = piece;
        grid[from.row()][from.col()] = null;
        if (piece != null) {
            piece.setPosition(to);
        }
    }

    public boolean isPathClear(Move move) {
        return isPathClear(move.from(), move.to());
    }

    public boolean isPathClear(Position from, Position to) {
        int dr = to.row() - from.row();
        int dc = to.col() - from.col();

        // orthogonal path (rook/queen)
        if (dr == 0 || dc == 0) {
            int stepR = Integer.signum(dr);
            int stepC = Integer.signum(dc);
            int r = from.row() + stepR;
            int c = from.col() + stepC;
            while (r != to.row() || c != to.col()) {
                if (isOccupied(new Position(r, c))) return false;
                r += stepR;
                c += stepC;
            }
            return true;
        }

        // diagonal path (bishop/queen)
        if (Math.abs(dr) == Math.abs(dc)) {
            int stepR = Integer.signum(dr);
            int stepC = Integer.signum(dc);
            int r = from.row() + stepR;
            int c = from.col() + stepC;
            while (r != to.row()) {
                if (isOccupied(new Position(r, c))) return false;
                r += stepR;
                c += stepC;
            }
            return true;
        }

        // knights and kings don't need path check
        return true;
    }

    public Board copy() {
        Board copy = new Board();
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                copy.grid[r][c] = this.grid[r][c];
            }
        }
        return copy;
    }

    public BoardSnapshot snapshot() {
        IdentityHashMap<Piece, Position> positions = new IdentityHashMap<>();
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Piece piece = grid[r][c];
                if (piece != null) {
                    positions.put(piece, piece.getPosition());
                }
            }
        }
        return new BoardSnapshot(grid, positions);
    }

    public void restore(BoardSnapshot snapshot) {
        for (int r = 0; r < 8; r++) {
            System.arraycopy(snapshot.grid()[r], 0, grid[r], 0, 8);
        }
        for (var entry : snapshot.positions().entrySet()) {
            entry.getKey().setPosition(entry.getValue());
        }
    }
}
