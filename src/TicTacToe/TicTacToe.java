package TicTacToe;

public class TicTacToe {
    public static void main(String[] vars) {
        TicTacToeState tttState = new TicTacToeState();
        Human h = new Human('A');
//        Human c = new Human('B');
        Computer c = new Computer();

        while(true) {
            TicTacToeMove cMove = (TicTacToeMove) c.genMove(tttState);

            if(tttState.setMove(c, cMove)) {
                System.out.println(tttState);
                if(tttState.hasWon() || tttState.hasDrawn()) break;
            }

            TicTacToeMove hMove = (TicTacToeMove) h.genMove(tttState);

            if(tttState.setMove(h, hMove)) {
                System.out.println(tttState);
                if(tttState.hasWon() || tttState.hasDrawn()) break;
            }
        }
    }
}
