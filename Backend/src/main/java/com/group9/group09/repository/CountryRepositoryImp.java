package com.group9.group09.repository;

import com.group9.group09.exception.UserNotFoundException;
import com.group9.group09.model.Country;
import com.group9.group09.repository.interfaces.CountryRepository;
import com.group9.group09.repository.rowmapper.CountryRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CountryRepositoryImp implements CountryRepository {

    private final JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactory.getLogger(CountryRepositoryImp.class);

    public CountryRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Optional<Country> findByCountryId(Integer countryID) {
        try {
            logger.info("Info Message: ");
            String findCountrybyIDQuery = "SELECT * FROM Countries where country_id = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findCountrybyIDQuery, new CountryRowMapper(), countryID));
        } catch (Exception e) {
            logger.error("Error Message: ");
            throw new UserNotFoundException("dafs");
        }

    }

    @Override
    public Optional<Country> findByCountryName(String countryName) {

        try {
            logger.info("Info Message: ");
            String findCountrybyNameQuery = "SELECT * FROM Countries where country_name = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findCountrybyNameQuery, new CountryRowMapper(), countryName));
        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e.getMessage());
            throw new UserNotFoundException();
        }
    }
}
