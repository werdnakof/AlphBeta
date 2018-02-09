package TicTacToe;

import Game.State;
import Game.Move;
import Game.Player;

public class Human implements Player {

    private Character name;

    public Human(Character name) {
        this.name = name;
    }

    @Override
    public Move genMove(State state) {

        int idx;
        while(true) {
            try {
                int ch = System.in.read();
                idx = ch - 48;
                System.in.read();
//                System.in.read();

                TicTacToeMove m = new TicTacToeMove(idx, this);

                if(state.isValidMove(this, m))
                    return m;
                else
                    System.out.println("Invalid Move @ " + String.valueOf(idx));

            } catch (Exception e) {

            }
        }
    }

    @Override
    public Character getCharLabel() { return this.name; }
}
