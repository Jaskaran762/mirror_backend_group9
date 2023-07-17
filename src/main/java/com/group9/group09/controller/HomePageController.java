package com.group9.group09.controller;

import com.group9.group09.DTO.*;
import com.group9.group09.service.interfaces.HomePageService;
import jakarta.servlet.http.HttpServletRequest;
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
    public ResponseEntity<?> choiceSelector(@RequestBody ChoiceRequestDTO choice, HttpServletRequest request) {
         try {
                choice.setToken(request.getHeader("Authorization").replace("Bearer ",""));
                ChoiceResponseDTO choiceResponseDTO =  homeService.choiceSelectorService(choice);
                return new ResponseEntity<>(choiceResponseDTO, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Choice selector api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    @PostMapping(path = "/location")
    public ResponseEntity<?> locationSelector(@RequestBody LocationRequestDTO location, HttpServletRequest request) {
        try {
            location.setToken(request.getHeader("Authorization").replace("Bearer ",""));
            LocationResponseDTO locationResponseDTO =  homeService.locationSelectorService(location);
            return new ResponseEntity<>(locationResponseDTO, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("location selector api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

   /* @PostMapping(path = "/city")
    public ResponseEntity<?> citySelector(@RequestBody CityRequestDTO city, HttpServletRequest request) {
        try {
            city.setToken(request.getHeader("Authorization").replace("Bearer ",""));
            CityResponseDTO cityResponseDTO =  homeService.citySelectorService(city);
            return new ResponseEntity<>(cityResponseDTO, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("city selector api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }*/


    @PostMapping(path = "/city")
    public ResponseEntity<?> citySelector(@RequestBody CityRequestDTO city, HttpServletRequest request) {
        try {
            city.setToken(request.getHeader("Authorization").replace("Bearer ",""));
            CityResponseDTO cityResponseDTO =  homeService.citySelectorService(city);
            return new ResponseEntity<>(cityResponseDTO, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("city selector api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

     @PostMapping(path = "/place")
    public ResponseEntity<?> placeSelector(@RequestBody PlaceRequestDTO placeRequestDTO, HttpServletRequest request) {
        try {
            placeRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ",""));
            PlaceResponseDTO placeResponseDTO =  homeService.placeSelectorService(placeRequestDTO);
            return new ResponseEntity<>(placeResponseDTO, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("place selector api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    @PostMapping(path = "/activities")
    public ResponseEntity<?> getActivities(@RequestBody ActivityRequestDTO activityRequestDTO, HttpServletRequest request) {
        try {
            activityRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ",""));
            ActivityResponseDTO activityResponseDTO =  homeService.getActivitiesService(activityRequestDTO);
            return new ResponseEntity<>(activityResponseDTO, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("activity response selector api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    @PostMapping(path = "/wishlist")
    public ResponseEntity<?> getWishList(@RequestBody WishListRequestDTO wishListRequestDTO, HttpServletRequest request) {
        try {
            wishListRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ",""));
            WishListResponseDTO wishListResponseDTO =  homeService.getWishListService(wishListRequestDTO);
            return new ResponseEntity<>(wishListResponseDTO, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("wishlist api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    //@PostMapping(path = "/activity/{activityId}")
   /* @GetMapping(path = "/itemstocarry")
    public ResponseEntity<?> getItemstoCarry() {
        try {
            ItemsToCarryResponseDTO itemsToCarryResponseDTO =  homeService.getItemstoCarry();
            return new ResponseEntity<>(itemsToCarryResponseDTO, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Items to carry  api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }*/

    public HomePageService getHomeService() {
        return homeService;
    }

    public void setHomeService(HomePageService homeService) {
        this.homeService = homeService;
    }
}
