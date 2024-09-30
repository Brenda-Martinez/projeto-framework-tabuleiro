package Selva.Pecas;

import Pecas.*;
import Tabuleiro.Board;

public abstract class SelvaPieceDecorator implements SelvaPiece {
    protected BasicSelvaPiece decoratedPiece;

    public SelvaPieceDecorator(BasicSelvaPiece decoratedPiece) {
        this.decoratedPiece = decoratedPiece;
    }

    @Override
    public boolean move(int newRow, int newColumn, Board board) {
        return decoratedPiece.move(newRow, newColumn, board);
    }
    
    @Override
    public AnimalType getAnimalType() {
        return decoratedPiece.getAnimalType();
    }

    @Override
    public PlayerPieces getPlayerPieces() {
        return decoratedPiece.getPlayerPieces();
    }

    @Override
    public String getSymbol() {
        return decoratedPiece.getSymbol();
    }

    public int getCurrentRow(){
        return decoratedPiece.getCurrentRow();
    }

    public int getCurrentColumn(){
        return decoratedPiece.getCurrentColumn();
    }

    public String showPiece(){
        return decoratedPiece.showPiece();
    }
}
