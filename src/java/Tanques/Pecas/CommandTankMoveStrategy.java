package Tanques.Pecas;

import java.util.List;

import Pecas.MoveStrategy;
import Pecas.Piece;
import Tabuleiro.Board;
import Tabuleiro.ConcreteBoardBuilder;
import Tanques.Tabuleiro.TanksBattleBoardDirector;

public class CommandTankMoveStrategy implements MoveStrategy {

    private List<int[]> contaminatedAreaCoordinates;
    private List<int[]> player1BaseCoordinates;
    private List<int[]> player2BaseCoordinates;

    private ConcreteBoardBuilder builder;
    private TanksBattleBoardDirector director = new TanksBattleBoardDirector(builder);

    public CommandTankMoveStrategy() {
        this.contaminatedAreaCoordinates = director.getContaminatedAreaCoordinates();
        this.player1BaseCoordinates = director.getPlayer1BaseCoordinates();
        this.player2BaseCoordinates = director.getPlayer2BaseCoordinates();
    }

    @Override
    public boolean move(Piece peca, int newRow, int newColumn, Board board) {

        TankPiece piece = (TankPiece) peca;

        int currentRow = piece.getCurrentRow();
        int currentColumn = piece.getCurrentColumn();

        String playerColor = piece.getPlayerPieces().getColor(); 
        boolean isPlayer1Tank = playerColor.equals("white");
        boolean isPlayer2Tank = playerColor.equals("black");
        
        
        if ((isPlayer1Tank && isInBase(piece, player2BaseCoordinates)) || 
            (isPlayer2Tank && isInBase(piece, player1BaseCoordinates))) {
            System.out.println("O tanque está na base adversária e não pode sair.");
            return false;
        }

        
        if (isInContaminatedArea(newRow, newColumn)) {
            return true;
        }


        if (!canMoveThroughPath(currentRow, currentColumn, newRow, newColumn, board)) {
            System.out.println("O movimento não é permitido. Não pode atravessar outros tanques ou minas.");
            return false;
        }

        return true;
    }

    private boolean isInContaminatedArea(int row, int column) {
        for (int[] coord : contaminatedAreaCoordinates) {
            if (coord[0] == row && coord[1] == column) {
                return true;
            }
        }
        return false;
    }

    private boolean isInBase(Piece peca, List<int[]> baseCoordinates) {
        TankPiece piece = (TankPiece) peca;

        for (int[] coord : baseCoordinates) {
            if (coord[0] == piece.getCurrentRow() && coord[1] == piece.getCurrentColumn()) {
                return true;
            }
        }
        return false;
    }

    private boolean canMoveThroughPath(int currentRow, int currentColumn, int newRow, int newColumn, Board board) {

        Piece pieceAtDestination = board.getPieceAt(newRow, newColumn);
    
        if (pieceAtDestination != null && 
            !pieceAtDestination.getPlayerPieces().getColor().equals(board.getPieceAt(currentRow, currentColumn).getPlayerPieces().getColor())) {
            return true; 
        }
    
        if (board.getGrid()[newRow][newColumn].equals("#")) {
            System.out.println("Movimento não permitido. Há uma mina na posição de destino.");
            return false;
        }
    
        return pieceAtDestination == null;
    }  
    
}