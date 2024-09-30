package Selva.Pecas;

import Pecas.MoveStrategy;
import Pecas.Piece;
import Selva.SelvaGame;
import Tabuleiro.Board;

public class DefaultMoveStrategy implements MoveStrategy {

    @Override
    public boolean move(Piece peca, int newRow, int newColumn, Board board) {
        SelvaGame selvaGame = SelvaGame.getInstance();
        BasicSelvaPiece piece = (BasicSelvaPiece) peca;
        
        if (!board.isWithinBounds(newRow, newColumn)) {
            System.out.println("ERRO: nova posição fora dos limites do tabuleiro.");
            return false;
        }

        String targetSymbol = board.getGrid()[newRow][newColumn];

        if (targetSymbol.equals("~")) {
            System.out.println("Movimento inválido: " + piece.getAnimalType() + " não pode entrar na água.");
            return false;
        }

        if (targetSymbol.equals("o") || targetSymbol.equals("O")) {
            if ((targetSymbol.equals("O") && piece.getPlayerPieces().getColor().equals("branco")) ||
                (targetSymbol.equals("o") && piece.getPlayerPieces().getColor().equals("preto"))) {
                
                System.out.println("Jogador " + piece.getPlayerPieces().getColor() + " ganhou o jogo!");
                selvaGame.finishGame(piece.getPlayerPieces().getColor());
                return true;
            } else {
                System.out.println("Movimento inválido: Apenas peças da cor correta podem entrar nessa casa.");
                return false;
            }
        }

        if (targetSymbol.equals("#")) {
            board.setSquare(newRow, newColumn, "#" + piece.getSymbol());
            System.out.println("Animal " + piece.getSymbol() + " entrou na casa especial # e agora está vulnerável.");
            piece.getAnimalType().setTrapped(true);
            return true; 
        }

        if (targetSymbol.equals(" ")) {
            board.setPieceAt(newRow, newColumn, piece);
            board.setSquare(piece.getCurrentRow(), piece.getCurrentColumn(), " ");
            piece.setCurrentPosition(newRow, newColumn);
            return true;
        } else {
            Piece targetPiece = board.findPieceBySymbol(targetSymbol);
            
            if (targetPiece != null) {
                System.out.println("Tentando capturar peça: " + targetPiece.getSymbol());
                System.out.println("Força da peça em movimento: " + piece.getAnimalType().getForca());
                System.out.println("Força da peça alvo: " + ((SelvaPiece) targetPiece).getAnimalType().getForca());
                
                if (piece.getAnimalType().canCapture(((SelvaPiece) targetPiece).getAnimalType()) &&
                    !piece.getPlayerPieces().getColor().equals(targetPiece.getPlayerPieces().getColor())) {
                    
                    board.setPieceAt(newRow, newColumn, piece);
                    board.setSquare(piece.getCurrentRow(), piece.getCurrentColumn(), " ");
                    piece.setCurrentPosition(newRow, newColumn);
                    return true;
                } else {
                    System.out.println("Movimento inválido: A peça não pode capturar o alvo.");
                    return false;
                }
            } else {
                System.out.println("Erro: Peça de destino não encontrada.");
                return false;
            }
        }
    }
}
