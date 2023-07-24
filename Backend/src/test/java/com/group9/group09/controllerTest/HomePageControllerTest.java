package com.group9.group09.controllerTest;

import com.group9.group09.DTO.RequestDTO.ChoiceRequestDTO;
import com.group9.group09.DTO.RequestDTO.CityRequestDTO;
import com.group9.group09.DTO.RequestDTO.LocationRequestDTO;
import com.group9.group09.DTO.ResponseDTO.ChoiceResponseDTO;
import com.group9.group09.DTO.ResponseDTO.CityResponseDTO;
import com.group9.group09.DTO.ResponseDTO.ItemsToCarryResponseDTO;
import com.group9.group09.DTO.ResponseDTO.LocationResponseDTO;
import com.group9.group09.config.JwtService;
import com.group9.group09.model.*;
import com.group9.group09.repository.CityRepositoryImp;
import com.group9.group09.repository.ItemsRepositoryImp;
import com.group9.group09.repository.PlaceRepositoryImp;
import com.group9.group09.repository.interfaces.CountryRepository;
import com.group9.group09.repository.interfaces.StateRepository;
import com.group9.group09.repository.interfaces.UserRepository;
import com.group9.group09.service.HomePageServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class HomePageControllerTest {

    @InjectMocks
    private HomePageServiceImpl homePageService;

    @Mock
    private JwtService jwtService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private CountryRepository countryRepository;
    @Mock
    private StateRepository stateRepository;
    private CityRepositoryImp cityRepository;
    private PlaceRepositoryImp placeRepository;
    private ItemsRepositoryImp itemsRepository;

    @Test
    public void testChoiceSelectorService_InternationalRegion() {

        ChoiceRequestDTO choice = new ChoiceRequestDTO();
        choice.setRegion("International");
        choice.setToken("test_token");

        // Mock the JwtService to return the username
        Mockito.when(jwtService.extractUsername(choice.getToken())).thenReturn("test_user");

        // Mock the UserRepository to return the user with the home country
        User user = new User();
        user.setHomeCountry(1);
        Mockito.when(userRepository.findByUsermail("test_user")).thenReturn(Optional.of(user));

        List<Country> countryList = new ArrayList<>();


        Mockito.when(countryRepository.getCountries()).thenReturn(countryList);

        // Perform the test
        ChoiceResponseDTO choiceResponseDTO = homePageService.choiceSelectorService(choice);

        // Assert the response
        Assertions.assertEquals("International", choiceResponseDTO.getRegion());
        Assertions.assertEquals(countryList, choiceResponseDTO.getRegionList());
    }

    @Test
    public void testChoiceSelectorService_DomesticRegion() {
        // Prepare the ChoiceRequestDTO object with region as "Domestic"
        ChoiceRequestDTO choice = new ChoiceRequestDTO();
        choice.setRegion("Domestic");
        choice.setToken("test_token");

        // Mock the JwtService to return the username
        Mockito.when(jwtService.extractUsername(choice.getToken())).thenReturn("test_user");

        // Mock the UserRepository to return the user with the home country
        User user = new User();
        user.setHomeCountry(1); // Replace 1L with the desired home country ID
        Mockito.when(userRepository.findByUsermail("test_user")).thenReturn(Optional.of(user));

        // Mock the CountryRepository to return the user's home country
        Country homeCountry = new Country();
        homeCountry.setCountryID(user.getHomeCountry());
        Mockito.when(countryRepository.findByCountryId(user.getHomeCountry())).thenReturn(Optional.of(homeCountry));

        // Mock the StateRepository to return a list of states
        List<State> stateList = new ArrayList<>();

        Mockito.when(stateRepository.getStatesbyCountryID(homeCountry.getCountryID())).thenReturn(stateList);

        // Perform the test
        ChoiceResponseDTO choiceResponseDTO = homePageService.choiceSelectorService(choice);

        // Assert the response
        Assertions.assertEquals("Domestic", choiceResponseDTO.getRegion());
        Assertions.assertEquals(stateList, choiceResponseDTO.getRegionList());
    }

    @Test
    public void testLocationSelectorService() {
        // Prepare the LocationRequestDTO object
        LocationRequestDTO location = new LocationRequestDTO();
        location.setLocation("Gujarat");
        location.setToken("test_token");

        Mockito.when(jwtService.extractUsername(location.getToken())).thenReturn("test_user");

        // Mock the UserRepository to return the user with the home country
        User user = new User();
        user.setHomeCountry(1);
        Mockito.when(userRepository.findByUsermail("test_user")).thenReturn(Optional.of(user));


        State state = new State();
        state.setStateID(1);
        Mockito.when(stateRepository.findByStateName(location.getLocation())).thenReturn(Optional.of(state));

        List<City> cityList = new ArrayList<>();

        Mockito.when(cityRepository.getCitiesbyStateID(state.getStateID())).thenReturn(cityList);

        LocationResponseDTO locationResponseDTO = homePageService.locationSelectorService(location);

        Assertions.assertEquals(state.getDescription(), locationResponseDTO.getDescription());
        Assertions.assertEquals(cityList, locationResponseDTO.getCities());
    }

    @Test
    public void testCitySelectorService() {
        // Prepare the CityRequestDTO object
        CityRequestDTO cityRequestDTO = new CityRequestDTO();
        cityRequestDTO.setCityID(1);
        cityRequestDTO.setToken("test_token");

        // Mock the JwtService to return the username
        Mockito.when(jwtService.extractUsername(cityRequestDTO.getToken())).thenReturn("test_user");

        // Mock the UserRepository to return the user with the home country
        User user = new User();
        user.setHomeCountry(1);
        Mockito.when(userRepository.findByUsermail("test_user")).thenReturn(Optional.of(user));

        // Mock the CityRepository to return the city based on the city ID
        City city = new City();
        city.setCityId(1);
        Mockito.when(cityRepository.findByCityId(cityRequestDTO.getCityID())).thenReturn(Optional.of(city));

        List<Place> placeList = new ArrayList<>();

        Mockito.when(placeRepository.getPlacesbyCityID(city.getCityId())).thenReturn(placeList);

        CityResponseDTO cityResponseDTO = homePageService.citySelectorService(cityRequestDTO);

        Assertions.assertEquals(city.getCityName(), cityResponseDTO.getCityName());
        Assertions.assertEquals(city.getDescription(), cityResponseDTO.getDescription());
        Assertions.assertEquals(placeList, cityResponseDTO.getPlaceResponseList());
    }

    @Test
    public void testGetItemstoCarry() {

        List<ItemstoCarry> itemstoCarryList = new ArrayList<>();

        Mockito.when(itemsRepository.getAllItems()).thenReturn(itemstoCarryList);

        ItemsToCarryResponseDTO itemsToCarryResponseDTO = homePageService.getItemstoCarry();

        Assertions.assertEquals(itemstoCarryList, itemsToCarryResponseDTO.getItemstoCarryResponseList());
    }
}
