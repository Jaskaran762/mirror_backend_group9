package com.group9.group09.exception;

public class ItemNotFoundException extends RuntimeException{

    public ItemNotFoundException(){super();}

    public ItemNotFoundException(String message){
        super(message);
    }
}
