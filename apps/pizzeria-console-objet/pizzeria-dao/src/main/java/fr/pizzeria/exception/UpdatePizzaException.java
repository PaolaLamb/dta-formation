package fr.pizzeria.exception;

/**
 * @author PaolaLamb
 *
 */
public class UpdatePizzaException extends StockageException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public UpdatePizzaException() {
		super("\n /!\\/!\\ la pizza n'existe pas /!\\/!\\ \n");
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UpdatePizzaException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public UpdatePizzaException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public UpdatePizzaException(Throwable cause) {
		super(cause);
	}
	
}