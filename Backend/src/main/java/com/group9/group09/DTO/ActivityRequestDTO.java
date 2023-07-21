package com.group9.group09.DTO;

/**
 * Data Transfer Object for Activity request.
 */
public class ActivityRequestDTO extends RequestDTO {

    private Integer activityID;
    private String activityName;

    /**
     * Get the activity ID.
     *
     * @return the activityID
     */
    public Integer getActivityID() {
        return activityID;
    }

    /**
     * Set the activity ID.
     *
     * @param activityID the activityID to set
     */
    public void setActivityID(Integer activityID) {
        this.activityID = activityID;
    }

    /**
     * Get the activity name.
     *
     * @return the activityName
     */
    public String getActivityName() {
        return activityName;
    }

    /**
     * Set the activity name.
     *
     * @param activityName the activityName to set
     */
    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}
