/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_memorygame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author barry
 */
public class Molina_MemoryGame extends Application {
    
    @Override
    public void start(Stage primaryStage) {
//        PlayersTable players = new PlayersTable();
//        ScoresTable scores = new ScoresTable();
        IntroForm intro = new IntroForm(primaryStage);
        intro.buildForm();
//        Scores scoresData = new Scores();
//        scoresData.resetScores();
//        ScoresForm scores = new ScoresForm(primaryStage);
//        Score score = new Score("Barry", 55, DifficultyLevel.EASY);
//        ScoresForm scores = new ScoresForm(primaryStage, score);
//        scoresData.addScore(score);
//        scoresData.fillScores();
//        System.out.println(scoresData);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
