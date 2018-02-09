package Game;

public interface State {
    boolean hasDrawn();
    boolean hasWonBy(Player player);
    boolean hasWon();
    boolean isValidMove(Player player, Move move);
    void start();
}
