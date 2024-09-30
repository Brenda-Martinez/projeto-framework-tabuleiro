package Selva.Pecas;

import Pecas.*;

public class ConcreteSelvaPieceCreator implements SelvaPieceCreator{

    @Override
    public Piece factory(String symbol, PlayerPieces jogador) {
        throw new UnsupportedOperationException("Unimplemented method 'factory': Paramentros incorretos, necessario definir o tipo do animal.");
    }

    @Override
    public Piece factory(String symbol, PlayerPieces jogador, AnimalType animal) {
        return new BasicSelvaPiece(symbol, jogador, animal);
    }
    
}
