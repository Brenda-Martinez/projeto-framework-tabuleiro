package Selva.Pecas;

public enum AnimalType {
    CAT(2),
    DOG(4),
    ELEPHANT(8),
    LEOPARD(5),
    LION(7),
    RAT(1),
    TIGER(6),
    WOLF(3);

    private final int forca;
    private boolean isTrapped;

    AnimalType(int forca) {
        this.forca = forca;
        this.isTrapped = false;
    }
    
    // Métodos gerais para todos os animais
    public boolean canCapture(AnimalType animal) {
        if(animal.isTrapped == true){
            return true;
        }
        if(this.equals("RAT")){
            return animal == AnimalType.ELEPHANT;
        }
        if(this.equals("ELEPHANT")){
            return animal != AnimalType.RAT;
        }
        return this.getForca() > animal.getForca();
    }

    public int getForca() {
        return forca;
    }

    public void setTrapped(boolean isTrapped) {
        this.isTrapped = isTrapped;
    }

    public boolean getTrapped() {
        return isTrapped;
    }
    
}