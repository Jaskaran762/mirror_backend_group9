package com.group9.group09.controller;

import com.group9.group09.DTO.ChoiceRequestDTO;
import com.group9.group09.DTO.LocationRequestDTO;
import com.group9.group09.service.interfaces.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
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


        return null;

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
