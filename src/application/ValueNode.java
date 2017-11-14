package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ValueNode {

	private SimpleStringProperty name;
	private SimpleStringProperty value;

	public ValueNode(String name, String value) { //need to find out way to track values
		this.name = new SimpleStringProperty(name);
		this.value = new SimpleStringProperty(value);
	}

	public String getValue() {
		return value.get();
	}
	
	public void setValue(String n) {
		value.set(n);
	}
	
	public String getName() {
		return name.get();
	}
	
	public void setName(String n) {
		value.set(n);
	}
}

//
//public class ValueNode extends HBox {
//
//	private Label value;
//
//	public ValueNode(String nameText) { //need to find out way to track values
//		Label name = new Label(nameText);
//		value = new Label("0");
//		this.getChildren().add(name);
//		this.getChildren().add(value);
//	}
//
//	public void setValue(double n) {
//		value.setText(n + "");
//	}
//
//}
