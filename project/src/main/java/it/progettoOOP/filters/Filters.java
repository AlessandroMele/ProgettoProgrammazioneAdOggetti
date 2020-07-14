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
	/**
	 * Stats for max/min values if params will not be inserted in body
	 */
	private Statistics stats;

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
		stats = new Statistics();
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
		stats = new Statistics();
	}

	/**
	 * It tries to take value "min" from JSONObject length. If it fails, it will be
	 * set by default value to min length message contained on a post in array
	 * 
	 * @return the minimum length message
	 * @throws BadValueException
	 * @throws BadRangeValueException
	 * @throws ClassCastException
	 */
	public int MinLength(ArrayList<FacebookPost> array) throws BadValueException {
		try {
			minLength = (int) length.get("min");
		} catch (NullPointerException e) {
			// else by defaul it's setted to min length message
			minLength = stats.MinLengthMessage(array);
		}
		if (minLength < 0)
			throw new BadValueException();
		return minLength;
	}

	/**
	 * It tries to take value "max" from JSONObject length. If it fails, it will be
	 * set by default value to max length message contained on a post in array
	 * 
	 * @return the maximum length message
	 * @throws BadValueException
	 * @throws BadRangeValueException
	 * @throws ClassCastException
	 */

	public int MaxLength(ArrayList<FacebookPost> array) throws BadValueException, BadRangeValueException {
		try {
			maxLength = (int) length.get("max");
			if (maxLength < minLength)
				throw new BadRangeValueException();
		} catch (NullPointerException e) {
			// else by defaul it's setted to max length message
			maxLength = stats.MaxLengthMessage(array);
		}
		if (maxLength < 0)
			throw new BadValueException();
		return maxLength;
	}

	/**
	 * This method tries to take value "min" from JSONObject shares. If it fails, it
	 * set by default value to min share value contained on a post in array
	 * 
	 * @return the minimum number of shares
	 * @throws BadValueException
	 * @throws BadRangeValueException
	 * @throws ClassCastException
	 */
	public int MinShares(ArrayList<FacebookPost> array) throws BadValueException {
		try {
			minShares = (int) shares.get("min");
		} catch (NullPointerException e) {
			// else by defaul it's setted to min share value
			minShares = stats.MinShareValue(array);
		}
		if (minShares < 0)
			throw new BadValueException();
		return minShares;
	}

	/**
	 * This method tries to take value "max" from JSONObject shares If it fails, it
	 * set by default value to max share value contained on a post in array
	 * 
	 * @return the maximum number of shares
	 * @throws BadValueException
	 * @throws BadRangeValueException
	 * @throws ClassCastException
	 */
	public int MaxShares(ArrayList<FacebookPost> array) throws BadValueException, BadRangeValueException {
		try {
			maxShares = (int) shares.get("max");
			if (maxShares < minShares)
				throw new BadRangeValueException();
		} catch (NullPointerException e) {
			// else by defaul it's setted to max share value
			// maxShares = stats.MaxShareValue(array);
		}
		if (maxShares < 0)
			throw new BadValueException();
		return maxShares;
	}

	/**
	 * This method tries to take value "min" from JSONObject reactions. If it fails,
	 * set by default value to min reaction value contained on a post in array
	 * 
	 * @return the minimum number of reactions
	 * @throws BadValueException
	 * @throws BadRangeValueException
	 * @throws ClassCastException
	 */
	public int MinReactions(ArrayList<FacebookPost> array) throws BadValueException {
		try {
			minReactions = (int) reactions.get("min");
		} catch (NullPointerException e) {
			// else by defaul it's setted to min reaction value
			minReactions = stats.MinReactionValue(array);
		}
		if (minReactions < 0)
			throw new BadValueException();
		return minReactions;
	}

	/**
	 * This method tries to take value "max" from JSONObject reactions. If it fails,
	 * set by default value to max reaction value contained on a post in array
	 * 
	 * @return the maximum number of reactions
	 * @throws BadValueException
	 * @throws BadRangeValueException
	 * @throws ClassCastException
	 */
	public int MaxReactions(ArrayList<FacebookPost> array) throws BadValueException, BadRangeValueException {
		try {
			maxReactions = (int) reactions.get("max");
			if (maxReactions < minReactions)
				throw new BadRangeValueException();
		} catch (Exception e) {
			// else by defaul it's setted to max reaction value
			// maxReactions = stats.MaxReactionValue(array);
		}
		if (maxReactions < 0)
			throw new BadValueException();
		return maxReactions;
	}

}