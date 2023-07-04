package com.group9.group09.controller;

import com.group9.group09.DTO.ErrorResponse;
import com.group9.group09.DTO.ResponseDTO;
import com.group9.group09.exception.UserNotFoundException;
import com.group9.group09.model.User;
import com.group9.group09.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path="/login")
    public ResponseEntity<?> userLogin(@RequestBody User user){

        try{
            ResponseDTO serviceResponse = userService.loginUserService(user);
            return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
        }
        catch(Exception e){
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Login Issue");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    @PostMapping(path="/register")
    public ResponseEntity<?> userRegister(@RequestBody User user){

        try{
            ResponseDTO serviceResponse = userService.registerUserService(user);
            return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
        }
        catch(UserNotFoundException e){
            ErrorResponse response = new ErrorResponse();
            response.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
        catch(Exception e){
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Registration Issue");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }
}
