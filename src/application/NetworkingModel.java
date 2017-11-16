package application;

import javafx.beans.property.SimpleStringProperty;

public class NetworkingModel{

	private SimpleStringProperty deviceName;
	private SimpleStringProperty value;

	public NetworkingModel(String name, String value) { //need to find out way to track values
		this.deviceName = new SimpleStringProperty(name);
		this.value = new SimpleStringProperty(value);
	}

	public String getName() {
		return deviceName.get();
	}
	
	public void setName(String n) {
		deviceName.set(n);
	}
	
	public String getValue() {
		return value.get();
	}
	
	public void setValue(String n) {
		value.set(n);
	}	
}
