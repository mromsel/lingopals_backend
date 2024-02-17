package com.romsel.lingopal_backend.application.exceptions;

public class ExceptionMessages {

    // Private constructor to prevent instantiation
    private ExceptionMessages() {
        throw new AssertionError(); // Throw an exception to avoid instantiation within the class
    }

    public static final String GENERIC_MESSAGE_ERROR = "A generic error occurred";

    public static final String WORD_REFERENCE_NOT_FOUND = "The Word Reference with that ID does not exist in the database";
    public static final String WORD_REFERENCE_UPDATE_ERROR = "Error updating Word Reference";
    public static final String WORD_REFERENCE_UPDATE_NOT_FOUND = "Error updating Word Reference because it does not exist in the database";
    public static final String WORD_REFERENCE_DELETE_ERROR = "Error deleting Word Reference";

    public static final String WORD_NOT_FOUND = "The Word with that ID does not exist in the database";
    public static final String WORD_UPDATE_ERROR = "Error updating Word";
    public static final String WORD_UPDATE_NOT_FOUND = "Error updating Word because it does not exist in the database";
    public static final String WORD_DELETE_ERROR = "Error deleting Word";

    public static final String WORD_ADDITIONAL_INFO_NOT_FOUND = "The Word Additional Info with that ID does not exist in the database";
    public static final String WORD_ADDITIONAL_INFO_UPDATE_ERROR = "Error updating Word Additional Info";
    public static final String WORD_ADDITIONAL_INFO_UPDATE_NOT_FOUND = "Error updating Word Additional Info because it does not exist in the database";
    public static final String WORD_ADDITIONAL_INFO_DELETE_ERROR = "Error deleting Word Additional Info";

    public static final String LANGUAGE_NOT_FOUND = "The Language with that ID does not exist in the database";
    public static final String LANGUAGE_UPDATE_ERROR = "Error updating Language";
    public static final String LANGUAGE_UPDATE_NOT_FOUND = "Error updating Language because it does not exist in the database";
    public static final String LANGUAGE_DELETE_ERROR = "Error deleting Language";

    public static final String LANGUAGE_LEVEL_NOT_FOUND = "The Language Level with that ID does not exist in the database";
    public static final String LANGUAGE_LEVEL_UPDATE_ERROR = "Error updating Language Level";
    public static final String LANGUAGE_LEVEL_UPDATE_NOT_FOUND = "Error updating Language Level because it does not exist in the database";
    public static final String LANGUAGE_LEVEL_DELETE_ERROR = "Error deleting Language Level";

    public static final String CATEGORY_NOT_FOUND = "The Category with that ID does not exist in the database";
    public static final String CATEGORY_UPDATE_ERROR = "Error updating Category";
    public static final String CATEGORY_UPDATE_NOT_FOUND = "Error updating Category because it does not exist in the database";
    public static final String CATEGORY_DELETE_ERROR = "Error deleting Category";

    public static final String WRITING_SYSTEM_NOT_FOUND = "The Writing System with that ID does not exist in the database";
    public static final String WRITING_SYSTEM_UPDATE_ERROR = "Error updating Writing System";
    public static final String WRITING_SYSTEM_UPDATE_NOT_FOUND = "Error updating Writing System because it does not exist in the database";
    public static final String WRITING_SYSTEM_DELETE_ERROR = "Error deleting Writing System";

    public static final String LESSON_NOT_FOUND = "The Lesson with that ID does not exist in the database";
    public static final String LESSON_UPDATE_ERROR = "Error updating Lesson";
    public static final String LESSON_UPDATE_NOT_FOUND = "Error updating Lesson because it does not exist in the database";
    public static final String LESSON_DELETE_ERROR = "Error deleting Lesson";

}
