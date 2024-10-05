package Tanques.Pecas;

import Game.PieceDecorator;
import Pecas.PlayerPieces;
import Tabuleiro.Board;

public class TankBattlePieceDecorator extends PieceDecorator{
    protected TankPiece decoratedPiece;

    public TankBattlePieceDecorator(TankPiece decoratedPiece) {
        super(decoratedPiece);
    }

    
    @Override
    public PlayerPieces getPlayerPieces() {
        return decoratedPiece.getPlayerPieces();
    }

    @Override
    public String showPiece() {
        return decoratedPiece.showPiece();
    }

    @Override
    public boolean move(int newRow, int newColumn, Board board) {
        return decoratedPiece.move(newRow, newColumn, board);
    }

    @Override
    public String getSymbol() {
        return decoratedPiece.getSymbol();
    }

    public TankType getTankType() {
        return decoratedPiece.getTankType();
    }
}
