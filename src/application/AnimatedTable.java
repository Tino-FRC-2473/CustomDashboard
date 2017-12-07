package application;

import javafx.animation.AnimationTimer;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.chart.Axis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
	
public class AnimatedTable extends TableView<Model>{

	private boolean stopped;
	private ObservableList<Model> data; //MAKE A GENERAL MODEL LATER
	private AnimatedTable self; 

	public AnimatedTable(ObservableList data) {
		this.data = data;
		stopped = false;
		self = this;
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
		self.getColumns().addAll(motorCol, powerCol, stalledCol, voltageCol, currentCol, encoderCol);
		
	}

	public void run() {
		new AnimationTimer() {

			@Override
			public void handle(long now) {
				if (now % 50 == 0) {
					
					updateValue(new MotorModel(String.valueOf(Math.random()),String.valueOf(Math.random()),String.valueOf(Math.random()),String.valueOf(Math.random()),String.valueOf(Math.random()),String.valueOf(Math.random())));
					self.getItems().clear();
					System.out.println(data);
					self.setItems(data);//add in new
					self.refresh(); //refresh
				}
			}
			
		}.start();
		
	}

	//strategy: update it
	//parameters: model
	//use getter to get the row
	//if its alreayd in the table, tthen update the existing one, otherwise add it
	private void updateValue(Model model){
		String name = model.getName();
		int index = -1; //-1 = doesnt exist, other number = index 
		for(Model i: data){
			if(i.getName().equals(name)){
				index = data.indexOf(i);
			}
		}
		if(index == -1){
			data.add(model);
		} else {
			data.set(index, model);
		}

	}
	
	public void stop() {
		stopped = true;
	}
}
