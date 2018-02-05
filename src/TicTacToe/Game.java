package TicTacToe;

import AlphaBeta.State;
import AlphaBeta.Move;
import AlphaBeta.Player;

public class Game implements State {

    private boolean playerStart;
    private Player[] grid = new Player[9];
    private Human human;

    public Game(boolean playerStart, Human human) {
        this.playerStart = playerStart;
        this.human = human;
    }

    @Override
    public boolean drawPosition() {
        return false;
    }

    @Override
    public boolean wonPosition(Player player) {
        return false;
    }

    @Override
    public float positionEvaluation(Player player) {
        return 0;
    }

    @Override
    public Move[] possibleMoves(Player player) {
        return new Move[0];
    }

    @Override
    public void makeMove(Player player, Move move) {

    }

    @Override
    public boolean reachedMaxDepth(Integer depth) {
        return false;
    }

    @Override
    public void start() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int index = 0;

        for(Player player: this.grid) {
            sb.append("[");

            if(player == null) sb.append(" ");
            else sb.append(player);

            sb.append("]");

            if((index+1) % 3 == 0) sb.append("\n"); // new line every third slot

            index++;
        }
        return sb.toString();
    }

    static public void main (String[] args) {
        Human h = new Human('H');
        Game g = new Game(true, h);
        System.out.println(g);
    }
}
