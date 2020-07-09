package it.progettoOOP.exceptions;

public class BadStringException extends Exception{
	private static final long serialVersionUID = 1L;

	public BadStringException() {
		super("String not accepted");
	}

}
