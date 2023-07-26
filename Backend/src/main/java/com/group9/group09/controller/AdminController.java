package com.group9.group09.controller;

import com.group9.group09.DTO.RequestDTO.*;
import com.group9.group09.DTO.ResponseDTO.*;
import com.group9.group09.config.JwtService;
import com.group9.group09.exception.NotAdminAccessException;
import com.group9.group09.model.User;
import com.group9.group09.repository.interfaces.UserRepository;
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

import java.util.Optional;

@RestController
@RequestMapping(path="/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    private static Logger logger = LoggerFactory.getLogger(HomePageController.class);

    @PostMapping(path = "/addCountry")
    public ResponseEntity<?> addCountry(@RequestBody CountryRequestDTO countryRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message:");
            String token = countryRequestDTO.getToken();
            token = token.replace("Bearer ","");
            String username = jwtService.extractUsername(token);
            Optional<User> user = userRepository.findByUsermail(username);

            if(user.get().getIsadmin()==1){

            countryRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            ResponseDTO responseDTO = adminService.addCountryService(countryRequestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }else{
                throw new NotAdminAccessException("Can't Access admin level functionality");
            }

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
            logger.info("Info Message:");
            String token = stateRequestDTO.getToken();
            token = token.replace("Bearer ","");
            String username = jwtService.extractUsername(token);
            Optional<User> user = userRepository.findByUsermail(username);

            if(user.get().getIsadmin()==1){

            ResponseDTO responseDTO = adminService.addStateService(stateRequestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }
            else{
                throw new NotAdminAccessException("Can't Access admin level functionality");
            }
        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Add state admin api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    @PostMapping(path = "/addCity")
    public ResponseEntity<?> addState(@RequestBody CityRequestDTO cityRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message:'addCity method running'");

            logger.info("Info Message:");
            String token = cityRequestDTO.getToken();
            token = token.replace("Bearer ","");
            String username = jwtService.extractUsername(token);
            Optional<User> user = userRepository.findByUsermail(username);

            if(user.get().getIsadmin()==1){

            ResponseDTO responseDTO = adminService.addCityService(cityRequestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }else{
                throw new NotAdminAccessException("Can't Access admin level functionality");
            }

        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Add city admin api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }


    @PostMapping(path = "/addPlace")
    public ResponseEntity<?> addPlace(@RequestBody PlaceRequestDTO placeRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message:'addPlace method running in controller'");
            logger.info("Info Message:");
            String token = placeRequestDTO.getToken();
            token = token.replace("Bearer ","");
            String username = jwtService.extractUsername(token);
            Optional<User> user = userRepository.findByUsermail(username);

            if(user.get().getIsadmin()==1){
            ResponseDTO responseDTO = adminService.addPlaceService(placeRequestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }else{
                throw new NotAdminAccessException("Can't Access admin level functionality");
            }

        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Add palce admin api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }

    }

    @PostMapping(path = "/addActivity")
    public ResponseEntity<?> addActivity(@RequestBody ActivityRequestDTO activityRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message:'addactivity method running in controller'");

            logger.info("Info Message:");
            String token = activityRequestDTO.getToken();
            token = token.replace("Bearer ","");
            String username = jwtService.extractUsername(token);
            Optional<User> user = userRepository.findByUsermail(username);

            if(user.get().getIsadmin()==1){
            ResponseDTO responseDTO = adminService.addActivityService(activityRequestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            }else{
                throw new NotAdminAccessException("Can't Access admin level functionality");
            }

        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Add activity admin api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }
}