package com.group9.group09.exception;

public class ItineraryNotFoundException extends RuntimeException{

    public ItineraryNotFoundException(){super();}

    public ItineraryNotFoundException(String message){
        super(message);
    }
}
