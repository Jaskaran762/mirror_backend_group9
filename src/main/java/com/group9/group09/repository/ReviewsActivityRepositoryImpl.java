package com.group9.group09.repository;

import com.group9.group09.model.ReviewsActivity;
import com.group9.group09.repository.interfaces.ReviewsActivityRepository;
import com.group9.group09.repository.rowmapper.ReviewsActivityRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ReviewsActivityRepositoryImpl implements ReviewsActivityRepository {
    private final JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactory.getLogger(ReviewsPlaceRepositoryImp.class);
    public ReviewsActivityRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ReviewsActivity> getReviewsActivitybyActivityId(Integer activityId) {
        try{
            logger.info("Info Message: ");
            String getReviewsPlaceByReviewId = "Select * from ReviewsActivity where activity_id = ?";
            return jdbcTemplate.query(getReviewsPlaceByReviewId,new ReviewsActivityRowMapper(),activityId);
        }catch (Exception e){
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }
    }
}
