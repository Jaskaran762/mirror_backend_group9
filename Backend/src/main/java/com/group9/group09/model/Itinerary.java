package com.group9.group09.model;

import javax.xml.transform.sax.SAXResult;
import java.util.Date;

public class Itinerary {
    private Integer itineraryid;
    private Integer userid;
    private Date startdate;
    private Date endDate;
    private String placename;
    private String activityname;

    /**
     * Get the ID of the itinerary.
     *
     * @return the itineraryid
     */
    public Integer getItineraryid() {
        return itineraryid;
    }

    /**
     * Set the ID of the itinerary.
     *
     * @param itineraryid the itineraryid to set
     */
    public void setItineraryid(Integer itineraryid) {
        this.itineraryid = itineraryid;
    }

    /**
     * Get the ID of the user.
     *
     * @return the userid
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * Set the ID of the user.
     *
     * @param userid the userid to set
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * Get the start date of the itinerary.
     *
     * @return the startdate
     */
    public Date getStartdate() {
        return startdate;
    }

    /**
     * Set the start date of the itinerary.
     *
     * @param startdate the startdate to set
     */
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    /**
     * Get the end date of the itinerary.
     *
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Set the end date of the itinerary.
     *
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
}
