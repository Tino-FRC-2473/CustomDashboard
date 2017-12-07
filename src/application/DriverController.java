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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Screen;

public class DriverController extends Group {

	private BorderPane pane = new BorderPane();
	private Rectangle2D screenBalance = Screen.getPrimary().getVisualBounds(); //for getting screen dimensions
	private double screenWidth = screenBalance.getWidth();
	private double screenHeight = 630;
	private double x = 865; //x where camera ends and stuff goes
	private double battery = 1;

	private TableView<MotorModel> motorTable;
	private final double GAP = 10; //width of spacing/"gaps"
	double textHeight = 20; //height of labels
	private final ObservableList<MotorModel> data2 = FXCollections.observableArrayList(
<<<<<<< HEAD
		    new MotorModel("motor1", "hi", "0812309128390", "asldjaskld", "asldaskld", "asdlkajsd"),
		    new MotorModel("motor2", "hadi", "0828390", "asldjaskld", "asldaskld", "asdlkajsd"),
		    new MotorModel("motor3", "hasdasfi", "012312390", "asldjaskld", "asldaskld", "asdlkajsd"),
		    new MotorModel("motor4", "hiasfasf", "08123123124354235", "asldjaskld", "asldaskld", "asdlkajsd")
		);
	
=======
			new MotorModel("hi", "0812309128390", "asldjaskld", "asldaskld", "asdlkajsd"),
			new MotorModel("hadi", "0828390", "asldjaskld", "asldaskld", "asdlkajsd"),
			new MotorModel("hasdasfi", "012312390", "asldjaskld", "asldaskld", "asdlkajsd"),
			new MotorModel("hiasfasf", "08123123124354235", "asldjaskld", "asldaskld", "asdlkajsd")
	);

>>>>>>> 284a6cd4171caf60fc690018c38ab5a47f91b73e
	private void setLayout() {

		VBox rightVB = new VBox();
		
		
		ScrollPane sp = new ScrollPane();
		sp.setPrefSize(screenWidth - x, screenHeight);
		sp.setContent(rightVB);
<<<<<<< HEAD
		
=======

		//LEFT VBOX THINGS
>>>>>>> 284a6cd4171caf60fc690018c38ab5a47f91b73e
		Label title = new Label("MOTOR STATUS");
		title.setPadding(new Insets(10, 10, 10, 10));
		title.setFont(new Font("Sans Serif", 20));

		Label batteryLabel = new Label((int) (battery * 100) + "%");
		batteryLabel.setFont(new Font("Arial", 40));
		JFXProgressBar batteryBar = new JFXProgressBar();
		//hbox for battery stuff
		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);
		hbox.setSpacing(20);
		hbox.getChildren().addAll(batteryBar, batteryLabel);
		hbox.setPadding(new Insets(0, 10, 0, 10));
		//help
		batteryBar.setPrefWidth(screenWidth - x - 200);
		batteryBar.setPrefHeight(30);

		int volts = 100;
		Label voltage = new Label("VOLTAGE: " + volts + " v ");
		voltage.setFont(new Font("Arial", 30));
		voltage.setPadding(new Insets(30, 10, 40, 10));

		//TEMPERATURE STUFF
		StackPane tempPane = new StackPane();
		Image img = new Image("images/temperature scale.png");
		ImageView temp = new ImageView(img);
		temp.setFitWidth(200);
		temp.setFitHeight(200);

		Image img2 = new Image("images/temperature hand.png");
		ImageView hand = new ImageView(img2);
		hand.setFitWidth(150);
		hand.setFitHeight(150);

		double minTemp = 0;
		double maxTemp = 180;
		double temperature = 180;
		hand.setRotate((-135 + 270 * (temperature - minTemp) / (maxTemp - minTemp))); //clockwise from vertical

		Label tempLabel = new Label(temperature + "\u00B0");
		tempLabel.setFont(new Font("Sans Serif", 20));
		tempLabel.setPadding(new Insets(120, 0, 0, 0));
		tempPane.getChildren().addAll(temp, hand, tempLabel);

		motorTable();
		rightVB.getChildren().addAll(title, hbox, voltage, tempPane, motorTable);
<<<<<<< HEAD
		rightVB.setAlignment(Pos.CENTER);
		
=======


>>>>>>> 284a6cd4171caf60fc690018c38ab5a47f91b73e
//		Rectangle r = new Rectangle(screenWidth - x, 2 * screenHeight, Color.WHITE); //white background using stackpane
//		r.setLayoutX(x);
		//stack.getChildren().add(r);

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

<<<<<<< HEAD
	public void motorTable(){
	motorTable = new TableView<MotorModel>();
		
		TableColumn<MotorModel, String> motorCol = new TableColumn<MotorModel, String>("Motor");
		motorCol.setCellValueFactory(
				new PropertyValueFactory<MotorModel, String>("name"));
		
		TableColumn<MotorModel, String> powerCol = new TableColumn<MotorModel, String>("Power");
=======
	public void motorTable() {
		motorTable = new TableView<>();

		TableColumn<MotorModel, String> powerCol = new TableColumn<>("Power");
>>>>>>> 284a6cd4171caf60fc690018c38ab5a47f91b73e
		powerCol.setCellValueFactory(
				new PropertyValueFactory<>("power")); //"_____" is variable name

		TableColumn<MotorModel, String> stalledCol = new TableColumn<>("Stalled");
		stalledCol.setCellValueFactory(
				new PropertyValueFactory<>("stalled"));

		TableColumn<MotorModel, String> voltageCol = new TableColumn<>("Voltage");
		voltageCol.setCellValueFactory(
				new PropertyValueFactory<>("voltage"));

		TableColumn<MotorModel, String> currentCol = new TableColumn<>("Current");
		currentCol.setCellValueFactory(
				new PropertyValueFactory<>("current"));

		TableColumn<MotorModel, String> encoderCol = new TableColumn<>("Encoder");
		encoderCol.setCellValueFactory(
<<<<<<< HEAD
				new PropertyValueFactory<MotorModel, String>("encoder"));
		
=======
				new PropertyValueFactory<>("encoder"));
>>>>>>> 284a6cd4171caf60fc690018c38ab5a47f91b73e
		motorTable.setItems(data2);
		motorTable.getColumns().addAll(motorCol, powerCol, stalledCol, voltageCol, currentCol, encoderCol);
//		motorTable.setMinWidth(screenWidth / 2 - 2 * GAP);
		motorTable.setPrefHeight(screenHeight - 3.5 * GAP - textHeight);
		motorTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

	}


	Pane getContent() {
		setLayout();
		return pane;
	}
}