package Tanques.Pecas;

public class TanksPlayer2PieceFactory implements TanksPieceFamilyFactory{

    @Override
    public TankPiece createNormalTank() {
        return TankPieceFlyweightFactory.getTankPiece("black", TankType.NORMAL);
    }

    @Override
    public TankPiece createCommander() {
        return TankPieceFlyweightFactory.getTankPiece("black", TankType.COMANDANTE);
    }

}