package com.group9.group09.DTO.RequestDTO;

/**
 * Data Transfer Object for City Request.
 */
public class CityRequestDTO extends RequestDTO {

    private Integer cityID;
    private String cityName;

    /**
     * Get the city ID from the request.
     *
     * @return the city ID
     */
    public Integer getCityID() {
        return cityID;
    }

    /**
     * Set the city ID in the request.
     *
     * @param cityID the city ID to set
     */
    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    /**
     * Get the city name from the request.
     *
     * @return the city name
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Set the city name in the request.
     *
     * @param cityName the city name to set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
