package application;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class SoftwareController extends Node {

	private BorderPane pane = new BorderPane();

	private void setLayout() {
		// add all of your stuff here
		HBox hBox = new HBox();
		HBox inhBox = new HBox();

		JFXTreeTableView sensorTable = new JFXTreeTableView();
		JFXTreeTableColumn sensorCol = new JFXTreeTableColumn("Sensors");
		JFXTreeTableColumn sensorValCol = new JFXTreeTableColumn("Values");
		sensorTable.setEditable(false);
		sensorTable.getColumns().addAll(sensorCol, sensorValCol);
		
		JFXTreeTableView networkingTable = new JFXTreeTableView();
		JFXTreeTableColumn netCol1 = new JFXTreeTableColumn("Networking!");
		JFXTreeTableColumn netCol2 = new JFXTreeTableColumn("!gnikrowteN");
		sensorTable.setEditable(false);
		networkingTable.getColumns().addAll(netCol1, netCol2);

		JFXTreeTableView motorTable = new JFXTreeTableView();
		JFXTreeTableColumn motorCol = new JFXTreeTableColumn("Motors");
		JFXTreeTableColumn motorValCol = new JFXTreeTableColumn("Values");
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
