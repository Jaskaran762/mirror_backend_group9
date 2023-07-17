package com.group9.group09.model;

import java.util.Date;

public class Itinerary {
    private Integer itineraryid;
    private Integer userid;
    private Date startdate;
    private Date endDate;

    public Integer getItineraryid() {
        return itineraryid;
    }

    public void setItineraryid(Integer itineraryid) {
        this.itineraryid = itineraryid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
