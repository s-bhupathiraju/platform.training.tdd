package com.ebsco.platform.training.tdd.begin.app.service.exception;

public class MessageFormatServiceException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String MESSAGE = "Message format exception occured";
	
	public MessageFormatServiceException() {
		super(MESSAGE);
	}

	public MessageFormatServiceException(String message) {
		super(message);
	}

	public MessageFormatServiceException(Throwable cause) {
		super(cause);
	}

	public MessageFormatServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
