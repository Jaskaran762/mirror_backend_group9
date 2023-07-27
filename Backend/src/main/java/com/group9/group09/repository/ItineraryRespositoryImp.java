package com.group9.group09.repository;

import com.group9.group09.DTO.RequestDTO.ItineraryRequestDTO;
import com.group9.group09.DTO.ResponseDTO.ItineraryResponseDTO;
import com.group9.group09.model.ItemstoCarry;
import com.group9.group09.model.Itinerary;
import com.group9.group09.repository.interfaces.ItineraryRepository;
import com.group9.group09.repository.rowmapper.ItemstoCarryRowMapper;
import com.group9.group09.repository.rowmapper.ItineraryRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItineraryRespositoryImp implements ItineraryRepository {
    private final JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactory.getLogger(ItemsRepositoryImp.class);
    public ItineraryRespositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Itinerary> getItineraryList(Integer userid) {

        try {
            logger.info("Info Message: ");
            String getItinerarybyUserIDQuery = "SELECT * FROM Itinerary where user_id=?";
            return jdbcTemplate.query(getItinerarybyUserIDQuery, new ItineraryRowMapper(), userid);
        } catch (Exception e) {
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public int addtoItinerary(ItineraryRequestDTO itineraryRequestDTO) {
        try{
            logger.info("Info Message: in itinerary repository, addtoitinerary method  ");
            String addtoItineraryQuery = "Insert INTO Itinerary  (user_id,`start_date`,`end_date`,`placeid`,`activityid`,`title`) VALUES(?,?,?,?,?,?);";
            return jdbcTemplate.update(addtoItineraryQuery, itineraryRequestDTO.getUserid(), itineraryRequestDTO.getStartdate(),itineraryRequestDTO.getEnddate(),itineraryRequestDTO.getPlaceid(),itineraryRequestDTO.getActivityid(),itineraryRequestDTO.getTitle());
        }catch (Exception e){
            logger.error("Error Message: error adding to itinerary list ");
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int deleteitinerarybyid(Integer itineraryid) {


        try{
            logger.info("Info Message: in itinerary repository, deleteitinerarybyid method  ");
            String deleteItineraryByIDQuery = "Delete from Itinerary where itinerary_id=?;";
            return jdbcTemplate.update(deleteItineraryByIDQuery, itineraryid);

        }catch (Exception e){
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }

    }
}