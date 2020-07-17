/**
 * @author Mele Alessandro & Verdecchia Matteo
 * OOP project exam, A.A. 2019/2020
 *
 */
package it.progettoOOP.stats;

import java.util.ArrayList;
import it.progettoOOP.model.FacebookPost;

/**
 * Contains attributes and methods for doing Statistics and parsing
 * ArrayList<FacebookPost> into ArrayList<Integer> or ArrayList<String>,
 */
public class Statistics {
	/**
	 * Minimum length message
	 */
	private int minLengthMessage;
	/**
	 * Maximum length message
	 */
	private int maxLengthMessage;
	/**
	 * StatisticsModel object that contains details about shares
	 */
	private StatisticsModel shares;
	/**
	 * StatisticsModel object that contains details about reactions
	 */
	private StatisticsModel reactions;

	/**
	 * Basic constructor
	 */
	public Statistics() {
		minLengthMessage = 0;
		maxLengthMessage = 0;
		shares = new StatisticsModel();
		reactions = new StatisticsModel();
	}

	/**
	 * Constructor using fields
	 * 
	 * @param arrayfil  the filtered array
	 * @param arrayfull the complete array
	 */
	public Statistics(ArrayList<FacebookPost> arrayfil, ArrayList<FacebookPost> arrayfull) {
		minLengthMessage = MinValueLength(ParseToMessages(arrayfil));
		maxLengthMessage = MaxValueLength(ParseToMessages(arrayfil));
		shares = new StatisticsModel(ParseToShares(arrayfil), ParseToShares(arrayfull));
		reactions = new StatisticsModel(ParseToReactions(arrayfil), ParseToReactions(arrayfull));
	}

	/**
	 * Constructor using fields, necessary only for minimum/maximum length message
	 * 
	 * @param arrayfil the filtered array
	 */
	public Statistics(ArrayList<FacebookPost> array) {
		minLengthMessage = MinValueLength(ParseToMessages(array));
		maxLengthMessage = MaxValueLength(ParseToMessages(array));
		shares = new StatisticsModel();
		reactions = new StatisticsModel();
	}

	/**
	 * @return the shares
	 */
	public StatisticsModel getShares() {
		return shares;
	}

	/**
	 * @return the minLengthMessage
	 */
	public int getMinLengthMessage() {
		return minLengthMessage;
	}

	/**
	 * @param minLengthMessage the minLengthMessage to set
	 */
	public void setMinLengthMessage(int minLengthMessage) {
		this.minLengthMessage = minLengthMessage;
	}

	/**
	 * @return the maxLengthMessage
	 */
	public int getMaxLengthMessage() {
		return maxLengthMessage;
	}

	/**
	 * @param maxLengthMessage the maxLengthMessage to set
	 */
	public void setMaxLengthMessage(int maxLengthMessage) {
		this.maxLengthMessage = maxLengthMessage;
	}

	/**
	 * @param shares the shares to set
	 */
	public void setShares(StatisticsModel shares) {
		this.shares = shares;
	}

	/**
	 * @return the reactions
	 */
	public StatisticsModel getReactions() {
		return reactions;
	}

	/**
	 * @param reactions the reactions to set
	 */
	public void setReactions(StatisticsModel reactions) {
		this.reactions = reactions;
	}

	/**
	 * It searches the max value length message in ArrayList<String> messages
	 * 
	 * @param array the ArrayList<String> for extract maximum length message
	 * @return the maximum length message contained in ArrayList<String> messages
	 */
	public int MaxValueLength(ArrayList<String> array) {
		if (!array.isEmpty()) {
			maxLengthMessage = array.get(0).length();
			for (int i = 1; i < array.size(); i++)
				if (array.get(i).length() > maxLengthMessage)
					maxLengthMessage = array.get(i).length();
			return maxLengthMessage;
		}
		return 0;
	}

	/**
	 * It searches the minimum value length message in ArrayList<String> messages
	 * 
	 * @param array the ArrayList<String> for extract minimum length message
	 * @return the minimum length message contained in ArrayList<String> messages
	 */
	public int MinValueLength(ArrayList<String> array) {
		if (!array.isEmpty()) {
			minLengthMessage = array.get(0).length();
			for (int i = 1; i < array.size(); i++)
				if (array.get(i).length() < minLengthMessage)
					minLengthMessage = array.get(i).length();
			return minLengthMessage;
		}
		return 0;
	}

	/**
	 * It creates an ArrayList<Integer> that contains reactions value
	 * 
	 * @param array the ArrayList<FacebookPost> for extract reactions field
	 * @return ArrayList<Integer> that contains reactions values
	 */
	public static ArrayList<Integer> ParseToReactions(ArrayList<FacebookPost> array) {
		ArrayList<Integer> reactions = new ArrayList<Integer>();
		for (int i = 0; i < array.size(); i++)
			reactions.add(array.get(i).getNumReactions());
		return reactions;
	}

	/**
	 * It creates an ArrayList<String> that contains messages
	 * 
	 * @param array the ArrayList<FacebookPost> for extract messages field
	 * @return ArrayList<String> that contains messages
	 */
	public static ArrayList<String> ParseToMessages(ArrayList<FacebookPost> array) {
		ArrayList<String> reactions = new ArrayList<String>();
		for (int i = 0; i < array.size(); i++)
			if (array.get(i).getMessage().equals("no message"))
				reactions.add("");
			else
				reactions.add(array.get(i).getMessage());

		return reactions;
	}

	/**
	 * It creates an ArrayList<Integer> that contains share values
	 * 
	 * @param array the ArrayList<FacebookPost> for extract shares field
	 * @return ArrayList<Integer> that contains shares values
	 */

	public static ArrayList<Integer> ParseToShares(ArrayList<FacebookPost> array) {
		ArrayList<Integer> shares = new ArrayList<Integer>();
		for (int i = 0; i < array.size(); i++)
			shares.add(array.get(i).getNumShares());
		return shares;
	}

}
