/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_memorygame;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
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
 *
 * @author barry
 */
public class GameForm {

    private Stage primaryStage;
    private String name;
    private Difficulty d;
    private Cards cards;
    private ImageView firstCardView = null;
    private ImageView firstCard = null;
    private ImageView secondCard = null;
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
		cardsGrid.setPadding(new Insets(20));
//		cardsGrid.setGridLinesVisible(true);
        cardsGrid.setAlignment(Pos.CENTER);
//		cardsGrid.maxHeightProperty().bind(cardsGrid.widthProperty().multiply(1.1));
//		cardsGrid.minHeightProperty().bind(cardsGrid.widthProperty().multiply(1.06));
//		cardsGrid.maxWidthProperty().bind(cardsGrid.heightProperty().multiply(1.01));
//        cardsGrid.heightProperty().addListener(new ChangeListener<Number>(){
//            @Override
//            public void changed(ObservableValue<? extends Number > observable,
//                                Number old, Number newNum) {
//                cardsGrid.setMaxWidth((double)newNum * 1.1);
//            }
//        });
//        cardsGrid.widthProperty().addListener(new ChangeListener<Number>(){
//            @Override
//            public void changed(ObservableValue<? extends Number > observable,
//                                Number old, Number newNum) {
//                cardsGrid.setMaxHeight((double) newNum * 1.1);
//            }
//        });
        
        VBox root = new VBox (40, headerHBox, cardsGrid);
//                root.setStyle("-fx-border-style: solid inside;"
//                        + "-fx-border-color: blue;"
//                        + "-fx-border-width: 2;");
        root.setAlignment(Pos.TOP_CENTER);
		//root.setFillHeight(true);
		root.setVgrow(cardsGrid, Priority.ALWAYS);
		//cardsGrid.prefHeightProperty().bind(root.heightProperty());

        Scene scene = new Scene(root, d.getScreenSizeX(), d.getScreenSizeY());
//        Scene scene = new Scene(root);
//        ChangeListener<Number> stageSizeListener = (observable, oldValue, newValue) -> {
//           cardsGrid.setMaxSize(cardsGrid.getHeight() * 1.1, cardsGrid.getWidth() * 1.1);
//        };
//        primaryStage.widthProperty().addListener(stageSizeListener);
//        primaryStage.heightProperty().addListener(stageSizeListener);
                

                                            
        primaryStage.setTitle(name + "'s MemoryGame");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void defineGrid() {
        cardsGrid = new GridPane();
        for (int i = 0; i < d.getGridRows(); i++) {
//            cardsGrid.getRowConstraints().add(new RowConstraints(0, d.getCardHeight(),
//									Double.MAX_VALUE));
			RowConstraints row = new RowConstraints();
			row.setPercentHeight((100 / d.getGridRows()) * 100);
//			row.setMinHeight(0);
			cardsGrid.getRowConstraints().add(row);

        }
        for (int i = 0; i < d.getGridCols(); i++) {
//            cardsGrid.getColumnConstraints().add(new ColumnConstraints(d.getCardWidth(),
//									Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE));
			ColumnConstraints col = new ColumnConstraints();
			col.setPercentWidth((100 / d.getGridCols()) * 100);
//			col.setMinWidth(0);
			cardsGrid.getColumnConstraints().add(col);
        }
        for (int y = 0; y < d.getGridCols(); y++) {
            for (int x = 0; x < d.getGridRows(); x++) {
                ResizableImageView view = new ResizableImageView(cardBack);
                HBox.setHgrow(view, Priority.ALWAYS);
                
//                ImageView view = new ImageView(cardBack);
                HBox cardBox = new HBox(view);
                cardBox.setAlignment(Pos.CENTER);
//                cardBox.setStyle("-fx-border-style: solid inside;"
//                        + "-fx-border-color: blue;"
//                        + "-fx-border-width: 2;");
//                view.fitHeightProperty().bind(cardBox.heightProperty());
//                view.fitWidthProperty().bind(cardBox.widthProperty());
                cardsGrid.add(cardBox, y, x);

                

//                cardsGrid.add(new ImageView(cardBack), y, x);
            }
        }
    }

    class gridClickHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            Node clickedNode = event.getPickResult().getIntersectedNode();
            int rowIndex;
            int colIndex;
            if (secondCard != null) {
                firstCard.setImage(cardBack);
                secondCard.setImage(cardBack);
                firstCard = null;
                secondCard = null;
            }
            if (clickedNode != cardsGrid && !(clickedNode instanceof HBox)) {
                ImageView thisView = (ImageView) clickedNode;
                System.out.println(thisView.getImage());
                rowIndex = GridPane.getRowIndex(clickedNode.getParent());
                System.out.println(rowIndex);
                colIndex = GridPane.getColumnIndex(clickedNode.getParent());
                thisView.setImage(cards.getCard(rowIndex, colIndex).getImage());
                if (firstCardView == null) {
                    firstCardRow = rowIndex;
                    firstCardCol = colIndex;
                    firstCardView = thisView;
                    firstCard = thisView;
                    
                } 
                else if (thisView != firstCardView) {
                    secondCard = thisView;
                    if (cards.getCard(firstCardRow, firstCardCol).equals(
                                    cards.getCard(rowIndex, colIndex))) {
                        // new variables so they still exist by the time pause is over
                        SequentialTransition fade = getFadeSequence(firstCard);
                        SequentialTransition fade2 = getFadeSequence(secondCard);

                        fade.play();
                        fade2.play();

                        firstCard = null;
                        secondCard = null;
                        //pause.play();
                    }
//                        else {
//                            thisView.setImage(cardBack);
//                            firstCardView.setImage(cardBack);
//                        }
                    firstCardView = null;
                }

                System.out.println("Card clicked: " + colIndex + ", "
                        + rowIndex);
                System.out.println("Width: " + cardsGrid.getWidth());
                System.out.println("Height: " + cardsGrid.getHeight());
            }
        }
    }
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
