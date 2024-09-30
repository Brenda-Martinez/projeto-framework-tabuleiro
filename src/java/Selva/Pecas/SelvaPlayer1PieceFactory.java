package Selva.Pecas;

import Pecas.*;

public class SelvaPlayer1PieceFactory implements SelvaPieceFamilyFactory {
    @Override
    public SelvaPiece createCat() {
        return new BasicSelvaPiece("C", PlayerPiecesFactory.getPlayerPieces("white"), AnimalType.CAT);
    }

    @Override
    public SelvaPiece createDog() {
        return new BasicSelvaPiece("D", PlayerPiecesFactory.getPlayerPieces("white"), AnimalType.DOG);
    }

    @Override
    public SelvaPiece createElephant() {
        return new BasicSelvaPiece("E", PlayerPiecesFactory.getPlayerPieces("white"), AnimalType.ELEPHANT);
    }

    @Override
    public SelvaPiece createLeopard() {
        return new BasicSelvaPiece("P", PlayerPiecesFactory.getPlayerPieces("white"), AnimalType.LEOPARD);
    }

    @Override
    public SelvaPiece createLion() {
        return new JumpDecorator(new BasicSelvaPiece("L", PlayerPiecesFactory.getPlayerPieces("white"), AnimalType.LION));
    }

    @Override
    public SelvaPiece createRat() {
        return new BasicSelvaPiece("R", PlayerPiecesFactory.getPlayerPieces("white"), AnimalType.RAT);
    }

    @Override
    public SelvaPiece createTiger() {
        return new JumpDecorator (new BasicSelvaPiece("T", PlayerPiecesFactory.getPlayerPieces("white"), AnimalType.TIGER));
    }

    @Override
    public SelvaPiece createWolf() {
        return new BasicSelvaPiece("W", PlayerPiecesFactory.getPlayerPieces("white"), AnimalType.WOLF);
    }
}