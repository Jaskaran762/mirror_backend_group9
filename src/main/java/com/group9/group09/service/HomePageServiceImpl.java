package com.group9.group09.service;

import com.group9.group09.DTO.ChoiceRequestDTO;
import com.group9.group09.DTO.ChoiceResponseDTO;
import com.group9.group09.DTO.LocationRequestDTO;
import com.group9.group09.DTO.LocationResponseDTO;
import com.group9.group09.config.JwtService;
import com.group9.group09.model.Country;
import com.group9.group09.model.State;
import com.group9.group09.model.User;
import com.group9.group09.repository.interfaces.CountryRepository;
import com.group9.group09.repository.interfaces.StateRepository;
import com.group9.group09.repository.interfaces.UserRepository;
import com.group9.group09.service.interfaces.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;

@Service
public class HomePageServiceImpl implements HomePageService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateRepository stateRepository;

    @Override
    public ChoiceResponseDTO choiceSelectorService(ChoiceRequestDTO choice) {

       ChoiceResponseDTO choiceResponseDTO = new ChoiceResponseDTO();

       String username = jwtService.extractUsername(choice.getToken());
       Optional<User> user = userRepository.findByUsermail(username);
       Optional<Country> country = countryRepository.findByCountryName(user.get().getHomeCountry());
       List<State> stateList =  stateRepository.getStatesbyCountryID(country.get().getCountryID());

       List<String> states = new ArrayList<>();
        for (State state :stateList) {
            states.add(state.getStateName());
        }

        choiceResponseDTO.setRegion(choice.getRegion());
        choiceResponseDTO.setRegionList(states);

        return choiceResponseDTO;
    }

    @Override
    public LocationResponseDTO locationSelectorService(LocationRequestDTO location) {
        return null;
    }


}