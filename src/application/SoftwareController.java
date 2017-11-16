package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class SoftwareController extends Group {
	private BorderPane pane = new BorderPane();
	private TableView<SensorModel> sensorTable;
	private TableView<NetworkingModel> networkingTable;
	private TableView<MotorModel> motorTable;
	
	private final ObservableList<SensorModel> data = FXCollections.observableArrayList(
		    new SensorModel("hi", "0812309128390"),
		    new SensorModel("hadi", "0828390"),
		    new SensorModel("hasdasfi", "012312390"),
		    new SensorModel("hiasfasf", "08123123124354235")
		);

	private final ObservableList<MotorModel> data2 = FXCollections.observableArrayList(
		    new MotorModel("hi", "0812309128390", "asldjaskld", "asldaskld", "asdlkajsd"),
		    new MotorModel("hadi", "0828390", "asldjaskld", "asldaskld", "asdlkajsd"),
		    new MotorModel("hasdasfi", "012312390", "asldjaskld", "asldaskld", "asdlkajsd"),
		    new MotorModel("hiasfasf", "08123123124354235", "asldjaskld", "asldaskld", "asdlkajsd")
		);
	
	private final ObservableList<NetworkingModel> data3 = FXCollections.observableArrayList(
		    new NetworkingModel("hi", "0812309128390"),
		    new NetworkingModel("hadi", "0828390"),
		    new NetworkingModel("hasdasfi", "012312390"),
		    new NetworkingModel("hiasfasf", "08123123124354235")
		);
	
	private void setLayout() {
		VBox vb1 = new VBox();
		VBox vb2 = new VBox();
		VBox vb3 = new VBox();
		sensorTable();
		motorTable();
		networkingTable();
		
		vb1.getChildren().addAll(new Label("SENSOR"), sensorTable);
		vb1.setSpacing(5);
        vb1.setPadding(new Insets(10, 0, 0, 10));
       
    	vb2.getChildren().addAll(new Label("MOTOR"), motorTable);
		vb2.setSpacing(5);
        vb2.setPadding(new Insets(10, 0, 0, 10));
        
        vb3.getChildren().addAll(new Label("NETWORKING"), networkingTable);
		vb3.setSpacing(5);
        vb3.setPadding(new Insets(10, 0, 0, 10));
        
		pane.setCenter(vb1);
		pane.setLeft(vb2);
		pane.setBottom(vb3);
		
	}

	public Pane getContent() {
		setLayout();
		return pane;
	}
	
	public void sensorTable(){ 
		sensorTable = new TableView<SensorModel>();
		sensorTable.setEditable(true);
		
		//help broken :(((((((((((((
		TableColumn<SensorModel, String> sensorCol = new TableColumn<SensorModel, String>("Sensor");
		sensorCol.setCellValueFactory(
				new PropertyValueFactory<SensorModel, String>("name"));
		
		TableColumn<SensorModel, String> valueCol = new TableColumn<SensorModel, String>("Value");
		valueCol.setCellValueFactory(
				new PropertyValueFactory<SensorModel, String>("value"));
		
		sensorTable.setItems(data);
		sensorTable.getColumns().addAll(sensorCol, valueCol);
		sensorTable.setMaxWidth(210);
	}
	
	public void motorTable(){
		motorTable = new TableView<MotorModel>();
		motorTable.setEditable(true);
		
		TableColumn<MotorModel, String> powerCol = new TableColumn<MotorModel, String>("Power");
		powerCol.setCellValueFactory(
				new PropertyValueFactory<MotorModel, String>("power")); //"name" is variable name
		
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
		motorTable.getColumns().addAll(powerCol, stalledCol, voltageCol, currentCol, encoderCol);
		motorTable.setMaxWidth(500);
	}
	
	public void networkingTable(){
		networkingTable = new TableView<NetworkingModel>();
		networkingTable.setEditable(true);
		
		//help broken :(((((((((((((
		TableColumn<NetworkingModel, String> deviceCol = new TableColumn<NetworkingModel, String>("Device");
		deviceCol.setCellValueFactory(
				new PropertyValueFactory<NetworkingModel, String>("name"));
		
		TableColumn<NetworkingModel, String> valueCol = new TableColumn<NetworkingModel, String>("Value");
		valueCol.setCellValueFactory(
				new PropertyValueFactory<NetworkingModel, String>("value"));
		
		networkingTable.setItems(data3);
		networkingTable.getColumns().addAll(deviceCol, valueCol);
		networkingTable.setMaxWidth(210);
	}
}
