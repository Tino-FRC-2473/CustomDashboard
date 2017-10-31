package application;
import javafx.animation.*;
import javafx.scene.text.Text;
//This class is used to display values, updated in real time.
//Multiple ValueNode objects can be used to make a table.
public class ValueNode extends AnimationTimer{

	//value: raw value that is tracked
	Text value;
	//name: name of value tracked
	Text name;
	//don't forget to check Text class API: https://docs.oracle.com/javafx/2/text/jfxpub-text.htm
	
	public ValueNode(double x, double y, String nameText) { //need to find out way to track values
		name = new Text(nameText);
		name.setX(x);
		name.setY(y);
		value = new Text();
		//value Text is offset to the right by 100, so that name and value don't overlap
		name.setX(x+100);
		name.setY(y);
	}
	
	@Override
	public void handle(long arg0) {
		//value updated constantly within this method
		//long is measured in nanoseconds (1e^-9 seconds)
		//use modulus to configure rate at which value is updated
	}

}
