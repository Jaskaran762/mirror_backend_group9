package com.group9.group09.controller;

import com.group9.group09.DTO.ErrorResponse;
import com.group9.group09.DTO.RecommendationResponseDTO;
import com.group9.group09.DTO.RequestDTO;
import com.group9.group09.service.interfaces.RecommendationService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class to handle user-recommendations operations.
 */
@RestController
@CrossOrigin
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping(path = "/recommendation")
    public ResponseEntity<?> getRecommendations(@RequestBody RequestDTO requestDTO, HttpServletRequest request){

        try {
            requestDTO.setToken(request.getHeader("Authorization"));
            RecommendationResponseDTO responseDTO =
                    recommendationService.getUserRecommendationsBasedOnInterests(requestDTO);
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
