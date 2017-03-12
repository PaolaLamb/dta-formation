package fr.pizzeria.exception;

/**
 * @author PaolaLamb
 * Exception liée au crédit du solde d'un client
 */
public class CrediterException extends SoldeException{

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur sans paramètre
	 */
	public CrediterException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CrediterException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public CrediterException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public CrediterException(Throwable cause) {
		super(cause);
	}

	
	
}
