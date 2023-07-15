package com.group9.group09.repository.interfaces;

import com.group9.group09.model.City;
import com.group9.group09.model.State;

import java.util.List;
import java.util.Optional;

public interface CityRepository {
    Optional<City> findByCityId(Integer cityID);
    Optional<City> findByCityName(String cityName);

    List<City> getCitiesbyStateID(Integer stateID);

}
