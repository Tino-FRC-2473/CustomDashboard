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
	private TableView<SensorModel> sensorTable;
	private TableView<NetworkingModel> networkingTable;
	private TableView<MotorModel> motorTable;

	private Rectangle2D screenBalance = Screen.getPrimary().getVisualBounds(); //for getting screen dimensions
	private double screenWidth = screenBalance.getWidth();
	private double screenHeight = 630;
	private double textHeight = 20; //height of labels
	private final double GAP = 10; //width of spacing/"gaps"
	private StackPane stack = new StackPane(); //for background


	private final ObservableList<SensorModel> data = FXCollections.observableArrayList(
			new SensorModel("hi", "0812309128390"),
			new SensorModel("hadi", "0828390"),
			new SensorModel("hasdasfi", "012312390"),
			new SensorModel("hiasfasf", "08123123124354235")
	);

	private final ObservableList<MotorModel> data2 = FXCollections.observableArrayList(
<<<<<<< HEAD
		    new MotorModel("motor1", "hi", "0812309128390", "asldjaskld", "asldaskld", "asdlkajsd"),
		    new MotorModel("motor2", "hadi", "0828390", "asldjaskld", "asldaskld", "asdlkajsd"),
		    new MotorModel("motor3", "hasdasfi", "012312390", "asldjaskld", "asldaskld", "asdlkajsd"),
		    new MotorModel("motor4", "hiasfasf", "08123123124354235", "asldjaskld", "asldaskld", "asdlkajsd")
		);
	
=======
			new MotorModel("hi", "0812309128390", "asldjaskld", "asldaskld", "asdlkajsd"),
			new MotorModel("hadi", "0828390", "asldjaskld", "asldaskld", "asdlkajsd"),
			new MotorModel("hasdasfi", "012312390", "asldjaskld", "asldaskld", "asdlkajsd"),
			new MotorModel("hiasfasf", "08123123124354235", "asldjaskld", "asldaskld", "asdlkajsd")
	);

>>>>>>> 284a6cd4171caf60fc690018c38ab5a47f91b73e
	private final ObservableList<NetworkingModel> data3 = FXCollections.observableArrayList(
			new NetworkingModel("hi", "0812309128390"),
			new NetworkingModel("hadi", "0828390"),
			new NetworkingModel("hasdasfi", "012312390"),
			new NetworkingModel("hiasfasf", "08123123124354235")
	);

	private void setLayout() {
		VBox vb1 = new VBox();
		VBox vb2 = new VBox();
		sensorTable();
		motorTable();
		networkingTable();
<<<<<<< HEAD
		
		AnimatedTable testAnimTable = new AnimatedTable(data2);
		//vb1.getChildren().add(testAnimTable);
		testAnimTable.run();
		
		vb1.getChildren().addAll(new Label("MOTOR"), testAnimTable);
=======

		vb1.getChildren().addAll(new Label("MOTOR"), motorTable);
>>>>>>> 284a6cd4171caf60fc690018c38ab5a47f91b73e
		vb1.setSpacing(GAP / 2);
		vb1.setPadding(new Insets(GAP, GAP, GAP, GAP));

		vb2.getChildren().addAll(new Label("SENSOR"), sensorTable, new Label("NETWORKING"), networkingTable);
		vb2.setSpacing(GAP / 2);
		vb2.setPadding(new Insets(GAP, GAP, GAP, GAP));

		pane.setLeft(vb1);
		pane.setCenter(vb2);

		Rectangle r = new Rectangle(screenWidth, screenHeight, Color.WHITE); //white background using stackpane
		stack.getChildren().addAll(r, pane);

<<<<<<< HEAD
		
=======
		new AnimationTimer() {
			@Override
			public void handle(long now) {


			}

		}.start();

>>>>>>> 284a6cd4171caf60fc690018c38ab5a47f91b73e
	}

	public Pane getContent() {
		setLayout();
		return stack;
	}

	public void sensorTable() {
		sensorTable = new TableView<SensorModel>();

		TableColumn<SensorModel, String> sensorCol = new TableColumn<SensorModel, String>("Sensor");
		sensorCol.setCellValueFactory(
				new PropertyValueFactory<SensorModel, String>("name"));

		TableColumn<SensorModel, String> valueCol = new TableColumn<SensorModel, String>("Value");
		valueCol.setCellValueFactory(
				new PropertyValueFactory<SensorModel, String>("value"));

		sensorTable.setItems(data);
		sensorTable.getColumns().addAll(sensorCol, valueCol);
		sensorTable.setMaxWidth(screenWidth / 2 - 2 * GAP);
		sensorTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); //distributes the space between columns so that there is no extra column
		sensorTable.setPrefHeight((screenHeight - (4.5) * GAP - 2 * textHeight) / 2);
	}

	public void motorTable() {
		motorTable = new TableView<MotorModel>();
<<<<<<< HEAD
		
		TableColumn<MotorModel, String> motorCol = new TableColumn<MotorModel, String>("Motor");
		motorCol.setCellValueFactory(
				new PropertyValueFactory<MotorModel, String>("name"));
		
=======

>>>>>>> 284a6cd4171caf60fc690018c38ab5a47f91b73e
		TableColumn<MotorModel, String> powerCol = new TableColumn<MotorModel, String>("Power");
		powerCol.setCellValueFactory(
				new PropertyValueFactory<MotorModel, String>("power")); //"_____" is variable name

		TableColumn<MotorModel, String> stalledCol = new TableColumn<MotorModel, String>("Stalled");
		stalledCol.setCellValueFactory(
				new PropertyValueFactory<MotorModel, String>("stalled"));

		TableColumn<MotorModel, String> voltageCol = new TableColumn<MotorModel, String>("Voltage");
		voltageCol.setCellValueFactory(
				new PropertyValueFactory<MotorModel, String>("voltage"));

		TableColumn<MotorModel, String> currentCol = new TableColumn<MotorModel, String>("Current");
		currentCol.setCellValueFactory(
				new PropertyValueFactory<MotorModel, String>("current"));

		TableColumn<MotorModel, String> encoderCol = new TableColumn<MotorModel, String>("Encoder");
		encoderCol.setCellValueFactory(
				new PropertyValueFactory<MotorModel, String>("encoder"));
		
		motorTable.setItems(data2);
		motorTable.getColumns().addAll(motorCol, powerCol, stalledCol, voltageCol, currentCol, encoderCol);
		motorTable.setMinWidth(screenWidth / 2 - 2 * GAP);
		motorTable.setPrefHeight(screenHeight - 3.5 * GAP - textHeight);
		motorTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

	}

	public void networkingTable() {
		networkingTable = new TableView<NetworkingModel>();

		TableColumn<NetworkingModel, String> deviceCol = new TableColumn<NetworkingModel, String>("Device");
		deviceCol.setCellValueFactory(
				new PropertyValueFactory<NetworkingModel, String>("name"));

		TableColumn<NetworkingModel, String> valueCol = new TableColumn<NetworkingModel, String>("Value");
		valueCol.setCellValueFactory(
				new PropertyValueFactory<NetworkingModel, String>("value"));

		networkingTable.setItems(data3);
		networkingTable.getColumns().addAll(deviceCol, valueCol);
		networkingTable.setMaxWidth(screenWidth / 2 - 2 * GAP);
		networkingTable.setPrefHeight((screenHeight - (4.5) * GAP - 2 * textHeight) / 2);
		networkingTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	}

	public void updateSensorTable(String power, String stalled, String voltage, String current, String encoder) {

	}
}
