package Tabuleiro;

import Pecas.Piece;

public interface BoardBuilder {
    void setDimensions(int rows, int columns);
    void setSquare(int row, int column, String square);
    void placePiece(int row, int column, Piece piece);
    Board build();
}
