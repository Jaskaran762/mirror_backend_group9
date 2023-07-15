package com.group9.group09.controller;

import com.group9.group09.DTO.ChoiceRequestDTO;
import com.group9.group09.DTO.ChoiceResponseDTO;
import com.group9.group09.DTO.ErrorResponse;
import com.group9.group09.DTO.LocationRequestDTO;
import com.group9.group09.service.interfaces.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/home")
@CrossOrigin
public class HomePageController {

    @Autowired
    private HomePageService homeService;

    @PostMapping(path = "/choice")
    public ResponseEntity<?> choiceSelector(@RequestBody ChoiceRequestDTO choice) {

        try {
                ChoiceResponseDTO choiceResponseDTO =  homeService.choiceSelectorService(choice);
                return new ResponseEntity<>(choiceResponseDTO, HttpStatus.OK);
        }catch (Exception e){
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Choice selector api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }

    }

    @PostMapping(path = "/location")
    public ResponseEntity<?> locationSelector(@RequestBody LocationRequestDTO location) {

        return null;
    }

    public HomePageService getHomeService() {
        return homeService;
    }

    public void setHomeService(HomePageService homeService) {
        this.homeService = homeService;
    }
}
