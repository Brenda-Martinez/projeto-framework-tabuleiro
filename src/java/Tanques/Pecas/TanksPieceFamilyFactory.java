package Tanques.Pecas;

import Pecas.Piece;

public interface TanksPieceFamilyFactory {
    Piece createNormalTank();
    Piece createCommander();
}
