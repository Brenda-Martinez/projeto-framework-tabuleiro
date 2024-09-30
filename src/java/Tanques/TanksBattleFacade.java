package Tanques;

import Tabuleiro.*;
import Tanques.Tabuleiro.TanksBattleBoardDirector;

public class TanksBattleFacade {
    private TanksBattleGame tanksBattleGame;
    private BoardBuilder builder;
    private TanksBattleBoardDirector director;

    public TanksBattleFacade() {
        this.tanksBattleGame = TanksBattleGame.getInstance();
        this.builder = new ConcreteBoardBuilder();
        this.director = new TanksBattleBoardDirector(builder);
    }

    public void startTanksBattleGame() {
        director.constructTankBattleBoard();
        Board board = builder.build();
        tanksBattleGame.setBoard(board);
        tanksBattleGame.startGame();
    }

    public void selectPiece(int row, int column) {
        tanksBattleGame.selectPiece(row, column);
    }

    public void makeMove(char direction) {
        tanksBattleGame.makeMove(direction);
    }

    public void showBoard() {
        tanksBattleGame.show();
    }

    public void saveGame(){
        tanksBattleGame.saveGame();
    }

    public void loadGame(){
        tanksBattleGame.loadGame();
    }
}

