package it.progettoOOP.exceptions;

/**
 * This exception starts if range value is not a positive number (min>max)
 */

public class BadRangeValueException extends Exception{
	private static final long serialVersionUID = 1L;

	public BadRangeValueException(){
		super("Range not accepted!");
	}
	

}
