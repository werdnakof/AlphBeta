package TicTacToe;

import AlphaBeta.Player;

public abstract class TicTacPlayer implements Player {
    private char identifier;

    public TicTacPlayer(char identifier) {
        this.identifier = identifier;
    }

    /**
     *
     */
    public abstract TicTacMove createMove(TicTacPlayer[] grid);

    @Override
    public String toString() {
        return String.valueOf(this.identifier);
    }
}
