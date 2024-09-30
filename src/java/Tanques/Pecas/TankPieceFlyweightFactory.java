package Tanques.Pecas;

import Pecas.PlayerPieces;
import Pecas.PlayerPiecesFactory;

import java.util.HashMap;
import java.util.Map;

public class TankPieceFlyweightFactory {
    // Cache que armazena as peças, associando cada peça a uma chave única
    private static final Map<String, TankPiece> tankPiecesCache = new HashMap<>();

    public static TankPiece getTankPiece(String color, TankType tankType) {
        // Define o símbolo de acordo com a cor e tipo de tanque
        String symbol;
        if (tankType == TankType.COMANDANTE) {
            symbol = color.equalsIgnoreCase("white") ? "C" : "c";
        } else {
            symbol = color.equalsIgnoreCase("white") ? "T" : "t";
        }

        // Gera a chave com base na cor, tipo de tanque e símbolo
        String key = color + "-" + tankType + "-" + symbol;

        // Verifica se a peça já existe no cache
        TankPiece tankPiece = tankPiecesCache.get(key);

        if (tankPiece == null) {
            // Obtém as peças do jogador usando a fábrica de PlayerPieces
            PlayerPieces playerPieces = PlayerPiecesFactory.getPlayerPieces(color);

            // Cria uma nova peça de tanque com o símbolo correto, cor do jogador e tipo de tanque
            tankPiece = new TankPiece(symbol, playerPieces, tankType);

            // Armazena a nova peça no cache, com a chave correta
            tankPiecesCache.put(key, tankPiece);
        }

        return tankPiece;
    }
}
