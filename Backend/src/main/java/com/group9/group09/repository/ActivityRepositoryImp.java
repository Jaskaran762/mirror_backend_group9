package com.group9.group09.repository;

import com.group9.group09.model.Activity;
import com.group9.group09.repository.interfaces.ActivityRepository;
import com.group9.group09.repository.rowmapper.ActivityRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ActivityRepositoryImp implements ActivityRepository {

    private final JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactory.getLogger(ActivityRepositoryImp.class);

    public ActivityRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Activity> findByActivityId(Integer activityID) {

        try {
            logger.info("Info Message: ");
            String findActivitybyIDQuery = "SELECT * FROM Activity where Activity_ID = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findActivitybyIDQuery, new ActivityRowMapper(), activityID));
        } catch (Exception e) {
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional<Activity> findByActivityName(String activityName) {

        try {
            logger.info("Info Message: ");
            String findActivitybyNameQuery = "SELECT * FROM Activity where activit_name = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findActivitybyNameQuery, new ActivityRowMapper(), activityName));
        } catch (Exception e) {
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public List<Activity> getActivitiesbyCityID(Integer cityID) {

        try {
            logger.info("Info Message: ");
            String getActivitiesByCityID = "SELECT * FROM Activity where city_id = ?";
            return jdbcTemplate.query(getActivitiesByCityID, new ActivityRowMapper(), cityID);
        } catch (Exception e) {
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Activity> getAllActivities() {

        try {
            logger.info("Info Message: ");
            String getAllActivitiesQuery = "SELECT * FROM Activity";
            return jdbcTemplate.query(getAllActivitiesQuery, new ActivityRowMapper(), null);
        } catch (Exception e) {
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }
    }
}