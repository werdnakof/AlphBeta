package AlphaBeta;

import Game.Move;
import Game.State;

public abstract class AlphaBetaEngine {

    public static final boolean DEBUG = true;

    public abstract float positionEvaluation(State state);
    public abstract Move[] possibleMoves(State state);
    public abstract boolean reachedMaxDepth(State state, Integer depth);
    public abstract State applyMove(State state, Move move);

    public class NextMove {
        public float value;
        public Move move;
        public NextMove next;
    }

    protected NextMove alphabeta(int depth, State state, float alpha, float beta, boolean isMax) {

        if(reachedMaxDepth(state, depth)) {
            NextMove nextMove = new NextMove();
            nextMove.value = positionEvaluation(state);
            return nextMove;
        }

        Move[] moves = possibleMoves(state);

        NextMove best = new NextMove();
        best.value = isMax ? Float.MIN_VALUE : Float.MAX_VALUE;

        for (int i=0; i < moves.length; i++) {

            NextMove val = alphabeta(depth-1, applyMove(state, moves[i]), alpha, beta, !isMax);

            if(isMax && val.value > best.value) {
                best.value = val.value;
                best.move = moves[i];
                best.next = val;
                if(val.value > alpha) alpha = val.value;

            } else if(!isMax && val.value < best.value) {
                best.value = val.value;
                best.move = moves[i];
                best.next = val;
                if(val.value < beta) beta = val.value;
            }

            // Prune Check
            if(isMax && best.value > beta) {
                break;
            } else if(!isMax && best.value < alpha) {
                break;
            }
        }

        return best;
    }
}
