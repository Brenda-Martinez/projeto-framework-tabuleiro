package Game;

import Pecas.*;
import Tabuleiro.Board;

public abstract class PieceDecorator implements Piece {
    protected Piece decoratedPiece;

    public PieceDecorator(Piece decoratedPiece) {
        this.decoratedPiece = decoratedPiece;
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
}

