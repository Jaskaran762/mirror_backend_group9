package com.group9.group09.service.interfaces;

import com.group9.group09.DTO.ChoiceRequestDTO;
import com.group9.group09.DTO.ChoiceResponseDTO;
import com.group9.group09.DTO.LocationRequestDTO;
import com.group9.group09.DTO.LocationResponseDTO;

public interface HomePageService {

    ChoiceResponseDTO choiceSelectorService(ChoiceRequestDTO choice);

    LocationResponseDTO locationSelectorService(LocationRequestDTO location);
}
