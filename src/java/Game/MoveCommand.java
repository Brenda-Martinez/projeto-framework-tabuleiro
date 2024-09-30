package Game;

import Pecas.Piece;

public class MoveCommand implements Command{
    private Game game;
    private char direction;
    private int previousRow;
    private int previousColumn;
    private int newRow;
    private int newColumn;
    private Piece selectedPiece;

    public MoveCommand(Game game, char direction) {
        this.game = game;
        this.direction = direction;
        this.selectedPiece = game.getSelectedPiece();
        this.previousRow = game.getCurrentRow();
        this.previousColumn = game.getCurrentColumn();
    }

    public boolean execute() {
        if (selectedPiece != null) {
            game.getBoard().movePieceWithDirection(previousRow, previousColumn, direction, selectedPiece);
  
            this.newRow = game.getCurrentRow();
            this.newColumn = game.getCurrentColumn();
            return true;
        }
        return false;
    }

    public void undo() {
        game.getBoard().movePieceBack(newRow, newColumn, previousRow, previousColumn, selectedPiece);
        game.setCurrentRow(previousRow);
        game.setCurrentColumn(previousColumn);
    }

    public void redo() {
        game.getBoard().movePieceWithDirection(previousRow, previousColumn, direction, selectedPiece);
        
        game.setCurrentRow(newRow);
        game.setCurrentColumn(newColumn);
    }
}


