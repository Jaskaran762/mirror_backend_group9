package com.group9.group09.exception;

public class CountryNotFoundException extends RuntimeException{

    public CountryNotFoundException(){super();}

    public CountryNotFoundException(String message){
        super(message);
    }
}
