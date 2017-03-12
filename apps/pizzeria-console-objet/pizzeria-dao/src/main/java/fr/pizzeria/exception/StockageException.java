package fr.pizzeria.exception;

/**
 * @author PaolaLamb
 *
 */
public class StockageException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public StockageException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 */
	public StockageException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public StockageException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public StockageException(Throwable cause) {
		super(cause);
	}
	
}