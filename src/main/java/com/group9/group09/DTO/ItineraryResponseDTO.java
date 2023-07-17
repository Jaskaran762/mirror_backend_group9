package com.group9.group09.DTO;

import com.group9.group09.model.Itinerary;

import java.util.List;

public class ItineraryResponseDTO {

    private Integer userid;

    private List<Itinerary> itineraryObjectList;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public List<Itinerary> getItineraryObjectList() {
        return itineraryObjectList;
    }

    public void setItineraryObjectList(List<Itinerary> itineraryObjectList) {
        this.itineraryObjectList = itineraryObjectList;
    }
}
