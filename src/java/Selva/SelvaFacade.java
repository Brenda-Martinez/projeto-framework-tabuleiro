package Selva;

import Tabuleiro.*;

public class SelvaFacade {
    private SelvaGame selvaGame;
    private BoardBuilder builder;
    private BoardDirector director;

    public SelvaFacade() {
        this.selvaGame = SelvaGame.getInstance();
        this.builder = new ConcreteBoardBuilder();
        this.director = new BoardDirector(builder);
    }

    public void startSelvaGame() {
        director.constructSelvaBoard();
        Board board = builder.build();
        selvaGame.setBoard(board);
        showBoard();
        selvaGame.startGame();
    }

    public void selectPiece(int row, int column) {
        selvaGame.selectPiece(row, column);
    }

    public void makeMove(char direction) {
        selvaGame.makeMove(direction);
    }

    public void showBoard() {
        selvaGame.show();
    }

    public void saveGame(){
        selvaGame.saveGame();
    }

    public void loadGame(){
        selvaGame.loadGame();
    }
}

