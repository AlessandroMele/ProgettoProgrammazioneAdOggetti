/**
 * @author Mele Alessandro & Verdecchia Matteo
 * Project of OOP Programming exams, A.A. 2019/2020
 *
 */
package it.progettoOOP.stats;

import org.json.JSONObject;

import it.progettoOOP.model.ArrayListFacebookPost;

public class Statistics implements StatisticsMethods {
	/**
	 * Average value of reactions contained in ArrayListFacebookPost
	 */
	private int averageReactionValue;
	/**
	 * Sum value of reactions contained in ArrayListFacebookPost
	 */
	private int sumReactionValue;
	/**
	 * Greatest value of reactions contained in ArrayListFacebookPost
	 */
	private int maxReactionValue;
	/**
	 * Smallest value of reactions contained in ArrayListFacebookPost
	 */
	private int minReactionValue;
	/**
	 * Greatest value of characters contained on a message in ArrayListFacebookPost
	 */
	private int maxLengthMessage;

	/**
	 * Greatest value of reactions contained in ArrayListFacebookPost
	 */
	private int maxShareValue;
	/**
	 * Smallest value of reactions contained in ArrayListFacebookPost
	 */
	private int minShareValue;
	/**
	 * Average value of reactions contained in ArrayListFacebookPost
	 */
	private int averageShareValue;
	/**
	 * Sum value of reactions contained in ArrayListFacebookPost
	 */
	private int sumShareValue;

	/**
	 * Perch of posts contained in first ArrayListFacebookPost in relation to the second ArrayListFacebookPost
	 */
	private int percPosts;
	
	/**
	 * Perch of reactions contained in first ArrayListFacebookPost in relation to the second ArrayListFacebookPost
	 */
	private int percReactions;
	/**
	 * JSON that contains statistics report
	 */
	private JSONObject json;
	

	/**
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
		sumReactionValue = 0;
		averageShareValue = 0;
		percPosts = 0;
		percReactions = 0;
		json= new JSONObject();
	}
	
	/**
	 * @return the averageReactionValue
	 */
	public int getAverageReactionValue() {
		return averageReactionValue;
	}

	/**
	 * @return the sumReactionValue
	 */
	public int getSumReactionValue() {
		return sumReactionValue;
	}

	/**
	 * @return the maxReactionValue
	 */
	public int getMaxReactionValue() {
		return maxReactionValue;
	}

	/**
	 * @return the minReactionValue
	 */
	public int getMinReactionValue() {
		return minReactionValue;
	}

	/**
	 * @return the maxShareValue
	 */
	public int getMaxShareValue() {
		return maxShareValue;
	}

	/**
	 * @return the minShareValue
	 */
	public int getMinShareValue() {
		return minShareValue;
	}
	
	/**
	 * @return the maxLengthMessage
	 */
	public int getMaxLengthMessage() {
		return maxLengthMessage;
	}


	/**
	 * @return the averageSharesValue
	 */
	public int getAverageShareValue() {
		return averageShareValue;
	}

	/**
	 * @return the sumShareValue
	 */
	public int getSumShareValue() {
		return sumShareValue;
	}
	
	/**
	 * @return Perch of posts contained in first ArrayListFacebookPost in relation to the second ArrayListFacebookPost
	 */
	public int getPercPosts(ArrayListFacebookPost array1, ArrayListFacebookPost array2) {
		percPosts = (array1.getSize() *100)/array2.getSize();	
		return percPosts;
	}
	
	/**
	 * @return Perch of reactions contained in first ArrayListFacebookPost in relation to the second ArrayListFacebookPost
	 */
	public int getPercReactions(ArrayListFacebookPost array1, ArrayListFacebookPost array2) {
		percReactions = (array1.getTotReactions()*100)/array2.getTotReactions();	
		return percReactions;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the sum value of reactions contained in ArrayListFacebookPost
	 */
	public int SumReactionsValue(ArrayListFacebookPost array) {
		sumReactionValue = 0;
		for (int i = 0; i < array.getSize(); i++)
			sumReactionValue = sumReactionValue + array.getPost(i).getNumReactions();
		return sumReactionValue;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the average value of reactions contained in ArrayListFacebookPost
	 */
	public int AverageReactionsValue(ArrayListFacebookPost array) {
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
	public int MaxReactionValue(ArrayListFacebookPost array) {
		maxReactionValue = 0;
		for (int i = 0; i < array.getSize(); i++)
			if (array.getPost(i).getNumReactions() > maxReactionValue)
				maxReactionValue = array.getPost(i).getNumReactions();
		return maxReactionValue;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the smallest value of reactions contained in ArrayListFacebookPost
	 */
	public int MinReactionValue(ArrayListFacebookPost array) {
		minReactionValue = 0;
		for (int i = 0; i < array.getSize(); i++)
			if (array.getPost(i).getNumReactions() < minReactionValue)
				minReactionValue = array.getPost(i).getNumReactions();
		return minReactionValue;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the greatest value of characters contained on a message in
	 *         ArrayListFacebookPost
	 */
	@Override
	public int MaxLengthMessage(ArrayListFacebookPost array) {
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
	@Override
	public int MaxShareValue(ArrayListFacebookPost array) {
		maxShareValue = 0;
		for (int i = 0; i < array.getSize(); i++)
			if (array.getPost(i).getNumShares() > maxShareValue)
				maxShareValue = array.getPost(i).getNumShares();
		return maxShareValue;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the smallest value of shares contained in ArrayListFacebookPost
	 */
	@Override
	public int MinShareValue(ArrayListFacebookPost array) {
		minShareValue = 0;
		for (int i = 0; i < array.getSize(); i++)
			if (array.getPost(i).getNumShares() < minShareValue)
				minShareValue = array.getPost(i).getNumShares();
		return minShareValue;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the sum value of reactions contained in ArrayListFacebookPost
	 */
	@Override
	public int SumSharesValue(ArrayListFacebookPost array) {
		sumShareValue = 0;
		for (int i = 0; i < array.getSize(); i++)
			sumShareValue = sumShareValue + array.getPost(i).getNumShares();
		return sumShareValue;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the average value of shares contained in ArrayListFacebookPost
	 */
	@Override
	public int AverageSharesValue(ArrayListFacebookPost array) {
		averageShareValue = 0;
		try {
			averageShareValue = SumSharesValue(array) / array.getSize();
		} catch (ArithmeticException e) {
			// e.printStackTrace();
		}
		return averageShareValue;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return a JSON parsed in string that contains report's summary
	 */
	@Override
	public String StatisticsReports(ArrayListFacebookPost array, ArrayListFacebookPost totalArray) {
		if (!array.isEmpty())
			json=new JSONObject();
		json.put("total posts:", array.getSize());
		json.put("sum reactions value", SumReactionsValue(array));
		json.put("average reactions value",AverageReactionsValue(array));
		json.put("max reactions value", MaxReactionValue(array));
		json.put("min reactions value", MinReactionValue(array));
		json.put("max shares value", MaxShareValue(array));
		json.put("min shares value", MinShareValue(array));
		json.put("average shares value",AverageReactionsValue(array));
		json.put("Greatest messages character's value",MaxLengthMessage(array));
		json.put(" % of total posts:",getPercPosts(array,totalArray));
		json.put(" % of total reactions:",getPercReactions(array,totalArray));
		return json.toString();
	}

}
