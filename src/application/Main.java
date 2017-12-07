package application;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTabPane;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

public class Main extends Application {
	private double screenWidth;
	private double screenHeight = 630;
	
	private double x = 865; //x where camera ends and stuff goes
	public static ArrayList<String> data = new ArrayList<>();

	@Override
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		primaryStage.getIcons().add(new Image("images/icon.png"));
		primaryStage.setTitle("Dashboard :D");
		primaryStage.setY(0);
		primaryStage.setX(0);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		Rectangle2D screenBalance = Screen.getPrimary().getVisualBounds(); //for getting screen dimensions
		screenWidth = screenBalance.getWidth();


//		Rectangle r = new Rectangle(screenWidth - x, screenHeight, Color.WHITE);
//		r.setLayoutX(x);
//		root.getChildren().add(r);
//		
		Scene scene = new Scene(root, screenWidth, screenHeight);
		scene.setFill(Color.TRANSPARENT);
		primaryStage.setScene(scene);
		
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

		root.getChildren().add(tabPane);
		primaryStage.show();
		openConsole();
	}


	public static void main(String[] args) throws IOException {
		String serverAddress = JOptionPane.showInputDialog("Enter IP Address of the robot that is\n" + "running on port 8080:");

		if (Integer.parseInt(serverAddress) != 0) {
			Socket socket = new Socket(serverAddress, 8080);
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("Connected");
			data.add(reader.readLine());
		}

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

		ConsoleController consoleController = new ConsoleController();


		root.getChildren().add(tabPane);
		stage.show();
	}
}