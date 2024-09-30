package Game;

public interface Command {
    boolean execute();
    void undo();
    void redo();
}