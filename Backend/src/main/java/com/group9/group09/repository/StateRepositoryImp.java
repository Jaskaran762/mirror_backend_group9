package com.group9.group09.repository;

import com.group9.group09.exception.UserNotFoundException;
import com.group9.group09.model.State;
import com.group9.group09.repository.interfaces.StateRepository;
import com.group9.group09.repository.rowmapper.StateRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StateRepositoryImp implements StateRepository {
    private final JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactory.getLogger(StateRepositoryImp.class);

    public StateRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<State> findByStateId(Integer stateId) {
        try {
            logger.info("Info Message: ");
            String findStatebyIDQuery = "SELECT * FROM States where state_id = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findStatebyIDQuery, new StateRowMapper(), stateId));
        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public Optional<State> findByStateName(String stateName) {

        try {
            logger.info("Info Message: ");
            String findStatebyNameQuery = "SELECT * FROM States where state = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findStatebyNameQuery, new StateRowMapper(), stateName));
        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public List<State> getStatesbyCountryID(Integer countryID) {

        try {
            logger.info("Info Message: ");
            String getStatesbyCountryIDQuery = "SELECT * FROM States where country_id = ?";
            return jdbcTemplate.query(getStatesbyCountryIDQuery, new StateRowMapper(), countryID);
        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override

    public int addState(String stateName, String description, int country_id) {
        try {
            logger.info("Info Message: ");
            String addStateQuery = "INSERT INTO States (`state`,`description`,country_id) VALUES (?,?,?);";
            //return jdbcTemplate.update(addCountryQuery,new CountryRowMapper(),countryName,description);
            return jdbcTemplate.update(addStateQuery, stateName, description, country_id);
        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e.getMessage());
            throw new UserNotFoundException();
        }
    }

    @Override
    public Optional<State> isStatePresent(String stateName, Integer countryid) {
        Optional<State> state;
        try {

            logger.info("Info Message: checking if state already present");
            String findState = "SELECT * FROM States where state = ? and country_id=?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findState, new StateRowMapper(), stateName, countryid));

        } catch (Exception e) {

            logger.error("Error Message: ");
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }
}