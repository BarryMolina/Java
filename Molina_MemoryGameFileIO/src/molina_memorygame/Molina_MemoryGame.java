/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_memorygame;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This class includes the main and start methods for the game.
 */
public class Molina_MemoryGame extends Application {
    
    /**
     * Where the GUI creating starts.
     * @param primaryStage The primary stage.
     */
    @Override
    public void start(Stage primaryStage) {
//        PlayersTable players = new PlayersTable();
//        ScoresTable scores = new ScoresTable();
        IntroForm intro = new IntroForm(primaryStage); // Create a new IntroForm
        intro.buildForm(); // Build the IntroForm and display it
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
     * The Main Method.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
