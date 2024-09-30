package Game;

import Pecas.Piece;
import Tabuleiro.*;

public interface Game {
    void selectPiece(int row, int column);  
    void makeMove(char direction);         
    void undo();
    void redo(); 
    void changeTurn();                      

    Board getBoard();
    void setBoard(Board board);      

    int getCurrentRow();                    
    int getCurrentColumn();                 
    void setCurrentRow(int row);            
    void setCurrentColumn(int column);      

    Piece getSelectedPiece();               
    void setSelectedPiece(Piece piece);
    
    void startGame();
    void finishGame(String winner);
    void saveGame();
    void loadGame();

    Memento createMemento();

    void show();                           
}

