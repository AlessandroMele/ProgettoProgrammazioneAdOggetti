/**
 * @author Mele Alessandro & Verdecchia Matteo
 * OOP project exam, A.A. 2019/2020
 *
 */

package it.progettoOOP.stats;

import java.util.ArrayList;

import it.progettoOOP.model.FacebookPost;

/**
 * A list of minimum methods for statistics to implement project's requirement
 */
public interface StatisticsMethods {

	/**
	 * @param <ArrayList>FacebookPost
	 * @return the greatest value of characters contained on a message in
	 *         <ArrayList>FacebookPost
	 */
	public abstract int MaxLengthMessage(ArrayList<FacebookPost> array);

	/**
	 * @param <ArrayList>FacebookPost
	 * @return the greatest value of shares contained in <ArrayList>FacebookPost
	 */
	public abstract int MaxShareValue(ArrayList<FacebookPost> array);

	/**
	 * @param <ArrayList>FacebookPost
	 * @return the smallest value of shares contained in <ArrayList>FacebookPost
	 */
	public abstract int MinShareValue(ArrayList<FacebookPost> array);

	/**
	 * @param <ArrayList>FacebookPost
	 * @return the sum value of reactions contained in <ArrayList>FacebookPost
	 */
	public abstract int SumSharesValue(ArrayList<FacebookPost> array);

	/**
	 * @param <ArrayList>FacebookPost
	 * @return the average value of shares contained in <ArrayList>FacebookPost
	 */
	public abstract double AverageSharesValue(ArrayList<FacebookPost> array);

}