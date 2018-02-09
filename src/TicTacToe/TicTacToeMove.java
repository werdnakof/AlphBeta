package TicTacToe;

import Game.Move;
import Game.Player;

public class TicTacToeMove implements Move {
    private Integer index;
    private Player playedBy;

    public TicTacToeMove(Integer index, Player playedBy) {
        this.index = index;
        this.playedBy = playedBy;
    }

    public Player playedBy() {
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
