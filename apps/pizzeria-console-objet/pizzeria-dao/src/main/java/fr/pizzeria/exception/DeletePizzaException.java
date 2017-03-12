package fr.pizzeria.exception;

/**
 * @author PaolaLamb
 *
 */
public class DeletePizzaException extends StockageException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public DeletePizzaException() {
		super("\n /!\\/!\\ La pizza n'existe pas /!\\/!\\ \n");
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DeletePizzaException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public DeletePizzaException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public DeletePizzaException(Throwable cause) {
		super(cause);
	}
	

}