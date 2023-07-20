package com.group9.group09.repository;


import com.group9.group09.model.ReviewsPlace;
import com.group9.group09.repository.interfaces.ReviewsPlaceRepository;
import com.group9.group09.repository.rowmapper.ReviewsPlaceRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ReviewsPlaceRepositoryImp implements ReviewsPlaceRepository{
    private final JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactory.getLogger(ReviewsPlaceRepositoryImp.class);
    public ReviewsPlaceRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ReviewsPlace> getReviewsPlacebyUserId(Integer placeId) {

        try{
            logger.info("Info Message: ");
            String getReviewsPlaceByReviewId = "Select * from ReviewsPlace where place_id = ?";
            return jdbcTemplate.query(getReviewsPlaceByReviewId,new ReviewsPlaceRowMapper(),placeId);
        }catch (Exception e){
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }
    }
}
