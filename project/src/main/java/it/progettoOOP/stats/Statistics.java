/**
 * @author Mele Alessandro & Verdecchia Matteo
 * Project of OOP Programming exams, A.A. 2019/2020
 *
 */
package it.progettoOOP.stats;

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
	 * Perc of posts contained in first ArrayListFacebookPost in relation to the second ArrayListFacebookPost
	 */
	private int percPosts;
	
	/**
	 * Perc of reactions contained in first ArrayListFacebookPost in relation to the second ArrayListFacebookPost
	 */
	private int percReactions;
	

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
	}
	
	/**
	 * @return the averageReactionValue
	 */
	public int getAverageReactionValue() {
		return averageReactionValue;
	}

	/**
	 * @param averageReactionValue the averageReactionValue to set
	 */
	public void setAverageReactionValue(int averageReactionValue) {
		this.averageReactionValue = averageReactionValue;
	}

	/**
	 * @return the sumReactionValue
	 */
	public int getSumReactionValue() {
		return sumReactionValue;
	}

	/**
	 * @param sumReactionValue the sumReactionValue to set
	 */
	public void setSumReactionValue(int sumReactionValue) {
		this.sumReactionValue = sumReactionValue;
	}

	/**
	 * @return the maxReactionValue
	 */
	public int getMaxReactionValue() {
		return maxReactionValue;
	}

	/**
	 * @param maxReactionValue the maxReactionValue to set
	 */
	public void setMaxReactionValue(int maxReactionValue) {
		this.maxReactionValue = maxReactionValue;
	}

	/**
	 * @return the minReactionValue
	 */
	public int getMinReactionValue() {
		return minReactionValue;
	}

	/**
	 * @param minReactionValue the minReactionValue to set
	 */
	public void setMinReactionValue(int minReactionValue) {
		this.minReactionValue = minReactionValue;
	}

	/**
	 * @return the maxShareValue
	 */
	public int getMaxShareValue() {
		return maxShareValue;
	}

	/**
	 * @param maxShareValue the maxShareValue to set
	 */
	public void setMaxShareValue(int maxShareValue) {
		this.maxShareValue = maxShareValue;
	}

	/**
	 * @return the minShareValue
	 */
	public int getMinShareValue() {
		return minShareValue;
	}

	/**
	 * @param minShareValue the minShareValue to set
	 */
	public void setMinShareValue(int minShareValue) {
		this.minShareValue = minShareValue;
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
	 * @return the averageSharesValue
	 */
	public int getAverageShareValue() {
		return averageShareValue;
	}

	/**
	 * @param averageSharesValue the averageSharesValue to set
	 */
	public void setAverageShareValue(int averageSharesValue) {
		this.averageShareValue = averageSharesValue;
	}

	/**
	 * @return the sumShareValue
	 */
	public int getSumShareValue() {
		return sumShareValue;
	}

	/**
	 * @param sumShareValue the sumShareValue to set
	 */
	public void setSumShareValue(int sumShareValue) {
		this.sumShareValue = sumShareValue;
	}
	
	/**
	 * @return Perc of posts contained in first ArrayListFacebookPost in relation to the second ArrayListFacebookPost
	 */
	public int getPercPosts(ArrayListFacebookPost array1, ArrayListFacebookPost array2) {
		percPosts = (array1.getSize() *100)/array2.getSize();	
		return percPosts;
	}
	
	/**
	 * @return Perc of reactions contained in first ArrayListFacebookPost in relation to the second ArrayListFacebookPost
	 */
	public int getPercReactions(ArrayListFacebookPost array1, ArrayListFacebookPost array2) {
		percPosts = (array1.getTotReactions()*100)/array2.getTotReactions();	
		return percPosts;
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
	 * @return string that contains report's summary
	 */
	@Override
	public String StatisticsReports(ArrayListFacebookPost array, ArrayListFacebookPost totalArray) {
		if (!array.isEmpty())
			return "\n**STATS**\nTOTAL NUMBER OF POSTS: " + array.getSize() + "\n\nREACTIONS:\nAverage value="
					+ AverageReactionsValue(array) + ", Sum value=" + SumReactionsValue(array) + ", Greatest value="
					+ MaxReactionValue(array) + ", Smallest value=" + MinReactionValue(array)
					+ "\n\nMESSAGE:\nGreatest messages character's value=" + MaxLengthMessage(array)
					+ "\n\nSHARES:\nAverage value=" + AverageSharesValue(array) + ", Sum value=" + SumSharesValue(array)
					+ ", Greatest value=" + MaxShareValue(array) + ", Smallest value=" + MinShareValue(array) 
					+ "\n\n These posts are the " + getPercPosts(array,totalArray) + "% of the total." 
					+ "\n Reactions are the " + getPercReactions(array,totalArray) + "% of the totale reactions. "; 
		return "\n**NO STATS**\n";
	}

}
