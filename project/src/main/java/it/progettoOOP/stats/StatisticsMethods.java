/**
 * @author Mele Alessandro & Verdecchia Matteo
 * OOP project exam, A.A. 2019/2020
 *
 */

package it.progettoOOP.stats;

import java.util.ArrayList;

/**
 * A list of minimum methods for statistics
 */
public interface StatisticsMethods {

	/**
	 * It calculates the greatest value of generic field contained on a post in
	 * ArrayList<Integer>
	 * 
	 * @param ArrayList<Integer>
	 * @return the greatest value of generic field contained in ArrayList<Integer>
	 */
	public abstract int MaxValue(ArrayList<Integer> array);

	/**
	 * It calculates the smallest value of generic field contained on a post in
	 * ArrayList<Integer>
	 * 
	 * @param ArrayList<Integer>
	 * @return the smallest value of generic field contained in ArrayList<Integer>
	 */
	public abstract int MinValue(ArrayList<Integer> array);

	/**
	 * It calculates the sum of generic field contained on a post in
	 * ArrayList<Integer>
	 * 
	 * @param ArrayList<Integer>
	 * @return the sum value of generic field contained in <ArrayList>FacebookPost
	 */
	public abstract int SumValue(ArrayList<Integer> array);

	/**
	 * It calculates the average of generic field contained on a post in
	 * ArrayList<Integer>
	 * 
	 * @param ArrayList<Integer>
	 * @return the average value of generic field contained in ArrayList<Integer>
	 */
	public abstract double AverageValue(ArrayList<Integer> array);

}
