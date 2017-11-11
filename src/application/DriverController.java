package application;

import com.jfoenix.controls.JFXProgressBar;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.util.Duration;

public class DriverController extends Node {

	private BorderPane pane = new BorderPane();
	Rectangle2D screenBalance = Screen.getPrimary().getVisualBounds(); //for getting screen dimensions
	double screenWidth = screenBalance.getWidth();
	double screenHeight = 630;
	double camWidth = 600;
	double battery = 0.64;
	
	double minTemp = 0;
	double maxTemp = 180;
	double temperature = 100;
	int volts = 100;
	
	private void setLayout() {
		
		VBox leftVB = new VBox();
		leftVB.setAlignment(Pos.TOP_CENTER);
//		leftVB.getChildren().add(new Rectangle(, screenHeight, Color.ALICEBLUE));
		VBox rightVB = new VBox();
		rightVB.getChildren().add(new Rectangle((screenWidth - camWidth) / 2, screenHeight, Color.ALICEBLUE));
		
		VBox camera = new VBox();
		
		//LEFT VBOX THINGS
		Label title = new Label("MOTOR STATUS");
		title.setPadding(new Insets(10, 10, 10, 10));
		title.setFont(new Font("Sans Serif", 20));
		
		Label batteryLabel = new Label(battery * 100 + "%");
		batteryLabel.setFont(new Font("Arial", 40));
		JFXProgressBar batteryBar = new JFXProgressBar();
		//hbox for battery stuff
		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);
		hbox.setSpacing(20);
		hbox.getChildren().addAll(batteryBar, batteryLabel);
		hbox.setPadding(new Insets(0, 10, 0, 10));
		//help
		batteryBar.setPrefWidth((screenWidth - camWidth) / 2 - 200);
		batteryBar.setPrefHeight(30);
		batteryBar.setProgress(battery);
		
		Label voltage = new Label("VOLTAGE: " +  volts + " v ");
		voltage.setFont(new Font("Arial", 30));
		voltage.setPadding(new Insets(30, 10, 40, 10));
		
		//TEMPERATURE STUFF
		StackPane tempPane = new StackPane();
		Image img = new Image("temperature scale.png");
		ImageView temp = new ImageView(img);
		temp.setFitWidth(200);
		temp.setFitHeight(200);
		
		Image img2 = new Image("temperature hand.png");
		ImageView hand = new ImageView(img2);
		hand.setFitWidth(150);
		hand.setFitHeight(150);
		
		hand.setRotate(temperature - (minTemp + maxTemp) * 0.5); //clockwise from vertical
		
		Label tempLabel = new Label(temperature + "\u00B0");
		tempLabel.setFont(new Font("Sans Serif", 20));
		tempLabel.setPadding(new Insets(120, 0, 0, 0));
		tempPane.getChildren().addAll(temp, hand, tempLabel);
	
		
		leftVB.getChildren().addAll(title, hbox, voltage, tempPane);
		
		pane.setLeft(leftVB);
		pane.setRight(rightVB);

	}

	public Pane getContent() {
		setLayout();
		return pane;
	}

	@Override
	protected NGNode impl_createPeer() {
		return null;
	}

	@Override
	public BaseBounds impl_computeGeomBounds(BaseBounds bounds, BaseTransform tx) {
		return null;
	}

	@Override
	protected boolean impl_computeContains(double localX, double localY) {
		return false;
	}

	@Override
	public Object impl_processMXNode(MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx) {
		return null;
	}
}
