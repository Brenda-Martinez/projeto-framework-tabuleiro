package Selva.Pecas;

public interface CaptureStrategy {
    boolean canCapture(AnimalType attacker, AnimalType defender);
}