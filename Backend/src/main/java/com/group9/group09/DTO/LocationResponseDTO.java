package com.group9.group09.DTO;

import com.group9.group09.model.City;

import java.util.List;

public class LocationResponseDTO {

    private String description;
    private List<City> cities;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
