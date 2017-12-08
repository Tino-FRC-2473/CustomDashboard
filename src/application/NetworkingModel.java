package application;

import javafx.beans.property.SimpleStringProperty;

public class NetworkingModel implements Model{

	private SimpleStringProperty name;
	private SimpleStringProperty value;

	public NetworkingModel(String device, String value) { //need to find out way to track values
		this.name = new SimpleStringProperty(device);
		this.value = new SimpleStringProperty(value);
	}
	
	@Override
	public String getName() {
		return name.get();
	}
	
	public void setName(String n) {
		name.set(n);
	}
		
	public String getValue() {
		return value.get();
	}
	
	public void setValue(String n) {
		value.set(n);
	}	
}
