package Selva.Pecas;

import Pecas.*;
import Tabuleiro.Board;

public class BasicSelvaPiece implements SelvaPiece {
    private AnimalType animalType;
    private PlayerPieces playerPieces;
    private final String symbol;
    private boolean inWater;

    private MoveStrategy moveStrategy;
    private int currentRow;
    private int currentColumn;

    public BasicSelvaPiece(String symbol, PlayerPieces playerPieces, AnimalType animalType) {
        this.animalType = animalType;
        this.playerPieces = playerPieces;
        this.symbol = symbol;
        this.inWater = false;
        this.moveStrategy = animalType.getMove();
    }

    @Override
    public AnimalType getAnimalType() {
        return animalType;
    }

    @Override
    public PlayerPieces getPlayerPieces() {
        return playerPieces;
    }

    public boolean isInWater() {
        return inWater;
    }

    public void setInWater(boolean inWater) {
        this.inWater = inWater;
    }

    @Override
    public boolean move(int newRow, int newColumn, Board board) {
        return moveStrategy.move(this, newRow, newColumn, board);
    }

    public void setCurrentPosition(int row, int column) {
        this.currentRow = row;
        this.currentColumn = column;
    }
    
    public int getCurrentRow() {
        return currentRow;
    }
    
    public int getCurrentColumn() {
        return currentColumn;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
    
    public String showPiece() {
        return "Peça: " + getAnimalType().name() + " do jogador " + getPlayerPieces().getColor();
    }
}
