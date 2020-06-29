/**
 * @author Mele Alessandro & Verdecchia Matteo
 * Project of OOP Programming exams, A.A. 2019/2020
 *
 */
package it.progettoOOP.stats;

import it.progettoOOP.model.ArrayListFacebookPost;

public class Statistics {
	/**
	 * Average value of reactions contained in ArrayListFacebookPost
	 */
	private static int averageReactionValue;
	/**
	 * Sum value of reactions contained in ArrayListFacebookPost
	 */
	private static int sumReactionValue;
	/**
	 * Greatest value of reactions contained in ArrayListFacebookPost
	 */
	private static int maxReactionValue;
	/**
	 * Smallest value of reactions contained in ArrayListFacebookPost
	 */
	private static int minReactionValue;
	/**
	 * Greatest value of characters contained on a message in ArrayListFacebookPost
	 */
	private static int maxLengthMessage;
	
	/**
	 * Greatest value of reactions contained in ArrayListFacebookPost
	 */
	private static int maxShareValue;
	/**
	 * Smallest value of reactions contained in ArrayListFacebookPost
	 */
	private static int minShareValue;

	/*
	 * Basic constructor
	 */
	public Statistics() {
		sumReactionValue = 0;
		averageReactionValue = 0;
		maxReactionValue = 0;
		minReactionValue = 0;
		maxLengthMessage = 0;
		maxShareValue = 0;
		minShareValue = 0;
	}

	/**
	 * @return the averageReactionValue
	 */
	public static int getAverageReactionValue() {
		return averageReactionValue;
	}

	/**
	 * @param averageReactionValue the averageReactionValue to set
	 */
	public static void setAverageReactionValue(int averageReactionValue) {
		Statistics.averageReactionValue = averageReactionValue;
	}

	/**
	 * @return the sumReactionValue
	 */
	public static int getSumReactionValue() {
		return sumReactionValue;
	}

	/**
	 * @param sumReactionValue the sumReactionValue to set
	 */
	public static void setSumReactionValue(int sumReactionValue) {
		Statistics.sumReactionValue = sumReactionValue;
	}

	/**
	 * @return the maxReactionValue
	 */
	public static int getMaxReactionValue() {
		return maxReactionValue;
	}

	/**
	 * @param maxReactionValue the maxReactionValue to set
	 */
	public static void setMaxReactionValue(int maxReactionValue) {
		Statistics.maxReactionValue = maxReactionValue;
	}

	/**
	 * @return the minReactionValue
	 */
	public static int getMinReactionValue() {
		return minReactionValue;
	}

	/**
	 * @param minReactionValue the minReactionValue to set
	 */
	public static void setMinReactionValue(int minReactionValue) {
		Statistics.minReactionValue = minReactionValue;
	}
	
	
	/**
	 * @return the maxShareValue
	 */
	public static int getMaxShareValue() {
		return maxShareValue;
	}

	/**
	 * @param maxShareValue the maxShareValue to set
	 */
	public static void setMaxShareValue(int maxShareValue) {
		Statistics.maxShareValue = maxShareValue;
	}

	/**
	 * @return the minShareValue
	 */
	public static int getMinShareValue() {
		return minShareValue;
	}

	/**
	 * @param minShareValue the minShareValue to set
	 */
	public static void setMinShareValue(int minShareValue) {
		Statistics.minShareValue = minShareValue;
	}

	/**
	 * @return the maxLengthMessage
	 */
	public static int getMaxLengthMessage() {
		return maxLengthMessage;
	}

	/**
	 * @param maxLengthMessage the maxLengthMessage to set
	 */
	public static void setMaxLengthMessage(int maxLengthMessage) {
		Statistics.maxLengthMessage = maxLengthMessage;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the sum value of reactions contained in ArrayListFacebookPost
	 */
	public static Integer SumReactionsValue(ArrayListFacebookPost array) {
		sumReactionValue = 0;
		for (int i = 0; i < array.getSize(); i++)
			sumReactionValue = sumReactionValue + array.getPost(i).getReactions();
		return sumReactionValue;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the average value of reactions contained in ArrayListFacebookPost
	 */
	public static Integer AverageReactionsValue(ArrayListFacebookPost array) {
		averageReactionValue = 0;
		try {
			averageReactionValue = SumReactionsValue(array) / array.getSize();
		} catch (ArithmeticException e) {// e.printStackTrace();
		}
		return averageReactionValue;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the greatest value of reactions contained in ArrayListFacebookPost
	 */
	public static Integer MaxReactionValue(ArrayListFacebookPost array) {
		maxReactionValue = 0;
		for (int i = 0; i < array.getSize(); i++)
			if (array.getPost(i).getReactions() > maxReactionValue)
				maxReactionValue = array.getPost(i).getReactions();
		return maxReactionValue;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the smallest value of reactions contained in ArrayListFacebookPost
	 */
	public static Integer MinReactionValue(ArrayListFacebookPost array) {
		minReactionValue = 0;
		for (int i = 0; i < array.getSize(); i++)
			if (array.getPost(i).getReactions() < minReactionValue)
				minReactionValue = array.getPost(i).getReactions();
		return minReactionValue;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the greatest value of characters contained on a message in
	 *         ArrayListFacebookPost
	 */
	public static Integer MaxLengthMessage(ArrayListFacebookPost array) {
		maxLengthMessage = 0;
		for (int i = 0; i < array.getSize(); i++)
			if (array.getPost(i).getLengthMessage() > maxLengthMessage)
				maxLengthMessage = array.getPost(i).getLengthMessage();
		return maxLengthMessage;
	}
	
	/**
	 * @param ArrayListFacebookPost
	 * @return the greatest value of shares contained in ArrayListFacebookPost
	 */
	public static Integer MaxShareValue(ArrayListFacebookPost array) {
		maxShareValue = 0;
		for (int i = 0; i < array.getSize(); i++)
			if (array.getPost(i).getShares() > maxShareValue)
				maxShareValue = array.getPost(i).getShares();
		return maxShareValue;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the smallest value of shares contained in ArrayListFacebookPost
	 */
	public static Integer MinShareValue(ArrayListFacebookPost array) {
		minShareValue = 0;
		for (int i = 0; i < array.getSize(); i++)
			if (array.getPost(i).getShares() < minShareValue)
				minShareValue = array.getPost(i).getShares();
		return minShareValue;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return string that contains report's summary
	 */
	public static String StatisticsReports(ArrayListFacebookPost array) {
		if (!array.isEmpty())
			return "Average reactions value=" + AverageReactionsValue(array) + ", Sum reactions value="
					+ SumReactionsValue(array) + ", Greatest reactions value=" + MaxReactionValue(array)
					+ ", Smallest reactions value=" + MinReactionValue(array) + ", Greatest messages character's value="
					+ MaxLengthMessage(array) + ", Greatest shares value=" + MaxShareValue(array)
					+ ", Smallest share value=" + MinShareValue(array)+"\n";
		return "No Statistic's report\n";
	}

}
