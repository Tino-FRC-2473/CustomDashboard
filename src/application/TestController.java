package application;

import com.jfoenix.controls.*;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

public class TestController extends Node{

	private BorderPane pane = new BorderPane();

	private void setLayout() {
		HBox box = new HBox();
		box.setSpacing(100);

		//BUTTON CODE
		//Basic Button Stuff
		JFXButton button = new JFXButton("CLICK ME");
		button.setButtonType(JFXButton.ButtonType.RAISED);
		button.setPrefSize(200, 100);
		button.setFont(new Font("Comic Sans MS", 22));
		button.setRipplerFill(Color.BLUEVIOLET);

		//Button Background Stuff
		BackgroundFill backgroundFill = new BackgroundFill(Color.LIGHTSTEELBLUE, new CornerRadii(20), Insets.EMPTY);
		Background background = new Background(backgroundFill);
		button.setBackground(background);

		box.getChildren().add(button);

		//CHECK BOX CODE
		JFXCheckBox checkBox = new JFXCheckBox("CheckBox");
		checkBox.setCheckedColor(Color.RED);
		checkBox.setUnCheckedColor(Color.BLACK);
		box.getChildren().add(checkBox);

		HBox box2 = new HBox();
		box.setSpacing(100);

		JFXTreeTableView tableView = new JFXTreeTableView();
		JFXTreeTableColumn sensors = new JFXTreeTableColumn("Sensors");
		JFXTreeTableColumn sensorValues = new JFXTreeTableColumn("Values");
		tableView.setEditable(false);
		tableView.getColumns().addAll(sensors, sensorValues);

		box2.getChildren().add(tableView);


		pane.setCenter(box);
		pane.setTop(box2);
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
