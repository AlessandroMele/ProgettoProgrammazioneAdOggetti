package it.progettoOOP.filters;

import org.json.simple.JSONObject;
import org.springframework.http.converter.HttpMessageNotReadableException;

import it.progettoOOP.exceptions.BadValueException;

public class Filters {
	private JSONObject length;
	private JSONObject shares;
	private JSONObject reactions;

	public Filters() {
		try {
			length = null;
		} catch (HttpMessageNotReadableException e) {
			length = new JSONObject();
		}
		try {
			shares = null;
		} catch (HttpMessageNotReadableException e) {
			shares = new JSONObject();
		}
		try {
			reactions = null;
		} catch (HttpMessageNotReadableException e) {
			reactions = new JSONObject();
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

	public int getMaxLengthMess() throws BadValueException {
		int maxLengthMess = 10000;
		if ((int) length.get("max") < 0)
			throw new BadValueException();
		maxLengthMess = (int) length.get("max");
		return maxLengthMess;
	}

	public int getMinLengthMess() throws BadValueException {
		int minLengthMess = 0;
		if ((int) length.get("min") < 0)
			throw new BadValueException();
		minLengthMess = (int) length.get("min");
		return minLengthMess;
	}

	public int getMaxShares() throws BadValueException {
		int maxShares = 10000;
		if ((int) shares.get("max") < 0)
			throw new BadValueException();
		maxShares = (int) length.get("max");
		return maxShares;
	}

	public int getMinShares() throws BadValueException {
		int minShares = 0;
		if ((int) shares.get("min") < 0)
			throw new BadValueException();
		minShares = (int) length.get("min");
		return minShares;
	}

	public int getMaxReactions() throws BadValueException {
		int maxReactions = 10000;
		if ((int) reactions.get("max") < 0)
			throw new BadValueException();
		maxReactions = (int) length.get("max");
		return maxReactions;
	}

	public int getMinReactions() throws BadValueException {
		int minReactions = 0;
		if ((int) reactions.get("min") < 0)
			throw new BadValueException();
		minReactions = (int) reactions.get("min");
		return minReactions;
	}

}
