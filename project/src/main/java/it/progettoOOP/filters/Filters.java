/**
 * @author Mele Alessandro & Verdecchia Matteo
 * OOP project exam, A.A. 2019/2020
 *
 */

package it.progettoOOP.filters;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import it.progettoOOP.exceptions.*;
import it.progettoOOP.model.*;
import it.progettoOOP.stats.*;

/**
 * Contains attributes and methods for Filters object It's used for parsing
 * details from Body POST request
 */
public class Filters {
	/**
	 * JSONObject object that contains length values
	 */
	private JSONObject length;
	/**
	 * JSONObject object that contains shares values
	 */
	private JSONObject shares;
	/**
	 * JSONObject object that contains reactions values
	 */
	private JSONObject reactions;
	/**
	 * FiltersModel object that contains maximum and minimum for length message
	 */
	private FiltersModel lengthValues;
	/**
	 * FiltersModel object that contains maximum and minimum maximum and minimum for
	 * shares
	 */
	private FiltersModel sharesValues;
	/**
	 * FiltersModel object that contains maximum and minimum maximum and minimum for
	 * reactions
	 */
	private FiltersModel reactionsValues;

	/**
	 * Basic constructor
	 */
	public Filters() {

		length = new JSONObject();
		shares = new JSONObject();
		reactions = new JSONObject();
		lengthValues = new FiltersModel();
		sharesValues = new FiltersModel();
		reactionsValues = new FiltersModel();
	}

	/**
	 * It set filter attributes according to array's Statistics or body imports.
	 * 
	 * @param array the ArrayList<FacebookPost> for doing Statistics
	 * @return filter with maximum/minimum Statistics values
	 * @throws BadValueException
	 * @throws BadRangeValueException
	 */
	public void ReadValues(ArrayList<FacebookPost> array) throws BadValueException, BadRangeValueException {
		lengthValues.setMin(MinLength(array));
		lengthValues.setMax(MaxLength(array));
		sharesValues.setMin(MinShares(array));
		sharesValues.setMax(MaxShares(array));
		reactionsValues.setMin(MinReactions(array));
		reactionsValues.setMax(MaxReactions(array));

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

	/**
	 * @return the lengthValues
	 */
	public FiltersModel getLengthValues() {
		return lengthValues;
	}

	/**
	 * @return the sharesValues
	 */
	public FiltersModel getSharesValues() {
		return sharesValues;
	}

	/**
	 * @return the reactionsValues
	 */
	public FiltersModel getReactionsValues() {
		return reactionsValues;
	}

	/**
	 * Constructor for JUnit test
	 */
	public Filters(JSONObject length) throws BadValueException, BadRangeValueException {
		this.length = length;
		shares = new JSONObject();
		reactions = new JSONObject();
		lengthValues = new FiltersModel();
		sharesValues = new FiltersModel();
		reactionsValues = new FiltersModel();
	}

	/**
	 * It tries to take value "min" from JSONObject length. If it fails, it will be
	 * set by default value to minimum length message contained among all posts of
	 * the array
	 * 
	 * @param array the ArrayList<FacebookPost> for doing statistics
	 * @return the minimum length message
	 * @throws BadValueException
	 */
	public int MinLength(ArrayList<FacebookPost> array) throws BadValueException {
		Statistics stats = new Statistics();
		int min = stats.MinValueLength(Statistics.ParseToMessages(array));
		try {
			min = (int) length.get("min");
		} catch (NullPointerException e) {
			// else by default it's set to minimum length message
		}
		if (min < 0)
			throw new BadValueException();
		return min;
	}

	/**
	 * It tries to take value "max" from JSONObject length. If it fails, it will be
	 * set by default value to maximum length message contained among all posts of
	 * the array
	 * 
	 * @param array the ArrayList<FacebookPost> for doing statistics
	 * @return the maximum length message
	 * @throws BadValueException
	 * @throws BadRangeValueException
	 */
	public int MaxLength(ArrayList<FacebookPost> array) throws BadValueException, BadRangeValueException {
		Statistics stats = new Statistics();
		int max = stats.MaxValueLength(Statistics.ParseToMessages(array));
		try {
			max = (int) length.get("max");
		} catch (NullPointerException e) {
			// else by default it's set to max length message
		}
		if (max < 0)
			throw new BadValueException();
		if (max < lengthValues.getMin())
			throw new BadRangeValueException();
		return max;
	}

	/**
	 * It tries to take value "min" from JSONObject reactions. If it fails, it will
	 * be set by default value to minimum reactions value contained among all posts
	 * of the array
	 * 
	 * @param array the ArrayList<FacebookPost> for doing statistics
	 * @return the minimum reactions value
	 * @throws BadValueException
	 */
	public int MinReactions(ArrayList<FacebookPost> array) throws BadValueException {
		StatisticsModel modelStats = new StatisticsModel();
		int min = modelStats.MinValue(Statistics.ParseToReactions(array));
		try {
			min = (int) reactions.get("min");
		} catch (NullPointerException e) {
			// else by default it's set to minimum reaction message
		}
		if (min < 0)
			throw new BadValueException();
		return min;
	}

	/**
	 * It tries to take value "max" from JSONObject reactions. If it fails, it will
	 * be set by default value to max reactions value contained among all posts of
	 * the array
	 * 
	 * @param array the ArrayList<FacebookPost> for doing statistics
	 * @return the maximum reactions value
	 * @throws BadValueException
	 * @throws BadRangeValueException
	 * @throws BadRangeValueException
	 */
	public int MaxReactions(ArrayList<FacebookPost> array) throws BadValueException, BadRangeValueException {
		StatisticsModel modelStats = new StatisticsModel();
		int max = modelStats.MaxValue(Statistics.ParseToReactions(array));
		try {
			max = (int) reactions.get("max");
		} catch (NullPointerException e) {
			// else by default it's set to max length message
		}
		if (max < 0)
			throw new BadValueException();
		if (max < reactionsValues.getMin())
			throw new BadRangeValueException();
		return max;
	}

	/**
	 * It tries to take value "min" from JSONObject shares. If it fails, it will be
	 * set by default value to minimum shares value contained among all posts of the
	 * array
	 * 
	 * @param array the ArrayList<FacebookPost> for doing statistics
	 * @return the minimum shares value
	 * @throws BadValueException
	 */
	public int MinShares(ArrayList<FacebookPost> array) throws BadValueException {
		StatisticsModel modelStats = new StatisticsModel();
		int min = modelStats.MinValue(Statistics.ParseToShares(array));
		try {
			min = (int) shares.get("min");
		} catch (NullPointerException e) {
			// else by default it's set to minimum reaction message
		}
		if (min < 0)
			throw new BadValueException();
		return min;
	}

	/**
	 * It tries to take value "max" from JSONObject shares. If it fails, it will be
	 * set by default value to maximum shares value contained contained among all posts
	 * of the array
	 * 
	 * @param array the ArrayList<FacebookPost> for doing statistics
	 * @return the maximum share value
	 * @throws BadValueException
	 * @throws BadRangeValueException
	 */
	public int MaxShares(ArrayList<FacebookPost> array) throws BadValueException, BadRangeValueException {
		StatisticsModel modelStats = new StatisticsModel();
		int max = modelStats.MaxValue(Statistics.ParseToShares(array));
		try {
			max = (int) shares.get("max");
		} catch (NullPointerException e) {
			// else by default it's set to maximum length message
		}
		if (max < 0)
			throw new BadValueException();
		if (max < sharesValues.getMin())
			throw new BadRangeValueException();
		return max;
	}

}
