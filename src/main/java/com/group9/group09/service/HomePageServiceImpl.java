package com.group9.group09.service;

import com.group9.group09.DTO.ChoiceRequestDTO;
import com.group9.group09.DTO.ChoiceResponseDTO;
import com.group9.group09.DTO.LocationRequestDTO;
import com.group9.group09.DTO.LocationResponseDTO;
import com.group9.group09.repository.HomePageRepository;
import com.group9.group09.service.interfaces.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;

public class HomePageServiceImpl implements HomePageService {

    @Autowired
    private HomePageRepository homePageRepository;

    @Override
    public ChoiceResponseDTO choiceSelectorService(ChoiceRequestDTO choice) {


        return null;
    }

    @Override
    public LocationResponseDTO locationSelectorService(LocationRequestDTO location) {
        return null;
    }


}
