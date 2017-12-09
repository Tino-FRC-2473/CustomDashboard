package application;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
	
public class AnimatedTable extends TableView<Model>{

	private boolean stopped;
	private ObservableList<Model> data; 
	private Class c; // only for now while there are random generated values
	public AnimatedTable(Class c, ObservableList data) {
		this.data = data;
		this.c = c;
		stopped = false;
		setUpColumns(c);
		setItems(data);
		
	}

	public void run() {
		new AnimationTimer() {

			@Override
			public void handle(long now) {
				if (now % 50 == 0) {
					if(c.equals(MotorModel.class))
						updateValue(new MotorModel("motor" + String.valueOf(new Random().nextInt(10)),String.valueOf(Math.random()),String.valueOf(Math.random()),String.valueOf(Math.random()),String.valueOf(Math.random()),String.valueOf(Math.random())));
					else if(c.equals(SensorModel.class))
						updateValue(new SensorModel("sensor" + String.valueOf(new Random().nextInt(10)),String.valueOf(Math.random())));	
					else if(c.equals(NetworkingModel.class))
						updateValue(new NetworkingModel("thing" + String.valueOf(new Random().nextInt(10)),String.valueOf(Math.random())));
					setItems(data);
					refresh(); 	
				}
			}
			
		}.start();
		
	}

	private void updateValue(Model model){
		String name = model.getName();
		int index = -1; //-1 = doesnt exist, other number = index 
		for(Model i: data){
			if(i.getName().equals(name)){
				index = data.indexOf(i);
			}
		}
		if(index != -1){ //resets item value
			data.set(index, model); 
		}
		else{
			data.add(0, model); //adds new items and values
		}
	}
	
	//sets up the columns
	public void setUpColumns(Class c){
		if(c.equals(MotorModel.class)){
			TableColumn<Model, String> motorCol = new TableColumn<Model, String>("Motor");
			motorCol.setCellValueFactory(
					new PropertyValueFactory<Model, String>("name"));
			
			TableColumn<Model, String> powerCol = new TableColumn<Model, String>("Power");
			powerCol.setCellValueFactory(
					new PropertyValueFactory<Model, String>("power")); //"_____" is variable name
			
			TableColumn<Model, String> stalledCol = new TableColumn<Model, String>("Stalled");
			stalledCol.setCellValueFactory(
					new PropertyValueFactory<Model, String>("stalled"));
			
			TableColumn<Model, String> voltageCol = new TableColumn<Model, String>("Voltage");
			voltageCol.setCellValueFactory(
					new PropertyValueFactory<Model, String>("voltage"));
			
			TableColumn<Model, String> currentCol = new TableColumn<Model, String>("Current");
			currentCol.setCellValueFactory(
					new PropertyValueFactory<Model, String>("current"));
					
			TableColumn<Model, String> encoderCol = new TableColumn<Model, String>("Encoder");
			encoderCol.setCellValueFactory(
					new PropertyValueFactory<Model, String>("encoder"));
			getColumns().addAll(motorCol, powerCol, stalledCol, voltageCol, currentCol, encoderCol);
		} else if(c.equals(NetworkingModel.class)){
			TableColumn<Model, String> nameCol = new TableColumn<Model, String>("Name");
			nameCol.setCellValueFactory(
					new PropertyValueFactory<Model, String>("name"));
					
			TableColumn<Model, String> valueCol = new TableColumn<Model, String>("Value");
			valueCol.setCellValueFactory(
					new PropertyValueFactory<Model, String>("value"));
			getColumns().addAll(nameCol, valueCol);
		} else if(c.equals(SensorModel.class)){
			TableColumn<Model, String> sensorCol = new TableColumn<Model, String>("Sensor");
			sensorCol.setCellValueFactory(
					new PropertyValueFactory<Model, String>("name"));

			TableColumn<Model, String> valueCol = new TableColumn<Model, String>("Value");
			valueCol.setCellValueFactory(
					new PropertyValueFactory<Model, String>("value"));
			getColumns().addAll(sensorCol, valueCol);
		}
	}
	public void stop() {
		stopped = true;
	}
}
