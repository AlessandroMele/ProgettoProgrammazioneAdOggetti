package it.progettoOOP.filters;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.springframework.http.converter.HttpMessageNotReadableException;

import it.progettoOOP.exceptions.BadValueException;

public class FiltersModel {
	private JSONObject length;
	private JSONObject shares;
	private JSONObject reactions;

	public FiltersModel() {
		try {
			this.length = null;
		} catch (HttpMessageNotReadableException e) {
			this.length = new JSONObject();
		}
		try {
			this.shares = null;
		} catch (HttpMessageNotReadableException e) {
			this.shares = new JSONObject();
		}
		try {
			this.reactions = null;
		} catch (HttpMessageNotReadableException e) {
			this.reactions = new JSONObject();
		}
	}


	public JSONObject getLength() {
		return length;
	}

	public JSONObject getShares() {
		return shares;
	}

	public JSONObject getReactions() {
		return reactions;
	}

	public int getMinLengthMess() throws BadValueException {
		int minLengthMess = 0;
			if ((int) length.get("min") < 0) throw new BadValueException(); 
				minLengthMess = (int) length.get("min");
			return minLengthMess;
	}
	
	public int getMaxLengthMess() throws BadValueException {
		int maxLengthMess = 10000;
			if ((int) length.get("max") < 0) throw new BadValueException(); 
				maxLengthMess = (int) length.get("max");
			return maxLengthMess;
	}


	/*public int getMaxLengthMess() {
		try {
			int maxLengthMess = (int) length.get("max");
			return maxLengthMess;
		} catch (NullPointerException e) {
			return 100000;
		}
	}*/

	public int getMinShares() {
		try {
			int minShares = (int) shares.get("min");
			return minShares;
		} catch (NullPointerException e) {
			return 0;
		}
	}

	public int getMaxShares() {
		try {
			int maxShares = (int) shares.get("max");
			return maxShares;
		} catch (NullPointerException e) {
			return 100000;
		}
	}

	public int getMinReactions() {
		try {
			int minReactions = (int) reactions.get("min");
			return minReactions;
		} catch (NullPointerException e) {
			return 0;
		}
	}

	public int getMaxReactions() {
		try {
			int maxReactions = (int) reactions.get("max");
			return maxReactions;
		} catch (NullPointerException e) {
			return 100000;
		}
	}

}
