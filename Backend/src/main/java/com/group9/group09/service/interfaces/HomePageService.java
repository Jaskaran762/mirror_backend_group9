package com.group9.group09.service.interfaces;

import com.group9.group09.DTO.*;
import com.group9.group09.model.ItemstoCarry;

public interface HomePageService {

    /**
     * Handles the choice selector service.
     *
     * @param choice the ChoiceRequestDTO object
     * @return the ChoiceResponseDTO object
     */

    ChoiceResponseDTO choiceSelectorService(ChoiceRequestDTO choice);

    /**
     * Handles the location selector service.
     *
     * @param location the LocationRequestDTO object
     * @return the LocationResponseDTO object
     */
    LocationResponseDTO locationSelectorService(LocationRequestDTO location);

    /**
     * Handles the city selector service.
     *
     * @param city the CityRequestDTO object
     * @return the CityResponseDTO object
     */
    CityResponseDTO citySelectorService(CityRequestDTO city);

    /**
     * Handles the place selector service.
     *
     * @param placeRequestDTO the PlaceRequestDTO object
     * @return the PlaceResponseDTO object
     */
    PlaceResponseDTO placeSelectorService(PlaceRequestDTO placeRequestDTO);

    /**
     * Handles the activities service.
     *
     * @param activityRequestDTO the ActivityRequestDTO object
     * @return the ActivityResponseDTO object
     */
    ActivityResponseDTO getActivitiesService(ActivityRequestDTO activityRequestDTO);

    /**
     * Handles the items to carry service.
     *
     * @return the ItemsToCarryResponseDTO object
     */
    ItemsToCarryResponseDTO getItemstoCarry();

    /**
     * Handles the wishlist service.
     *
     * @param wishListRequestDTO the WishListRequestDTO object
     * @return the WishListResponseDTO object
     */
    WishListResponseDTO getWishListService(WishListRequestDTO wishListRequestDTO);

    /**
     * Handles the itinerary service.
     *
     * @param itineraryRequestDTO the ItineraryRequestDTO object
     * @return the ItineraryResponseDTO object
     */
    ItineraryResponseDTO getItinerary(ItineraryRequestDTO itineraryRequestDTO);
    ReviewsPlaceResponseDTO getReviewDetails(ReviewsPlaceRequestDTO reviewsPlaceRequestDTO);
}