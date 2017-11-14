package application;

import com.jfoenix.controls.JFXTextArea;
import javafx.scene.layout.BorderPane;

public class Console extends BorderPane {
	private final JFXTextArea display = new JFXTextArea();

	Console() {
		display.setEditable(false);
		setCenter(display);
	}

	public void addText(String input) {
		display.appendText(input + System.lineSeparator());
	}

	public String getText() {
		return display.getText();
	}
}
