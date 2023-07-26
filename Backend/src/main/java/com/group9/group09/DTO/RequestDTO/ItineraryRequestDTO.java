package com.group9.group09.DTO.RequestDTO;

import java.util.Date;
import java.util.List;

/**
 * Data Transfer Object for Itinerary Request.
 */
public class ItineraryRequestDTO extends RequestDTO{

    private Integer userid;
    private Integer placeid;
    private Integer activityid;
    private String startdate;
    private String enddate;

    private  String placename;
    private String activityname;

    private Integer itineraryid;

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


    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public Integer getPlaceid() {
        return placeid;
    }

    public void setPlaceid(Integer placeid) {
        this.placeid = placeid;
    }

    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }


    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
    }

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname;
    }

    public Integer getItineraryid() {
        return itineraryid;
    }

    public void setItineraryid(Integer itineraryid) {
        this.itineraryid = itineraryid;
    }
}
