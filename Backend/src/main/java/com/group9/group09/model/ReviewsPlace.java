package com.group9.group09.model;

public class ReviewsPlace {
    private Integer reviewPlaceID;
    private Integer userID;
    private Integer placeID;
    private Double rating;

    private String reviewplaceComment;

    public String getReviewplaceComment() {
        return reviewplaceComment;
    }

    public void setReviewplaceComment(String reviewplaceComment) {
        this.reviewplaceComment = reviewplaceComment;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getReviewPlaceID() {
        return reviewPlaceID;
    }

    public void setReviewPlaceID(Integer reviewPlaceID) {
        this.reviewPlaceID = reviewPlaceID;
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
}
