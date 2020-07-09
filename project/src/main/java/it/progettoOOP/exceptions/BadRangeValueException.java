package it.progettoOOP.exceptions;

public class BadRangeValueException extends Exception{
	private static final long serialVersionUID = 1L;

	public BadRangeValueException(){
		super("Range not accepted!");
	}
	

}
