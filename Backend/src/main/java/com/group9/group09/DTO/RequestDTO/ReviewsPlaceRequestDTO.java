package com.group9.group09.DTO.RequestDTO;

public class ReviewsPlaceRequestDTO extends RequestDTO{

    private Integer user_id;
    private Integer rating;
    private Integer place_id;
    private String review_message;

    public Integer getPlace_id() {
        return place_id;
    }

    public void setPlace_id(Integer place_id) {
        this.place_id = place_id;
    }

    public Integer getUserid() {
        return user_id;
    }

    public void setUserid(Integer userid) {
        this.user_id = userid;
    }

    public String getReview_message() {
        return review_message;
    }

    public void setReview_message(String review_message) {
        this.review_message = review_message;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
