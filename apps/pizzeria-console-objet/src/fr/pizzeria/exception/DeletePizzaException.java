package fr.pizzeria.exception;

public class DeletePizzaException extends StockageException {

	public DeletePizzaException() {
		super("\n /!\\/!\\ La pizza n'existe pas /!\\/!\\ \n");
	}

	public DeletePizzaException(String message, Throwable cause) {
		super(message, cause);
	}

	public DeletePizzaException(String message) {
		super(message);
	}

	public DeletePizzaException(Throwable cause) {
		super(cause);
	}
	

}