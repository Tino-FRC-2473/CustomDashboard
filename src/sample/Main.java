package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    private static double xOffset = 0;
    private static double yOffset = 0;
    NetworkingThread networkingThread;
    @Override
    public void start(Stage primaryStage)throws Exception{
        Map<String, String> map = new HashMap<>();

        networkingThread = new NetworkingThread(2005, map);
        networkingThread.start();
        /*Root and window*/
        Parent root = FXMLLoader.load(getClass().getResource("layout.fxml"));

        primaryStage.initStyle(StageStyle.UNDECORATED);

        Scene scene = new Scene(root, 536, 400);
        scene.getStylesheets().add("stylesheet.css");
        Controller control = new Controller(scene, map);

        primaryStage.setScene(scene);
        primaryStage.show();

        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });

        Timeline time = new Timeline(new KeyFrame(new Duration(100), e -> {
                control.update();
            }
        ));
        time.setCycleCount(Timeline.INDEFINITE);
        time.play();
//        control.addSystem("Memes");
    }

    @Override
    public void stop() {
        networkingThread.quit();
    }

    public static void main(String[] args) {
//        launch(args);
    }

    public static double getxOffset() {
        return xOffset;
    }

    public static void setxOffset(double offset) {
        xOffset = offset;
    }

    public static double getyOffset() {
        return yOffset;
    }

    public static void setyOffset(double offset) {
        yOffset = offset;
    }
}

/*
                                        Works Cited
Penzov, Peter. “How to Drag Undecorated Window.” Javafx 2 - How to Drag Undecorated Window - Stack Overflow,
    StackExchange, 11 Aug. 2013, stackoverflow.com/questions/18173956/how-to-drag-undecorated-window.
 */