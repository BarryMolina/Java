import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class ButtonDemo extends Application {

    private Label myLabel;
    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        myLabel = new Label("Click the button to see a message.");
        Button myButton = new Button("Click Me");

        myButton.setOnAction(new ButtonClickHandler());
        
        VBox vbox = new VBox(10, myLabel, myButton);
        Scene scene = new Scene(vbox, 300, 100);
        vbox.setAlignment(Pos.CENTER);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Button Demo");
        primaryStage.show();
    }

    class ButtonClickHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            myLabel.setText("Thanks for clicking the button!");
        }
    }
}
