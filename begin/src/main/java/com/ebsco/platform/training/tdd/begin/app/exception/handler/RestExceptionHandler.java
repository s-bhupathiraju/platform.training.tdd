package com.ebsco.platform.training.tdd.begin.app.exception.handler;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ebsco.platform.training.tdd.begin.app.exception.BadRequestException;
import com.ebsco.platform.training.tdd.begin.app.exception.UserNotFoundException;
import com.ebsco.platform.training.tdd.begin.app.exception.detail.ErrorDetail;

@ControllerAdvice
public class RestExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorDetail> handleBadRequestServiceException(BadRequestException rse) {
		Long now = Calendar.getInstance().getTimeInMillis();
		ErrorDetail errorDetail = new ErrorDetail();
		errorDetail.setTimestamp(now);
		errorDetail.setStatus(HttpStatus.BAD_REQUEST.value());
		errorDetail.setTitle("Bad Request Service Exception");
		errorDetail.setDetail(rse.getMessage());
		errorDetail.setDeveloperMessage(rse.getClass().getName());
		LOGGER.error("Bad Request Service Exception returning to client:ErrorDetail[{}]:Status[{}]", errorDetail,
				HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDetail> handleConflictException(UserNotFoundException rse) {
		Long now = Calendar.getInstance().getTimeInMillis();
		ErrorDetail errorDetail = new ErrorDetail();
		errorDetail.setTimestamp(now);
		errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
		errorDetail.setTitle("Conflict Exception");
		errorDetail.setDetail(rse.getMessage());
		errorDetail.setDeveloperMessage(rse.getClass().getName());
		LOGGER.error("User Not Found Exception returning to client:ErrorDetail[{}]:Status[{}]", errorDetail,
				HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
	}
	
}