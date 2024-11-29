package org.example.lld.tictactoe.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Board {

    public int size;
    public Piece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new Piece[size][size];
    }

    public boolean addPiece(int row, int col, Piece piece){
        if (board[row][col]!=null){
            return false;
        }
        board[row][col]=piece;
        return true;
    }

    public List<Map.Entry<Integer,Integer>>  getFreeCells(){
        List<Map.Entry<Integer,Integer>> freeCells = new ArrayList<>();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]==null){
                    Map.Entry entry = (Map.Entry) board[i][j];
                    freeCells.add(entry);
                }
            }
        }
        return freeCells;
    }

    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }

}
