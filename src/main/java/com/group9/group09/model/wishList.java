package com.group9.group09.model;

import com.group9.group09.repository.PlaceRepositoryImp;
import org.springframework.security.access.prepost.PrePostInvocationAttributeFactory;

public class wishList {
    private Integer wishListID;
    private Integer userID;
    private Integer placeID;
    private Integer activityID;


    public Integer getWishListID() {
        return wishListID;
    }

    public void setWishListID(Integer wishListID) {
        this.wishListID = wishListID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getPlaceID() {
        return placeID;
    }

    public void setPlaceID(Integer placeID) {
        this.placeID = placeID;
    }

    public Integer getActivityID() {
        return activityID;
    }

    public void setActivityID(Integer activityID) {
        this.activityID = activityID;
    }
}
