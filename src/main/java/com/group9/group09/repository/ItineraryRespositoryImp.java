package com.group9.group09.repository;

import com.group9.group09.model.Itinerary;
import com.group9.group09.repository.interfaces.ItineraryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItineraryRespositoryImp implements ItineraryRepository {
    @Override
    public List<Itinerary> getItineraryList(Integer userid) {




        return null;
    }
}
