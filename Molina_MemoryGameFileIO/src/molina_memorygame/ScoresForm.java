/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_memorygame;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * This class creates the form to display the high scores.
 */
public class ScoresForm {

    // The primary stage
    private Stage primaryStage;
    // The scene
    private Scene scene;
    // The grid to hold the scores
    private GridPane scoresGrid;
    // The scores
    private Scores scores;
    // Constants to hold info for the grid
    private final int GRID_ROWS = 5;
    private final int GRID_COLS = 6;
    private final int EASY_COL = 0;
    private final int MED_COL = 2;
    private final int HARD_COL = 4;
    // Constants to hold string values for each level.
    private final String CLASS_EASY = "easy";
    private final String CLASS_MED = "medium";
    private final String CLASS_HARD = "hard";


    /**
     * Creates a scores object and fills it, then builds the form and displays it.
     * @param stage The Primary Stage
     */
    public ScoresForm(Stage stage) {

        primaryStage = stage;
        scores = new Scores();
        scores.fillScores();
        buildForm();
        stage.setScene(scene);
        stage.setTitle("High Scores");
        stage.show();
    }
    /**
     * Creates a scores form but takes a new Score that it first adds to the score file.
     * @param stage The primary stage
     * @param newScore The new score to add.
     */
    public ScoresForm(Stage stage, Score newScore) {

        primaryStage = stage;
        scores = new Scores();
        scores.addScore(newScore);
        scores.fillScores();
        buildForm();
        stage.setScene(scene);
        stage.setTitle("High Scores");
        stage.show();
    }

    /**
     * Builds the high score form.
     */
    private void buildForm() {
        Label title = new Label("High Scores");
        title.getStyleClass().add("title");

        Button btnPlayAgain = new Button("Play Again!");
        btnPlayAgain.setDefaultButton(true);
		btnPlayAgain.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				IntroForm intro = new IntroForm(primaryStage);
				intro.buildForm();
			}
		});
        Button btnQuit = new Button("Quit");
        btnQuit.setCancelButton(true);
		btnQuit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				System.exit(0);
			}
		});
        HBox btnHBox = new HBox(20, btnQuit, btnPlayAgain);

        buildGrid();
        Group group = new Group(scoresGrid);
        scoresGrid.setAlignment(Pos.CENTER);
//        scoresGrid.setGridLinesVisible(true);
        
        VBox vBox = new VBox(60, title, group, btnHBox);
        vBox.setAlignment(Pos.CENTER);

        scene = new Scene(vBox, 600, 400);
        scene.getStylesheets().add("molina_memorygame/styles.css");
    }
        
    /**
     * Builds the grid the hold score data
     */
    private void buildGrid() {
        scoresGrid = new GridPane();
        for (int i = 0; i < GRID_ROWS; i++) {
			scoresGrid.getRowConstraints().add(new RowConstraints(30));
        }
        for (int i = 0; i < GRID_COLS; i++) {
            scoresGrid.getColumnConstraints().add(new ColumnConstraints(80));
        }
        HBox bxEasy = new HBox(new Label("Easy"));
        HBox bxMed = new HBox(new Label("Medium"));
        HBox bxHard = new HBox(new Label("Hard"));

        bxEasy.getStyleClass().add(CLASS_EASY);
        bxEasy.getStyleClass().add("heading-1");
        bxMed.getStyleClass().add(CLASS_MED);
        bxMed.getStyleClass().add("heading-1");
        bxHard.getStyleClass().add(CLASS_HARD);
        bxHard.getStyleClass().add("heading-1");

        scoresGrid.add(bxEasy, 0, 0, 2, 1);
        scoresGrid.add(bxMed, 2, 0, 2, 1);
        scoresGrid.add(bxHard, 4, 0, 2, 1);

        addHeadings(EASY_COL, CLASS_EASY);
        addHeadings(MED_COL, CLASS_MED);
        addHeadings(HARD_COL, CLASS_HARD);

        fillGrid(scores.getEasyScores(), EASY_COL);
        fillGrid(scores.getMediumScores(), MED_COL);
        fillGrid(scores.getHardScores(), HARD_COL);
    }
    /**
     * Adds the headings to scoresGrid.
     * @param colStart The column to start at.
     * @param className The CSS class to add.
     */
    public void addHeadings(int colStart, String className) {
        HBox bxName = new HBox(new Label("Name"));
        HBox bxTurns = new HBox(new Label("Turns"));
        bxName.getStyleClass().add(className);
        bxName.getStyleClass().add("heading-2");
        bxTurns.getStyleClass().add(className);
        bxTurns.getStyleClass().add("heading-2");
        scoresGrid.add(bxName, colStart, 1);
        scoresGrid.add(bxTurns, colStart + 1, 1);
    }
    /**
     * Fills the appropriate columns of scoresGrid with names and scores.
     * @param scoreArray The scores to fill.
     * @param colStart The column to start at.
     */
    public void fillGrid(ArrayList<Score> scoreArray, int colStart) {
        // The name on the score
        String name;
        // The number of turns taken.
        String score;
        // The CSS class to add to this cell.
        String className = "";
        // Set className depending on the difficulty level of these scores
        if (colStart == EASY_COL) {
            className = CLASS_EASY;
        }
        else if (colStart == MED_COL) {
            className = CLASS_MED;
        }
        else if (colStart == HARD_COL) {
            className = CLASS_HARD;
        }
        for (int scoreIdx = 0, gridRow = 2; 
                 gridRow < GRID_ROWS; 
                 scoreIdx++, gridRow++) {
            HBox nameCell = new HBox();
            HBox scoreCell = new HBox();
            nameCell.getStyleClass().add(className);
            scoreCell.getStyleClass().add(className);
            if (scoreIdx < scoreArray.size()) {
                name = scoreArray.get(scoreIdx).getName();
                score = Integer.toString(scoreArray.get(scoreIdx).getScore());
                nameCell.getChildren().add(new Label(name));
                scoreCell.getChildren().add(new Label(score));
            }
            scoresGrid.add(nameCell, colStart, gridRow);
            scoresGrid.add(scoreCell, colStart + 1, gridRow);
        }
    }
}
