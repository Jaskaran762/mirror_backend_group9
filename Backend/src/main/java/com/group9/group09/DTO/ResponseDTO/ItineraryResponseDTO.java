package com.group9.group09.DTO.ResponseDTO;

import com.group9.group09.model.Itinerary;

import java.util.List;

/**
 * Data Transfer Object for Itinerary Response.
 */
public class ItineraryResponseDTO {

    private Integer userid;

    private List<Itinerary> itineraryObjectList;

    /**
     * Get the user ID from the itinerary response.
     *
     * @return the user ID
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * Set the user ID in the itinerary response.
     *
     * @param userid the user ID to set
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * Get the list of itinerary objects from the itinerary response.
     *
     * @return the list of itinerary objects
     */
    public List<Itinerary> getItineraryObjectList() {
        return itineraryObjectList;
    }

    /**
     * Set the list of itinerary objects in the itinerary response.
     *
     * @param itineraryObjectList the list of itinerary objects to set
     */
    public void setItineraryObjectList(List<Itinerary> itineraryObjectList) {
        this.itineraryObjectList = itineraryObjectList;
    }
}
