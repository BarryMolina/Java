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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author barry
 */
public class GameForm {

    private Stage primaryStage;
    private String name;
    private Difficulty d;
    private Cards cards;
    private ImageView firstCardView = null;
    private int firstCardRow;
    private int firstCardCol;


    private Label lblNumMatches;
    private Label lblNumFound;
    private Label lblNumAttempts;
    private GridPane cardsGrid;
    private Image cardBack;

    

    public GameForm(Stage primaryStage, String name, DifficultyLevel level) {
        this.primaryStage = primaryStage;
        this.name = name;

        d = new Difficulty(level);
        cards = new Cards(d.getTotalCards(), d.getGridRows(), d.getGridCols()); 
//        fillImages();
        System.out.println(cards);
    }
    public void buildForm() {
        Label lblName = new Label("Name: " + name);
        Label lblLevel = new Label("Difficulty: " + d.getLvlName());
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
        
        cardBack = new Image(cards.getBack());

        defineGrid();

        cardsGrid.setOnMouseClicked(new gridClickHandler());
        cardsGrid.setHgap(10);
        cardsGrid.setVgap(10);
        cardsGrid.setAlignment(Pos.CENTER);
        
        VBox root = new VBox (40, headerHBox, cardsGrid);

        Scene scene = new Scene(root, d.getScreenSizeX(), d.getScreenSizeY());
                                            
        primaryStage.setTitle(name + "'s MemoryGame");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void defineGrid() {
        cardsGrid = new GridPane();
        for (int i = 0; i < d.getGridRows(); i++) {
            cardsGrid.getRowConstraints().add(new RowConstraints(d.getCardHeight()));
        }
        for (int i = 0; i < d.getGridCols(); i++) {
            cardsGrid.getColumnConstraints().add(new ColumnConstraints(d.getCardWidth()));
        }
        for (int y = 0; y < d.getGridCols(); y++) {
            for (int x = 0; x < d.getGridRows(); x++) {
                cardsGrid.add(new ImageView(cardBack), y, x);
            }
        }
    }

    class gridClickHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            Node clickedNode = event.getPickResult().getIntersectedNode();
            int rowIndex;
            int colIndex;
            if (clickedNode != cardsGrid) {
                ImageView thisView = (ImageView) clickedNode;
                rowIndex = GridPane.getRowIndex(clickedNode);
                colIndex = GridPane.getColumnIndex(clickedNode);
                thisView.setImage(cards.getCard(rowIndex, colIndex).getImage());
                if (firstCardView == null) {
                    firstCardRow = rowIndex;
                    firstCardCol = colIndex;
                    firstCardView = thisView;
                    
                } 
                else if (thisView != firstCardView) {
                    if (cards.getCard(firstCardRow, firstCardCol).equals(
                                    cards.getCard(rowIndex, colIndex))) {

                        cardsGrid.getChildren().removeAll(firstCardView,
                                                            thisView);
                    }
                    else {
                        thisView.setImage(cardBack);
                        firstCardView.setImage(cardBack);

                    }
                    firstCardView = null;
                }

                System.out.println("Card clicked: " + colIndex + ", "
                        + rowIndex);
                System.out.println("Width: " + cardsGrid.getWidth());
                System.out.println("Height: " + cardsGrid.getHeight());
            }
        }
    }
}
