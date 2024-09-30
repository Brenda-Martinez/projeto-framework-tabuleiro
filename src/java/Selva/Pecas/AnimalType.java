package Selva.Pecas;

import Pecas.MoveStrategy;

public enum AnimalType {
    CAT(2, new DefaultCaptureStrategy(), new DefaultMoveStrategy()),
    DOG(4, new DefaultCaptureStrategy(), new DefaultMoveStrategy()),
    ELEPHANT(8, new ElephantCaptureStrategy(), new DefaultMoveStrategy()),
    LEOPARD(5, new DefaultCaptureStrategy(), new DefaultMoveStrategy()),
    LION(7, new DefaultCaptureStrategy(), new DefaultMoveStrategy()),
    RAT(1, new RatCaptureStrategy(), new RatMoveStrategy()),
    TIGER(6, new DefaultCaptureStrategy(), new DefaultMoveStrategy()),
    WOLF(3, new DefaultCaptureStrategy(), new DefaultMoveStrategy());

    private final int forca;
    CaptureStrategy capture;
    MoveStrategy move;
    private boolean isTrapped;

    AnimalType(int forca, CaptureStrategy cap, MoveStrategy move) {
        this.forca = forca;
        this.capture = cap;
        this.move = move;
        this.isTrapped = false;
    }
    
    // Métodos gerais para todos os animais
    public boolean canCapture(AnimalType animal) {
        if(animal.isTrapped == true){
            return true;
        }
        return this.capture.canCapture(this, animal);
    }

    public int getForca() {
        return forca;
    }

    public MoveStrategy getMove() {
        return move;
    }

    public void setTrapped(boolean isTrapped) {
        this.isTrapped = isTrapped;
    }

    public boolean getTrapped() {
        return isTrapped;
    }
    
}