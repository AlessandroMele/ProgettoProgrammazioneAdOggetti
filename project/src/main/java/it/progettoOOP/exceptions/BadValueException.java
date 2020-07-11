/**
 * @author Mele Alessandro & Verdecchia Matteo
 * OOP project exam, A.A. 2019/2020
 *
 */

package it.progettoOOP.exceptions;

/**
 * It starts if a number is not a positive value
 */

public class BadValueException extends Exception {

	private static final long serialVersionUID = 1L;

	public BadValueException() {
		super("Value is not positive number! ");
	}
}
