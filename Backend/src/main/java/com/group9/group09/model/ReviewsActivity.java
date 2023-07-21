package com.group9.group09.model;

public class ReviewsActivity {
    private Integer reviewActivityID;
    private Integer userID;
    private Integer activityId;
    private Double rating;

    private String reviewactivityComment;

    public Integer getReviewActivityID() {
        return reviewActivityID;
    }

    public void setReviewActivityID(Integer reviewActivityID) {
        this.reviewActivityID = reviewActivityID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getReviewactivityComment() {
        return reviewactivityComment;
    }

    public void setReviewactivityComment(String reviewactivityComment) {
        this.reviewactivityComment = reviewactivityComment;
    }
}
