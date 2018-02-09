package Game;

public interface Player {
    Move genMove(State state);
    Character getCharLabel();
}
