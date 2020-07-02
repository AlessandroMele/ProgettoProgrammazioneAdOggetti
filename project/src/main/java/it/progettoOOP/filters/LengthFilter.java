package it.progettoOOP.filters;

import org.json.simple.JSONObject;

public class LengthFilter {

	private int min;
	private int max;
	
	public int getMin(JSONObject length) {
		min = length.getint("min");
		return min;
	}
	
	public int getMax(JSONObject length) {
		max = (int) length.get("max");
		return max;
	}

}
