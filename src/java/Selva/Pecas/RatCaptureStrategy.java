package Selva.Pecas;

public class RatCaptureStrategy implements CaptureStrategy {
    @Override
    public boolean canCapture(AnimalType attacker, AnimalType defender) {
        if(defender.getTrapped() == true){
            return true;
        }
        return defender == AnimalType.ELEPHANT;
    }
}