package it.progettoOOP.exceptions;

public class BadValueException extends Exception {

	private static final long serialVersionUID = 1L;

	public BadValueException() {
		super("Value is not positive number! ");
	}
}
