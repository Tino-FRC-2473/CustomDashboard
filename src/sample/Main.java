package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*Root and window*/
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage window = primaryStage;
        window.initStyle(StageStyle.UNDECORATED);

        /*Parent layout*/
        Pane pane = new Pane();

        /*Main Screen Scene*/
        Scene main = new Scene(pane, 1280, 1024, Color.BLACK);

        /*Top green bar*/
        Rectangle top_bar = new Rectangle();
        top_bar.setFill(Color.web("rgba(29,255,42,1.0)"));
        top_bar.setHeight(24);
        top_bar.setWidth(main.getWidth());
        top_bar.setLayoutX(0);
        top_bar.setLayoutY(0);
        pane.getChildren().addAll(top_bar);

        primaryStage.setScene(main);
        primaryStage.setTitle("FRC " + Constants.TEAM_NUMBER + " Dashboard");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
