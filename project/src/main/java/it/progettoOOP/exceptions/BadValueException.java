package it.progettoOOP.exceptions;

/**
 * This exception starts if number is not positive value
 */

public class BadValueException extends Exception {

	private static final long serialVersionUID = 1L;

	public BadValueException() {
		super("Value is not positive number! ");
	}
}
