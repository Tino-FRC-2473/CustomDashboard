package application;

import javafx.animation.AnimationTimer;
import javafx.beans.property.SimpleStringProperty;

public class ValueNode {

	private SimpleStringProperty name;
	private SimpleStringProperty value;
	private ValueNodeAnimation timer;

	public ValueNode(String name, String value) { //need to find out way to track values
		this.name = new SimpleStringProperty(name);
		this.value = new SimpleStringProperty(value);
		timer = new ValueNodeAnimation(this);
		timer.start();
		System.out.println("oh boy");
	}

	public String getName() {
		return name.get();
	}
	
	public String getValue() {
		return value.get();
	}
	
	public void setName(String n) {
		name.set(n);
	}
	
	public void setValue(String n) {
		value.set(n);
	}
	

}

class ValueNodeAnimation extends AnimationTimer {

	private ValueNode target;
	private double x;

	ValueNodeAnimation(ValueNode t) {
		target = t;
		x = 0;
	}
	
	@Override
	public void handle(long arg0) {
		x++;
		target.setValue(x + "");
		System.out.println(x);
	}


}
