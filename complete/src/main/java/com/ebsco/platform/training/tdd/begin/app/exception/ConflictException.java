package com.ebsco.platform.training.tdd.begin.app.exception;

public class ConflictException extends RuntimeException {

	public ConflictException() {
		
	}

	public ConflictException(String message) {
		super(message);
		
	}

	public ConflictException(Throwable cause) {
		super(cause);
		
	}

	public ConflictException(String message, Throwable cause) {
		super(message, cause);
		
	}


}