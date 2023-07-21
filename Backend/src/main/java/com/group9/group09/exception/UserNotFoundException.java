package com.group9.group09.exception;

// Custom exception class for user not found.
public class UserNotFoundException extends RuntimeException {

    // Constructs a new UserNotFoundException with no detail message.
    public UserNotFoundException() {
        super();
    }

    /**
     * Constructs a new UserNotFoundException with the specified detail message.
     *
     * @param rspCde the error response code
     */
    public UserNotFoundException(String rspCde) {
    }
}