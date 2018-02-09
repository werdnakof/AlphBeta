package TicTacToe;

import Game.State;
import Game.Move;
import Game.Player;

import java.util.*;

public class TicTacToeState implements State {

    private Character[] grid = new Character[9];
    private int emptyTilesCount;

    private int[][] winningCombos = {
            {0,1,2}, {3,4,5}, {6,7,8},
            {2,5,8}, {0,4,8}, {2,4,6},
            {0,3,6}, {1,4,7}
    };

    public TicTacToeState() {
        this.emptyTilesCount = 9;
    }

    public Character getPlayerInTile(int index) {
        return this.grid[index];
    }

    public int[] getEmptyTileIndicies() {
        int[] ret = new int[this.emptyTilesCount];
        int inc = 0;
        for (int i=0; i<9; i++) {
            if (this.grid == null) ret[inc] = i++ ; // i.e. tile is blank
        }
        return ret;
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
    public boolean setMove(Player p, Move m) {
        if(isValidMove(p, m)) {
            TicTacToeMove tttm = (TicTacToeMove) m;
            this.grid[tttm.getIndex()] = p.getCharLabel();
            this.emptyTilesCount--;
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
}
