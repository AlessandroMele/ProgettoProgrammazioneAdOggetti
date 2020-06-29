/**
 * @author Mele Alessandro & Verdecchia Matteo
 * Project of OOP Programming exams, A.A. 2019/2020
 *
 */
package it.progettoOOP.stats;

import java.util.ArrayList;

import org.json.JSONException;

import it.progettoOOP.model.ArrayListFacebookPost;
import it.progettoOOP.model.FacebookPost;

public class Statistics {
	private static int averageReactionValue;
	private static int sumReactionValue;
	private static int maxReactionValue;
	private static int minReactionValue;
	private static int maxLengthMessage;

	/**
	 * Basic constructor
	 */
	public Statistics() {
		averageReactionValue = 0;
		sumReactionValue = 0;
		maxReactionValue = 0;
		minReactionValue = 0;
		maxLengthMessage = 0;
	}

	/**
	 * Constructor with fields
	 */
	public Statistics(ArrayList<Integer> likeValues, int averageReactionValue, int sumReactionValue,
			int maxReactionValue, int minReactionValue, int maxLengthMessage) {
		this.averageReactionValue = averageReactionValue;
		this.sumReactionValue = sumReactionValue;
		this.maxReactionValue = maxReactionValue;
		this.minReactionValue = minReactionValue;
		this.maxLengthMessage = maxLengthMessage;
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

	public static Integer SumReactionValue(ArrayListFacebookPost array) {
		FacebookPost fp = new FacebookPost();
		for (int i = 0; i < array.getDimension(); i++) {
			fp=array.getPost(i);
			sumReactionValue = sumReactionValue + fp.getReactions();}
	return sumReactionValue;
	}
	
	public static Integer AverageReactionValue(ArrayListFacebookPost array) {
		averageReactionValue = SumReactionValue(array) / array.getDimension();
	return averageReactionValue;
	}

	public static Integer MaxReactionValue(ArrayListFacebookPost array) {
		FacebookPost fp = new FacebookPost();
		for (int i = 0; i < array.getDimension(); i++) {
			fp = array.getPost(i);
			if (fp.getReactions() > maxReactionValue) {
				maxReactionValue = fp.getReactions();
			}
		}
		return maxReactionValue;
	}

	public static Integer MinReactionValue(ArrayListFacebookPost array) {
		FacebookPost fp = new FacebookPost();
		for (int i = 0; i < array.getDimension(); i++) {
			fp = array.getPost(i);
			if (fp.getReactions() < minReactionValue) {
				minReactionValue = fp.getReactions();
			}
		}
		return minReactionValue;
	}

	public static Integer MaxLengthMessage(ArrayListFacebookPost array) {
		FacebookPost fp = new FacebookPost();
		for (int i = 0; i < array.getDimension(); i++) {
			fp = array.getPost(i);
			if (fp.getLengthMessage() > maxLengthMessage) {
				maxLengthMessage = fp.getLengthMessage();
			}
		}
		return maxLengthMessage;
	}

	public static String StatisticValues(ArrayListFacebookPost array) {
		return "\nAverage reactions value:"+AverageReactionValue(array) +", Sum reactions value:"+SumReactionValue(array) +
				", Max reactions value:"+MaxReactionValue(array) +
				", Min reactions value:"+ MinReactionValue(array) +", Max length message value:"+ MaxLengthMessage(array);
	}

}
