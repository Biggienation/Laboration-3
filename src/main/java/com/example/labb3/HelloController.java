package com.example.labb3;

import com.example.labb3.Bot.EasyBot;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import com.example.labb3.GameBoard.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

import java.util.Arrays;


public class HelloController {
    @FXML
    public Button Start_button;
    public HBox borderPane = new HBox();
    public Label playerXScore;
    public Label playerOScore;
    public Button restart_button;
    private final GameBoard gameBoard = new GameBoard();

    public void initialize() {
        makeTileBoard(borderPane);
        makePlayerScore();
    }

    private void makePlayerScore() {
        playerXScore.textProperty().bind(gameBoard.getScoreDisplay().playerXScoreProperty());
        playerOScore.textProperty().bind(gameBoard.getScoreDisplay().playerOScoreProperty());
        playerXScore.setFont(Font.font(20));
        playerOScore.setFont(Font.font(20));
    }

    private void makeTileBoard(HBox borderPane) {
        borderPane.setAlignment(Pos.CENTER);
        borderPane.getChildren().add(gameBoard.getGrid());
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void pressOnRestartGame(MouseEvent mouseEvent) {
        pressOnNext(mouseEvent);
        //TODO Reset playerscore
    }

    public void pressOnNext(MouseEvent mouseEvent) {
        resetBoard();
    }

    private void resetBoard() {
        Arrays.stream(gameBoard.getTiles()).forEach(tiles -> Arrays.stream(tiles).forEach(tile -> tile.setLabel("")));
        gameBoard.startGame();
    }

    public void ChangeToEasyBot(ActionEvent actionEvent) {
        resetBoard();
        //TODO Reset playerscore
        gameBoard.setBot(new EasyBot());

    }

    public void changeToPlayer(ActionEvent actionEvent) {
        resetBoard();
        gameBoard.setBot(null);
    }
}