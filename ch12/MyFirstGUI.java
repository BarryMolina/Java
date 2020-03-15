import javafx.application.Application;
import javafx.stage.Stage;

public class MyFirstGUI extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("My First GUI Application");

        primaryStage.show();
    }
}
