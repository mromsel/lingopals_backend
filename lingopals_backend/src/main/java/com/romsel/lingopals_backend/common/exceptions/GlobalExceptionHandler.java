package com.romsel.lingopals_backend.common.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.romsel.lingopals_backend.auth.domain.LoginException;
import com.romsel.lingopals_backend.masters.language_levels.domain.LanguageLevelException;
import com.romsel.lingopals_backend.masters.languages.domain.LanguageException;
import com.romsel.lingopals_backend.masters.writing_systems.domain.WritingSystemException;
import com.romsel.lingopals_backend.masters.xp_levels.domain.XPLevelException;
import com.romsel.lingopals_backend.users_related.users.domain.UserException;
import com.romsel.lingopals_backend.users_related.users_activity.domain.UserActivityException;
import com.romsel.lingopals_backend.users_related.users_completed_lessons.domain.UserCompletedLessonsException;
import com.romsel.lingopals_backend.users_related.users_languages.domain.UserLanguagesException;
import com.romsel.lingopals_backend.users_related.users_progress.domain.UserProgressDataException;
import com.romsel.lingopals_backend.words_related.categories.domain.CategoryException;
import com.romsel.lingopals_backend.words_related.lessons.domain.LessonException;
import com.romsel.lingopals_backend.words_related.word_references.domain.WordReferenceException;
import com.romsel.lingopals_backend.words_related.words.domain.WordException;

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

	@ExceptionHandler(BaseException.class)
	public ResponseEntity<ErrorResponse> handleResourceBase(BaseException ex,
			HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getHttpStatus().value(),
				ex.getCustomErrors(), ex.getHttpStatus().getReasonPhrase(), ex.getStackTrace()[0].toString(),
				request.getRequestURI());
		logError("Error handling xp level resource", ex, request);
		return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
	}

	// #region Auth Exceptions

	@ExceptionHandler(LoginException.class)
	public ResponseEntity<ErrorResponse> handleLogin(LoginException ex,
			HttpServletRequest request) {
		HttpStatus exHttpStatus = HttpStatus.UNAUTHORIZED;
		ErrorResponse errorResponse = new ErrorResponse(exHttpStatus.value(),
				ex.getCustomErrors(), exHttpStatus.getReasonPhrase(), ex.getStackTrace()[0].toString(),
				request.getRequestURI());
		logError("Error in login", ex, request);
		return new ResponseEntity<>(errorResponse, exHttpStatus);
	}

	// #endregion

	// #region Masters Exception

	@ExceptionHandler(XPLevelException.class)
	public ResponseEntity<ErrorResponse> handleResourceXpLevel(XPLevelException ex,
			HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getHttpStatus().value(),
				ex.getCustomErrors(), ex.getHttpStatus().getReasonPhrase(), ex.getStackTrace()[0].toString(),
				request.getRequestURI());
		logError("Error handling xp level resource", ex, request);
		return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
	}

	// #endregion

	// #region Words-related entities Exceptions

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

	// #region Users-related entities Exceptions

	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorResponse> handleResourceUser(UserException ex, HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getHttpStatus().value(),
				ex.getCustomErrors(), ex.getHttpStatus().getReasonPhrase(), ex.getStackTrace()[0].toString(),
				request.getRequestURI());
		logError("Error handling user resource", ex, request);
		return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
	}

	@ExceptionHandler(UserActivityException.class)
	public ResponseEntity<ErrorResponse> handleResourceUserActivity(UserActivityException ex,
			HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getHttpStatus().value(),
				ex.getCustomErrors(), ex.getHttpStatus().getReasonPhrase(), ex.getStackTrace()[0].toString(),
				request.getRequestURI());
		logError("Error handling user-activity resource", ex, request);
		return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
	}

	@ExceptionHandler(UserCompletedLessonsException.class)
	public ResponseEntity<ErrorResponse> handleResourceUserLessons(UserCompletedLessonsException ex,
			HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getHttpStatus().value(),
				ex.getCustomErrors(), ex.getHttpStatus().getReasonPhrase(), ex.getStackTrace()[0].toString(),
				request.getRequestURI());
		logError("Error handling user-lessons resource", ex, request);
		return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
	}

	@ExceptionHandler(UserProgressDataException.class)
	public ResponseEntity<ErrorResponse> handleResourceUserProgress(UserProgressDataException ex,
			HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getHttpStatus().value(),
				ex.getCustomErrors(), ex.getHttpStatus().getReasonPhrase(), ex.getStackTrace()[0].toString(),
				request.getRequestURI());
		logError("Error handling user-progress resource", ex, request);
		return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
	}

	@ExceptionHandler(UserLanguagesException.class)
	public ResponseEntity<ErrorResponse> handleResourceUserLanguages(UserLanguagesException ex,
			HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getHttpStatus().value(),
				ex.getCustomErrors(), ex.getHttpStatus().getReasonPhrase(), ex.getStackTrace()[0].toString(),
				request.getRequestURI());
		logError("Error handling user-languages resource", ex, request);
		return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
	}

	// #endregion
}
