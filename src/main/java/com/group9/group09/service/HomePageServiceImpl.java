package com.group9.group09.service;

import com.group9.group09.DTO.*;
import com.group9.group09.config.JwtService;
import com.group9.group09.model.*;
import com.group9.group09.repository.interfaces.*;
import com.group9.group09.service.interfaces.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private ItemsRepository itemsRepository;

    @Override
    public ChoiceResponseDTO choiceSelectorService(ChoiceRequestDTO choice) {

       ChoiceResponseDTO choiceResponseDTO = new ChoiceResponseDTO();

       String username = jwtService.extractUsername(choice.getToken());
       Optional<User> user = userRepository.findByUsermail(username);
       Optional<Country> country = countryRepository.findByCountryId(user.get().getHomeCountry());
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

        LocationResponseDTO locationResponseDTO = new LocationResponseDTO();

        String username = jwtService.extractUsername(location.getToken());
        Optional<User> user = userRepository.findByUsermail(username);
        Optional<State> state = stateRepository.findByStateName(location.getLocation());
        List<City> cityList = cityRepository.getCitiesbyStateID(state.get().getStateID());

        List<String> citiesStringList = new ArrayList<>();
        for (City city: cityList) {
            citiesStringList.add(city.getCityName());
        }

        locationResponseDTO.setDescription(state.get().getDescription());
        locationResponseDTO.setCities(cityList);

        return locationResponseDTO;
    }


   /* @Override
    public CityResponseDTO citySelectorService(CityRequestDTO cityRequestDTO) {

        CityResponseDTO cityResponseDTO = new CityResponseDTO();

        String username = jwtService.extractUsername(cityRequestDTO.getToken());
        Optional<User> user = userRepository.findByUsermail(username);
        Optional<City> city = cityRepository.findByCityId(cityRequestDTO.getCityID());
        List<Activity> activityList = activityRepository.getActivitiesbyCityID(city.get().getCityId());

        List<String> activityStringList = new ArrayList<>();
        for (Activity activity: activityList) {
            activityStringList.add(activity.getActivityName());
        }
        cityResponseDTO.setCityID(city.get().getCityId());
        cityResponseDTO.setCityName(city.get().getCityName());
        cityResponseDTO.setDescription(city.get().getDescription());
        cityResponseDTO.setPlaceResponseList(activityStringList);


        return cityResponseDTO;
    }*/

    public CityResponseDTO citySelectorService(CityRequestDTO cityRequestDTO) {

        CityResponseDTO cityResponseDTO = new CityResponseDTO();

        String username = jwtService.extractUsername(cityRequestDTO.getToken());
        Optional<User> user = userRepository.findByUsermail(username);
        Optional<City> city = cityRepository.findByCityId(cityRequestDTO.getCityID());
        List<Place> placeList = placeRepository.getPlacesbyCityID(city.get().getCityId());

        List<String> placeStringList = new ArrayList<>();

        for (Place place: placeList) {
            placeStringList.add(place.getPlaceName());
        }

        cityResponseDTO.setCityID(city.get().getCityId());
        cityResponseDTO.setCityName(city.get().getCityName());
        cityResponseDTO.setDescription(city.get().getDescription());
        cityResponseDTO.setPlaceResponseList(placeStringList);

        return cityResponseDTO;
    }

    @Override
    public PlaceResponseDTO placeSelectorService(PlaceRequestDTO placeRequestDTO) {
        PlaceResponseDTO placeResponseDTO = new PlaceResponseDTO();

        String username = jwtService.extractUsername(placeRequestDTO.getToken());
        Optional<User> user = userRepository.findByUsermail(username);
        Optional<Place> place = placeRepository.findByPlaceId(placeRequestDTO.getPlaceID());
        List<Activity> activityList = activityRepository.getActivitiesbyCityID(place.get().getCityId());

        List<String> activityStringList = new ArrayList<>();
        for ( Activity activity : activityList) {
            activityStringList.add(activity.getActivityName());
        }

        placeResponseDTO.setPlaceName(place.get().getPlaceName());
        placeResponseDTO.setPlaceID(place.get().getPlaceId());
        placeResponseDTO.setDescription(place.get().getDescription());
        placeResponseDTO.setActivityStringResponseList(activityStringList);
        placeResponseDTO.setActivityObjectsResponseList(activityList);
        return placeResponseDTO;
    }

    @Override
    public ActivityResponseDTO getActivitiesService(ActivityRequestDTO activityRequestDTO) {
        ActivityResponseDTO activityResponseDTO = new ActivityResponseDTO();

        String username = jwtService.extractUsername(activityRequestDTO.getToken());
        Optional<User> user = userRepository.findByUsermail(username);
        List<Activity> activityList = activityRepository.getAllActivities();

        activityResponseDTO.setActivityObjectsResponseList(activityList);


        return activityResponseDTO;
    }

    @Override
    public ItemsToCarryResponseDTO getItemstoCarry() {

        ItemsToCarryResponseDTO itemsToCarryResponseDTO = new ItemsToCarryResponseDTO();

        List<ItemstoCarry> itemstoCarryList = itemsRepository.getAllItems();
        itemsToCarryResponseDTO.setItemstoCarryResponseList(itemstoCarryList);

        return itemsToCarryResponseDTO;
    }
}
