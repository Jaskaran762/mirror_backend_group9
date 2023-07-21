package com.group9.group09.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TripifyTestController {

    /**
     * Handles the GET request to the "/home" endpoint.
     *
     * @return a string response indicating whether it is working or not
     */

    @GetMapping("/home")
    public String testTripify() {
        return "hello world, is it working still";
    }

}
