package Game;

import java.util.ArrayList;
import java.util.List;

import Pecas.Piece;

public class Memento {
    private final String[][] boardState;
    private final List<Piece> activePiecesState;

    public Memento(String[][] boardState, List<Piece> activePiecesState) {
        this.boardState = new String[boardState.length][];
        for (int i = 0; i < boardState.length; i++) {
            this.boardState[i] = boardState[i].clone();
        }
        this.activePiecesState = new ArrayList<Piece>(activePiecesState);
    }

    public String[][] getBoardState() {
        return boardState;
    }

    public List<Piece> getActivePiecesState() {
        return activePiecesState;
    }
}

