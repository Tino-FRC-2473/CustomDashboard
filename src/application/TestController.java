package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TestController extends Group {

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

		TableView table = new TableView();
		table.setEditable(true);
		TableColumn sensorNames = new TableColumn("Sensor");
		TableColumn values = new TableColumn("Value");
		
		
		
		ObservableList<ValueNode> data = FXCollections.observableArrayList(
				new ValueNode("a", "0.0"),
				new ValueNode("b", "0.1"),
				new ValueNode("c", "0.3"),
				new ValueNode("d", "0.5")
				);
		
		sensorNames.setCellValueFactory(new PropertyValueFactory<>("Sensor"));
		values.setCellValueFactory(new PropertyValueFactory<>("Values"));
			
		table.setItems(data);
		table.getColumns().addAll(sensorNames, values);
		
		pane.setCenter(table);	
		//pane.setCenter(box);
		//pane.setTop(box2);

	}

	public Pane getContent() {
		setLayout();
		return pane;
	}
}