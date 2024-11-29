package org.example.lld.tictactoe.model;

import org.example.lld.tictactoe.model.Piece;

public class Player {
    String playerName;
    Piece piece;

    public Player(String playerName, Piece piece) {
        this.playerName = playerName;
        this.piece = piece;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
