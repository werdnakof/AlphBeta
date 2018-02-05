package AlphaBeta;

public interface State {
    boolean drawPosition();
    boolean wonPosition(Player player);
    float positionEvaluation(Player player);
    Move[] possibleMoves(Player player);
    void makeMove(Player player, Move move);
    boolean reachedMaxDepth(Integer depth);
    void start();
}
