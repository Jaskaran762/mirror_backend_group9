package com.group9.group09.DTO.RequestDTO;

public class WishListRequestDTO extends RequestDTO{

    private Integer wishlistid;
    private Integer userid;
    private Integer placeId;
    private Integer activityId;
    private String placename;
    private String activityname;
    private String cityName;
    private Integer cityid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public Integer getWishlistid() {
        return wishlistid;
    }

    public void setWishlistid(Integer wishlistid) {
        this.wishlistid = wishlistid;
    }
}
