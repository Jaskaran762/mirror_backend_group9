package com.group9.group09.DTO;

import java.util.List;

/**
 * Data Transfer Object for Choice Response.
 */
public class ChoiceResponseDTO {

    private String region;
    private List<String> regionList;

    /**
     * Get the region value from the response.
     *
     * @return the region value
     */
    public String getRegion() {
        return region;
    }

    /**
     * Set the region value in the response.
     *
     * @param region the region value to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Get the list of regions from the response.
     *
     * @return the list of regions
     */
    public List<String> getRegionList() {
        return regionList;
    }

    /**
     * Set the list of regions in the response.
     *
     * @param regionList the list of regions to set
     */
    public void setRegionList(List<String> regionList) {
        this.regionList = regionList;
    }
}
