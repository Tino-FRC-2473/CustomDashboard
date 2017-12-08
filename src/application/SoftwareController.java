package application;

import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;

public class SoftwareController extends Group {
	private BorderPane pane = new BorderPane();
	private AnimatedTable sensorTable;
	private AnimatedTable networkingTable;
	private AnimatedTable motorTable;

	private Rectangle2D screenBalance = Screen.getPrimary().getVisualBounds(); //for getting screen dimensions
	private double screenWidth = screenBalance.getWidth();
	private double screenHeight = screenBalance.getHeight() / 1.5;
	private double textHeight = 20; //height of labels
	private final double GAP = 10; //width of spacing/"gaps"
	private StackPane stack = new StackPane(); //for background


	private final ObservableList<SensorModel> data = FXCollections.observableArrayList(
			new SensorModel("sensor1", "0812309128390"),
			new SensorModel("sensor2", "0828390"),
			new SensorModel("sensor3", "012312390"),
			new SensorModel("sensor4", "08123123124354235")
	);

	private final ObservableList<MotorModel> data2 = FXCollections.observableArrayList(

		    new MotorModel("motor1", "hi", "0812309128390", "asldjaskld", "asldaskld", "asdlkajsd"),
		    new MotorModel("motor2", "hadi", "0828390", "asldjaskld", "asldaskld", "asdlkajsd"),
		    new MotorModel("motor3", "hasdasfi", "012312390", "asldjaskld", "asldaskld", "asdlkajsd"),
		    new MotorModel("motor4", "hiasfasf", "08123123124354235", "asldjaskld", "asldaskld", "asdlkajsd")
		);
	

	private final ObservableList<NetworkingModel> data3 = FXCollections.observableArrayList(
			new NetworkingModel("thing1", "0812309128390"),
			new NetworkingModel("thing2", "0828390"),
			new NetworkingModel("thing3", "012312390"),
			new NetworkingModel("thing4", "08123123124354235")
	);

	private void setLayout() {
		VBox vb1 = new VBox();
		VBox vb2 = new VBox();
		sensorTable();
		motorTable();
		networkingTable();
		
		vb1.getChildren().addAll(new Label("MOTOR"), motorTable);

		vb1.setSpacing(GAP / 2);
		vb1.setPadding(new Insets(GAP, GAP, GAP, GAP));

		vb2.getChildren().addAll(new Label("SENSOR"), sensorTable, new Label("NETWORKING"), networkingTable);
		vb2.setSpacing(GAP / 2);
		vb2.setPadding(new Insets(GAP, GAP, GAP, GAP));

		pane.setLeft(vb1);
		pane.setCenter(vb2);

		Rectangle r = new Rectangle(screenWidth, screenHeight, Color.WHITE); //white background using stackpane
		stack.getChildren().addAll(r, pane);

	}

	public Pane getContent() {
		setLayout();
		return stack;
	}

	public void sensorTable() {
		sensorTable = new AnimatedTable(SensorModel.class, data);
		sensorTable.setMaxWidth(screenWidth / 2 - 2 * GAP);
		sensorTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); //distributes the space between columns so that there is no extra column
		sensorTable.setPrefHeight((screenHeight - (4.5) * GAP - 2 * textHeight) / 2);
		sensorTable.run();
	}

	public void motorTable() {
		motorTable = new AnimatedTable(MotorModel.class, data2);
		motorTable.setMinWidth(screenWidth / 2 - 2 * GAP);
		motorTable.setPrefHeight(screenHeight - 3.5 * GAP - textHeight);
		motorTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		motorTable.run();

	}

	public void networkingTable() {
		networkingTable = new AnimatedTable(NetworkingModel.class, data3);
		networkingTable.setMaxWidth(screenWidth / 2 - 2 * GAP);
		networkingTable.setPrefHeight((screenHeight - (4.5) * GAP - 2 * textHeight) / 2);
		networkingTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		networkingTable.run();
	}
}
