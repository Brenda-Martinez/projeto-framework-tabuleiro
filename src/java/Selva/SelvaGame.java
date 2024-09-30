package Selva;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Game.*;
import Tabuleiro.*;
import Pecas.Piece;
import Selva.Pecas.SelvaPiece;

public class SelvaGame implements Game{
    private static SelvaGame instance;
    private GameState currentState;
    private Board board;
    private int currentRow, currentColumn;
    private SelvaPiece selectedPiece;
    private List<SelvaPiece> activePieces;

    private CommandManager commandManager;
    private Stack<MoveCommand> commandHistory = new Stack<>();
    private Stack<MoveCommand> redoStack = new Stack<>();

    private Caretaker caretaker;

    private SelvaGame() {
        BoardBuilder builder = new ConcreteBoardBuilder();
        BoardDirector director = new BoardDirector(builder);
        this.board = director.constructSelvaBoard();
        this.currentState = new Player1State();
        this.commandManager = new CommandManager();
        this.caretaker = new Caretaker();
        activePieces = new ArrayList<>();
    }

    public static synchronized SelvaGame getInstance() {
        if (instance == null) {
            instance = new SelvaGame();
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
                if (piece instanceof SelvaPiece) {
                    this.activePieces.add((SelvaPiece) piece);
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
        System.out.println("Novo Jogo Selva");
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
        show(); // Mostra o estado atual do jogo
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
        System.out.println("O jogo terminou! Jogador " + winningColor + " ganhou!");
        System.exit(0);
    }

    public Memento createMemento() {
        return new Memento(board.getGrid(), new ArrayList<>(activePieces));
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void addPiece(SelvaPiece piece) {
        activePieces.add(piece);
    }

    public void removePiece(SelvaPiece piece) {
        activePieces.remove(piece);
    }

    public List<SelvaPiece> getActivePieces() {
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
        this.selectedPiece = ((SelvaPiece) piece);
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