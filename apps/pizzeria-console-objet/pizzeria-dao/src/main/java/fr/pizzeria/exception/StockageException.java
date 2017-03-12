package fr.pizzeria.exception;

public class StockageException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public StockageException() {
		super();
	}

	public StockageException(String message, Throwable cause) {
		super(message, cause);
	}

	public StockageException(String message) {
		super(message);
	}

	public StockageException(Throwable cause) {
		super(cause);
	}
	
}