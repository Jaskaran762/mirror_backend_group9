package com.group9.group09.controller;

import com.group9.group09.DTO.RequestDTO.RequestDTO;
import com.group9.group09.DTO.RequestDTO.UserProfileRequestDTO;
import com.group9.group09.DTO.ResponseDTO.ErrorResponse;
import com.group9.group09.DTO.ResponseDTO.RecommendationResponseDTO;
import com.group9.group09.DTO.ResponseDTO.ResponseDTO;
import com.group9.group09.DTO.ResponseDTO.UserProfileResponseDTO;
import com.group9.group09.service.interfaces.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserProfileController {

    @Autowired
    private UserService userService;

    private static Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping(path = "/getProfile")
    public ResponseEntity<?> getUserDetails(@RequestBody RequestDTO requestDTO, HttpServletRequest request) {

        try {
            requestDTO.setToken(request.getHeader("Authorization"));
            UserProfileResponseDTO responseDTO =
                    userService.getUserDetails(requestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }
        catch (Exception e){
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage("some issue");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    @PostMapping(path = "/setProfile")
    public ResponseEntity<?> setUserDetails(@RequestBody UserProfileRequestDTO requestDTO, HttpServletRequest request) {

        try {
            requestDTO.setToken(request.getHeader("Authorization"));
            ResponseDTO responseDTO =
                    userService.setUserDetails(requestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        }
        catch (Exception e){
            logger.error("Error Message: ");
            ErrorResponse response = new ErrorResponse();
            response.setMessage("some issue");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }
}
