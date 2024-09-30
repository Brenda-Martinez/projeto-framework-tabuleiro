package Tanques.Pecas;

import Pecas.MoveStrategy;

import Pecas.Piece;
import Pecas.PlayerPieces;
import Tabuleiro.Board;

public class TankPiece implements Piece{

    private TankType tankType;
    private PlayerPieces playerPieces;
    private final String symbol;
    
    private MoveStrategy moveStrategy;
    private int currentRow;
    private int currentColumn;

    public TankPiece(String symbol, PlayerPieces playerPieces, TankType tankType) {
        this.tankType = tankType;
        this.playerPieces = playerPieces;
        this.symbol = symbol;
        this.moveStrategy = tankType.getMove();
    }

    public TankType getTankType() {
        return tankType;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public PlayerPieces getPlayerPieces() {
        return playerPieces;
    }

    @Override
    public String showPiece() {
        return "Peça: " + getTankType() + " do jogador " + getPlayerPieces().getColor();
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
    
}
