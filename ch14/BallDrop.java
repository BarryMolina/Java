import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.animation.TranslateTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;

public class BallDrop extends Application {

    public static void main(String[] args) {
        
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        final double SCENE_WIDTH = 200.0;
        final double SCENE_HEIGHT = 200.0;

        final double START_X = 100.0, START_Y = 40.0;
        final double END_X = 100.0, END_Y = 160.0;
        final double RADIUS = 40.0;

        final double ONE_SEC = 1000.0;

        Circle ball = new Circle(RADIUS);

        TranslateTransition ttrans = new TranslateTransition(new Duration(ONE_SEC), ball);
        ttrans.setFromX(START_X);
        ttrans.setFromY(START_Y);
        ttrans.setToX(END_X);
        ttrans.setToY(END_Y);

        SequentialTransition seqT = new SequentialTransition(new PauseTransition(new Duration(1000)), ttrans);

        Pane pane = new Pane(ball);

        Scene scene = new Scene(pane, SCENE_WIDTH, SCENE_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();

        seqT.play();
    }
}
