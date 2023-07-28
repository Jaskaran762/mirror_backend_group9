package com.group9.group09.exception;

public class ActivityNotFoundException extends RuntimeException{

    public ActivityNotFoundException(){super();}

    public ActivityNotFoundException(String message){
        super(message);
    }
}
