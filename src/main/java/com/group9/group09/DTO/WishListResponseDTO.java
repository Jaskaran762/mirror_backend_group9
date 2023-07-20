package com.group9.group09.DTO;

import com.group9.group09.model.wishList;

import java.util.List;

public class WishListResponseDTO {

    private Integer wishlistID;
    private Integer userId;

    private List<wishList> wishLists;

    public List<wishList> getWishLists() {
        return wishLists;
    }

    public void setWishLists(List<wishList> wishLists) {
        this.wishLists = wishLists;
    }

    public Integer getWishlistID() {
        return wishlistID;
    }

    public void setWishlistID(Integer wishlistID) {
        this.wishlistID = wishlistID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    private Integer placeid;
    private Integer activityid;

}