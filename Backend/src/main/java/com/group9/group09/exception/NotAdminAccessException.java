package com.group9.group09.exception;

public class NotAdminAccessException extends RuntimeException{
    // Constructs a new UserNotFoundException with no detail message.
    public NotAdminAccessException() {
        super();
    }

    public NotAdminAccessException(String message){ super(message);}
}
