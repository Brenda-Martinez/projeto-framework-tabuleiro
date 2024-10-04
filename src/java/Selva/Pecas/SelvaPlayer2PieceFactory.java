package Selva.Pecas;

import Pecas.*;

public class SelvaPlayer2PieceFactory implements SelvaPieceFamilyFactory {
    @Override
    public SelvaPiece createCat() {
        return new BasicSelvaPiece("c", PlayerPiecesFactory.getPlayerPieces("black"), AnimalType.CAT);
    }

    @Override
    public SelvaPiece createDog() {
        return new BasicSelvaPiece("d", PlayerPiecesFactory.getPlayerPieces("black"), AnimalType.DOG);
    }

    @Override
    public SelvaPiece createElephant() {
        return new BasicSelvaPiece("e", PlayerPiecesFactory.getPlayerPieces("black"), AnimalType.ELEPHANT);
    }

    @Override
    public SelvaPiece createLeopard() {
        return new BasicSelvaPiece("p", PlayerPiecesFactory.getPlayerPieces("black"), AnimalType.LEOPARD);
    }

    @Override
    public SelvaPiece createLion() {
        return new BasicSelvaPiece("l", PlayerPiecesFactory.getPlayerPieces("black"), AnimalType.LION);
    }

    @Override
    public SelvaPiece createRat() {
        return new BasicSelvaPiece("r", PlayerPiecesFactory.getPlayerPieces("black"), AnimalType.RAT);
    }

    @Override
    public SelvaPiece createTiger() {
        return new BasicSelvaPiece("t", PlayerPiecesFactory.getPlayerPieces("black"), AnimalType.TIGER);
    }

    @Override
    public SelvaPiece createWolf() {
        return new BasicSelvaPiece("w", PlayerPiecesFactory.getPlayerPieces("black"), AnimalType.WOLF);
    }
}
