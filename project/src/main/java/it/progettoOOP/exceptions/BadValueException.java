package it.progettoOOP.exceptions;

import org.json.simple.JSONObject;

public class BadValueException extends Exception {
	
	public BadValueException() {
		super("valore non accettato! ");
	}
}
