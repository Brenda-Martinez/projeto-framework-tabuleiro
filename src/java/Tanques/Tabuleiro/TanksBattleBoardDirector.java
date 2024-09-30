package Tanques.Tabuleiro;

import java.util.ArrayList;
import java.util.List;

import Tabuleiro.*;
import Tanques.Pecas.TanksPlayer1PieceFactory;
import Tanques.Pecas.TanksPlayer2PieceFactory;

public class TanksBattleBoardDirector extends BoardDirector{

    private TanksPlayer1PieceFactory player1;
    private TanksPlayer2PieceFactory player2;

    private List<int[]> player1BaseCoordinates;
    private List<int[]> player2BaseCoordinates;
    private List<int[]> contaminatedAreaCoordinates;

    public TanksBattleBoardDirector(BoardBuilder builder){
        super(builder);
        this.player1 = new TanksPlayer1PieceFactory();
        this.player2 = new TanksPlayer2PieceFactory();

        player1BaseCoordinates = new ArrayList<>();
        player2BaseCoordinates = new ArrayList<>();
        contaminatedAreaCoordinates = new ArrayList<>();
    }

    public Board constructTankBattleBoard() {
        builder.setDimensions(11, 11);
       
        // Base do Jogador 1
        addPlayer1Base(0, 0);
        addPlayer1Base(0, 1);
        addPlayer1Base(0, 2);
        addPlayer1Base(0, 3);
        addPlayer1Base(0, 4);
        addPlayer1Base(1, 0);
        addPlayer1Base(1, 2);
        addPlayer1Base(1, 3);
        addPlayer1Base(2, 0);
        addPlayer1Base(2, 1);
        addPlayer1Base(2, 2);
        addPlayer1Base(3, 0);
        addPlayer1Base(3, 1);
        addPlayer1Base(4, 0);
        
        // tanques
        builder.placePiece(0, 0, player1.createCommander());
        builder.placePiece(0, 1, player1.createNormalTank());
        builder.placePiece(0, 2, player1.createNormalTank());
        builder.placePiece(0, 3, player1.createNormalTank());
        builder.placePiece(0, 4, player1.createNormalTank());
        builder.placePiece(1, 0, player1.createNormalTank());
        builder.placePiece(1, 2, player1.createNormalTank());
        builder.placePiece(1, 3, player1.createNormalTank());
        builder.placePiece(2, 0, player1.createNormalTank());
        builder.placePiece(2, 1, player1.createNormalTank());
        builder.placePiece(2, 2, player1.createNormalTank());
        builder.placePiece(3, 0, player1.createNormalTank());
        builder.placePiece(3, 1, player1.createNormalTank());
        builder.placePiece(4, 0, player1.createNormalTank());

        // Base do Jogador 2
        addPlayer2Base(10, 10);
        addPlayer2Base(10, 9);
        addPlayer2Base(10, 8);
        addPlayer2Base(10, 7);
        addPlayer2Base(10, 6);
        addPlayer2Base(9, 10);
        addPlayer2Base(9, 8);
        addPlayer2Base(9, 7);
        addPlayer2Base(8, 10);
        addPlayer2Base(8, 9);
        addPlayer2Base(8, 8);
        addPlayer2Base(7, 10);
        addPlayer2Base(7, 9);
        addPlayer2Base(6, 10);

        builder.placePiece(10, 10, player2.createCommander());
        builder.placePiece(10, 9, player2.createNormalTank());
        builder.placePiece(10, 8, player2.createNormalTank());
        builder.placePiece(10, 7, player2.createNormalTank());        
        builder.placePiece(10, 6, player2.createNormalTank());        
        builder.placePiece(9, 10, player2.createNormalTank());        
        builder.placePiece(9, 8, player2.createNormalTank());        
        builder.placePiece(9, 7, player2.createNormalTank());        
        builder.placePiece(8, 10, player2.createNormalTank());        
        builder.placePiece(8, 9, player2.createNormalTank());        
        builder.placePiece(8, 8, player2.createNormalTank());        
        builder.placePiece(7, 10, player2.createNormalTank());        
        builder.placePiece(7, 9, player2.createNormalTank());        
        builder.placePiece(6, 10, player2.createNormalTank());
        
        // Zonas químicas
        addContaminatedArea(6, 4);
        addContaminatedArea(6, 5);
        addContaminatedArea(4, 4);
        addContaminatedArea(4, 5);
        addContaminatedArea(5, 4);
        addContaminatedArea(5, 5);
        addContaminatedArea(4, 6);
        addContaminatedArea(5, 6);
        addContaminatedArea(6, 6);

        builder.setSquare(6, 4, "@"); 
        builder.setSquare(6, 5, "@"); 
        builder.setSquare(4, 4, "@"); 
        builder.setSquare(4, 5, "@"); 
        builder.setSquare(5, 4, "@"); 
        builder.setSquare(5, 5, "@");
        builder.setSquare(4, 6, "@"); 
        builder.setSquare(5, 6, "@"); 
        builder.setSquare(6, 6, "@"); 

        //adicionar minas
        builder.setSquare(0, 5, "#");
        builder.setSquare(1, 1, "#");
        builder.setSquare(1, 9, "#");
        builder.setSquare(2, 3, "#");
        builder.setSquare(2, 5, "#");
        builder.setSquare(2, 7, "#");
        builder.setSquare(3, 2, "#");
        builder.setSquare(3, 8, "#");
        builder.setSquare(5, 0, "#");
        builder.setSquare(5, 2, "#");
        builder.setSquare(5, 8, "#");
        builder.setSquare(5, 10, "#");
        builder.setSquare(7, 2, "#");
        builder.setSquare(7, 8, "#");
        builder.setSquare(8, 3, "#");
        builder.setSquare(8, 5, "#");
        builder.setSquare(8, 7, "#");
        builder.setSquare(9, 1, "#");
        builder.setSquare(9, 9, "#");
        builder.setSquare(10, 5, "#");

        return builder.build();
    }

    private void addPlayer1Base(int row, int col) {
        player1BaseCoordinates.add(new int[]{row, col});
    }

    private void addPlayer2Base(int row, int col) {
        player2BaseCoordinates.add(new int[]{row, col});
    }

    private void addContaminatedArea(int row, int col) {
        contaminatedAreaCoordinates.add(new int[]{row, col});
    }

    public List<int[]> getPlayer1BaseCoordinates() {
        return player1BaseCoordinates;
    }

    public List<int[]> getPlayer2BaseCoordinates() {
        return player2BaseCoordinates;
    }

    public List<int[]> getContaminatedAreaCoordinates() {
        return contaminatedAreaCoordinates;
    }

}