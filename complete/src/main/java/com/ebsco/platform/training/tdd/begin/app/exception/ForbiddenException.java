package com.ebsco.platform.training.tdd.begin.app.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ForbiddenException extends RuntimeException {

	public ForbiddenException() {
		
	}

	public ForbiddenException(String message) {
		super(message);
		
	}

	public ForbiddenException(Throwable cause) {
		super(cause);
		
	}

	public ForbiddenException(String message, Throwable cause) {
		super(message, cause);
		
	}


}