package Game;

import java.util.Stack;

public class CommandManager {
    private Stack<Command> commandStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();
    private Stack<Command> confirmedCommands = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        commandStack.push(command);
        redoStack.clear();
    }

    public void undo() {
        if (!commandStack.isEmpty()) {
            Command command = commandStack.pop();
            command.undo();
            redoStack.push(command);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.redo(); 
            commandStack.push(command);
        }
    }

    public void confirmMovement() {
        if (!commandStack.isEmpty()) {
            confirmedCommands.push(commandStack.peek());
        }
    }
}

