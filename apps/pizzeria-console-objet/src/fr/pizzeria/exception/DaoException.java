package fr.pizzeria.exception;

import java.io.IOException;

public class DaoException extends IOException {

	public DaoException() {
		super("ca marche paaaas !");
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

}
