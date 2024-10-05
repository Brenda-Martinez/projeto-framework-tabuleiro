package Selva.Pecas;

import Pecas.*;

public class SelvaPlayer1PieceFactory implements SelvaPieceFamilyFactory {
    @Override
    public SelvaPiece createCat() {
        return new BasicSelvaPiece(AnimalType.CAT.getSymbol(), PlayerPiecesFactory.getPlayerPieces("white"), AnimalType.CAT);
    }

    @Override
    public SelvaPiece createDog() {
        return new BasicSelvaPiece(AnimalType.DOG.getSymbol(), PlayerPiecesFactory.getPlayerPieces("white"), AnimalType.DOG);
    }

    @Override
    public SelvaPiece createElephant() {
        return new BasicSelvaPiece(AnimalType.ELEPHANT.getSymbol(), PlayerPiecesFactory.getPlayerPieces("white"), AnimalType.ELEPHANT);
    }

    @Override
    public SelvaPiece createLeopard() {
        return new BasicSelvaPiece(AnimalType.LEOPARD.getSymbol(), PlayerPiecesFactory.getPlayerPieces("white"), AnimalType.LEOPARD);
    }

    @Override
    public SelvaPiece createLion() {
        return new BasicSelvaPiece(AnimalType.LION.getSymbol(), PlayerPiecesFactory.getPlayerPieces("white"), AnimalType.LION);
    }

    @Override
    public SelvaPiece createRat() {
        return new BasicSelvaPiece(AnimalType.RAT.getSymbol(), PlayerPiecesFactory.getPlayerPieces("white"), AnimalType.RAT);
    }

    @Override
    public SelvaPiece createTiger() {
        return new BasicSelvaPiece(AnimalType.TIGER.getSymbol(), PlayerPiecesFactory.getPlayerPieces("white"), AnimalType.TIGER);
    }

    @Override
    public SelvaPiece createWolf() {
        return new BasicSelvaPiece(AnimalType.WOLF.getSymbol(), PlayerPiecesFactory.getPlayerPieces("white"), AnimalType.WOLF);
    }
}