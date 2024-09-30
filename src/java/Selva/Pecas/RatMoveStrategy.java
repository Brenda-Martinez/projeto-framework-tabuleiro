package Selva.Pecas;

import Pecas.MoveStrategy;
import Pecas.Piece;
import Tabuleiro.Board;

public class RatMoveStrategy implements MoveStrategy {

    @Override
    public boolean move(Piece peca, int newRow, int newColumn, Board board) {
        BasicSelvaPiece piece = (BasicSelvaPiece) peca;
        
        if (!board.isWithinBounds(newRow, newColumn)) {
            System.out.println("ERRO: nova posição fora dos limites do tabuleiro.");
            return false;
        }

        String targetSymbol = board.getGrid()[newRow][newColumn];

        if (targetSymbol.equals("~")) {
            System.out.println(piece.getAnimalType() + " entrou na água.");
            board.setSquare(newRow, newColumn, "~" + piece.getSymbol());
            piece.setCurrentPosition(newRow, newColumn);
            piece.setInWater(true);
            return true;
        }

        if (piece.isInWater()) {
            if (targetSymbol.equals("E") || targetSymbol.equals("e")) {
                System.out.println("Movimento inválido: O Rato não pode capturar um Elefante enquanto sai da água.");
                return false;
            }

            if (targetSymbol.equals("r") || targetSymbol.equals("R")) {
                Piece targetPiece = board.findPieceBySymbol(targetSymbol);
                
                if(!piece.getPlayerPieces().getColor().equals(targetPiece.getPlayerPieces().getColor())) {

                System.out.println("Rato capturou outro Rato.");
                    
                board.setPieceAt(newRow, newColumn, piece);
                board.setSquare(piece.getCurrentRow(), piece.getCurrentColumn(), " ");
                piece.setCurrentPosition(newRow, newColumn);
                return true;
                }
            }

            System.out.println(piece.getAnimalType() + " saiu da água.");
            piece.setInWater(false);
            board.setSquare(piece.getCurrentRow(), piece.getCurrentColumn(), "~");
            board.setSquare(newRow, newColumn, piece.getSymbol());
            piece.setCurrentPosition(newRow, newColumn);
            return true;
        }

        // Delegar a lógica de movimento padrão se não estiver na água
        return new DefaultMoveStrategy().move(piece, newRow, newColumn, board);
    }
}
