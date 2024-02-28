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

	private void logError(String message, Exception ex, HttpServletRequest request) {
		logger.error("{} - Request URI: {}", message, request.getRequestURI(), ex);
	}

	// #region General Exceptions

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

	// #endregion

	// #region Entity Exceptions

	@ExceptionHandler(WordReferenceException.class)
	public ResponseEntity<ErrorResponse> handleResourceWordReference(WordReferenceException ex,
			HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getHttpStatus().value(),
				ex.getCustomErrors(), ex.getHttpStatus().getReasonPhrase(), ex.getStackTrace()[0].toString(),
				request.getRequestURI());
		logError("Error handling word reference resource", ex, request);
		return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
	}

	@ExceptionHandler(WordException.class)
	public ResponseEntity<ErrorResponse> handleResourceWord(WordException ex,
			HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getHttpStatus().value(),
				ex.getCustomErrors(), ex.getHttpStatus().getReasonPhrase(), ex.getStackTrace()[0].toString(),
				request.getRequestURI());
		logError("Error handling word resource", ex, request);
		return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
	}

	@ExceptionHandler(WordAdditionalInfoException.class)
	public ResponseEntity<ErrorResponse> handleResourceWordAdditionalInfo(WordAdditionalInfoException ex,
			HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getHttpStatus().value(),
				ex.getCustomErrors(), ex.getHttpStatus().getReasonPhrase(), ex.getStackTrace()[0].toString(),
				request.getRequestURI());
		logError("Error handling word aditional info resource", ex, request);
		return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
	}

	@ExceptionHandler(LanguageException.class)
	public ResponseEntity<ErrorResponse> handleResourceLanguage(LanguageException ex, 
			HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getHttpStatus().value(),
				ex.getCustomErrors(), ex.getHttpStatus().getReasonPhrase(), ex.getStackTrace()[0].toString(),
				request.getRequestURI());
		logError("Error handling language resource", ex, request);
		return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
	}

	@ExceptionHandler(LanguageLevelException.class)
	public ResponseEntity<ErrorResponse> handleResourceLanguageLevel(LanguageLevelException ex,
			HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getHttpStatus().value(),
				ex.getCustomErrors(), ex.getHttpStatus().getReasonPhrase(), ex.getStackTrace()[0].toString(),
				request.getRequestURI());
		logError("Error handling language level resource", ex, request);
		return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
	}

	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<ErrorResponse> handleResourceCategory(CategoryException ex, HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getHttpStatus().value(),
				ex.getCustomErrors(), ex.getHttpStatus().getReasonPhrase(), ex.getStackTrace()[0].toString(),
				request.getRequestURI());
		logError("Error handling category resource", ex, request);
		return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
	}

	@ExceptionHandler(WritingSystemException.class)
	public ResponseEntity<ErrorResponse> handleResourceWritingSystem(WritingSystemException ex,
			HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getHttpStatus().value(),
				ex.getCustomErrors(), ex.getHttpStatus().getReasonPhrase(), ex.getStackTrace()[0].toString(),
				request.getRequestURI());
		logError("Error handling writing system resource", ex, request);
		return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
	}

	@ExceptionHandler(LessonException.class)
	public ResponseEntity<ErrorResponse> handleResourceLesson(LessonException ex, HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getHttpStatus().value(),
				ex.getCustomErrors(), ex.getHttpStatus().getReasonPhrase(), ex.getStackTrace()[0].toString(),
				request.getRequestURI());
		logError("Error handling lesson resource", ex, request);
		return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
	}

	// #endregion

}