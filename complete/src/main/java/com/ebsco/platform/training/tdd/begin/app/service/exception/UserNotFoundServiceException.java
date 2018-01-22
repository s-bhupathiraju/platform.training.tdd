package com.ebsco.platform.training.tdd.begin.app.service.exception;

public class UserNotFoundServiceException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String MESSAGE = "User has not been found in the database.";
	
	public UserNotFoundServiceException() {
		super(MESSAGE);
	}

	public UserNotFoundServiceException(String message) {
		super(message);
	}

	public UserNotFoundServiceException(Throwable cause) {
		super(cause);
	}

	public UserNotFoundServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
