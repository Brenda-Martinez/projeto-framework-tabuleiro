package Selva.Pecas;

public class DefaultCaptureStrategy implements CaptureStrategy {
    @Override
    public boolean canCapture(AnimalType attacker, AnimalType defender) {
        if(defender.getTrapped() == true){
            return true;
        }
        return attacker.getForca() > defender.getForca();
    }
}
