package Selva.Pecas;

import Pecas.*;

public interface SelvaPieceCreator extends PieceCreator{
    Piece factory(String symbol, PlayerPieces jogador, AnimalType animal);
}