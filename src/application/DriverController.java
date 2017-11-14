package application;

import com.jfoenix.controls.JFXProgressBar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Screen;

public class DriverController extends Group {

	private BorderPane pane = new BorderPane();
	Rectangle2D screenBalance = Screen.getPrimary().getVisualBounds(); //for getting screen dimensions
	double screenWidth = screenBalance.getWidth();
	double screenHeight = 630;
	double camWidth = 600;
	int batteryVal = 100;
	int volts = 100;

	private void setLayout() {

		VBox leftVB = new VBox();
		leftVB.setAlignment(Pos.TOP_CENTER);
//		leftVB.getChildren().add(new Rectangle(, screenHeight, Color.ALICEBLUE));
		VBox rightVB = new VBox();
		rightVB.getChildren().add(new Rectangle((screenWidth - camWidth) / 2, screenHeight, Color.ALICEBLUE));

		VBox camera = new VBox();

		Label batteryLabel = new Label("battery left: " + batteryVal);

		JFXProgressBar battery = new JFXProgressBar();

		//help
		battery.setPrefWidth((screenWidth - camWidth) / 2);
		battery.setPrefHeight(50);


		Label voltage = new Label("VOLTAGE: " + volts);
		voltage.setFont(new Font("Arial", 20));
		voltage.setPadding(new Insets(10, 10, 10, 10));

		Label title = new Label("MOTOR STATUS");
		title.setPadding(new Insets(10, 10, 10, 10));
		title.setFont(new Font("Arial", 20));
		leftVB.getChildren().addAll(title, batteryLabel, battery, voltage);

		pane.setLeft(leftVB);
		pane.setRight(rightVB);

	}

	public Pane getContent() {
		setLayout();
		return pane;
	}
}
