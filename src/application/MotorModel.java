package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MotorModel implements Model{
	
	private SimpleStringProperty name;
	private SimpleStringProperty power;
	private SimpleStringProperty stalled;
	private SimpleStringProperty voltage;
	private SimpleStringProperty current;
	private SimpleStringProperty encoder;

	public MotorModel(String motorName, String power, String stalled, String voltage, String current, String encoder) { //need to find out way to track values
		this.name = new SimpleStringProperty(motorName);
		this.power = new SimpleStringProperty(power);
		this.stalled = new SimpleStringProperty(stalled);
		this.voltage = new SimpleStringProperty(voltage);
		this.current = new SimpleStringProperty(current);
		this.encoder = new SimpleStringProperty(encoder);
	}
	
	@Override
	public String getName() {
		return name.get();
	}
	
	public void setName(String n){
		name.set(n);
	}

	public String getPower() {
		return power.get();
	}

	public void setPower(String n) {
		power.set(n);
	}

	public String getStalled() {
		return stalled.get();
	}

	public void setStalled(String n) {
		stalled.set(n);
	}

	public String getVoltage() {
		return voltage.get();
	}

	public void setVoltage(String n) {
		voltage.set(n);
	}

	public String getCurrent() {
		return current.get();
	}

	public void setCurrent(String n) {
		current.set(n);
	}

	public String getEncoder() {
		return encoder.get();
	}

	public void setEncoder(String n) {
		encoder.set(n);
	}
}
