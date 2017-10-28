package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//      Parent root = FXMLLoader.load(getClass().getResource("application.fxml"));
    	Group root = new Group();
        primaryStage.setTitle("Hello World");
        Rectangle2D screenBalance = Screen.getPrimary().getVisualBounds(); //for getting screen dimensions
        primaryStage.setScene(new Scene(root, screenBalance.getWidth(), 600)); 
        
        TabPane tabPane = new TabPane();
        Tab driverTab = new Tab();
        driverTab.setText("Driver");
        driverTab.setContent(new Rectangle(2000, 600, Color.LIGHTSTEELBLUE));
        tabPane.getTabs().add(driverTab);
        
        Tab swTab = new Tab();
        swTab.setText("Software");
        swTab.setContent(new Rectangle(2000, 600, Color.LIGHTSTEELBLUE));
        tabPane.getTabs().add(swTab);
        
        Tab graphTab = new Tab();
        graphTab.setText("Graphs");
        graphTab.setContent(new Rectangle(2000, 600, Color.LIGHTSTEELBLUE));
        tabPane.getTabs().add(graphTab);
        

        root.getChildren().add(tabPane);
        primaryStage.show();
       
    }


    public static void main(String[] args) {
        launch(args);
    }
}
