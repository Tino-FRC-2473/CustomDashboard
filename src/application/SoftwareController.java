package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class SoftwareController extends Group {
	private BorderPane pane = new BorderPane();
	private final ObservableList<ValueNode> data = FXCollections.observableArrayList(
		    new ValueNode("hi", "0812309128390"),
		    new ValueNode("hadi", "0828390"),
		    new ValueNode("hasdasfi", "012312390"),
		    new ValueNode("hiasfasf", "08123123124354235")
		);
	
	private void setLayout() {
		TableView<ValueNode> table = new TableView<ValueNode>();
		table.setEditable(true);
		TableColumn<ValueNode, String> sensorNames = new TableColumn<ValueNode, String>("Sensor");
		TableColumn<ValueNode, String> values = new TableColumn<ValueNode, String>("Value");
		sensorNames.setCellValueFactory(
				new PropertyValueFactory<ValueNode, String>("name"));
		values.setCellValueFactory(
				new PropertyValueFactory<ValueNode, String>("value"));
		
		table.setItems(data);
		table.getColumns().addAll(sensorNames, values);
		pane.setCenter(table);
	}

	public Pane getContent() {
		setLayout();
		return pane;
	}
}
