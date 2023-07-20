package com.group9.group09.repository;

import com.group9.group09.model.Activity;
import com.group9.group09.repository.interfaces.ActivityRepository;
import com.group9.group09.repository.rowmapper.ActivityRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ActivityRepositoryImp implements ActivityRepository {

    private final JdbcTemplate jdbcTemplate;

    public ActivityRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Activity> findByActivityId(Integer activityID) {

        try {
            String findActivitybyIDQuery = "SELECT * FROM Activity where Activity_ID = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findActivitybyIDQuery, new ActivityRowMapper(), activityID));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional<Activity> findByActivityName(String activityName) {

        try {
            String findActivitybyNameQuery = "SELECT * FROM Activity where activit_name = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findActivitybyNameQuery, new ActivityRowMapper(), activityName));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public List<Activity> getActivitiesbyCityID(Integer cityID) {

        try {
            String getActivitiesByCityID = "SELECT * FROM Activity where city_id = ?";
            return jdbcTemplate.query(getActivitiesByCityID, new ActivityRowMapper(), cityID);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Activity> getAllActivities() {

        try {
            String getAllActivitiesQuery = "SELECT * FROM Activity";
            return jdbcTemplate.query(getAllActivitiesQuery, new ActivityRowMapper(), null);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}