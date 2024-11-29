package org.example.lld.tictactoe;

import org.example.lld.tictactoe.model.*;

import java.util.*;

public class TicTacToeGame {

    Deque<Player> players;
    Board gameBoard;

    public void intializeGame(){

        players = new LinkedList<>();
        PieceX pieceX = new PieceX();
        Player player1 = new Player("Player 1",pieceX);
        PieceO pieceO = new PieceO();
        Player player2 = new Player("Player 2", pieceO);

        players.add(player1);
        players.add(player2);

        gameBoard = new Board(3);

    }

    public String startGame(){
        boolean noWinner = true;

        while(noWinner){
            Player playerTurn = players.removeFirst();

            gameBoard.printBoard();
            List<Map.Entry<Integer,Integer>> freeCells = gameBoard.getFreeCells();

            if(freeCells.isEmpty()){
                noWinner = false;
                continue;
            }
            List<Integer> list;

            System.out.println("Player : " + playerTurn.getPlayerName() + " , Enter row,column : ");
            try{
                list = getInputValue();
            } catch (Exception e){
                System.out.println("please enter in format '1,2'");
                list = getInputValue();
            }

            int inputRow = list.get(0);
            int inputColumn = list.get(1);

            boolean pieceAdded = gameBoard.addPiece(inputRow,inputColumn,playerTurn.getPiece());
            if(!pieceAdded) {
                //player can not insert the piece into this cell, player has to choose another cell
                System.out.println("Incorrect position chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean winner = isThereWinner(inputRow,inputColumn,playerTurn.getPiece().pieceType);

            if(winner){
                return playerTurn.getPlayerName();
            }
        }

        return "tie";
    }

    private List<Integer> getInputValue() {
        List<Integer> list = new ArrayList<>();
        Scanner inputScanner = new Scanner(System.in);
        String s = inputScanner.nextLine();
        String[] values = s.split(",");

        list.add(Integer.parseInt(values[0]));
        list.add(Integer.parseInt(values[1]));

        return list;
    }


    public boolean isThereWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<gameBoard.size;i++) {

            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<gameBoard.size;i++) {

            if(gameBoard.board[i][column] == null || gameBoard.board[i][column].pieceType != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<gameBoard.size;i++,j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=gameBoard.size-1; i<gameBoard.size;i++,j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}
