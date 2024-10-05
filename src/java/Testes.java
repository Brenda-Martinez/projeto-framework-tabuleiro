import Selva.SelvaGame;
import Tanques.TanksBattleFacade;

public class Testes {

    public static void main(String[] args) {
        
        /*
        SelvaGame game = SelvaGame.getInstance();
        game.startGame();
        game.selectPiece(0, 0);
        game.makeMove('s');
        game.saveGame();
        game.selectPiece(1, 0);
        game.makeMove('d');
        game.makeMove('w');
        game.loadGame();
        */

        TanksBattleFacade game = new TanksBattleFacade();
        game.startTanksBattleGame();
        game.selectPiece(0, 0);
        game.makeMove('s');        
        game.selectPiece(1, 0);
        game.makeMove('d');
        game.selectPiece(1, 3);
        game.makeMove('d');
        
    }

}
