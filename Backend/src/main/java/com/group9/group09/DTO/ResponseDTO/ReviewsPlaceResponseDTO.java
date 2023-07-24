package com.group9.group09.DTO.ResponseDTO;

import com.group9.group09.model.ReviewsPlace;
import com.group9.group09.model.wishList;

import java.util.List;

public class ReviewsPlaceResponseDTO {
    private List<ReviewsPlace> reviewsPlaces;

    public List<ReviewsPlace> getReviewsPlaces() {
        return reviewsPlaces;
    }

    public void setReviewsPlaces(List<ReviewsPlace> reviewsPlaces) {
        this.reviewsPlaces = reviewsPlaces;
    }
}
