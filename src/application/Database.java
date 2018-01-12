package application;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Map;

public class Database {
	// private String[] key = {"", ""}; "CGT"
	private static ArrayList<ArrayList<Point2D.Float>> graphValues;
	private static ArrayList<ArrayList<String>> tableValues;

	public static Database instance;
	
	static ArrayList<Point2D.Float> lineGraphValues;
	static ArrayList<String> motorTableValues;
	static ArrayList<String> sensorTableValues;
	static ArrayList<String> networkingTableValues;
	
	
	static {
		instance = new Database();
	}

	private Database() {
		graphValues = new ArrayList<>();
		tableValues = new ArrayList<>();
		lineGraphValues = new ArrayList<>();
		motorTableValues = new ArrayList<>();
		
	}

	public static Database instance() {
		return instance;
	}
		

	public static void updateData(ArrayList<String[]> arr){
		for(String[] i: arr){
			if(i[0].equals("GRAPH")) {
				if (i[1].equals("LINE")) {
					lineGraphValues.add(new Point2D.Float(Float.parseFloat(i[2]), Float.parseFloat(i[3])));
				}
			} else if(i[0].equals("TABLE")) { 
				if(i[1].equals("MOTOR")){ //";TABLE:MOTOR:name|power|stalled|voltage;"
					motorTableValues.add(i[2]);
				} else if(i[1].equals("SENSOR")) {
					sensorTableValues.add(i[2]);
				} else if(i[1].equals("NETWORKING")){
					networkingTableValues.add(i[2]);
				}
			}
		}
		graphValues.add(lineGraphValues);
		tableValues.add(motorTableValues);
		tableValues.add(sensorTableValues);
		tableValues.add(networkingTableValues);
	}
}
