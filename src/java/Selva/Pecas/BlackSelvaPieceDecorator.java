package Selva.Pecas;

public class BlackSelvaPieceDecorator extends SelvaPieceDecorator {

    public BlackSelvaPieceDecorator(BasicSelvaPiece decoratedPiece) {
        super(decoratedPiece);
    }

    @Override
    public String getSymbol() {
        return decoratedPiece.getSymbol().toLowerCase();
    }

}


