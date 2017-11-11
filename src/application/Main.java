package application;

import com.jfoenix.controls.JFXTabPane;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.stage.Screen;
import javafx.stage.Stage;
 				
public class Main extends Application {
	private double screenWidth;
	private double screenHeight;

	@Override
	public void start(Stage primaryStage) throws Exception {
//      Parent root = FXMLLoader.load(getClass().getResource("application.fxml"));
		Group root = new Group();
		primaryStage.setTitle("Dashboard :D");
		primaryStage.setY(0);
		primaryStage.setX(0);
		Rectangle2D screenBalance = Screen.getPrimary().getVisualBounds(); //for getting screen dimensions
		screenWidth = screenBalance.getWidth();
		screenHeight = 650;

		primaryStage.setScene(new Scene(root, screenWidth, screenHeight));

		JFXTabPane tabPane = new JFXTabPane();
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		tabPane.setDisableAnimation(true);

		Tab driverTab = new Tab();
		driverTab.setText("Driver");
		driverTab.setContent(new DriverController().getContent());
		tabPane.getTabs().add(driverTab);

		Tab swTab = new Tab();
		swTab.setText("Software");
		swTab.setContent(new SoftwareController().getContent());
		tabPane.getTabs().add(swTab);

		Tab graphTab = new Tab();
		graphTab.setText("Graphs");
		graphTab.setContent(new GraphController().getContent());
		tabPane.getTabs().add(graphTab);

		Tab testTab = new Tab();
		testTab.setText("Test");
		testTab.setContent(new TestController().getContent());
		tabPane.getTabs().add(testTab);


		root.getChildren().add(tabPane);
		primaryStage.show();
		openConsole();
	}


	public static void main(String[] args) {
		launch(args);
	}

	private void openConsole() {
		Stage stage = new Stage();

		Group root = new Group();

		stage.setTitle("Console");
		stage.setY(0);
		stage.setX(0);

		Rectangle2D screenBalance = Screen.getPrimary().getVisualBounds(); //for getting screen dimensions
		screenWidth = screenBalance.getWidth();
		screenHeight = screenBalance.getHeight();

		stage.setScene(new Scene(root, screenWidth, screenHeight));

		JFXTabPane tabPane = new JFXTabPane();
		tabPane.setTabClosingPolicy(TabClosingPolicy.SELECTED_TAB);
		tabPane.setDisableAnimation(false);
		tabPane.setPrefSize(screenWidth, screenHeight);

		Tab consoleTab = new Tab();
		consoleTab.setText("Console");
		consoleTab.setContent(new ConsoleController().getContent());
		tabPane.getTabs().add(consoleTab);

		root.getChildren().add(tabPane);
		stage.show();
	}
}
