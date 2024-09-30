package Tabuleiro;

import Pecas.Piece;

public class ConcreteBoardBuilder implements BoardBuilder{
    private Board board;

    @Override
    public void setDimensions(int rows, int columns) {
        board = new Board(rows, columns);
    }

    @Override
    public void placePiece(int row, int column, Piece piece) {
        board.setPieceAt(row, column, piece);
        board.addActivePiece(piece);
    }

    @Override
    public void setSquare(int row, int column, String content) {
        board.setSquare(row, column, content);
    }

    @Override
    public Board build() {
        return board;
    }
}
