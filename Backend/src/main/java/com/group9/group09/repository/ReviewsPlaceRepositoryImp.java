package com.group9.group09.repository;


import com.group9.group09.DTO.RequestDTO.ReviewsPlaceRequestDTO;
import com.group9.group09.Logger.LoggerFactoryImpl;
import com.group9.group09.exception.ReviewNotFoundException;
import com.group9.group09.model.ReviewsPlace;
import com.group9.group09.repository.interfaces.ReviewsPlaceRepository;
import com.group9.group09.repository.rowmapper.ReviewsPlaceRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ReviewsPlaceRepositoryImp implements ReviewsPlaceRepository{
    private final JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactoryImpl.getLogger();
    public ReviewsPlaceRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ReviewsPlace> getReviewsPlacebyPlaceId(Integer placeId) {

        try{
            logger.info("Info Message: ");
            String getReviewsPlaceByReviewId = "Select * from ReviewsPlace where place_id = ?";
            return jdbcTemplate.query(getReviewsPlaceByReviewId,new ReviewsPlaceRowMapper(),placeId);
        }catch (DataAccessException e){
            logger.error("Error Message: ");
            throw new ReviewNotFoundException(e.getMessage());
        }
    }

    @Override
    public int addReviewplace(ReviewsPlaceRequestDTO reviewsPlaceRequestDTO) {


        if (reviewsPlaceRequestDTO.getActivity_id() == null) {

            try {
                logger.info("Info Message: in ReviewsPlaceRepositoryImp addreviewplace");
                String addReviewsPlace = "INSERT INTO ReviewsPlace (user_id,rating,place_id,`review_message`) VALUES(?,?,?,?);";
                return jdbcTemplate.update(addReviewsPlace, reviewsPlaceRequestDTO.getUserid(), reviewsPlaceRequestDTO.getRating(), reviewsPlaceRequestDTO.getPlace_id(), reviewsPlaceRequestDTO.getReview_message());
            } catch (DataAccessException e) {
                logger.error("Error Message:issue in review place repo ");
                throw new ReviewNotFoundException(e.getMessage());
            }

        } else if (reviewsPlaceRequestDTO.getPlace_id() == null) {
            try {
                logger.info("Info Message: in ReviewsPlaceRepositoryImp addreviewpactivity ");
                String addReviewsactivity = "INSERT INTO ReviewsActivity (user_id,rating,activity_id,`review_message`) VALUES(?,?,?,?);";
                return jdbcTemplate.update(addReviewsactivity, reviewsPlaceRequestDTO.getUserid(), reviewsPlaceRequestDTO.getRating(), reviewsPlaceRequestDTO.getActivity_id(), reviewsPlaceRequestDTO.getReview_message());
            } catch (DataAccessException e) {
                logger.error("Error Message:issue in review place repo ");
                throw new ReviewNotFoundException(e.getMessage());
            }
        } else{
            return -1;
        }
    }
}
