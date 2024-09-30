package Tanques.Pecas;

public class TanksPlayer1PieceFactory implements TanksPieceFamilyFactory{

    @Override
    public TankPiece createNormalTank() {
        return TankPieceFlyweightFactory.getTankPiece("white", TankType.NORMAL);
    }

    @Override
    public TankPiece createCommander() {
        return TankPieceFlyweightFactory.getTankPiece("white", TankType.COMANDANTE);
    }

}