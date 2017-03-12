package fr.pizzeria.exception;

/**
 * @author PaolaLamb
 *
 */
public class SavePizzaException extends StockageException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public SavePizzaException() {
		super("\n /!\\/!\\ Le nom de code est invalide /!\\/!\\ \n");
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SavePizzaException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public SavePizzaException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public SavePizzaException(Throwable cause) {
		super(cause);
	}
	
}