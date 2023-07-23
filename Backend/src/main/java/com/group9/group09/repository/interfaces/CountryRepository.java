package com.group9.group09.repository.interfaces;

import com.group9.group09.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryRepository {

    Optional<Country> findByCountryId(Integer countryID);
    Optional<Country> findByCountryName(String countryName);

    List<Country> getCountries();
}
