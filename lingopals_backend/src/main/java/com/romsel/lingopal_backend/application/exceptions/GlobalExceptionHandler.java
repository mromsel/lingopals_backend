package com.romsel.lingopal_backend.application.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	//#region Entity Exceptions
	@ExceptionHandler(LanguageException.class)
	public ResponseEntity<ErrorResponse> handleResourceEmployee(LanguageException ex, HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getHttpStatus().value(),
				ex.getCustomErrors(), ex.getHttpStatus().getReasonPhrase(), ex.getStackTrace()[0].toString(),
				request.getRequestURI());
		logError("Error handling language resource", ex, request);
		return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
	}

	//#endregion

	@ExceptionHandler(EmailException.class)
	public ResponseEntity<ErrorResponse> handleResourceEmail(EmailException ex, HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getHttpStatus().value(),
				ex.getCustomErrors(), ex.getHttpStatus().getReasonPhrase(), ex.getStackTrace()[0].toString(),
				request.getRequestURI());
		logError("Error sending email", ex, request);
		return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
	}

	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<ErrorResponse> handleResourceUnauthorizedException(UnauthorizedException ex,
			HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), null, "", "",
				request.getRequestURI());
		logError("UnauthorizedException: ", ex, request);
		return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
	}

	//#region General Exceptions

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpStatus status,
			HttpServletRequest request) {
		List<String> errors = ex.getBindingResult().getFieldErrors()
				.stream()
				.map(err -> "In field '" + err.getField() + "' " + err.getDefaultMessage())
				.collect(Collectors.toList());
		ErrorResponse errorResponse = new ErrorResponse(status.value(), errors,
				status.getReasonPhrase(), ex.getStackTrace()[0].toString(), request.getRequestURI());
		logger.error("Error handling MethodArgumentNotValidException: {}", request.getRequestURI(), ex);
		return new ResponseEntity<>(errorResponse, status);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleResourceException(Exception ex, HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
				List.of(ExceptionMessages.GENERIC_MESSAGE_ERROR), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
				ex.getStackTrace()[0].toString(), request.getRequestURI());
		logError("General error handling", ex, request);
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private void logError(String message, Exception ex, HttpServletRequest request) {
		logger.error("{} - Request URI: {}", message, request.getRequestURI(), ex);
	}

	//#endregion
}
