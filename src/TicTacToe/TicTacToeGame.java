package TicTacToe;

import Game.State;
import Game.Move;
import Game.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class TicTacToeGame implements State {

    private boolean playerStart;
    private Character[] grid = new Character[9];
    private HashMap<Character, Player> players = new HashMap<>();

    private int[][] winningCombos = {
            {0,1,2}, {3,4,5}, {6,7,8},
            {2,5,8}, {0,4,8}, {2,4,6},
            {0,3,6}, {1,4,7}
    };

    public TicTacToeGame(boolean playerStart) {
        this.playerStart = playerStart;

        Human h = new Human();
        Computer c = new Computer();

        this.players.put(h.getCharLabel(), h);
        this.players.put(c.getCharLabel(), c);
    }

    // check if iterate copy required!!!
    public Character[] getGrid() {
        Character[] ret = new Character[9];
        for(int i = 0; i < 9; i++) {
            ret[i] = this.grid[i];
        }
        return ret;
    }

    public Set<Character> getPlayers() {
        return this.players.keySet();
    }

    public Character getPlayerInTile(int index) {
        return this.grid[index];
    }

    public int getEmptyTilesCount() {
        int count = 0;
        for (int i=0; i<9; i++) {
            if (this.grid == null) count++; // i.e. tile is blank
        }
        return count;
    }

    @Override
    public boolean hasDrawn() {
        for(Character p: this.grid) {
            if(p == null) return false;
        }
        return true;
    }

    @Override
    public boolean hasWonBy(Player player) {
        for(int[] combo: this.winningCombos) {
            if(isThreeInARow(combo[0], combo[1], combo[2], player.getCharLabel()))
                return true;
        }
        return false;
    }

    @Override
    public boolean hasWon() {
        for(int[] combo: this.winningCombos) {
            if(isThreeInARow(combo[0], combo[1], combo[2], null))
                return true;
        }
        return false;
    }

    @Override
    public boolean isValidMove(Player p, Move m) {
        TicTacToeMove move = (TicTacToeMove) m;

        if(move.getIndex() < 0 || move.getIndex() > 8) return false;

        if(this.grid[move.getIndex()] != null) return false;

        return true;
    }

    private boolean isThreeInARow(int i1, int i2, int i3, Character player) {
        if(player == null && grid[i1] == grid[i2] && grid[i1] == grid[i3])
            return true;
        else if (grid[i1] == player && grid[i2] == player && grid[i3] == player)
            return true;
        return false;
    }

    @Override
    public void start() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int index = 0;

        for(Character ch: this.grid) {
            sb.append("[");

            if(ch == null) sb.append(" ");
            else sb.append(ch);

            sb.append("]");

            if((index+1) % 3 == 0) sb.append("\n"); // new line every third slot

            index++;
        }
        return sb.toString();
    }

    static public void main (String[] args) {
        TicTacToeGame g = new TicTacToeGame(true);
//        g.start();
        System.out.println(g);
    }
}
