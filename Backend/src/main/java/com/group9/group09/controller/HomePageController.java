package com.group9.group09.controller;

import com.group9.group09.DTO.ResponseDTO.*;
import com.group9.group09.service.interfaces.HomePageService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/home")
@CrossOrigin(origins = "http://localhost:3000")
public class HomePageController {

    @Autowired
    private HomePageService homeService;

    private static Logger logger = LoggerFactory.getLogger(HomePageController.class);
    /**
     * Handles the choice selection request.
     *
     * @param choice  the ChoiceRequestDTO object
     * @param request the HttpServletRequest object
     * @return the ResponseEntity containing the ChoiceResponseDTO object
     */
    @PostMapping(path = "/choice")
    public ResponseEntity<?> choiceSelector(@RequestBody ChoiceRequestDTO choice, HttpServletRequest request) {
        try {
            logger.info("Info Message: ");
            choice.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            ChoiceResponseDTO choiceResponseDTO = homeService.choiceSelectorService(choice);
            return new ResponseEntity<>(choiceResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Choice selector api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    /**
     * Handles the location selection request.
     *
     * @param location the LocationRequestDTO object
     * @param request  the HttpServletRequest object
     * @return the ResponseEntity containing the LocationResponseDTO object
     */
    @PostMapping(path = "/location")
    public ResponseEntity<?> locationSelector(@RequestBody LocationRequestDTO location, HttpServletRequest request) {
        try {
            logger.info("Info Message: ");
            location.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            LocationResponseDTO locationResponseDTO = homeService.locationSelectorService(location);
            return new ResponseEntity<>(locationResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");
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


    /**
     * Handles the city selection request.
     *
     * @param city    the CityRequestDTO object
     * @param request the HttpServletRequest object
     * @return the ResponseEntity containing the CityResponseDTO object
     */
    @PostMapping(path = "/city")
    public ResponseEntity<?> citySelector(@RequestBody CityRequestDTO city, HttpServletRequest request) {
        try {
            logger.info("Info Message: ");
            city.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            CityResponseDTO cityResponseDTO = homeService.citySelectorService(city);
            return new ResponseEntity<>(cityResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("city selector api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    /**
     * Handles the place selection request.
     *
     * @param placeRequestDTO the PlaceRequestDTO object
     * @param request         the HttpServletRequest object
     * @return the ResponseEntity containing the PlaceResponseDTO object
     */
    @PostMapping(path = "/place")
    public ResponseEntity<?> placeSelector(@RequestBody PlaceRequestDTO placeRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message: ");
            placeRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            PlaceResponseDTO placeResponseDTO = homeService.placeSelectorService(placeRequestDTO);
            return new ResponseEntity<>(placeResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("place selector api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    /**
     * Handles the activities request.
     *
     * @param activityRequestDTO the ActivityRequestDTO object
     * @param request            the HttpServletRequest object
     * @return the ResponseEntity containing the ActivityResponseDTO object
     */
    @PostMapping(path = "/activities")
    public ResponseEntity<?> getActivities(@RequestBody ActivityRequestDTO activityRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message: ");
            activityRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            ActivityResponseDTO activityResponseDTO = homeService.getActivitiesService(activityRequestDTO);
            return new ResponseEntity<>(activityResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("activity response selector api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    /**
     * Handles the wishlist request.
     *
     * @param wishListRequestDTO the WishListRequestDTO object
     * @param request            the HttpServletRequest object
     * @return the ResponseEntity containing the WishListResponseDTO object
     */
    @PostMapping(path = "/wishlist")
    public ResponseEntity<?> getWishList(@RequestBody WishListRequestDTO wishListRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message: ");
            wishListRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            WishListResponseDTO wishListResponseDTO = homeService.getWishListService(wishListRequestDTO);
            return new ResponseEntity<>(wishListResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("wishlist api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    /**
     * Handles the itinerary request.
     *
     * @param itineraryRequestDTO the ItineraryRequestDTO object
     * @param request             the HttpServletRequest object
     * @return the ResponseEntity containing the ItineraryResponseDTO object
     */
    @PostMapping(path = "/itinerary")
    public ResponseEntity<?> getItinerary(@RequestBody ItineraryRequestDTO itineraryRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message: ");
            itineraryRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            ItineraryResponseDTO itineraryResponseDTO = homeService.getItinerary(itineraryRequestDTO);
            return new ResponseEntity<>(itineraryResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("itinerary api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    @PostMapping(path = "/reviewplace")
    public ResponseEntity<?> getReviewPlace(@RequestBody ReviewsPlaceRequestDTO reviewsPlaceRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message: ");
            reviewsPlaceRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            ReviewsPlaceResponseDTO reviewsPlaceResponseDTO  = homeService.getReviewDetails(reviewsPlaceRequestDTO);
            return new ResponseEntity<>(reviewsPlaceResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("review place api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    @PostMapping(path = "/reviewactivity")
    public ResponseEntity<?> getReviewActiviyy(@RequestBody ReviewsActivityRequestDTO reviewsActivityRequestDTO, HttpServletRequest request) {
        try {
            logger.info("Info Message: ");
            reviewsActivityRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            ReviewsActivityResponseDTO reviewsActivityResponseDTO = homeService.getReviewActivityDetails(reviewsActivityRequestDTO);
            return new ResponseEntity<>(reviewsActivityResponseDTO, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("review activity api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }


    @PostMapping(path = "/itemstocarry")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> getItemstoCarry(@RequestBody ItemstoCarryRequestDTO itemstoCarryRequestDTO, HttpServletRequest request) {
        try {
            itemstoCarryRequestDTO.setToken(request.getHeader("Authorization").replace("Bearer ", ""));
            ItemsToCarryResponseDTO itemsToCarryResponseDTO =  homeService.getItemstoCarry();
            return new ResponseEntity<>(itemsToCarryResponseDTO, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            ErrorResponse response = new ErrorResponse();
            response.setMessage("Items to carry  api failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
    }

    public HomePageService getHomeService() {
        return homeService;
    }

    public void setHomeService(HomePageService homeService) {
        this.homeService = homeService;
    }
}
