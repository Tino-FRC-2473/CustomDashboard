package application;

import java.util.HashMap;
import java.util.Map;

public class Database {
	private Map<String, Double> doubleValues;

	public static Database instance;

	static {
		instance = new Database();
	}

	private Database() {
		doubleValues = new HashMap<>();

	}

	public static Database instance() {
		return instance;
	}

	public void setDouble(String key, Double value) {
		doubleValues.put(key, value);
	}

	public Double getDouble(String key) {
		return doubleValues.get(key);
	}
}
