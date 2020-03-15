import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.geometry.Pos;

public class HelloWorld extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    public void start(Stage primaryStage) {

        Label messageLabel = new Label("Hello World");

        HBox hbox = new HBox(messageLabel);

        Scene scene = new Scene(hbox, 300, 100);

        hbox.setAlignment(Pos.CENTER);


        primaryStage.setScene(scene);

        primaryStage.setTitle("My Fist Scene");

        primaryStage.show();
    }
}
