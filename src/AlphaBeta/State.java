package AlphaBeta;

public interface State {
    boolean drawPosition();
    boolean wonPosition(Player player);
    boolean validateMove(Player player, Move move);
    void start();
}
