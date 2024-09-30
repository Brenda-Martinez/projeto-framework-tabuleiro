package Pecas;

import java.util.HashMap;
import java.util.Map;

public class PlayerPiecesFactory {
    private static final Map<String, PlayerPieces> piecesCache = new HashMap<>();

    public static PlayerPieces getPlayerPieces(String color) {
        PlayerPieces piece = piecesCache.get(color);

        if (piece == null) {
            if (color.equalsIgnoreCase("white")) {
                piece = new WhitePieces();
            } else if (color.equalsIgnoreCase("black")) {
                piece = new BlackPieces();
            }
            piecesCache.put(color, piece);
        }

        return piece;
    }
}
