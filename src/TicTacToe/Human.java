package TicTacToe;

public class Human extends TicTacPlayer {
    public Human() {
        super('H');
    }

    @Override
    public TicTacMove createMove(TicTacPlayer[] grid) {
        int i = 0;
        try {
            int ch = System.in.read();
            i = ch - 48;
            System.in.read();
            System.in.read();
        } catch (Exception e) { }

        return new TicTacMove(i, this);
    }

    public static void main (String[] cars) {
        Human h = new Human();
        TicTacPlayer[] grid = new TicTacPlayer[9];
        System.out.println(h.createMove(grid));
    }
}
