package fr.pizzeria.exception;

public class SavePizzaException extends StockageException {

	private static final long serialVersionUID = 1L;

	public SavePizzaException() {
		super("\n /!\\/!\\ Le nom de code est invalide /!\\/!\\ \n");
	}

	public SavePizzaException(String message, Throwable cause) {
		super(message, cause);
	}

	public SavePizzaException(String message) {
		super(message);
	}

	public SavePizzaException(Throwable cause) {
		super(cause);
	}
	
}