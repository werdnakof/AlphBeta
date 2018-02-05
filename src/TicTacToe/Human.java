package TicTacToe;

import AlphaBeta.Player;

public class Human implements Player {
    private char identifier;

    public Human(char identifier) {
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return String.valueOf(this.identifier);
    }
}
