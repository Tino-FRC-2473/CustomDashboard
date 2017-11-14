package application;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
<<<<<<< HEAD
import javafx.scene.Group;
=======
import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
>>>>>>> 2bee7a4654a7000819712eb4887d5c5749673b17
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

<<<<<<< HEAD
public class SoftwareController extends Group {
=======
public class SoftwareController {
>>>>>>> 2bee7a4654a7000819712eb4887d5c5749673b17

	private BorderPane pane = new BorderPane();

	private void setLayout() {
		TableView table = new TableView();
		table.setEditable(true);
		TableColumn sensorNames = new TableColumn("Sensor");
		TableColumn values = new TableColumn("Value");
		
		table.getColumns().addAll(sensorNames, values);
		pane.setCenter(table);
		
	}
	
	public Pane getContent() {
		setLayout();
		return pane;
	}
<<<<<<< HEAD
=======
	
>>>>>>> 2bee7a4654a7000819712eb4887d5c5749673b17
}
