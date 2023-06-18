package com.group9.group09.exception;

import com.group9.group09.DTO.ResponseDTO;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(){
        super();
    }
    public UserNotFoundException(String rspCde){
    }
}
