public record Position(int row, int col) {
    public static final Position OFF_BOARD = new Position(-1, -1);
}
