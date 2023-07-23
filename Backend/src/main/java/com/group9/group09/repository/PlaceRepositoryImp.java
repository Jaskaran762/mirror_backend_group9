package com.group9.group09.repository;

import com.group9.group09.model.Place;
import com.group9.group09.repository.interfaces.PlaceRepository;
import com.group9.group09.repository.rowmapper.PlaceRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlaceRepositoryImp implements PlaceRepository {
    private final JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactory.getLogger(PlaceRepositoryImp.class);
    public PlaceRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Place> findByPlaceId(Integer placeID) {

        try{
            logger.info("Info Message: ");
            String findPlaceByIDQuery = "SELECT * FROM Places where place_id=?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findPlaceByIDQuery,new PlaceRowMapper(),placeID));
        }catch (Exception e){
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public Optional<Place> findByPlaceName(String placeName) {

        try{
            logger.info("Info Message: ");
            String findPlaceByNameQuery = "SELECT * FROM Places where place_id=?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findPlaceByNameQuery,new PlaceRowMapper(),placeName));
        }catch (Exception e){
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public List<Place> getPlacesbyCityID(Integer cityID) {
        try{
            logger.info("Info Message: ");
            String getPlacesbyCityID = "SELECT * FROM Places where city_id=?";
            return jdbcTemplate.query(getPlacesbyCityID,new PlaceRowMapper(),cityID);
        }catch (Exception e){
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Place> getPlacesByInterest(String interest){
        try{
            logger.info("Info Message: ");
            String getPlacesByInterest = "SELECT * FROM Places where interest like CONCAT('%', ?, '%')";
            return jdbcTemplate.query(getPlacesByInterest, new PlaceRowMapper(), interest);
        }
        catch (Exception e){
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }
    }
}
