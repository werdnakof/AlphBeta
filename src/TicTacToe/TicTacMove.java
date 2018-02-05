package TicTacToe;

import AlphaBeta.Move;

public class TicTacMove implements Move {
    private Integer index;
    private TicTacPlayer playedBy;

    public TicTacMove(Integer index, TicTacPlayer playedBy) {
        this.index = index;
        this.playedBy = playedBy;
    }

    public TicTacPlayer playedBy() {
        return playedBy;
    }

    public Integer getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return this.playedBy + " play " + this.index;
    }
}
