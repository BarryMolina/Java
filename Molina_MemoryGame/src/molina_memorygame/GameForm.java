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
    private Node firstCardNode = null;
    private Image firstCardImage = null;
    private int firstCardRow;
    private int firstCardCol;
    private Image[][] images;


    private Label lblNumMatches;
    private Label lblNumFound;
    private Label lblNumAttempts;

    

    public GameForm(Stage primaryStage, String name, DifficultyLevel level) {
        this.primaryStage = primaryStage;
        this.name = name;

        d = new Difficulty(level);
        cards = new Cards(d.getTotalCards(), d.getGridRows(), d.getGridCols()); 
        images = new Image[d.getGridRows()][d.getGridCols()];
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
        
        Image cardBack = new Image(cards.getBack());
//        ImageView backView = new ImageView(cardBack);

        GridPane cardsGrid = new GridPane();
        for (int i = 0; i < d.getGridRows(); i++) {
            cardsGrid.getRowConstraints().add(new RowConstraints(d.getCellHeight()));
        }
        for (int i = 0; i < d.getGridCols(); i++) {
            cardsGrid.getColumnConstraints().add(new ColumnConstraints(d.getCellWidth()));
        }
        for (int y = 0; y < d.getGridCols(); y++) {
            for (int x = 0; x < d.getGridRows(); x++) {
                cardsGrid.add(new ImageView(cardBack), y, x);
            }
        }

//        cardsGrid.setPrefSize(cardsGrid.getWidth(), cardsGrid.getHeight());
        cardsGrid.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Node clickedNode = event.getPickResult().getIntersectedNode();
                int rowIndex;
                int colIndex;
                boolean same;
                if (clickedNode != cardsGrid) {
					ImageView thisView = (ImageView) clickedNode;
                    rowIndex = GridPane.getRowIndex(clickedNode);
                    colIndex = GridPane.getColumnIndex(clickedNode);
					thisView.setImage(cards.getCard(rowIndex, colIndex).getImage());
                    if (firstCardNode == null) {
                        firstCardRow = rowIndex;
                        firstCardCol = colIndex;
                        firstCardNode = clickedNode;
                        firstCardImage = thisView.getImage();
                        
                    } 
                    else if (clickedNode != firstCardNode) {
//                        same = cards.cardsAreSame(firstCardRow, firstCardCol,
//                                                     rowIndex, colIndex);
                        if (thisView.getImage().equals(firstCardImage)) {
//                            cardsGrid.getChildren().removeAll(firstCardNode,
//                                                                clickedNode);
                            thisView.setImage(null);
                            ImageView firstCardView = (ImageView) firstCardNode;
                            firstCardView.setImage(null);
                        }
                        else {
                            thisView.setImage(new Image(cards.getBack()));
                            ImageView firstCardView = (ImageView) firstCardNode;
                            firstCardView.setImage(new Image(cards.getBack()));

                        }
                        firstCardNode = null;
                    }

                    System.out.println("Card clicked: " + colIndex + ", "
                            + rowIndex);
                    System.out.println("Width: " + cardsGrid.getWidth());
                    System.out.println("Height: " + cardsGrid.getHeight());
                }
            }
        });
        cardsGrid.setHgap(10);
        cardsGrid.setVgap(10);
        cardsGrid.setAlignment(Pos.CENTER);
        
        VBox root = new VBox (40, headerHBox, cardsGrid);
//        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, d.getScreenSizeX(), 
                                            d.getScreenSizeY());
        primaryStage.setTitle(name + "'s MemoryGame");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
//    private void fillImages() {
//        for (int i = 0; i < images.length; i++) {
//            for (int j = 0; j < images[i].length; j++) {
//                images[i][j] = new Image(cards.getCardURL(i, j));
//            }
//        }
//    }
}
