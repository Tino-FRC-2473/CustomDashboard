package application;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class SoftwareController extends Node {

	private BorderPane pane = new BorderPane();

	private void setLayout() {
		// add all of your stuff here
		HBox hBox = new HBox();
		HBox inhBox = new HBox();
		
		TableView sensorTable = new TableView();
		TableColumn sensorCol = new TableColumn("Sensors");
		TableColumn sensorValCol = new TableColumn("Values");
		sensorTable.setEditable(false);
		sensorTable.getColumns().addAll(sensorCol, sensorValCol);
		
		TableView networkingTable = new TableView();
		TableColumn netCol1 = new TableColumn("Networking!");
		TableColumn netCol2 = new TableColumn("!gnikrowteN");
		sensorTable.setEditable(false);
		networkingTable.getColumns().addAll(netCol1, netCol2);
		
		TableView motorTable = new TableView();
		TableColumn motorCol = new TableColumn("Motors");
		TableColumn motorValCol = new TableColumn("Values");
		sensorTable.setEditable(false);
		motorTable.getColumns().addAll(motorCol, motorValCol);
		
		hBox.getChildren().add(sensorTable);
		hBox.getChildren().add(inhBox);
		inhBox.getChildren().add(networkingTable);
		inhBox.getChildren().add(motorTable);
		pane.setCenter(hBox);
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
