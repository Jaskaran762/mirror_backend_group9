package com.group9.group09.repository;

import com.group9.group09.exception.CityNotFoundException;
import com.group9.group09.model.City;
import com.group9.group09.repository.interfaces.CityRepository;
import com.group9.group09.repository.rowmapper.CityRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

    public Optional<City> findByCityId(Integer cityId) {
        try {
            logger.info("Info Message: ");
            String findCitybyIDQuery = "SELECT * FROM Cities where City_ID = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findCitybyIDQuery, new CityRowMapper(), cityId));
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new CityNotFoundException(e.getMessage());
        }
    }

    @Override
    public Optional<City> findByCityName(String cityName) {

        try {
            logger.info("Info Message: ");
            String findCitybyNameQuery = "SELECT * FROM Cities where city = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findCitybyNameQuery, new CityRowMapper(), cityName));
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new CityNotFoundException(e.getMessage());
        }
    }

    @Override
    public List<City> getCitiesbyStateID(Integer stateID) {

        try {
            logger.info("Info Message: ");
            String getCitiesbyStateIDQuery = "SELECT * FROM Cities where state_id = ?";
            return jdbcTemplate.query(getCitiesbyStateIDQuery, new CityRowMapper(), stateID);
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new CityNotFoundException(e.getMessage());
        }

    }

    @Override
    public Optional<City> isCityPresent(String city, Integer stateID) {

        Optional<City> cityobj;
        try {

            logger.info("Info Message: checking if city already present");
            String findCity = "SELECT * FROM Cities where city = ? and state_id=?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findCity, new CityRowMapper(), city, stateID));

        } catch (DataAccessException e) {

            logger.error("Error Message: ");
            System.out.println(e.getMessage());
            throw new CityNotFoundException(e.getMessage());
        }
    }

    @Override
    public int addCity(String city, String description, Integer stateID, String weather) {
        try {
            logger.info("Info Message: in addCity method of repo ");
            String addCityQuery = "INSERT INTO Cities (`city`,`description`,state_id,`weather`) VALUES (?,?,?,?);";
            return jdbcTemplate.update(addCityQuery, city, description, stateID, weather);
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            System.out.println(e.getMessage());
            throw new CityNotFoundException(e.getMessage());
        }
    }
}
