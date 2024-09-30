package Game;

import Pecas.Piece;

public class Player1State implements GameState {
    @Override
    public void selectPiece(int row, int column, Game game) {
        Piece piece = game.getBoard().getPieceAt(row, column);
        
        if (piece != null) {
            if (piece.getPlayerPieces().getColor().equals("white")) {
                game.setCurrentRow(row);
                game.setCurrentColumn(column);
                game.setSelectedPiece(piece);
                System.out.println("Peça " + piece.getSymbol() + " selecionada na posição (" + row + ", " + column + ")");
            } else {
                System.out.println("Jogador 1: Você só pode selecionar peças brancas. Selecione outra peça.");
            }
        } else {
            System.out.println("Não há peça na posição selecionada.");
        }
    }

    @Override
    public MoveCommand createMoveCommand(char direction, Game game) {
        Piece selectedPiece = game.getSelectedPiece();
        
        if (selectedPiece != null) {
            if (selectedPiece.getPlayerPieces().getColor().equals("white")) {
                return new MoveCommand(game, direction);
            } else {
                System.out.println("Jogador 1: Você só pode mover peças brancas.");
            }
        } else {
            System.out.println("Nenhuma peça foi selecionada.");
        }
        return null;
    }
}
