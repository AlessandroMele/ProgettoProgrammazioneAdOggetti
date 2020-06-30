/**
 * @author Mele Alessandro & Verdecchia Matteo
 * Project of OOP Programming exams, A.A. 2019/2020
 *
 */
package it.progettoOOP.filters;

import it.progettoOOP.model.ArrayListFacebookPost;

public interface FiltersMethods {
	/**
	 * This interface is a list of minimum methods for filters to implement for
	 * project's requirement Filtri per lunghezza del post e classifiche
	 * parametriche.
	 */

	/**
	 * @param ArrayListFacebookPost
	 * @return the ArrayList that contain's filter's length message requirement
	 *         ArrayListFacebookPost
	 */
	public abstract ArrayListFacebookPost filterByLengthMessage(ArrayListFacebookPost array, Integer value);

	/**
	 * @param ArrayListFacebookPost
	 * @return the ArrayList that contain's filter's reactions requirement
	 *         ArrayListFacebookPost
	 */
	public abstract ArrayListFacebookPost filterByReactions(ArrayListFacebookPost array, Integer value);

	/**
	 * @param ArrayListFacebookPost
	 * @return the ArrayList that contain's filter's share requirement
	 *         ArrayListFacebookPost
	 */
	public abstract ArrayListFacebookPost filterByShares(ArrayListFacebookPost array, Integer value);

}
