package com.group9.group09.repository.interfaces;

import com.group9.group09.model.Place;

import java.util.List;
import java.util.Optional;

public interface PlaceRepository {

    Optional<Place> findByPlaceId(Integer placeID);
    Optional<Place> findByPlaceName(String placeName);

    List<Place> getPlacesbyCityID(Integer cityID);
    List<Place> getPlacesByInterest(String interest);

}