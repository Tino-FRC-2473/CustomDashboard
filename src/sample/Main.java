package sample;

import javafx.application.Application;
import javafx.beans.binding.StringBinding;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class Main extends Application {

    private double xOffset = 0;
    private  double yOffset = 0;

    @Override
    public void start(Stage primaryStage)throws Exception{
        /*Root and window*/
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);

        /*Parent layout*/
        Pane pane = new VBox();

        /*Main Screen Scene*/
        Scene main = new Scene(pane, 800, 600, Color.BLACK);

        /*Top green bar*/
        Rectangle top_bar = new Rectangle();
        top_bar.setFill(Color.web("rgba(29,255,42,1.0)"));
        top_bar.setHeight(24);
        top_bar.setWidth(main.getWidth());
        top_bar.setLayoutX(0);
        top_bar.setLayoutY(0);
        pane.getChildren().addAll(top_bar);

        //Text testing stuff
        Text text = new Text(6400, 512, "TESTING");
        text.setFont(new Font(40));
        text.setFill(new Color(1.0, 1.0, 1.0, 1.0));
//        text.textProperty().bind(StringBinding.stringExpression());
        pane.getChildren().add(text);

        primaryStage.setScene(main);
        primaryStage.setTitle("FRC " + Constants.TEAM_NUMBER + " Dashboard");
        primaryStage.show();


        pane.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
            text.setText("Press");
        });

        pane.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
            text.setText("Drag");
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}

/*
                                        Works Cited
Penzov, Peter. “How to Drag Undecorated Window.” Javafx 2 - How to Drag Undecorated Window - Stack Overflow,
    StackExchange, 11 Aug. 2013, stackoverflow.com/questions/18173956/how-to-drag-undecorated-window.
 */



