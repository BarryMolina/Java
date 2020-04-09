import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import java.sql.SQLException;

import javax.swing.plaf.InsetsUIResource;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class OrderEntrySystem extends Application {

    private ListView<String> customerListView;
    private ListView<String> coffeeListView;
    private TextField qtyTextField;
    private TextField orderDateTextField;

    final int LV_WIDTH = 150;
    final int LV_HEIGHT = 75;
    final double SPACING = 10.0;

    private void buildGUI(Stage stage) {
        Label customerPrompt = new Label("Select a Customer");
        customerListView = new ListView<String>();
        customerListView.setPrefSize(LV_WIDTH, LV_HEIGHT);
        VBox customerVBox = new VBox(SPACING, customerPrompt, customerListView);
        customerVBox.setAlignment(Pos.CENTER);
        customerVBox.setPadding(new Insets(SPACING));

        Label coffeePrompt = new Label("Select a Coffee");
        coffeeListView = new ListView<String>();
        coffeeListView.setPrefSize(LV_WIDTH, LV_HEIGHT);
        VBox coffeeVBox = new VBox(10, coffeePrompt, coffeeListView);
        coffeeVBox.setAlignment(Pos.CENTER);
        coffeeVBox.setPadding(new Insets(SPACING));

        Label qtyPrompt = new Label("Quantity");
        qtyTextField = new TextField();

        Label datePrompt = new Label("Order Date");
        orderDateTextField = new TextField();
        VBox orderVBox = new VBox(SPACING, qtyPrompt, qtyTextField,
                                    datePrompt, orderDateTextField);
        orderVBox.setAlignment(Pos.CENTER);
        orderVBox.setPadding(new Insets(SPACING));

        Button submitButton = new Button("Submit");
        Button exitButton = new Button("Exit");
        HBox buttonHBox = new HBox(SPACING, submitButton, exitButton);
        buttonHBox.setAlignment(Pos.CENTER);
        buttonHBox.setPadding(new Insets(SPACING));

        submitButton.setOnAction(new SubmitButtonHandler());
        exitButton.setOnAction(e -> {
            stage.close();
        });

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(customerVBox);
        borderPane.setCenter(coffeeVBox);
        borderPane.setRight(orderVBox);
        borderPane.setBottom(buttonHBox);

        stage.setTitle("Order Entry System");

        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
    }

    private void loadData() {
        try {
            customerListView.getItems().setAll(
                     CoffeeDBManager.getCustomerNames());
            coffeeListView.getItems().setAll(
                     CoffeeDBManager.getCoffeeNames());
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        buildGUI(primaryStage);
        
        loadData();

        primaryStage.show();
    }

    class SubmitButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            try {
                String customerName = 
                    customerListView.getSelectionModel().getSelectedItem();
                String coffeeName = 
                    coffeeListView.getSelectionModel().getSelectedItem();

                int qty = Integer.parseInt(qtyTextField.getText());

                String orderDate = orderDateTextField.getText();

                String custNum = 
                    CoffeeDBManager.getCustomerNum(customerName);

                String prodNum = CoffeeDBManager.getProdNum(coffeeName);

                double price = CoffeeDBManager.getCoffeePrice(prodNum);

                CoffeeDBManager.submitOrder(custNum, prodNum, qty, price, orderDate);

                qtyTextField.clear();
                orderDateTextField.clear();
            }
            catch (SQLException e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
    }
}
