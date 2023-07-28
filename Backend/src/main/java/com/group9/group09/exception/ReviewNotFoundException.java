package com.group9.group09.exception;

public class ReviewNotFoundException extends RuntimeException{

    public ReviewNotFoundException(){super();}

    public ReviewNotFoundException(String message){
        super(message);
    }
}
