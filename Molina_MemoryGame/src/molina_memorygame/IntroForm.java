/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_memorygame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 *
 * @author barry
 */
public class IntroForm {

    Stage primaryStage;
    TextField txtBxName;
    RadioButton rbEasy;
    RadioButton rbMed;
    RadioButton rbHard;

    public IntroForm(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    public void buildForm() {
        Label lblTitle = new Label("Welcome to MemoryGame!");
        Label lblName = new Label("Enter Your Name:");
        Label lblDifficulty = new Label("Select Your Difficulty:");

        txtBxName = new TextField();

        rbEasy = new RadioButton("Easy");
        rbMed= new RadioButton("Medium");
        rbHard = new RadioButton("Hard");

        ToggleGroup radioGroup = new ToggleGroup();

        rbEasy.setToggleGroup(radioGroup);
        rbMed.setToggleGroup(radioGroup);
        rbHard.setToggleGroup(radioGroup);
        
        VBox vBox1 = new VBox(25, lblName, lblDifficulty);
        vBox1.setAlignment(Pos.TOP_RIGHT);
        vBox1.setPadding(new Insets(3, 0, 0, 0));
        VBox rbVBox = new VBox(7, rbEasy, rbMed, rbHard);
        VBox vBox2 = new VBox(20, txtBxName, rbVBox);
        HBox hBox = new HBox(10, vBox1, vBox2);
        hBox.setAlignment(Pos.CENTER);

        Button btn = new Button("Let's Play!");
        btn.setOnAction(new PlayButtonHandler());
        
        VBox root = new VBox(20, lblTitle, hBox, btn);
        root.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(root, 500, 350);
        
        primaryStage.setTitle("MemoryGame");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    class PlayButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            
            DifficultyLevel level;
            String name;

            name = txtBxName.getText();
            
            if (rbHard.isSelected()) {
                level = DifficultyLevel.HARD;
            }
            else if (rbMed.isSelected()) {
                level = DifficultyLevel.MEDIUM;
            }
            else {
                level = DifficultyLevel.EASY;
            }

            GameForm game = new GameForm(primaryStage, name, level);
            game.buildForm();
        }
    }
    
}
