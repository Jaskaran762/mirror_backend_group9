package com.group9.group09.service.interfaces;

import com.group9.group09.DTO.ActivityResponseDTO;
import com.group9.group09.DTO.PlaceResponseDTO;
import com.group9.group09.DTO.ResponseDTO.RecommendationResponseDTO;
import com.group9.group09.DTO.RequestDTO;
import com.group9.group09.model.Activity;

import java.util.List;

public interface RecommendationService {

    RecommendationResponseDTO getUserRecommendationsBasedOnInterests(RequestDTO requestDTO);
    List<String> fetchUserInterests(String userName);
    List<Activity> fetchActivitiesBasedOnInterest(String interest);
    List<PlaceResponseDTO> fetchPlacesBasedOnInterest(String interest);
}
