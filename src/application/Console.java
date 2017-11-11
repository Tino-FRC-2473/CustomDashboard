package application;

import com.jfoenix.controls.JFXTextArea;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class Console extends BorderPane {
	private final JFXTextArea display = new JFXTextArea();

	public Console() {
		display.setEditable(false);
		display.setPadding(new Insets(5, 10, 0, 10));
		setCenter(display);
	}

	public void addText(String input) {
		display.appendText(input + System.lineSeparator());
	}

	public String getText() {
		return display.getText();
	}
}
