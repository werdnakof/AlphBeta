package TicTacToe;

import AlphaBeta.AlphaBetaEngine;
import Game.Player;
import Game.Move;
import Game.State;

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
        TicTacToeGame tttg = (TicTacToeGame) state;

        int count = 10 - tttg.getEmptyTilesCount();

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

        return new Move[0];
    }

    @Override
    public boolean reachedMaxDepth(State state, Integer depth) {
        TicTacToeGame tttGame = (TicTacToeGame) state;
        return tttGame.hasDrawn();
    }

    @Override
    public State applyMove(State state, Move move) {
        TicTacToeGame tttGame = (TicTacToeGame) state;
        return null;
    }
}
