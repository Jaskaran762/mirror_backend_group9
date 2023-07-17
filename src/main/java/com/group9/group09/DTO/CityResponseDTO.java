package com.group9.group09.DTO;

import com.group9.group09.model.Place;

import java.util.List;

public class CityResponseDTO {

    private Integer cityID;
    private String cityName;
    private String description;

    private List<String> placeResponseList;

    public List<Place> getPlaceObjectResponseList() {
        return placeObjectResponseList;
    }

    public void setPlaceObjectResponseList(List<Place> placeObjectResponseList) {
        this.placeObjectResponseList = placeObjectResponseList;
    }

    private List<Place> placeObjectResponseList;

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPlaceResponseList() {
        return placeResponseList;
    }

    public void setPlaceResponseList(List<String> placeResponseList) {
        this.placeResponseList = placeResponseList;
    }
}
