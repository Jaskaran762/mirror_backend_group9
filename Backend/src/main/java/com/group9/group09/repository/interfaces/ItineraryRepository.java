package com.group9.group09.repository.interfaces;

import com.group9.group09.model.Itinerary;

import java.util.List;

public interface ItineraryRepository {

    List<Itinerary> getItineraryList(Integer userid);

}
