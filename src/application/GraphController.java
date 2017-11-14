package application;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.chart.*;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

import java.util.ArrayList;

public class GraphController extends Node {

	private BorderPane pane = new BorderPane();

	private void setLayout() {

		Rectangle2D screenBalance = Screen.getPrimary().getVisualBounds(); //for getting screen dimensions
		double screenWidth = screenBalance.getWidth();
		double screenHeight = 630;

		//right scroll pane
		ScrollPane spR = new ScrollPane();
		spR.setPrefSize(screenWidth / 2 - 20, screenHeight);
		pane.setRight(spR);
		VBox rightVB = addVBox();
		spR.setContent(rightVB);
		BorderPane.setMargin(spR, new Insets(0, 0, 0, 10));

		//left scroll pane
		ScrollPane spL = new ScrollPane();
		spL.setPrefSize(screenWidth / 2 - 20, screenHeight);
		pane.setLeft(spL);
		VBox leftVB = addVBox();
		spL.setContent(leftVB);
		BorderPane.setMargin(spL, new Insets(0, 10, 0, 0));

		//delete later when u have actual data
		ArrayList<Number> xVals = new ArrayList<Number>();
		xVals.add(1);
		xVals.add(2);
		xVals.add(3);
		xVals.add(4);
		ArrayList<Number> yVals = xVals;
		ArrayList<Number> zVals = new ArrayList<Number>();
		zVals.add(6);
		zVals.add(4);
		zVals.add(2);
		zVals.add(2);
		ArrayList<XYChart.Series> series = new ArrayList<XYChart.Series>();
		series.add(addSeries("serie 1", xVals, yVals));
		series.add(addSeries("series 2", xVals, zVals));
		ArrayList<XYChart.Series> series2 = new ArrayList<XYChart.Series>();
		series2.add(addSeries("serie 1", xVals, yVals));
		series2.add(addSeries("series 2", xVals, zVals));

		rightVB.getChildren().add(addScatterChart("scatter chart", "x axis", zVals, "y axis", yVals));
		//example line chart
		leftVB.getChildren().add(addLineChart("gr8 line chart", "x axis", "y axis", series)); //cant repeat series arraylist or strange things happen

		//example area chart
		rightVB.getChildren().add(addAreaChart("area chart", "x axis", "y axis", series2));

		//example scatter plot
		leftVB.getChildren().add(addScatterChart("a scatter chart", "x axis", xVals, "y axis", yVals));
	}

	//prerequisite: xval and yval are same size
	//arraylist can change to something else idk
	public XYChart.Series addSeries(String name, ArrayList xVals, ArrayList yVals) {
		XYChart.Series series = new XYChart.Series();
		series.setName(name);
		for (int i = 0; i < xVals.size(); i++) {
			series.getData().add(new XYChart.Data(xVals.get(i), yVals.get(i)));
		}
		return series;
	}

	//u can have multiple series of data, scroll down for single series method
	//returns a linechart
	private LineChart<Number, Number> addLineChart(String title, String xLabel, String yLabel, ArrayList<XYChart.Series> series) {
		final NumberAxis xAxis = new NumberAxis();
		xAxis.setLabel(xLabel);
		final NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel(yLabel);

		LineChart<Number, Number> lc = new LineChart<Number, Number>(xAxis, yAxis);
		lc.setTitle(title);
		for (XYChart.Series i : series) {
			lc.getData().add(i);
		}
		return lc;
	}

	//returns a scatterchart
	private ScatterChart<Number, Number> addScatterChart(String title, String xLabel, ArrayList<Number> xVals, String yLabel, ArrayList<Number> yVals) {
		final NumberAxis xAxis = new NumberAxis();
		xAxis.setLabel(xLabel);
		final NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel(yLabel);

		ScatterChart<Number, Number> sc = new ScatterChart<Number, Number>(xAxis, yAxis);
		sc.setTitle(title);
		sc.getData().add(addSeries("serie 1", xVals, yVals));

		return sc;
	}

	private AreaChart<Number, Number> addAreaChart(String title, String xLabel, String yLabel, ArrayList<XYChart.Series> series) {
		final NumberAxis xAxis = new NumberAxis();
		xAxis.setLabel(xLabel);
		final NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel(yLabel);

		AreaChart<Number, Number> c = new AreaChart<Number, Number>(xAxis, yAxis);
		c.setTitle(title);
		for (XYChart.Series i : series) {
			c.getData().add(i);
		}
		return c;
	}

	private VBox addVBox() {
		VBox vb = new VBox();
		vb.setPadding(new Insets(10, 0, 10, 0));
		vb.setSpacing(20);
		vb.setAlignment(Pos.CENTER); //not centering rip
		return vb;
	}

	Pane getContent() {
		setLayout();
		return pane;
	}

	@Override
	protected NGNode impl_createPeer() {
		return null;
	}

	@Override
	public BaseBounds impl_computeGeomBounds(BaseBounds bounds, BaseTransform tx) {
		return null;
	}

	@Override
	protected boolean impl_computeContains(double localX, double localY) {
		return false;
	}

	@Override
	public Object impl_processMXNode(MXNodeAlgorithm alg, MXNodeAlgorithmContext ctx) {
		return null;
	}
	/*public LineChart<Number, Number> addLineChart(String title, String xLabel, ArrayList<Number> xVals, String yLabel, ArrayList<Number> yVals){
		final NumberAxis xAxis = new NumberAxis();
		xAxis.setLabel(xLabel);
	    final NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel(yLabel);
		
		LineChart<Number, Number> lc = new LineChart<Number, Number>(xAxis, yAxis);
		lc.setTitle(title);
		lc.getData().add(addSeries("serie 1", xVals, yVals));
		
	    return lc;
	}*/
}
