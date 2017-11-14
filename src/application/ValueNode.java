package application;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ValueNode extends HBox {

	private Label value;

	public ValueNode(String nameText) { //need to find out way to track values
		Label name = new Label(nameText);
		value = new Label("0");
		this.getChildren().add(name);
		this.getChildren().add(value);
	}

	public void setValue(double n) {
		value.setText(n + "");
	}

}
