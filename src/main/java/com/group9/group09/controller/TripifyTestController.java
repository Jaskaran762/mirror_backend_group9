package com.group9.group09.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TripifyTestController {

    @GetMapping("/home")
    public String testTripify(){
        return "hello world";
    }
}
