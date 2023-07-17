package com.group9.group09.service.interfaces;

import com.group9.group09.DTO.*;
import com.group9.group09.model.ItemstoCarry;

public interface HomePageService {

    ChoiceResponseDTO choiceSelectorService(ChoiceRequestDTO choice);

    LocationResponseDTO locationSelectorService(LocationRequestDTO location);

    CityResponseDTO citySelectorService(CityRequestDTO city);

    PlaceResponseDTO placeSelectorService(PlaceRequestDTO placeRequestDTO);

    ActivityResponseDTO getActivitiesService(ActivityRequestDTO activityRequestDTO);

    ItemsToCarryResponseDTO getItemstoCarry();

//    CityResponseDTO citySelectorplaceService(CityRequestDTO city);


}
