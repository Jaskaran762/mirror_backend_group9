package com.group9.group09.DTO.ResponseDTO;

import com.group9.group09.model.City;
import java.util.List;

public class StateResponseDTO {

    private Integer stateID;
    private String stateName;
    private String description;
    private List<City> cityObjectList;
    private List<String> cityStringList;

    public Integer getStateID() {
        return stateID;
    }

    public void setStateID(Integer stateID) {
        this.stateID = stateID;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<City> getCityObjectList() {
        return cityObjectList;
    }

    public void setCityObjectList(List<City> cityObjectList) {
        this.cityObjectList = cityObjectList;
    }

    public List<String> getCityStringList() {
        return cityStringList;
    }

    public void setCityStringList(List<String> cityStringList) {
        this.cityStringList = cityStringList;
    }
}
