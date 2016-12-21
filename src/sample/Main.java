package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private static double xOffset = 0;
    private static double yOffset = 0;

    public static void main(String[] args) {
        launch(args);
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

    @Override
    public void start(Stage primaryStage) throws Exception {
        /*Root and window*/
        Parent root = FXMLLoader.load(getClass().getResource("layout.fxml"));

        primaryStage.initStyle(StageStyle.UNDECORATED);

        Scene scene = new Scene(root, 536, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });
    }
}

/*
                                        Works Cited
Penzov, Peter. “How to Drag Undecorated Window.” Javafx 2 - How to Drag Undecorated Window - Stack Overflow,
    StackExchange, 11 Aug. 2013, stackoverflow.com/questions/18173956/how-to-drag-undecorated-window.
 */