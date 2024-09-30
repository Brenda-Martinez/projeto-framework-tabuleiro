package Selva.Pecas;

import Pecas.*;
import Tabuleiro.Board;

public class JumpDecorator extends SelvaPieceDecorator {

    public JumpDecorator(BasicSelvaPiece decoratedPiece) {
        super(decoratedPiece);
    }

    @Override
    public boolean move(int newRow, int newColumn, Board board) {
        int currentRow = super.getCurrentRow();
        int currentColumn = super.getCurrentColumn();

        int rowIncrement = 0;
        int columnIncrement = 0;

        if (newRow < currentRow) {
            rowIncrement = -1;
        } else if (newRow > currentRow) {
            rowIncrement = 1;
        }

        if (newColumn < currentColumn) {
            columnIncrement = -1;
        } else if (newColumn > currentColumn) {
            columnIncrement = 1;
        }

        int nextRow = currentRow + rowIncrement;
        int nextColumn = currentColumn + columnIncrement;

        while (board.isWithinBounds(nextRow, nextColumn) && board.getGrid()[nextRow][nextColumn].equals("~")) {
            nextRow += rowIncrement;
            nextColumn += columnIncrement;
        }

        if (board.isWithinBounds(nextRow, nextColumn)) {
            String nextSquare = board.getGrid()[nextRow][nextColumn];

            if (nextSquare.equals(" ") || (board.getPieceAt(nextRow, nextColumn) != null 
                && super.getAnimalType().canCapture(((SelvaPiece) board.getPieceAt(nextRow, nextColumn)).getAnimalType()))) {

                boolean ratInWater = false;
                int checkRow = currentRow + rowIncrement;
                int checkColumn = currentColumn + columnIncrement;

                while (board.isWithinBounds(checkRow, checkColumn) && (checkRow != nextRow || checkColumn != nextColumn)) {
                    Piece pieceInPath = board.getPieceAt(checkRow, checkColumn);
                    if (pieceInPath != null && ((SelvaPiece) pieceInPath).getAnimalType() == AnimalType.RAT) {
                        ratInWater = true;
                        break;
                    }
                    checkRow += rowIncrement;
                    checkColumn += columnIncrement;
                }

                if (!ratInWater) {
                    return super.move(nextRow, nextColumn, board);
                } else {
                    System.out.println("Movimento inválido: O rato está bloqueando o salto.");
                    return false;
                }
            } else {
                System.out.println("Movimento inválido: Não é possível pular para essa posição.");
                return false;
            }
        } else {
            System.out.println("Movimento inválido: Fora dos limites do tabuleiro.");
            return false;
        }
    }
}
