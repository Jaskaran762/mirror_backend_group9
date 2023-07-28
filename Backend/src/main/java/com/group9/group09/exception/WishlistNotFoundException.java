package com.group9.group09.exception;

public class WishlistNotFoundException extends RuntimeException{

    public WishlistNotFoundException(){ super();}

    public WishlistNotFoundException(String message){
        super(message);
    }
}
