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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ConsoleController extends Group {

	private ConsolePane consolePane = new ConsolePane();
	private JFXButton exportButton = new JFXButton("Export");

	private void setLayout() {
		exportButton.setButtonType(JFXButton.ButtonType.FLAT);
		exportButton.setPrefSize(100, 50);
		exportButton.setFont(new Font("Roboto", 18));
		exportButton.setRipplerFill(Color.LIGHTSTEELBLUE);
		exportButton.setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN, new CornerRadii(0), Insets.EMPTY)));

		exportButton.setOnAction(event -> {
			File file = new File(System.getProperty("user.home") + File.separator + "Dashboard Log.log");

			try (PrintWriter writer = new PrintWriter(file)) {
				writer.println(consolePane.getText());
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		});

		consolePane.setTop(exportButton);

		new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				consolePane.addText(String.valueOf(i));
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
		return consolePane;
	}
}
