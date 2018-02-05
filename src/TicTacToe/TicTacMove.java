package TicTacToe;

import AlphaBeta.Move;

public class TicTacMove implements Move {
    private TicTacPlayer playedBy;
    public TicTacMove(TicTacPlayer playedBy) {
        this.playedBy = playedBy;
    }

    public TicTacPlayer playedBy() {
        return playedBy;
    }
}
