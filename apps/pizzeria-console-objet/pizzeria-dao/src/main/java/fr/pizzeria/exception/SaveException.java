package fr.pizzeria.exception;

/**
 * @author PaolaLamb
 *
 */
public class SaveException extends StockageException {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public SaveException() {
		super("\n /!\\/!\\ Le nom de code est invalide /!\\/!\\ \n");
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SaveException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public SaveException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public SaveException(Throwable cause) {
		super(cause);
	}
	
}