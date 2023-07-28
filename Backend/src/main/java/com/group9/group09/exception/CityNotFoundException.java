package com.group9.group09.exception;

public class CityNotFoundException extends RuntimeException {

    public CityNotFoundException(){super();}

    public CityNotFoundException(String message){
        super(message);
    }
}
