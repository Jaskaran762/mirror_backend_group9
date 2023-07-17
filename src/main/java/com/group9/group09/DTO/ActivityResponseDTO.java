package com.group9.group09.DTO;

import com.group9.group09.model.Activity;

import java.util.List;

public class ActivityResponseDTO {
    private List<Activity> activityObjectsResponseList;

    public List<Activity> getActivityObjectsResponseList() {
        return activityObjectsResponseList;
    }

    public void setActivityObjectsResponseList(List<Activity> activityObjectsResponseList) {
        this.activityObjectsResponseList = activityObjectsResponseList;
    }
}
