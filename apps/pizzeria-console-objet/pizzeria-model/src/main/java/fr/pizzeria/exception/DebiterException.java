package fr.pizzeria.exception;

/**
 * @author Paola
 * Exception liée au débit du compte du client
 */
public class DebiterException extends SoldeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur sans paramètre
	 */
	public DebiterException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DebiterException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public DebiterException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public DebiterException(Throwable cause) {
		super(cause);
	}

	
}
