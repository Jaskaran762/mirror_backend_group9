package com.group9.group09.repository;

import com.group9.group09.model.ItemstoCarry;
import com.group9.group09.model.Itinerary;
import com.group9.group09.repository.interfaces.ItineraryRepository;
import com.group9.group09.repository.rowmapper.ItemstoCarryRowMapper;
import com.group9.group09.repository.rowmapper.ItineraryRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItineraryRespositoryImp implements ItineraryRepository {
    private final JdbcTemplate jdbcTemplate;

    public ItineraryRespositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Itinerary> getItineraryList(Integer userid) {

        try {
            String getItinerarybyUserIDQuery = "SELECT * FROM Itinerary where user_id=?";
            return jdbcTemplate.query(getItinerarybyUserIDQuery, new ItineraryRowMapper(), userid);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
