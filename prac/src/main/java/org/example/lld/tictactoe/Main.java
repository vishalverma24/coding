package org.example.lld.tictactoe;

public class Main {
    public static void main(String[] args){
        TicTacToeGame game = new TicTacToeGame();
        game.intializeGame();
        System.out.println("Winner is : " + game.startGame());
    }
}
