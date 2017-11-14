package application;

import javafx.animation.AnimationTimer;

public class ValueNodeAnimation extends AnimationTimer {

	private ValueNode target;
	private double x;

	ValueNodeAnimation(ValueNode t) {
		target = t;
		x = 0;
	}

	@Override
	public void handle(long n) {
		x++;
		target.setValue(x);
	}

}
