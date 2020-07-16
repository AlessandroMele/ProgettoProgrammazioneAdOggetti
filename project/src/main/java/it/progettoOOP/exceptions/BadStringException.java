/**
 * @author Mele Alessandro & Verdecchia Matteo
 * OOP project exam, A.A. 2019/2020
 *
 */

package it.progettoOOP.exceptions;

/**
 * It starts if string emoji value is not "true", "false", "notSpecified" and
 * lower/upper combination of these words
 */

public class BadStringException extends Exception {
	private static final long serialVersionUID = 1L;

	public BadStringException() {
		super("String not accepted!");
	}

}
