package TicTacToe;

import AlphaBeta.AlphaBetaEngine;
import Game.Move;
import Game.Player;
import Game.State;

import java.util.Arrays;

public class Computer extends AlphaBetaEngine implements Player {

    final char name = 'C';

    @Override
    public Move genMove(State state) {
        return alphabeta(3, state, -100000.0f, 100000.0f, true).move;
    }

    @Override
    public Character getCharLabel() { return this.name; }

    @Override
    public float positionEvaluation(State state) {
        TicTacToeState tttg = (TicTacToeState) state;

        int count = 10 - tttg.getEmptyTileIndicies().length;

        // prefer the center square:
        float base = 1.0f;

        if (tttg.getPlayerInTile(4) == this.name) {
            base += 0.4f;
        } else if (tttg.getPlayerInTile(4) != null) {
            base -= 0.4f;
        }

        float ret = (base - 1.0f);
        if (tttg.hasWonBy(this))  {
            return (base + (1.0f / count));
        }else if (tttg.hasWon())  {
            return -(base + (1.0f / count));
        }

        return ret;
    }

    @Override
    public Move[] possibleMoves(State state) {
        TicTacToeState tttGame = (TicTacToeState) state;

        // can use for loop instead, but want to try stream
        return Arrays.stream(tttGame.getEmptyTileIndicies())
                .mapToObj(i -> new TicTacToeMove(i, this))
                .toArray(TicTacToeMove[]::new);
    }

    @Override
    public boolean reachedMaxDepth(State state, Integer depth) {
        TicTacToeState tttGame = (TicTacToeState) state;
        return tttGame.hasDrawn() || tttGame.hasWon();
    }

    @Override
    public State applyMove(State state, Move move) {
        TicTacToeState tmp = (TicTacToeState) state;

        // create a new state when applying move
        TicTacToeState tttGame = new TicTacToeState(tmp);
        if(tttGame.isValidMove(this, move)){
            tttGame.setMove(this, move);
        }
        
        return null;
    }
}
