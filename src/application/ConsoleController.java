package application;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ConsoleController extends Group {

	private Console console = new Console();
	private JFXButton exportButton = new JFXButton("Export");

	private void setLayout() {
		exportButton.setButtonType(JFXButton.ButtonType.FLAT);
		exportButton.setPrefSize(100, 50);
		exportButton.setFont(new Font("Roboto", 18));
		exportButton.setRipplerFill(Color.LIGHTSTEELBLUE);
		exportButton.setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN, new CornerRadii(0), Insets.EMPTY)));

		exportButton.setOnAction(event -> {
			System.out.println(console.getText());
		});

		console.setTop(exportButton);

		new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				console.addText(String.valueOf(i));
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	Node getContent() {
		setLayout();
		return console;
	}
}
