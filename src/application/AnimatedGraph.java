package application;

import javafx.animation.AnimationTimer;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class AnimatedGraph extends LineChart<Number, Number> {
	
	private int domain; 
	private boolean stopped;
	private XYChart.Series<Number, Number> series;
	private AnimatedGraph self;
	
	public AnimatedGraph(Axis<Number> arg0, Axis<Number> arg1, int d) {
		super(arg0, arg1);
		stopped = false;
		series = new XYChart.Series<>();
		domain = d;
		this.setAnimated(false);
		self = this;
	}
	
	public void run() {
		
		new AnimationTimer() {

			int counter = 0;
			@Override
			public void handle(long now) {
				if(counter%4 == 0) {
					series = new XYChart.Series<Number, Number>();
					for (int i = 1; i <= domain; i++) {
						series.getData().add(new XYChart.Data<>(i, (int) (Math.random() * 20)));
					}
					if (self.getData().size() > 0)
						self.getData().clear();
					self.getData().add(series);
				}
				
				counter++;

			}

		}.start();

	}

	public void stop() {
		stopped = true;
	}
}
