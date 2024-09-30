package Selva.Pecas;

public class ElephantCaptureStrategy implements CaptureStrategy {
    @Override
    public boolean canCapture(AnimalType attacker, AnimalType defender) {
        if(defender.getTrapped() == true){
            return true;
        }
        return defender != AnimalType.RAT;
    }
}