package application;

import java.util.ArrayList;

public class Parser {
	public static ArrayList<String[]> parse(String str, String regIn, String regOut){
		String[] items = str.split(regOut);
		ArrayList<String[]> dataItems = new ArrayList<>();
		for (String item: items) {
			dataItems.add(item.split(regIn));
		}
		return dataItems;
	}
}
