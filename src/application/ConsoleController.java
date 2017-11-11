package application;

import com.jfoenix.controls.JFXButton;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class ConsoleController extends Group {

	public static Console console = new Console();

	private void setLayout() {
		JFXButton exportButton = new JFXButton("Export");
		exportButton.setButtonType(JFXButton.ButtonType.RAISED);
		exportButton.setPrefSize(100, 25);
		exportButton.setFont(new Font("Roboto", 18));
		exportButton.setRipplerFill(Color.LIGHTSLATEGRAY);
		exportButton.setBackground(new Background(new BackgroundFill(Color.LIGHTSTEELBLUE, new CornerRadii(0), Insets.EMPTY)));
		exportButton.setOnAction(event -> {
			try (PrintWriter writer = new PrintWriter("log.txt", "UTF-8")) {
				writer.println(console.getText());
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		});
		console.setTop(exportButton);

		ConsoleUpdater consoleUpdater = new ConsoleUpdater(console);

		for (int i = 0; i < 100000; i++) {
			consoleUpdater.updateConsole(i + "");
		}
	}

	public Node getContent() {
		setLayout();
		return console;
	}

	public void print(String input) {
		console.addText(input);
	}
}
