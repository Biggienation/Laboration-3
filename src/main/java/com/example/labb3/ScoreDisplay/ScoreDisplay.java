package com.example.labb3.ScoreDisplay;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ScoreDisplay {
    private final StringProperty playerXScore = new SimpleStringProperty();
    private final StringProperty playerOScore = new SimpleStringProperty();
    private int playerX = 1;
    private int playerO = 1;
    public String playerTurn = "X";

    public String getPlayerTurn (){
        return playerTurn;
    }

    public void setPlayerTurn(String playerTurn){
        this.playerTurn = playerTurn;
    }

    public void changeTurn() {
        if (playerTurn.equals("X")) {
            this.playerTurn = "O";
        } else {
            this.playerTurn = "X";
        }
    }

    public void changeTurn(String turn) {
        this.playerTurn = turn;
    }

    public void addScore() {
        if (playerTurn.equals("X")) {
            setPlayerXScore("X - score: " + playerX++);
        } else {
            setPlayerOScore("O - score: " + playerO++);
        }

    }

    public StringProperty playerXScoreProperty() {
        return playerXScore;
    }

    public void setPlayerXScore(String playerXScore) {
        this.playerXScore.set(playerXScore);
    }

    public StringProperty playerOScoreProperty() {
        return playerOScore;
    }

    public void setPlayerOScore(String playerOScore) {
        this.playerOScore.set(playerOScore);
    }

}