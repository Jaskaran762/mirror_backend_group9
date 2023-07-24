package com.group9.group09.DTO.RequestDTO;

/**
 * Data Transfer Object for Itinerary Request.
 */
public class ItineraryRequestDTO extends RequestDTO{

    private Integer userid;

    /**
     * Get the user ID from the itinerary request.
     *
     * @return the user ID
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * Set the user ID in the itinerary request.
     *
     * @param userid the user ID to set
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
