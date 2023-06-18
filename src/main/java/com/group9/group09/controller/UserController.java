package com.group9.group09.controller;

import com.group9.group09.DTO.ResponseDTO;
import com.group9.group09.model.User;
import com.group9.group09.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path="/login")
    public ResponseEntity<ResponseDTO> userLogin(@RequestBody User user){

        try{
            ResponseDTO serviceResponse = userService.loginUserService(user);
            return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path="/register")
    public ResponseEntity<ResponseDTO> userRegister(@RequestBody User user){

        try{
            ResponseDTO serviceResponse = userService.registerUserService(user);
            return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
