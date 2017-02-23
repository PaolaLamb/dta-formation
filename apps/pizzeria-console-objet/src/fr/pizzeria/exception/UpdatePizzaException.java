package fr.pizzeria.exception;

public class UpdatePizzaException extends StockageException {

	public UpdatePizzaException() {
		super("\n /!\\/!\\ la pizza n'existe pas /!\\/!\\ \n");
	}

	public UpdatePizzaException(String message, Throwable cause) {
		super(message, cause);
	}

	public UpdatePizzaException(String message) {
		super(message);
	}

	public UpdatePizzaException(Throwable cause) {
		super(cause);
	}
	
}
