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
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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
	int batteryVal = 100;
	int volts = 100;
	
	private void setLayout() {
		
		VBox leftVB = new VBox();
//		leftVB.getChildren().add(new Rectangle(, screenHeight, Color.ALICEBLUE));
		VBox rightVB = new VBox();
		rightVB.getChildren().add(new Rectangle((screenWidth - camWidth) / 2, screenHeight, Color.ALICEBLUE));
	
		VBox camera = new VBox();
		
		Label batteryLabel = new Label("battery left: " + batteryVal);
		JFXProgressBar battery = new JFXProgressBar();
		
		//help
		battery.setPrefWidth((screenWidth - camWidth) / 2);
		battery.setPrefHeight(50);
	
		
		Label voltage = new Label("VOLTAGE: " +  volts);
		voltage.setFont(new Font("Arial", 20));
		
		leftVB.getChildren().addAll(new Label("Motor Status:"), batteryLabel, battery, voltage);

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
