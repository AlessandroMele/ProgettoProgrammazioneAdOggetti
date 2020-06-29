package it.progettoOOP.exception;

public class ConnectionNotStarted extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConnectionNotStarted(){
		super();
		System.out.println("WARNING-CONNECTION NOT STARTED");
	}

}
