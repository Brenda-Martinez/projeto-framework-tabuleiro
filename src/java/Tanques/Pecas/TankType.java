package Tanques.Pecas;

import Pecas.MoveStrategy;

public enum TankType {
    NORMAL(new DefaultTankMoveStrategy()), COMANDANTE(new CommandTankMoveStrategy());

    MoveStrategy move;

    TankType(MoveStrategy move){
        this.move = move;
    }

    public MoveStrategy getMove() {
        return move;
    }
}
