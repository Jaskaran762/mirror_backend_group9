package com.group9.group09.DTO;

import java.util.List;

public class ChoiceResponseDTO {

    private String region;
    private List<String> regionList;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<String> getRegionList() {
        return regionList;
    }

    public void setRegionList(List<String> regionList) {
        this.regionList = regionList;
    }
}
