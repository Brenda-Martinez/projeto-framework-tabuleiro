package Game;

import Pecas.Piece;

public class BlackPieceDecorator extends PieceDecorator {

    public BlackPieceDecorator(Piece decoratedPiece) {
        super(decoratedPiece);
    }

    @Override
    public String getSymbol() {
        return decoratedPiece.getSymbol().toLowerCase();
    }

}
