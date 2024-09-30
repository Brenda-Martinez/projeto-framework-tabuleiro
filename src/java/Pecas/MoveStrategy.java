package Pecas;

import Tabuleiro.Board;

public interface MoveStrategy {
    boolean move(Piece piece, int newRow, int newColumn, Board board);
}
