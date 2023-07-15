package com.group9.group09.repository;

import com.group9.group09.exception.UserNotFoundException;
import com.group9.group09.model.Country;
import com.group9.group09.repository.interfaces.CountryRepository;
import com.group9.group09.repository.rowmapper.CountryRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CountryRepositoryImp implements CountryRepository {

    private final JdbcTemplate jdbcTemplate;

    public CountryRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Optional<Country> findByCountryId(Integer countryID) {
        try {
            String findCountrybyIDQuery = "SELECT * FROM Country where country_id = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findCountrybyIDQuery, new CountryRowMapper(), countryID));
        } catch (Exception e) {
            throw new UserNotFoundException("dafs");
        }

    }

    @Override
    public Optional<Country> findByCountryName(String countryName) {

        try {
            String findCountrybyNameQuery = "SELECT * FROM Country where country_name = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(findCountrybyNameQuery, new CountryRowMapper(), countryName));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new UserNotFoundException();
        }
    }
}
