package com.group9.group09.repository;

import com.group9.group09.model.State;
import com.group9.group09.repository.interfaces.StateRepository;
import com.group9.group09.repository.rowmapper.StateRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StateRepositoryImp implements StateRepository {
    private final JdbcTemplate jdbcTemplate;

    public StateRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<State> findByStateId(Integer stateId) {
        try {
            String findStatebyIDQuery = "SELECT * FROM States where state_id = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findStatebyIDQuery, new StateRowMapper(), stateId));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public Optional<State> findByStateName(String stateName) {

        try {
            String findStatebyNameQuery = "SELECT * FROM States where state = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findStatebyNameQuery, new StateRowMapper(), stateName));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    @Override
    public List<State> getStatesbyCountryID(Integer countryID) {

        try {
            String getStatesbyCountryIDQuery = "SELECT * FROM States where country_id = ?";
            return jdbcTemplate.query(getStatesbyCountryIDQuery, new StateRowMapper(), countryID);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }
}