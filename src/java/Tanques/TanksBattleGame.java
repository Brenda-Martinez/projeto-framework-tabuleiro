package Tanques;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Game.*;
import Tabuleiro.*;
import Pecas.Piece;
import Tanques.Pecas.TankPiece;
import Tanques.Tabuleiro.*;

public class TanksBattleGame implements Game{
    private static TanksBattleGame instance;
    private GameState currentState;
    private Board board;
    private int currentRow, currentColumn;
    private Piece selectedPiece;
    private List<Piece> activePieces;
    TanksBattleBoardDirector director;

    private CommandManager commandManager;
    private Stack<MoveCommand> commandHistory = new Stack<>();
    private Stack<MoveCommand> redoStack = new Stack<>();

    private Caretaker caretaker;

    private TanksBattleGame() {
        BoardBuilder builder = new ConcreteBoardBuilder();
        this.director = new TanksBattleBoardDirector(builder);
        this.board = director.constructTankBattleBoard();
        this.currentState = new Player1State();
        this.commandManager = new CommandManager();
        this.caretaker = new Caretaker();
        activePieces = new ArrayList<>();
    }

    public static synchronized TanksBattleGame getInstance() {
        if (instance == null) {
            instance = new TanksBattleGame();
        }
        return instance;
    }

    public void saveGame() {
        Memento memento = createMemento();
        caretaker.saveMemento(memento);
        System.out.println("Jogo salvo com sucesso!");
    }

    public void loadGame() {
        Memento memento = caretaker.getMemento();
        if (memento != null) {
            this.board.setGrid(memento.getBoardState());
            
            this.activePieces.clear(); 
            for (Piece piece : memento.getActivePiecesState()) {
                if (piece instanceof Piece) {
                    this.activePieces.add((Piece) piece);
                }
            }
            
            System.out.println("Jogo restaurado com sucesso!");
        } else {
            System.out.println("Nenhum estado salvo encontrado.");
        }
        show();
    }
    
    public void show(){
        this.board.display();
    }

    public void startGame() {
        System.out.println("Novo Jogo Batalha de Tanques");
        show();
    }

    public void selectPiece(int row, int column) {
        if (board != null) {
            currentState.selectPiece(row, column, this);
        } else {
            System.out.println("Partida não existente.");
        }
    }

    public void makeMove(char direction) {
        if (currentState != null) {
            MoveCommand command = currentState.createMoveCommand(direction, this);
            
            if (command != null) {
                commandManager.executeCommand(command);
                commandHistory.push(command);
                redoStack.clear();
            }
        } else {
            System.out.println("Nenhuma peça selecionada ou partida não existente.");
        }
        
        show();
    }
    

    public void undo() {
        if (!commandHistory.isEmpty()) {
            MoveCommand lastCommand = commandHistory.pop();
            commandManager.undo();
            redoStack.push(lastCommand);
            System.out.println("Movimento desfeito.");
        } else {
            System.out.println("Nenhum movimento para desfazer.");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            MoveCommand lastUndoCommand = redoStack.pop();
            commandManager.redo();
            commandHistory.push(lastUndoCommand);
            System.out.println("Movimento refeito.");
        } else {
            System.out.println("Nenhum movimento para refazer.");
        }
    }

    @Override
    public void changeTurn() {
        if (currentState instanceof Player1State) {
            currentState = new Player2State();
            System.out.println("Turno do Jogador 2.");
        } else {
            currentState = new Player1State();
            System.out.println("Turno do Jogador 1.");
        }
    }

    
    public void finishGame(String winningColor) {
        if ("empate".equals(winningColor)) {
            System.out.println("O jogo terminou em empate!");
        } else {
            System.out.println("O jogo terminou! Jogador " + winningColor + " ganhou!");
        }
        System.exit(0);
    }

    public Memento createMemento() {
        return new Memento(board.getGrid(), new ArrayList<>(activePieces));
    }

    public boolean checkIfGameFinished(String playerColor) {
        boolean allTanksInEnemyBase = true;
        List<int[]> enemyBasePositions = getEnemyBasePositions(playerColor);
        
        for (Piece piece : activePieces) {
            
            if (piece.getPlayerPieces().getColor().equals(playerColor)) {
                
                if (!isInEnemyBase((TankPiece)piece, enemyBasePositions, false)) {
                    allTanksInEnemyBase = false;
                    break;
                }
            }
        }
        
        return allTanksInEnemyBase;
    }
    
    private List<int[]> getEnemyBasePositions(String playerColor) {
        List<int[]> enemyBasePositions = new ArrayList<>();
        
        if ("black".equals(playerColor)) {
            enemyBasePositions = director.getPlayer1BaseCoordinates();
        } else if ("white".equals(playerColor)) {
            enemyBasePositions = director.getPlayer2BaseCoordinates();
        }
        
        return enemyBasePositions;
    }

    public int calculateScore(String playerColor) {
        int score = 0;
        
        List<int[]> enemyBasePositions = getEnemyBasePositions(playerColor);
        
        for (Piece piece : activePieces) {
            if (piece.getPlayerPieces().getColor().equals(playerColor)) {

                if (piece.getPlayerPieces().equals("COMANDANTE")) {
                   
                    if (isInEnemyBase((TankPiece)piece, enemyBasePositions, true)) {
                        score += 3; 
                    } else if (isInEnemyBase((TankPiece)piece, enemyBasePositions, false)) {
                        score += 2; 
                    }
                } else {
                    if (isInEnemyBase((TankPiece)piece, enemyBasePositions, false)) {
                        score += 2; 
                    }
                }
            } else {
                score += 1;
            }
        }
        return score;
    }

    private boolean isInEnemyBase(TankPiece piece, List<int[]> enemyBasePositions, boolean isCommandTank) {
        for (int[] pos : enemyBasePositions) {
            if (piece.getCurrentRow() == pos[0] && piece.getCurrentColumn() == pos[1]) {
                return true;
            }
        }
        return false;
    }
    
    private String determineWinner() {
        int blackScore = calculateScore("black");
        int whiteScore = calculateScore("white");
    
        if (blackScore > whiteScore) {
            return "black";
        } else if (whiteScore > blackScore) {
            return "white";
        } else {
            System.out.println("Empate!");
            return "empate";
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void addPiece(Piece piece) {
        activePieces.add(piece);
    }

    public void removePiece(Piece piece) {
        activePieces.remove(piece);
    }

    public List<Piece> getActivePieces() {
        return activePieces;
    }
    
    @Override
    public void setCurrentColumn(int column) {
        this.currentColumn = column;
    }

    @Override
    public void setCurrentRow(int row) {
        this.currentRow = row;
    }

    @Override
    public void setSelectedPiece(Piece piece) {
        this.selectedPiece = ((Piece) piece);
    }

    @Override
    public int getCurrentRow() {
        return currentRow;
    }

    @Override
    public int getCurrentColumn() {
        return currentColumn;
    }

    @Override
    public Piece getSelectedPiece() {
        return selectedPiece;
    }
}
