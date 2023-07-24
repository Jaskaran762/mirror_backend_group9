package com.group9.group09.DTO.RequestDTO;

public class CountryRequestDTO extends RequestDTO {
    private String country_name;
    private String description;

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
