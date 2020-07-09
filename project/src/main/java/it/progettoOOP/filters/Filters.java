/**
 * @author Mele Alessandro & Verdecchia Matteo
 * OOP project exam, A.A. 2019/2020
 *
 */

package it.progettoOOP.filters;

import org.json.simple.JSONObject;

import it.progettoOOP.exceptions.BadRangeValueException;
import it.progettoOOP.exceptions.BadValueException;

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

	/**
     * This method tries to take value "max" from JSONObject length
     * If it fails, it set by default value 10000
     * @return the maximum length message
     * @throws BadValueException
     * @throws BadRangeValueException
     * @throws ClassCastException
     */
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
	
	/**
     * This method tries to take value "min" from JSONObject length
     * If it fails, it set by default value 0
     * @return the minimum length message
     * @throws BadValueException
     * @throws BadRangeValueException
     * @throws ClassCastException
     */
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
	
	/**
     * This method tries to take value "max" from JSONObject shares
     * If it fails, it set by default value 10000
     * @return the maximum number of shares
     * @throws BadValueException
     * @throws BadRangeValueException
     * @throws ClassCastException
     */
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
	
	/**
     * This method tries to take value "min" from JSONObject shares
     * If it fails, it set by default value 0
     * @return the minimum number of shares
     * @throws BadValueException
     * @throws BadRangeValueException
     * @throws ClassCastException
     */
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
	
	/**
     * This method tries to take value "max" from JSONObject reactions
     * If it fails, it set by default value 10000
     * @return the maximum number of reactions
     * @throws BadValueException
     * @throws BadRangeValueException
     * @throws ClassCastException
     */
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
	
	/**
     * This method tries to take value "min" from JSONObject reactions
     * If it fails, it set by default value 0
     * @return the minimum number of reactions
     * @throws BadValueException
     * @throws BadRangeValueException
     * @throws ClassCastException
     */
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
