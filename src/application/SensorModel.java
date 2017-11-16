package application;

import javafx.beans.property.SimpleStringProperty;

public class SensorModel{

	private SimpleStringProperty sensor;
	private SimpleStringProperty value;

	public SensorModel(String sensorName, String value) { //need to find out way to track values
		this.sensor = new SimpleStringProperty(sensorName);
		this.value = new SimpleStringProperty(value);
	}

	public String getName() {
		return sensor.get();
	}
	
	public void setName(String n) {
		sensor.set(n);
	}
	
	public String getValue() {
		return value.get();
	}
	
	public void setValue(String n) {
		value.set(n);
	}	
}
