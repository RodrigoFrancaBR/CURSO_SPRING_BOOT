package br.com.franca.exception;

public class FileNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FileNotFoundException(String exception) {
		super(exception);
	}

	public FileNotFoundException(String exception, Throwable cause) {
		super(exception, cause);
	}
}
