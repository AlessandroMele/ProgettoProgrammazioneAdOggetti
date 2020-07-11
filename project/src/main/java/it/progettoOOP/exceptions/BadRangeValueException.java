/**
 * @author Mele Alessandro & Verdecchia Matteo
 * OOP project exam, A.A. 2019/2020
 *
 */

package it.progettoOOP.exceptions;

/**
 * It starts if range values is not a positive number
 */

public class BadRangeValueException extends Exception {
	private static final long serialVersionUID = 1L;

	public BadRangeValueException() {
		super("Range not accepted!");
	}

}
