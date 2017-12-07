package application;

import java.util.HashMap;

public class Database {

	private HashMap<String, Double> values;
	
	public Database() {
		values = new HashMap<String, Double>();
	}
	
	public HashMap<String, Double> getValues(){
		return values;
	}
	
}
