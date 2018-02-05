package TicTacToe;

import AlphaBeta.State;
import AlphaBeta.Move;
import AlphaBeta.Player;

public class Game implements State {

    private boolean playerStart;
    private TicTacPlayer[] grid = new TicTacPlayer[9];
    private TicTacPlayer[] players;

    private int[][] threeInaRow = {
            {0,1,2}, {3,4,5}, {6,7,8},
            {2,5,8}, {0,4,8}, {2,4,6},
            {0,3,6}, {1,4,7}
    };

    public Game(boolean playerStart) {
        this.playerStart = playerStart;
        this.players = new TicTacPlayer[2];
        this.players[0] = new Human();
        this.players[1] = new Computer();
    }

    @Override
    public boolean drawPosition() {
        for(TicTacPlayer p: this.grid) {
            if(p == null) return false;
        }
        return true;
    }

    @Override
    public boolean wonPosition(Player player) {
        for(int[] combo: this.threeInaRow) {
            if(threeInARow(combo[0], combo[1], combo[2], (TicTacPlayer) player))
                return true;
        }
        return false;
    }

    @Override
    public boolean validateMove(Player p, Move m) {

        TicTacMove move = (TicTacMove) m;

        if(move.getIndex() < 0 || move.getIndex() > 8) return false;

        if(this.grid[move.getIndex()] != null) return false;

        return true;
    }

    private boolean threeInARow(int i1, int i2, int i3, TicTacPlayer player) {
        if (grid[i1] == player && grid[i2] == player && grid[i3] == player)
            return true;
        return false;
    }

    @Override
    public void start() {
        TicTacMove move;
        TicTacPlayer human = this.players[0];
        TicTacPlayer computer = this.players[1];

        if(playerStart) {
            move = human.createMove(this.grid);
            if(validateMove(human, move)) {
                this.grid[move.getIndex()] = human;
            }
        }

        while(true) {
            System.out.println(this);

            // computer move
            move = computer.createMove(this.grid);
            if(!validateMove(computer, move)) break;
            this.grid[move.getIndex()] = computer;
            if(wonPosition(computer)) break;

            System.out.println(this);

            // player move
            move = human.createMove(this.grid);
            if(!validateMove(human, move)) break;
            this.grid[move.getIndex()] = human;
            if(wonPosition(human)) break;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int index = 0;

        for(TicTacPlayer player: this.grid) {
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
        Game g = new Game(true);
//        g.start();
        System.out.println(g);
    }
}
