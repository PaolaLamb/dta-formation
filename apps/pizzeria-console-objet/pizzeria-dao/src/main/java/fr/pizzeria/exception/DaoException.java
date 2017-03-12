package fr.pizzeria.exception;

import java.io.IOException;

/**
 * @author PaolaLamb
 *
 */
public class DaoException extends IOException {

	
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public DaoException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public DaoException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public DaoException(Throwable cause) {
		super(cause);
	}

}
