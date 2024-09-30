package Game;

public interface GameState {
    void selectPiece(int row, int column, Game game);
    MoveCommand createMoveCommand(char direction, Game game);
}
