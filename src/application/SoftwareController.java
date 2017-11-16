package application;

import javafx.scene.Group;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class SoftwareController extends Group {
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
}
