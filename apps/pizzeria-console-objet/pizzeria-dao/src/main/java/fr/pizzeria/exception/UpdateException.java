package fr.pizzeria.exception;

/**
 * @author PaolaLamb
 *
 */
public class UpdateException extends StockageException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public UpdateException() {
		super("\n /!\\/!\\ la pizza n'existe pas /!\\/!\\ \n");
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UpdateException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public UpdateException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public UpdateException(Throwable cause) {
		super(cause);
	}
	
}