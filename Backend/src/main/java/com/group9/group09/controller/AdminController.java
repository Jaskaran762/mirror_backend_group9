package com.group9.group09.controller;

import com.group9.group09.DTO.RequestDTO.*;
import com.group9.group09.DTO.ResponseDTO.*;
import com.group9.group09.service.interfaces.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    private static Logger logger = LoggerFactory.getLogger(HomePageController.class);

    @PostMapping(path = "/addCountry")
    public ResponseEntity<?> addCountry(@RequestBody CountryRequestDTO countryRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message:");
            countryRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            ResponseDTO responseDTO = adminService.addCountryService(countryRequestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Add country admin api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    @PostMapping(path = "/addState")
    public ResponseEntity<?> addState(@RequestBody StateRequestDTO stateRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message:'addState method running'");
            ResponseDTO responseDTO = adminService.addStateService(stateRequestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Add state admin api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }
}