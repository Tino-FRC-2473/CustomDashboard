package application;

import javafx.animation.AnimationTimer;

public class ValueNodeAnimation extends AnimationTimer{

	private ValueNode target;
	private double x;
	
	public ValueNodeAnimation(ValueNode t) {
		target = t;
		x = 0;
	}

	@Override
	public void handle(long n) {
		if(n%1 == 0) {
			x++;
			target.setValue(x);
		}
	}
	
}
