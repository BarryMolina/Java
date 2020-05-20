/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_memorygame;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * This class builds the form for the game.
 */
public class GameForm {

    // The primary stage
    private Stage primaryStage;
    // The ScoreForm to be displayed after the game is over.
    private ScoresForm scoresForm;
    // The player's name
    private String name;
    // A difficulty object to get information relating to the selected difficulty
    private Difficulty d;
    // The Cards object used to get each card in play
    private Cards cards;
    // 
    private ImageView firstCardView = null;
    private ImageView firstCard = null;
    private ImageView secondCard = null;
    // The row of the first card of the turn
    private int firstCardRow;
    // The column of the first card of the turn
    private int firstCardCol;


    private Label lblNumMatches;
    private Label lblNumFound;
    private Label lblNumAttempts;
    private GridPane cardsGrid;
    private Image cardBack;

    private int numMatches;
    private int numFound = 0;
    private int numAttempts = 0;

    /**
     * Create Difficulty and Cards objects.
     * @param primaryStage The Primary Stage.
     * @param name Player name.
     * @param level Difficulty selected.
     */
    public GameForm(Stage primaryStage, String name, DifficultyLevel level) {
        this.primaryStage = primaryStage;
        this.name = name;

        d = new Difficulty(level);
        cards = new Cards(d.getTotalCards(), d.getGridRows(), d.getGridCols()); 
        numMatches = d.getTotalCards() / 2;
        //System.out.println(cards);
    }
    /**
     * Build GUI objects and attach them to the scene.
     */
    public void buildForm() {
        Label lblName = new Label("Name: " + name);
        Label lblLevel = new Label("Difficulty: " + d.getLvlName());
        Label lblMatches = new Label("Matches Left: ");
        Label lblFound = new Label("Matches Found: ");
        Label lblAttempts = new Label("Tries: ");

        lblNumMatches = new Label(Integer.toString(numMatches));
        lblNumFound = new Label(Integer.toString(numFound));
        lblNumAttempts = new Label(Integer.toString(numAttempts));

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
		cardsGrid.setPadding(new Insets(20));
//		cardsGrid.setGridLinesVisible(true);
        cardsGrid.setAlignment(Pos.CENTER);
        VBox root = new VBox (40, headerHBox, cardsGrid);
//                root.setStyle("-fx-border-style: solid inside;"
//                        + "-fx-border-color: blue;"
//                        + "-fx-border-width: 2;");
        root.setAlignment(Pos.TOP_CENTER);
		root.setVgrow(cardsGrid, Priority.ALWAYS);

        Scene scene = new Scene(root, d.getScreenSizeX(), d.getScreenSizeY());
                                            
        primaryStage.setTitle(name + "'s MemoryGame");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Build grid of cards and attach event listener to each.
     */
    private void defineGrid() {
        cardsGrid = new GridPane();
        for (int i = 0; i < d.getGridRows(); i++) {
			RowConstraints row = new RowConstraints();
			row.setPercentHeight((100 / d.getGridRows()) * 100);
			cardsGrid.getRowConstraints().add(row);
        }
        for (int i = 0; i < d.getGridCols(); i++) {
			ColumnConstraints col = new ColumnConstraints();
			col.setPercentWidth((100 / d.getGridCols()) * 100);
			cardsGrid.getColumnConstraints().add(col);
        }
        for (int y = 0; y < d.getGridCols(); y++) {
            for (int x = 0; x < d.getGridRows(); x++) {
                ResizableImageView view = new ResizableImageView(cardBack);
                HBox.setHgrow(view, Priority.ALWAYS);
                
                HBox cardBox = new HBox(view);
                cardBox.setAlignment(Pos.CENTER);
//                cardBox.setStyle("-fx-border-style: solid inside;"
//                        + "-fx-border-color: blue;"
//                        + "-fx-border-width: 2;");
                cardsGrid.add(cardBox, y, x);
            }
        }
    }

    /**
     * Logic for grid click.
     */
    class gridClickHandler implements EventHandler<MouseEvent> {
        /**
         * Show front side of card when grid is clicked.
         * @param event Mouse click event.
         */
        @Override
        public void handle(MouseEvent event) {
            // The node clicked
            Node clickedNode = event.getPickResult().getIntersectedNode();
            // The row index of the node
            int rowIndex;
            // The column index of the node.
            int colIndex;
            // If this is the first card and two cards were flipped before this one.
            if (secondCard != null) {
                // flip over the first two cards
                firstCard.setImage(cardBack);
                secondCard.setImage(cardBack);
                // reset values
                firstCard = null;
                secondCard = null;
            }
            // If the node clicked is and ImageView
            if (clickedNode != cardsGrid && !(clickedNode instanceof HBox)) {
                // An ImageView object to hold the current node
                ImageView thisView = (ImageView) clickedNode;
                rowIndex = GridPane.getRowIndex(clickedNode.getParent());
                colIndex = GridPane.getColumnIndex(clickedNode.getParent());
                thisView.setImage(cards.getCard(rowIndex, colIndex).getImage());
                // If this is the first card of the turn
                if (firstCardView == null) {
                    firstCardRow = rowIndex;
                    firstCardCol = colIndex;
                    firstCardView = thisView;
                    firstCard = thisView;
                } 
                // If the same card is not clicked twice
                else if (thisView != firstCardView) {
                    secondCard = thisView;
                    // Check if cards are the same
                    if (cards.getCard(firstCardRow, firstCardCol).equals(
                                    cards.getCard(rowIndex, colIndex))) {
                        // Get the fade sequence for each card
                        SequentialTransition fade = getFadeSequence(firstCard);
                        SequentialTransition fade2 = getFadeSequence(secondCard);

                        // Play the fade sequences
                        fade.play();
                        fade2.play();

                        // Reset the first and second card views
                        firstCard = null;
                        secondCard = null;
                        // update the counters and their labels
                        lblNumMatches.setText(Integer.toString(--numMatches));
                        lblNumFound.setText(Integer.toString(++numFound));
                    }
                    firstCardView = null;
                    lblNumAttempts.setText(Integer.toString(++numAttempts));
                    if (numMatches <= 0) {
                        Score score = new Score(name, numAttempts, d.getLevel());
                        scoresForm = new ScoresForm(primaryStage, score);
                    }
                }

                System.out.println("Card clicked: " + colIndex + ", "
                        + rowIndex);
                System.out.println("Width: " + cardsGrid.getWidth());
                System.out.println("Height: " + cardsGrid.getHeight());
            }
        }
    }
    /**
     * Create image fade out sequence.
     * @param img The image to fade.
     * @return The fade sequence.
     */
    private SequentialTransition getFadeSequence(ImageView img) {
        FadeTransition fadeIn = new FadeTransition(new Duration(500), img);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        FadeTransition fadeAway = new FadeTransition(new Duration(500), img);
        fadeAway.setToValue(0.0);
        SequentialTransition seq = new SequentialTransition(fadeIn, fadeAway);

        seq.setOnFinished(e -> {
            img.setImage(null);
        });

        return seq;
    }
}
