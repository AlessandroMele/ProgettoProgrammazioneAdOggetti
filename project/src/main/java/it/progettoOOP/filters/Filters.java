package it.progettoOOP.filters;

import org.json.simple.JSONObject;

import it.progettoOOP.exceptions.BadRangeValueException;
import it.progettoOOP.exceptions.BadValueException;
import it.progettoOOP.stats.Statistics;

public class Filters {
	private JSONObject length;
	private JSONObject shares;
	private JSONObject reactions;
	private int minLength;
	private int maxLength;
	private int minShares;
	private int maxShares;
	private int minReactions;
	private int maxReactions;

	public Filters() {
		length = new JSONObject();
		shares = new JSONObject();
		reactions = new JSONObject();
		minLength = 0;
		maxLength = 0;
		minShares = 0;
		maxShares = 0;
		minReactions = 0;
		maxReactions = 0;
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

	public int MaxLength() throws BadValueException, BadRangeValueException, ClassCastException {
		try {
			maxLength = (int) length.get("max");
			if (maxLength < minLength)
				throw new BadRangeValueException();
		} catch (NullPointerException e) {
			maxLength = 10000;
		}
		if (maxLength < 0)
			throw new BadValueException();
		return maxLength;
	}

	public int MinLength() throws BadValueException, ClassCastException {
		try {
			minLength = (int) length.get("min");
		} catch (NullPointerException e) {
			minLength = 0;
		}
		if (minLength < 0)
			throw new BadValueException();
		return minLength;
	}

	public int MaxShares() throws BadValueException, BadRangeValueException,ClassCastException {
		try {
			maxShares = (int) shares.get("max");
			if (maxShares < minShares)
				throw new BadRangeValueException();
		} catch (NullPointerException e) {
			maxShares = 10000;
		}
		if (maxShares < 0)
			throw new BadValueException();
		return maxShares;
	}

	public int MinShares() throws BadValueException,ClassCastException {
		try {
			minShares = (int) shares.get("min");
		} catch (NullPointerException e) {
			minShares = 0;
		}
		if (minShares < 0)
			throw new BadValueException();
		return minShares;
	}

	public int MaxReactions() throws BadValueException, BadRangeValueException,ClassCastException {
		try {
			maxReactions = (int) reactions.get("max");
			if (maxReactions < minReactions)
				throw new BadRangeValueException();
		} catch (NullPointerException e) {
			maxReactions = 10000;
		}
		if (maxReactions < 0)
			throw new BadValueException();
		return maxReactions;
	}

	public int MinReactions() throws BadValueException,ClassCastException {
		try {
			minReactions = (int) reactions.get("min");
		} catch (NullPointerException e) {
			minReactions = 0;
		}
		if (minReactions < 0)
			throw new BadValueException();
		return minReactions;
	}
}
