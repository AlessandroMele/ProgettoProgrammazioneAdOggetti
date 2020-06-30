/**
 * @author Mele Alessandro & Verdecchia Matteo
 * Project of OOP Programming exams, A.A. 2019/2020
 *
 */
package it.progettoOOP.stats;

import it.progettoOOP.model.ArrayListFacebookPost;

public interface StatisticsMethods {
	/**
	 * This interface is a list of minimum methods for statistics to implement for project's
	 * requirement
	 * Statistiche su media, massimi e minimi di share per fasce di lunghezza di post e per presenza di emoticon.
	 */

	/**
	 * @param ArrayListFacebookPost
	 * @return the greatest value of characters contained on a message in
	 *         ArrayListFacebookPost
	 */
	public abstract int MaxLengthMessage(ArrayListFacebookPost array);

	/**
	 * @param ArrayListFacebookPost
	 * @return the greatest value of shares contained in ArrayListFacebookPost
	 */
	public abstract int MaxShareValue(ArrayListFacebookPost array);

	/**
	 * @param ArrayListFacebookPost
	 * @return the smallest value of shares contained in ArrayListFacebookPost
	 */
	public abstract int MinShareValue(ArrayListFacebookPost array);

	/**
	 * @param ArrayListFacebookPost
	 * @return the sum value of reactions contained in ArrayListFacebookPost
	 */
	public abstract int SumSharesValue(ArrayListFacebookPost array);

	/**
	 * @param ArrayListFacebookPost
	 * @return the average value of shares contained in ArrayListFacebookPost
	 */
	public abstract int AverageSharesValue(ArrayListFacebookPost array);

	/**
	 * @param ArrayListFacebookPost
	 * @return string that contains report's summary
	 */
	public abstract String StatisticsReports(ArrayListFacebookPost array);

}