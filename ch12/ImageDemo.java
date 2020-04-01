import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageDemo extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Image image = new Image("http://www.gaddisbooks.com/images/HotAirBalloon.jpg");

        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(500);
        imageView.setPreserveRatio(true);

        HBox hbox = new HBox(imageView);

        Scene scene = new Scene(hbox);

        primaryStage.setScene(scene);

        primaryStage.setTitle("Hot Air Balloon");

        primaryStage.show();
    }
}
