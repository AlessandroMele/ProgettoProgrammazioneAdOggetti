/**
 * @author Mele Alessandro & Verdecchia Matteo
 * OOP project exam, A.A. 2019/2020
 *
 */
package it.progettoOOP.stats;

import java.util.ArrayList;
import it.progettoOOP.model.FacebookPost;

public class Statistics implements StatisticsMethods {
	/**
	 * Average value of reactions contained in <ArrayList>FacebookPost
	 */
	private double averageReactionValue;
	/**
	 * Sum value of reactions contained in <ArrayList>FacebookPost
	 */
	private int sumReactionValue;
	/**
	 * Greatest value of reactions contained in <ArrayList>FacebookPost
	 */
	private int maxReactionValue;
	/**
	 * Smallest value of reactions contained in <ArrayList>FacebookPost
	 */
	private int minReactionValue;
	/**
	 * Greatest value of characters on a message in <ArrayList>FacebookPost
	 */
	private int maxLengthMessage;
	/**
	 * Smallest value of characters on a message in <ArrayList>FacebookPost
	 */
	private int minLengthMessage;

	/**
	 * Greatest value of reactions contained in <ArrayList>FacebookPost
	 */
	private int maxShareValue;
	/**
	 * Smallest value of reactions contained in <ArrayList>FacebookPost
	 */
	private int minShareValue;
	/**
	 * Average value of reactions contained in <ArrayList>FacebookPost
	 */
	private double averageShareValue;
	/**
	 * Sum value of reactions contained in <ArrayList>FacebookPost
	 */
	private int sumShareValue;

	/**
	 * Perch of posts contained in first <ArrayList>FacebookPost in relation to the
	 * second <ArrayList>FacebookPost
	 */
	private double percPosts;

	/**
	 * Perch of reactions contained in first <ArrayList>FacebookPost in relation to
	 * the second <ArrayList>FacebookPost
	 */
	private double percReactions;
	/**
	 * JSON that contains statistics report
	 */

	/**
	 * Perch of posts contained in first <ArrayList>FacebookPost in relation to the
	 * second <ArrayList>FacebookPost
	 */
	private int totalReactions;

	/**
	 * Perch of reactions contained in first <ArrayList>FacebookPost in relation to
	 * the second <ArrayList>FacebookPost
	 */
	private int totalShares;

	public Statistics() {
		sumReactionValue = 0;
		maxReactionValue = 0;
		minReactionValue = 0;
		averageReactionValue = 0.0;
		totalReactions = 0;
		maxLengthMessage = 0;
		minLengthMessage = 0;
		sumShareValue = 0;
		maxShareValue = 0;
		minShareValue = 0;
		averageShareValue = 0.0;
		totalShares = 0;
		percPosts = 0.0;
		percReactions = 0.0;
	}

	public Statistics(ArrayList<FacebookPost> arrayfil, ArrayList<FacebookPost> arrayfull) {
		sumReactionValue = SumReactionsValue(arrayfil);
		maxReactionValue = MaxReactionValue(arrayfil);
		minReactionValue = MinReactionValue(arrayfil);
		averageReactionValue = AverageReactionsValue(arrayfil);
		totalReactions = TotalReactions(arrayfil);
		maxLengthMessage = MaxLengthMessage(arrayfil);
		sumShareValue = MaxShareValue(arrayfil);
		maxShareValue = MaxShareValue(arrayfil);
		minShareValue = MinShareValue(arrayfil);
		averageShareValue = AverageSharesValue(arrayfil);
		totalShares = TotalShares(arrayfil);
		percPosts = PercPosts(arrayfil, arrayfull);
		percReactions = PercReactions(arrayfil, arrayfull);
	}

	/**
	 * @return the averageReactionValue
	 */
	public double getAverageReactionValue() {
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
	 * @return the maxLengthMessage
	 */
	public int getMaxLengthMessage() {
		return maxLengthMessage;
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
	 * @return the averageShareValue
	 */
	public double getAverageShareValue() {
		return averageShareValue;
	}

	/**
	 * @return the sumShareValue
	 */
	public int getSumShareValue() {
		return sumShareValue;
	}

	/**
	 * @return the percPosts
	 */
	public double getPercPosts() {
		return percPosts;
	}

	/**
	 * @return the percReactions
	 */
	public double getPercReactions() {
		return percReactions;
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
	 * @param arrayList <ArrayList>FacebookPost
	 * @return the total number of reactions of the <ArrayList>FacebookPost
	 */
	public int TotalReactions(ArrayList<FacebookPost> array) {
		totalReactions = 0;
		if (!array.isEmpty())
			for (int i = 0; i < array.size(); i++)
				totalReactions = totalReactions + array.get(i).getNumReactions();
		return totalReactions;
	}

	/**
	 * @param arrayList <ArrayList>FacebookPost
	 * @return the total number of shares of the <ArrayList>FacebookPost
	 */
	public int TotalShares(ArrayList<FacebookPost> array) {
		totalShares = 0;
		if (!array.isEmpty())
			for (int i = 0; i < array.size(); i++)
				totalShares = totalShares + array.get(i).getNumShares();
		return totalShares;
	}

	/**
	 * @param array1 the <ArrayList>FacebookPost filtered
	 * @param array2 the total <ArrayList>FacebookPost
	 * @return Perch of posts contained in first <ArrayList>FacebookPost in relation
	 *         to the second <ArrayList>FacebookPost
	 */
	public double PercPosts(ArrayList<FacebookPost> array, ArrayList<FacebookPost> arrayfull) {
		percPosts = 0.0;
		if (!arrayfull.isEmpty())
			try {
				percPosts = (double) (array.size() * 100) / arrayfull.size();
			} catch (ArithmeticException e) {
			}
		return Math.floor(percPosts * 100.0) / 100.0;
	}

	/**
	 * @param array1 the <ArrayList>FacebookPost filtered
	 * @param array2 the total <ArrayList>FacebookPost
	 * @return Perch of reactions contained in first <ArrayList>FacebookPost in
	 *         relation to the second <ArrayList>FacebookPost
	 */
	public double PercReactions(ArrayList<FacebookPost> array, ArrayList<FacebookPost> arrayfull) {
		percReactions = 0.0;
		if (!arrayfull.isEmpty())
			try {
				percReactions = (double) (TotalReactions(array) * 100) / TotalReactions(arrayfull);
			} catch (ArithmeticException e) {
			}
		return Math.floor(percReactions * 100.0) / 100.0;
	}

	/**
	 * @param array <ArrayList>FacebookPost
	 * @return the sum value of reactions contained in <ArrayList>FacebookPost
	 */
	public int SumReactionsValue(ArrayList<FacebookPost> array) {
		sumReactionValue = 0;
		if (!array.isEmpty())
			for (int i = 0; i < array.size(); i++)
				sumReactionValue = sumReactionValue + array.get(i).getNumReactions();
		return sumReactionValue;
	}

	/**
	 * @param array <ArrayList>FacebookPost
	 * @return the average value of reactions contained in <ArrayList>FacebookPost
	 */
	public double AverageReactionsValue(ArrayList<FacebookPost> array) {
		averageReactionValue = 0.0;
		if (!array.isEmpty())
			try {
				averageReactionValue = (double) SumReactionsValue(array) / array.size();
			} catch (ArithmeticException e) {
			}
		return Math.floor(averageReactionValue * 100.0) / 100.0;
	}

	/**
	 * @param array <ArrayList>FacebookPost
	 * @return the greatest value of reactions contained in <ArrayList>FacebookPost
	 */
	public int MaxReactionValue(ArrayList<FacebookPost> array) {
		maxReactionValue = 0;
		if (!array.isEmpty())
			for (int i = 0; i < array.size(); i++)
				if (array.get(i).getNumReactions() > maxReactionValue)
					maxReactionValue = array.get(i).getNumReactions();
		return maxReactionValue;
	}

	/**
	 * @param array <ArrayList>FacebookPost
	 * @return the smallest value of reactions contained in <ArrayList>FacebookPost
	 */
	public int MinReactionValue(ArrayList<FacebookPost> array) {
		minReactionValue = 0;
		if (!array.isEmpty())
			for (int i = 0; i < array.size(); i++)
				if (array.get(i).getNumReactions() < minReactionValue)
					minReactionValue = array.get(i).getNumReactions();
		return minReactionValue;
	}

	/**
	 * @param array <ArrayList>FacebookPost
	 * @return the greatest value of characters contained on a message in
	 *         <ArrayList>FacebookPost
	 */
	@Override
	public int MaxLengthMessage(ArrayList<FacebookPost> array) {
		maxLengthMessage = 0;
		if (!array.isEmpty())
			for (int i = 0; i < array.size(); i++)
				if (array.get(i).LengthMessage() > maxLengthMessage)
					maxLengthMessage = array.get(i).LengthMessage();
		return maxLengthMessage;
	}

	/**
	 * @param array <ArrayList>FacebookPost
	 * @return the smallest value of characters contained on a message in
	 *         <ArrayList>FacebookPost
	 */
	public int MinLengthMessage(ArrayList<FacebookPost> array) {
		minLengthMessage = 0;
		if (!array.isEmpty())
			for (int i = 0; i < array.size(); i++)
				if (array.get(i).LengthMessage() < minLengthMessage)
					minLengthMessage = array.get(i).LengthMessage();
		return minLengthMessage;
	}

	/**
	 * @param array <ArrayList>FacebookPost
	 * @return the greatest value of shares contained in <ArrayList>FacebookPost
	 */
	@Override
	public int MaxShareValue(ArrayList<FacebookPost> array) {
		maxShareValue = 0;
		if (!array.isEmpty())
			for (int i = 0; i < array.size(); i++)
				if (array.get(i).getNumShares() > maxShareValue)
					maxShareValue = array.get(i).getNumShares();
		return maxShareValue;
	}

	/**
	 * @param array <ArrayList>FacebookPost
	 * @return the smallest value of shares contained in <ArrayList>FacebookPost
	 */
	@Override
	public int MinShareValue(ArrayList<FacebookPost> array) {
		minShareValue = 0;
		if (!array.isEmpty())
			for (int i = 0; i < array.size(); i++)
				if (array.get(i).getNumShares() < minShareValue)
					minShareValue = array.get(i).getNumShares();
		return minShareValue;
	}

	/**
	 * @param array <ArrayList>FacebookPost
	 * @return the sum value of reactions contained in <ArrayList>FacebookPost
	 */
	@Override
	public int SumSharesValue(ArrayList<FacebookPost> array) {
		sumShareValue = 0;
		if (!array.isEmpty())
			for (int i = 0; i < array.size(); i++)
				sumShareValue = sumShareValue + array.get(i).getNumShares();
		return sumShareValue;
	}

	/**
	 * @param array <ArrayList>FacebookPost
	 * @return the average value of shares contained in <ArrayList>FacebookPost
	 */
	@Override
	public double AverageSharesValue(ArrayList<FacebookPost> array) {
		averageShareValue = 0.0;
		if (!array.isEmpty())
			try {
				averageShareValue = (double) SumSharesValue(array) / array.size();
			} catch (ArithmeticException e) {

			}
		return Math.floor(averageShareValue * 100.0) / 100.0;
	}
}
