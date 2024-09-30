package Pecas;

import Tabuleiro.Board;

public interface Piece {
    String getSymbol();
    PlayerPieces getPlayerPieces(); // jogador branco(1) ou preto(2)
    String showPiece();
    boolean move(int newRow, int newColumn, Board board);
}