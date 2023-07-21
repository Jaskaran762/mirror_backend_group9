package com.group9.group09.DTO;

import com.group9.group09.model.Activity;

import java.util.List;

/**
 * Data Transfer Object for Activity response.
 */
public class ActivityResponseDTO {
    private List<Activity> activityObjectsResponseList;

    /**
     * Get the list of activity objects in the response.
     *
     * @return the activityObjectsResponseList
     */
    public List<Activity> getActivityObjectsResponseList() {
        return activityObjectsResponseList;
    }


    /**
     * Set the list of activity objects in the response.
     *
     * @param activityObjectsResponseList the activityObjectsResponseList to set
     */
    public void setActivityObjectsResponseList(List<Activity> activityObjectsResponseList) {
        this.activityObjectsResponseList = activityObjectsResponseList;
    }
}
