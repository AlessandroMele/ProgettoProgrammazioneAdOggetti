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
	 * @return the ArrayList that contain's filter's requirement
	 *         ArrayListFacebookPost
	 */
	public ArrayListFacebookPost filterByLengthMessage(ArrayListFacebookPost array);

	/**
	 * @param <T>
	 * @param ArrayListFacebookPost
	 * @return the ArrayList that contain's filter's requirement
	 *         ArrayListFacebookPost
	 */
	public <T> ArrayListFacebookPost classParam(ArrayListFacebookPost array, T param);

}
