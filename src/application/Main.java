package application;

import com.jfoenix.controls.JFXTabPane;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Main extends Application {
	private double screenWidth;
	private double screenHeight; 
	public static Socket socket;
	public static DataInputStream dataInputStream;
	public static DataOutputStream dataOutputStream;
	private double x = 865; //x where camera ends and stuff goes
	String test;
	boolean receiving = true;
	
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

		new Thread(() -> {
			try {
				while (receiving) {
					test = Main.dataInputStream.readUTF();
					System.out.println(test);
//					ArrayList<String[]> datas = Parser.parse(test, ":", ";");
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}

	//NETWORKING COD
	public static void main(String[] args) throws IOException {
		String serverAddress = JOptionPane.showInputDialog("Enter IP Address of the robot that is\n" + "running on port 8080:");

		if (!serverAddress.equals("0")) {
			socket = new Socket(serverAddress, 6969);
			dataInputStream = new DataInputStream(socket.getInputStream());
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
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
		screenWidth = screenBalance.getWidth() / 1.5;
		screenHeight = screenBalance.getHeight() / 1.5;

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