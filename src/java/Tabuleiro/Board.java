package Tabuleiro;

import java.util.ArrayList;
import java.util.List;

import Game.Memento;
import Pecas.Piece;

public class Board {
    private String[][] grid;
    private List<Piece> activePieces;

    public Board(int rows, int columns) {
        grid = new String[rows][columns];
        this.activePieces = new ArrayList<>();
        initializeBoard();
    }

    public void placePiece(int row, int column, String piece) {
        if (isWithinBounds(row, column)) {
            grid[row][column] = piece;
        } else {
            System.out.println("ERRO: posição fora dos limites do tabuleiro.");
        }
    }

    public void setPieceAt(int row, int column, Piece piece) {
        grid[row][column] = piece.getSymbol();
    }

    public void addActivePiece(Piece piece) {
        activePieces.add(piece);
    }

    public void setSquare(int row, int column, String piece) {
        if (isWithinBounds(row, column)) {
            grid[row][column] = piece;
        } else {
            System.out.println("ERRO: posição fora dos limites do tabuleiro.");
        }
    }

    private void initializeBoard() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = " ";
            }
        }
    }

    public Piece getPieceAt(int row, int column) {
        if (isWithinBounds(row, column)) {
            String cellContent = grid[row][column];
            if (!cellContent.equals(" ") && !cellContent.equals("~") && !cellContent.equals("o") && !cellContent.equals("#")) {
                return findPieceBySymbol(cellContent);
            }
        }
        return null; 
    }

    public Piece findPieceBySymbol(String symbol) {
        for (Piece piece : activePieces) {
            if (piece.getSymbol().equals(symbol)) {
                return piece;
            }
        }
        return null;
    }

    public void movePieceWithDirection(int currentRow, int currentColumn, char direction, Piece movingPiece) {
        int newRow = currentRow;
        int newColumn = currentColumn;
    
        switch (Character.toLowerCase(direction)) {
            case 'w':
                newRow = currentRow - 1;
                break;
            case 's':
                newRow = currentRow + 1;
                break;
            case 'a':
                newColumn = currentColumn - 1;
                break;
            case 'd':
                newColumn = currentColumn + 1;
                break;
            default:
                System.out.println("Direção inválida: use W, A, S ou D para mover a peça.");
        }
    
        if (isWithinBounds(newRow, newColumn)) {
            Piece piece = getPieceAt(currentRow, currentColumn);
            if (piece != null) {
                if (piece.move(newRow, newColumn, this)) {
                    grid[currentRow][currentColumn] = " ";
                    grid[newRow][newColumn] = piece.getSymbol();
                    System.out.println("Peça " + piece.getSymbol() + " movida para (" + newRow + ", " + newColumn + ")");
                } else {
                    System.out.println("Movimento inválido: A peça não pode se mover para a nova posição.");
                }
            } else {
                System.out.println("Não há nenhuma peça na posição atual (" + currentRow + ", " + currentColumn + ")");
            }
        } else {
            System.out.println("ERRO: nova posição fora dos limites do tabuleiro.");
        }
    }

    public void movePieceBack(int newRow, int newColumn, int previousRow, int previousColumn, Piece piece) {
        if (isWithinBounds(newRow, newColumn) && isWithinBounds(previousRow, previousColumn)) {
           
            grid[newRow][newColumn] = " ";
            
            grid[previousRow][previousColumn] = piece.getSymbol();
            System.out.println("Peça " + piece.getSymbol() + " movida de volta para (" + previousRow + ", " + previousColumn + ")");
        } else {
            System.out.println("ERRO: Movimento de volta fora dos limites do tabuleiro.");
        }
    }

    public Memento saveState() {
        String[][] currentBoardState = copyGrid();
        return new Memento(currentBoardState, activePieces);
    }

    public void restoreState(Memento memento) {
        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(memento.getBoardState()[i], 0, grid[i], 0, grid[i].length);
        }
        activePieces.clear();
        activePieces.addAll(memento.getActivePiecesState());
    }

    private String[][] copyGrid() {
        String[][] newGrid = new String[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(grid[i], 0, newGrid[i], 0, grid[i].length);
        }
        return newGrid;
    }

    public void display() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print("[" + grid[i][j] + "]");
            }
            System.out.println();
        }
    }

    public boolean isWithinBounds(int row, int column) {
        return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length;
    }

    public String[][] getGrid() {
        return grid;
    }

    public void setGrid(String[][] grid) {
        this.grid = new String[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            this.grid[i] = grid[i].clone();
        }
    }
}
