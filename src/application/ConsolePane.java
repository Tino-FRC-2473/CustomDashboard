package application;

import com.jfoenix.controls.JFXTextArea;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class ConsolePane extends BorderPane {
	private final JFXTextArea display = new JFXTextArea();

	public ConsolePane() {
		display.setEditable(false);
		display.setPadding(new Insets(5, 10, 2, 10));
		setCenter(display);
	}

	public void addText(String input) {
		display.appendText(input + System.lineSeparator());
	}

	public String getText() {
		return display.getText();
	}
}