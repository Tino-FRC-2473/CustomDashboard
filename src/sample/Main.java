package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Stage window = primaryStage;

        Label encoder_tr_label = new Label("Encoder value: ");

        HBox layout = new HBox(20);

        layout.getChildren().addAll(encoder_tr_label);

        Scene scene = new Scene(layout, 300, 275);

        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
