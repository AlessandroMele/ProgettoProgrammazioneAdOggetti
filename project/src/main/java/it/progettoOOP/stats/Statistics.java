/**
 * @author Mele Alessandro & Verdecchia Matteo
 * Project of OOP Programming exams, A.A. 2019/2020
 *
 */
package it.progettoOOP.stats;

import java.util.ArrayList;

import it.progettoOOP.model.FacebookPost;

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
	 * Perch of posts contained in first ArrayListFacebookPost in relation to the
	 * second ArrayListFacebookPost
	 */
	private int percPosts;

	/**
	 * Perch of reactions contained in first ArrayListFacebookPost in relation to
	 * the second ArrayListFacebookPost
	 */
	private int percReactions;
	/**
	 * JSON that contains statistics report
	 */

	/**
	 * Perch of posts contained in first ArrayListFacebookPost in relation to the
	 * second ArrayListFacebookPost
	 */
	private int totalReactions;

	/**
	 * Perch of reactions contained in first ArrayListFacebookPost in relation to
	 * the second ArrayListFacebookPost
	 */
	private int totalShares;

	/**
	 * Basic constructor
	 */
	public Statistics() {
		sumReactionValue = 0;
		averageReactionValue = 0;
		totalReactions = 0;
		maxReactionValue = 0;
		minReactionValue = 0;
		maxLengthMessage = 0;
		totalShares = 0;
		maxShareValue = 0;
		minShareValue = 0;
		sumReactionValue = 0;
		averageShareValue = 0;
		percPosts = 0;
		percReactions = 0;
	}

	public Statistics(ArrayList<FacebookPost> arrayList1, ArrayList<FacebookPost> arrayList2) {
		sumReactionValue = SumReactionsValue(arrayList1);
		maxReactionValue = MaxReactionValue(arrayList1);
		minReactionValue = MinReactionValue(arrayList1);
		averageReactionValue = AverageReactionsValue(arrayList1);
		totalReactions = getTotalReactions(arrayList1);
		maxLengthMessage = MaxLengthMessage(arrayList1);
		sumShareValue = MaxShareValue(arrayList1);
		maxShareValue = MaxShareValue(arrayList1);
		minShareValue = MinShareValue(arrayList1);
		averageShareValue = AverageSharesValue(arrayList1);
		totalShares = getTotalShares(arrayList1);
		percPosts = PercPosts(arrayList1, arrayList2);
		percReactions = PercReactions(arrayList1, arrayList2);
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

	public int getTotalReactions(ArrayList<FacebookPost> arrayList) {
		int totalReactions = 0;
		for (int i = 0; i < arrayList.size(); i++)
			totalReactions = totalReactions + arrayList.get(i).getNumReactions();
		return totalReactions;
	}

	/**
	 * @return the totalReactions
	 */
	public int getTotalReactions() {
		return totalReactions;
	}

	/**
	 * @return the totalShares
	 */
	public int getTotalShares() {
		return totalShares;
	}

	/**
	 * @return the total number of shares of the ArrayListFacebookPost
	 */
	public int getTotalShares(ArrayList<FacebookPost> arrayList) {
		int totalShares = 0;
		for (int i = 0; i < arrayList.size(); i++)
			totalShares = totalShares + arrayList.get(i).getNumShares();
		return totalShares;
	}

	/**
	 * @return Perch of posts contained in first ArrayListFacebookPost in relation
	 *         to the second ArrayListFacebookPost
	 */
	public int PercPosts(ArrayList<FacebookPost> array1, ArrayList<FacebookPost> array2) {
		percPosts = (array1.size() * 100) / array2.size();
		return percPosts;
	}

	/**
	 * @return Perch of reactions contained in first ArrayListFacebookPost in
	 *         relation to the second ArrayListFacebookPost
	 */
	public int PercReactions(ArrayList<FacebookPost> array1, ArrayList<FacebookPost> array2) {
		percReactions = (getTotalReactions(array1) * 100) / getTotalReactions(array2);
		return percReactions;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the sum value of reactions contained in ArrayListFacebookPost
	 */
	public int SumReactionsValue(ArrayList<FacebookPost> array) {
		sumReactionValue = 0;
		for (int i = 0; i < array.size(); i++)
			sumReactionValue = sumReactionValue + array.get(i).getNumReactions();
		return sumReactionValue;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the average value of reactions contained in ArrayListFacebookPost
	 */
	public int AverageReactionsValue(ArrayList<FacebookPost> array) {
		try {
			averageReactionValue = SumReactionsValue(array) / array.size();
		} catch (ArithmeticException e) {
			averageReactionValue = 0;
		}
		return averageReactionValue;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the greatest value of reactions contained in ArrayListFacebookPost
	 */
	public int MaxReactionValue(ArrayList<FacebookPost> array) {
		maxReactionValue = 0;
		for (int i = 0; i < array.size(); i++)
			if (array.get(i).getNumReactions() > maxReactionValue)
				maxReactionValue = array.get(i).getNumReactions();
		return maxReactionValue;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the smallest value of reactions contained in ArrayListFacebookPost
	 */
	public int MinReactionValue(ArrayList<FacebookPost> array) {
		minReactionValue = 0;
		for (int i = 0; i < array.size(); i++)
			if (array.get(i).getNumReactions() < minReactionValue)
				minReactionValue = array.get(i).getNumReactions();
		return minReactionValue;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the greatest value of characters contained on a message in
	 *         ArrayListFacebookPost
	 */
	@Override
	public int MaxLengthMessage(ArrayList<FacebookPost> array) {
		maxLengthMessage = 0;
		for (int i = 0; i < array.size(); i++)
			if (array.get(i).getLengthMessage() > maxLengthMessage)
				maxLengthMessage = array.get(i).getLengthMessage();
		return maxLengthMessage;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the greatest value of shares contained in ArrayListFacebookPost
	 */
	@Override
	public int MaxShareValue(ArrayList<FacebookPost> array) {
		maxShareValue = 0;
		for (int i = 0; i < array.size(); i++)
			if (array.get(i).getNumShares() > maxShareValue)
				maxShareValue = array.get(i).getNumShares();
		return maxShareValue;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the smallest value of shares contained in ArrayListFacebookPost
	 */
	@Override
	public int MinShareValue(ArrayList<FacebookPost> array) {
		minShareValue = 0;
		for (int i = 0; i < array.size(); i++)
			if (array.get(i).getNumShares() < minShareValue)
				minShareValue = array.get(i).getNumShares();
		return minShareValue;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the sum value of reactions contained in ArrayListFacebookPost
	 */
	@Override
	public int SumSharesValue(ArrayList<FacebookPost> array) {
		sumShareValue = 0;
		for (int i = 0; i < array.size(); i++)
			sumShareValue = sumShareValue + array.get(i).getNumShares();
		return sumShareValue;
	}

	/**
	 * @param ArrayListFacebookPost
	 * @return the average value of shares contained in ArrayListFacebookPost
	 */
	@Override
	public int AverageSharesValue(ArrayList<FacebookPost> array) {
		averageShareValue = 0;
		try {
			averageShareValue = SumSharesValue(array) / array.size();
		} catch (ArithmeticException e) {

		}
		return averageShareValue;
	}
}
