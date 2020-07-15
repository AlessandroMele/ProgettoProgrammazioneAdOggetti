/**
 * @author Mele Alessandro & Verdecchia Matteo
 * OOP project exam, A.A. 2019/2020
 *
 */

package it.progettoOOP.filters;

import java.util.ArrayList;
import org.json.simple.JSONObject;
import it.progettoOOP.exceptions.*;
import it.progettoOOP.model.FacebookPost;
import it.progettoOOP.stats.Statistics;
/**
 * Contains attributes and methods for Filters object
 * It's used for parsing details from Body POST request
 */
public class Filters {
	/**
	 * JSONObject that contains length values
	 */
	private JSONObject length;
	/**
	 * Minimum length value
	 */
	private int minLength;
	/**
	 * Maximum length value
	 */
	private int maxLength;
	/**
	 * JSONObject that contains shares values
	 */
	private JSONObject shares;
	/**
	 * Minimum share value
	 */
	private int minShares;
	/**
	 * Maximum share value
	 */
	private int maxShares;
	/**
	 * JSONObject that contains reactions values
	 */
	private JSONObject reactions;
	/**
	 * Minimum reactions value
	 */
	private int minReactions;
	/**
	 * Maximum reactions value
	 */
	private int maxReactions;

	/*
	 * Basic constructor
	 */
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

	/**
	 * @return the length
	 */
	public JSONObject getLength() {
		return length;
	}

	/**
	 * @return the shares
	 */
	public JSONObject getShares() {
		return shares;
	}

	/**
	 * @return the reactions
	 */
	public JSONObject getReactions() {
		return reactions;
	}

	/*
	 * Constructor for test
	 */
	public Filters(JSONObject length) {
		this.length = length;
		shares = new JSONObject();
		reactions = new JSONObject();
		minLength = 0;
		maxLength = 0;
		minShares = 0;
		maxShares = 0;
		minReactions = 0;
		maxReactions = 0;
	}

	/**
	 * It set values of Filters using Statistics' methods
	 * 
	 * @param ArrayList<FacebookPost> array the array for doing stats
	 */
	public void SetStatsValues(ArrayList<FacebookPost> array) {
		Statistics stats = new Statistics();
		minLength = stats.MinLengthMessage(array);
		maxLength = stats.MaxLengthMessage(array);
		minShares = stats.MinShareValue(array);
		maxShares = stats.MaxShareValue(array);
		minReactions = stats.MinReactionValue(array);
		maxReactions = stats.MaxReactionValue(array);
	}

	/**
	 * It tries to take value "min" from JSONObject length. If it fails, it will be
	 * set by default value to min length message contained on a post in array
	 * 
	 * @return the minimum length message
	 * @throws BadValueException
	 * @throws BadRangeValueException
	 */
	public int MinLength() throws BadValueException, BadRangeValueException {
		try {
			minLength = (int) length.get("min");
		} catch (NullPointerException e) {
			// else by defaul it's setted to min length message
		}
		if (minLength < 0)
			throw new BadValueException();
		if (maxLength < minLength)
			throw new BadRangeValueException();
		return minLength;

	}

	/**
	 * It tries to take value "max" from JSONObject length. If it fails, it will be
	 * set by default value to max length message contained on a post in array
	 * 
	 * @return the maximum length message
	 * @throws BadValueException
	 * @throws BadRangeValueException
	 */

	public int MaxLength() throws BadValueException, BadRangeValueException {
		try {
			maxLength = (int) length.get("max");
		} catch (NullPointerException e) {
			// else by default it's setted to max length message
		}
		if (maxLength < 0)
			throw new BadValueException();
		if (maxLength < minLength)
			throw new BadRangeValueException();
		return maxLength;
	}

	/**
	 * It tries to take value "min" from JSONObject shares. If it fails, it set by
	 * default value to min share value contained on a post in array
	 * 
	 * @return the minimum number of shares
	 * @throws BadValueException
	 * @throws BadRangeValueException
	 */
	public int MinShares() throws BadValueException, BadRangeValueException {
		try {
			minShares = (int) shares.get("min");
		} catch (NullPointerException e) {
			// else by default it's setted to min share value
		}
		if (minShares < 0)
			throw new BadValueException();
		if (maxShares < minShares)
			throw new BadRangeValueException();
		return minShares;
	}

	/**
	 * It tries to take value "max" from JSONObject shares If it fails, it set by
	 * default value to max share value contained on a post in array
	 * 
	 * @return the maximum number of shares
	 * @throws BadValueException
	 * @throws BadRangeValueException
	 */
	public int MaxShares() throws BadValueException, BadRangeValueException {
		try {
			maxShares = (int) shares.get("max");
		} catch (NullPointerException e) {
			// else by default it's setted to max share value
		}
		if (maxShares < 0)
			throw new BadValueException();
		if (maxShares < minShares)
			throw new BadRangeValueException();
		return maxShares;
	}

	/**
	 * It tries to take value "min" from JSONObject reactions. If it fails, set by
	 * default value to min reaction value contained on a post in array
	 * 
	 * @return the minimum number of reactions
	 * @throws BadValueException
	 * @throws BadRangeValueException
	 */
	public int MinReactions() throws BadValueException, BadRangeValueException {
		try {
			minReactions = (int) reactions.get("min");
		} catch (NullPointerException e) {
			// else by default it's setted to min reaction value
		}
		if (minReactions < 0)
			throw new BadValueException();
		if (maxReactions < minReactions)
			throw new BadRangeValueException();
		return minReactions;
	}

	/**
	 * It tries to take value "max" from JSONObject reactions. If it fails, set by
	 * default value to max reaction value contained on a post in array
	 * 
	 * @return the maximum number of reactions
	 * @throws BadValueException
	 * @throws BadRangeValueException
	 */
	public int MaxReactions() throws BadValueException, BadRangeValueException {
		try {
			maxReactions = (int) reactions.get("max");
			if (maxReactions < minReactions)
				throw new BadRangeValueException();
		} catch (NullPointerException e) {
			// else by default it's setted to max reaction value
		}
		if (maxReactions < 0)
			throw new BadValueException();
		if (maxReactions < minReactions)
			throw new BadRangeValueException();
		return maxReactions;
	}

}