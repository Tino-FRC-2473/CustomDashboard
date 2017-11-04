package application;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;

import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;

public class GraphController extends Node {

	private BorderPane pane = new BorderPane();

	private void setLayout() {
		ScrollPane spR = new ScrollPane();
		
		Rectangle2D screenBalance = Screen.getPrimary().getVisualBounds(); //for getting screen dimensions
		double screenWidth = screenBalance.getWidth();
		double screenHeight = 650;
		
	    spR.setPrefSize(screenWidth / 2, screenHeight);
	    spR.setContent(new Rectangle(screenWidth / 2, screenHeight * 2, Color.ALICEBLUE));
	    pane.setRight(spR);
	    
	    ScrollPane spL = new ScrollPane();
	    spL.setPrefSize(screenWidth / 2, screenHeight);
	    spL.setContent(new Rectangle(screenWidth / 2, screenHeight * 2, Color.ALICEBLUE));
	    pane.setLeft(spL);
	    
		XYChart.Series series = new XYChart.Series();
		series.getData().add(new XYChart.Data());
		final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
		LineChart<Number, Number> lc = new LineChart<Number, Number>(xAxis, yAxis);
	}

	public Pane getContent() {
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
}
