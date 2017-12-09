package application;

import com.jfoenix.controls.JFXProgressBar;
import javafx.animation.AnimationTimer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Screen;

public class DriverController extends Group {

	private BorderPane pane = new BorderPane();
	private Rectangle2D screenBalance = Screen.getPrimary().getVisualBounds(); //for getting screen dimensions
	private double screenWidth = screenBalance.getWidth();
	private double screenHeight = screenBalance.getHeight() / 1.5;
	private double x = 865; //x where camera ends and stuff goes
	private double battery = 1;

	private AnimatedTable motorTable;
	private final double GAP = 10; //width of spacing/"gaps"
	double textHeight = 20; //height of labels
	private final ObservableList<MotorModel> data2 = FXCollections.observableArrayList(
		    new MotorModel("motor1", "hi", "0812309128390", "asldjaskld", "asldaskld", "asdlkajsd"),
		    new MotorModel("motor2", "hadi", "0828390", "asldjaskld", "asldaskld", "asdlkajsd"),
		    new MotorModel("motor3", "hasdasfi", "012312390", "asldjaskld", "asldaskld", "asdlkajsd"),
		    new MotorModel("motor4", "hiasfasf", "08123123124354235", "asldjaskld", "asldaskld", "asdlkajsd")
		);
	
	private void setLayout() {

		VBox rightVB = new VBox();
		
		ScrollPane sp = new ScrollPane();
		sp.setPrefSize(screenWidth - x, screenHeight);
		sp.setContent(rightVB);

		Label volt = new Label("BATTERY VOLTAGE");
		volt.setPadding(new Insets(10, 10, 10, 10));
		volt.setFont(new Font("Sans Serif", 20));

		
		Label title = new Label("MOTOR STATUS");
		title.setPadding(new Insets(10, 10, 10, 10));
		title.setFont(new Font("Sans Serif", 20));

		Label batteryLabel = new Label((int) (battery * 100) + "%");
		batteryLabel.setFont(new Font("Arial", 40));
		JFXProgressBar batteryBar = new JFXProgressBar();
		//hbox for battery stuff
		HBox hbox = new HBox();
		hbox.setAlignment(Pos.TOP_LEFT);
		hbox.setSpacing(20);
		hbox.getChildren().addAll(batteryBar, batteryLabel);
		hbox.setPadding(new Insets(0, 10, 0, 10));
		//help
		batteryBar.setPrefWidth(screenWidth - x - 200);
		batteryBar.setPrefHeight(30);

		motorTable();
		rightVB.getChildren().addAll(volt, hbox, title, motorTable);

		rightVB.setAlignment(Pos.TOP_LEFT);
		new AnimationTimer() {

			@Override
			public void handle(long now) {
				batteryBar.setProgress(battery);
				batteryLabel.setText((int) (battery * 100) + "%");
				battery -= 0.01;
			}

		}.start();

		pane.setRight(sp);


	}


	public void motorTable(){
		motorTable = new AnimatedTable(MotorModel.class, data2);
		motorTable.setMinWidth(screenWidth / 2 - 2 * GAP);
		motorTable.setPrefHeight(screenHeight - 3.5 * GAP - textHeight);
		motorTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		motorTable.run();
	}


	Pane getContent() {
		setLayout();
		return pane;
	}
}