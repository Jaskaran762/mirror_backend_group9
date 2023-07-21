package com.group9.group09.repository;

import com.group9.group09.model.City;
import com.group9.group09.repository.interfaces.CityRepository;
import com.group9.group09.repository.rowmapper.CityRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CityRepositoryImp implements CityRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CityRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static Logger logger = LoggerFactory.getLogger(CityRepositoryImp.class);

    public Optional<City> findByCityId(Integer cityId){
        try {
            logger.info("Info Message: ");
            String findCitybyIDQuery = "SELECT * FROM Cities where City_ID = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findCitybyIDQuery, new CityRowMapper(), cityId));
        } catch (Exception e) {
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional<City> findByCityName(String cityName) {

        try {
            logger.info("Info Message: ");
            String findCitybyNameQuery = "SELECT * FROM Cities where city = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findCitybyNameQuery, new CityRowMapper(), cityName));
        } catch (Exception e) {
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<City> getCitiesbyStateID(Integer stateID) {

        try {
            logger.info("Info Message: ");
            String getCitiesbyStateIDQuery = "SELECT * FROM Cities where state_id = ?";
            return jdbcTemplate.query(getCitiesbyStateIDQuery, new CityRowMapper(), stateID);
        } catch (Exception e) {
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }

    }

}
