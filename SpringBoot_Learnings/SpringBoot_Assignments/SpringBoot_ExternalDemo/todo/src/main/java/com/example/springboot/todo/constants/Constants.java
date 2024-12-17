package com.example.springboot.todo.constants;

public class Constants {

    // API Version
    public static final String API_VERSION = "/api/v1/todos";

    // Validation messages
    public static final String DESCRIPTION_NOT_BLANK = "Description must not be empty";
    public static final String DESCRIPTION_SIZE = "Description must be between 3 and 255 characters";
    public static final String GROUP_ID_NOT_NULL = "Group ID must not be null";
    public static final String IS_DONE_NOT_BLANK = "IsDone must not be empty";
    public static final String IS_DONE_PATTERN = "isDone must be 'done' or 'pending'";

    // Error messages
    public static final String GROUP_NOT_FOUND = "Group not found with ID: ";
    public static final String TASK_NOT_FOUND = "Task not found with ID: ";
    public static final String TASK_DELETED_SUCCESS = "Task deleted successfully";

    // Task related messages
    public static final String TASK_NOT_FOUND_BY_ID = "Task with ID ";
    public static final String TASK_NOT_FOUND_SUFFIX = " not found";
}
