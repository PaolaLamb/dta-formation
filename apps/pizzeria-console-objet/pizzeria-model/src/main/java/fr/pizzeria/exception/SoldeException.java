package fr.pizzeria.exception;

/**
 * @author PaolaLamb
 *
 */
public class SoldeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur sans paramètre
	 */
	public SoldeException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SoldeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public SoldeException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public SoldeException(Throwable cause) {
		super(cause);
	}

	
}
