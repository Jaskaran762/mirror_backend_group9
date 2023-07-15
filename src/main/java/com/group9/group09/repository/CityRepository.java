package com.group9.group09.repository;

import com.group9.group09.exception.UserNotFoundException;
import com.group9.group09.model.City;
import com.group9.group09.model.User;
import com.group9.group09.repository.rowmapper.CityRowMapper;
import com.group9.group09.repository.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

public class CityRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CityRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<City> findByCityId(Integer cityId){
        try {
            String sql = "SELECT * FROM Cities where City_ID = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new CityRowMapper(), cityId));
        } catch (Exception e) {
            throw new RuntimeException("dafs");
        }
    }
}
