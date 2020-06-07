package br.com.franca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//  exceção usada pra erros de armazenamento do arquivo
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class FileStorageException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FileStorageException(String exception) {
		super(exception);
	}

	public FileStorageException(String exception, Throwable cause) {
		super(exception, cause);
	}

}
