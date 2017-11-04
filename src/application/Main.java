package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
	double screenWidth;
	double screenHeight;

	@Override
	public void start(Stage primaryStage) throws Exception {
//      Parent root = FXMLLoader.load(getClass().getResource("application.fxml"));
		Group root = new Group();
		primaryStage.setTitle("Hello World");
		primaryStage.setY(0);
		primaryStage.setX(0);
		Rectangle2D screenBalance = Screen.getPrimary().getVisualBounds(); //for getting screen dimensions
		screenWidth = screenBalance.getWidth();
	    screenHeight = 650;

		primaryStage.setScene(new Scene(root, screenWidth, screenHeight));

		TabPane tabPane = new TabPane();
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		Tab driverTab = new Tab();
		driverTab.setText("Driver");
		driverTab.setContent(new Rectangle(screenWidth, screenHeight, Color.LIGHTSTEELBLUE));
		tabPane.getTabs().add(driverTab);

		Tab swTab = new Tab();
		swTab.setText("Software");
		swTab.setContent(new Rectangle(screenWidth, screenHeight, Color.LIGHTSTEELBLUE));
		tabPane.getTabs().add(swTab);

		Tab graphTab = new Tab();
		graphTab.setText("Graphs");
		graphTab.setContent(new Rectangle(screenWidth, screenHeight, Color.LIGHTSTEELBLUE));
		tabPane.getTabs().add(graphTab);


		root.getChildren().add(tabPane);
		primaryStage.show();

	}


	public static void main(String[] args) {
		launch(args);
	}
}
