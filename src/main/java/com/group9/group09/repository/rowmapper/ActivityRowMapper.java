package com.group9.group09.repository.rowmapper;

import com.group9.group09.model.Activity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActivityRowMapper implements RowMapper<Activity> {
    @Override
    public Activity mapRow(ResultSet rs, int rowNum) throws SQLException {
        Activity activity = new Activity();
        activity.setActivityId(rs.getInt("Activity_ID"));
        activity.setActivityName(rs.getString("activity"));
        activity.setDescription(rs.getString("activity_description"));
        activity.setPlaceId(rs.getInt("place_id"));

        return activity;
    }
}
