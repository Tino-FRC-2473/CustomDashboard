package application;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class SoftwareController extends Node {

	private BorderPane pane = new BorderPane();

	private void setLayout() {
		// add all of your stuff here
		HBox hBox = new HBox();
		Label label = new Label("test");
		hBox.getChildren().add(label);
		pane.setTop(hBox);
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
