package com.group9.group09.repository.rowmapper;

import com.group9.group09.model.Place;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaceRowMapper implements RowMapper<Place> {

    @Override
    public Place mapRow(ResultSet rs, int rowNum) throws SQLException {
        Place place = new Place();
        place.setPlaceId(rs.getInt("Place_ID"));
        place.setPlaceName(rs.getString("place"));
        place.setCityId(rs.getInt("city_id"));
        place.setDescription(rs.getString("city_description"));

        return place;
    }
}
