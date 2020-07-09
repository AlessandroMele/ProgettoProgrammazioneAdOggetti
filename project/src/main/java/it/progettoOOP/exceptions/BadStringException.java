/**
 * @author Mele Alessandro & Verdecchia Matteo
 * OOP project exam, A.A. 2019/2020
 *
 */

package it.progettoOOP.exceptions;

/**
 * This exception starts if string emoji value is true (TRUE) or false (FALSE)
 */

public class BadStringException extends Exception{
	private static final long serialVersionUID = 1L;

	public BadStringException() {
		super("String not accepted");
	}

}
