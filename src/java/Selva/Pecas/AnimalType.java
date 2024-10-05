package Selva.Pecas;

public enum AnimalType {
    CAT(2, "C"),
    DOG(4, "D"),
    ELEPHANT(8, "E"),
    LEOPARD(5, "P"),
    LION(7, "L"),
    RAT(1,"R"),
    TIGER(6, "T"),
    WOLF(3, "W");

    private final int forca;
    private boolean isTrapped;
    private String symbol;

    AnimalType(int forca, String symbol) {
        this.forca = forca;
        this.isTrapped = false;
        this.symbol = symbol;
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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
}