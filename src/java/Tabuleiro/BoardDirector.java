package Tabuleiro;

import Selva.Pecas.*;

public class BoardDirector {
    protected final BoardBuilder builder;
    private SelvaPieceFamilyFactory player1Factory;
    private SelvaPieceFamilyFactory player2Factory;

    public BoardDirector(BoardBuilder builder) {
        this.builder = builder;
    }

    public Board constructSelvaBoard() {
        builder.setDimensions(9, 7);
        this.player1Factory = new SelvaPlayer1PieceFactory();
        this.player2Factory = new SelvaPlayer2PieceFactory();

        // adiciona casas do rio (casas com agua)
        builder.setSquare(3, 1, "~");
        builder.setSquare(3, 2, "~");
        builder.setSquare(4, 1, "~");
        builder.setSquare(4, 2, "~");
        builder.setSquare(5, 1, "~");
        builder.setSquare(5, 2, "~");
        builder.setSquare(3, 4, "~");
        builder.setSquare(3, 5, "~");
        builder.setSquare(4, 4, "~");
        builder.setSquare(4, 5, "~");
        builder.setSquare(5, 4, "~");
        builder.setSquare(5, 5, "~");

        // adiciona as tocas
        builder.setSquare(0, 3, "O");
        builder.setSquare(8, 3, "o");
        
        // adiciona as armadilhas
        builder.setSquare(0, 2, "#");
        builder.setSquare(0, 4, "#");
        builder.setSquare(1, 3, "#");

        builder.setSquare(8, 2, "#");
        builder.setSquare(8, 4, "#");
        builder.setSquare(7, 3, "#");

        // peças do jogador 1
        builder.placePiece(0, 0, player1Factory.createLion());
        builder.placePiece(0, 6, player1Factory.createTiger());
        builder.placePiece(2, 6, player1Factory.createElephant());
        builder.placePiece(2, 2, player1Factory.createLeopard());
        builder.placePiece(1, 1, player1Factory.createDog());
        builder.placePiece(2, 4, player1Factory.createWolf()); 
        builder.placePiece(1, 5, player1Factory.createCat());
        builder.placePiece(2, 0, player1Factory.createRat());
 
        //peças do jogador 2
        builder.placePiece(8, 6, player2Factory.createLion());
        builder.placePiece(8, 0, player2Factory.createTiger());
        builder.placePiece(6, 0, player2Factory.createElephant());
        builder.placePiece(6, 4, player2Factory.createLeopard());
        builder.placePiece(7, 5, player2Factory.createDog());
        builder.placePiece(6, 2, player2Factory.createWolf());
        builder.placePiece(7, 1, player2Factory.createCat());
        builder.placePiece(6, 6, player2Factory.createRat());

        return builder.build();
    }

    /*

    public Board constructCamelotBoard() {
        builder.setDimensions(16, 12);

        //casas que nao serao utilizadas, as casas são
        //A1 até E1, H1 até L1
        //A2 até B2, K2 até L2
        //A3, L3
        //A14, L14
        //A15 até B15, K15 até L15
        //A16 até E16, H16 até L16

        //posicoes iniciais pretas
        //posicoes iniciais brancas

        return builder.build();
    }
    */
}
