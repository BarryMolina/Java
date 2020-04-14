/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_memorygame;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author barry
 */
public class GameForm {

    private Stage primaryStage;
    private String name;
    Difficulty difficulty;
    Cards cards;

    private Label lblNumMatches;
    private Label lblNumFound;
    private Label lblNumAttempts;

    

    public GameForm(Stage primaryStage, String name, DifficultyLevel level) {
        this.primaryStage = primaryStage;
        this.name = name;

        difficulty = new Difficulty(level);
        cards = new Cards(difficulty.getTotalCards());

    }
    public void buildForm() {
        Label lblName = new Label("Name: " + name);
        Label lblLevel = new Label("Difficulty: " + difficulty.getLvlName());
        Label lblMatches = new Label("Matches Left: ");
        Label lblFound = new Label("Matches Found: ");
        Label lblAttempts = new Label("Tries: ");

        lblNumMatches = new Label("0");
        lblNumFound = new Label("0");
        lblNumAttempts = new Label("0");

        HBox matchesHBox = new HBox(5, lblMatches, lblNumMatches);
        HBox foundHBox = new HBox(5, lblFound, lblNumFound);
        HBox attemptsHBox = new HBox(5, lblAttempts, lblNumAttempts);

        HBox headerHBox = new HBox(20, lblLevel, matchesHBox,
                                       foundHBox, attemptsHBox);
        
        headerHBox.setPadding(new Insets(10));
        headerHBox.setAlignment(Pos.TOP_CENTER);
        
        Image cardBack = new Image(cards.getBack());
//        ImageView backView = new ImageView(cardBack);

        GridPane cardsGrid = new GridPane();
        for (int y = 0; y < difficulty.getGridCol(); y++) {
            for (int x = 0; x < difficulty.getGridRow(); x++) {
                cardsGrid.add(new ImageView(cardBack), y, x);
            }
        }
        cardsGrid.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node clickedNode = event.getPickResult().getIntersectedNode();
                int colIndex;
                int rowIndex;
                if (clickedNode != cardsGrid) {
                    colIndex = GridPane.getColumnIndex(clickedNode);
                    rowIndex = GridPane.getRowIndex(clickedNode);
                    System.out.println("Card clicked: " + colIndex + ", "
                            + rowIndex);
                }
            }
        });
        cardsGrid.setHgap(10);
        cardsGrid.setVgap(10);
        cardsGrid.setAlignment(Pos.CENTER);
        
        VBox root = new VBox (40, headerHBox, cardsGrid);
//        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, difficulty.getScreenSizeX(), 
                                            difficulty.getScreenSizeY());
        primaryStage.setTitle(name + "'s MemoryGame");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
