package com.group9.group09.controllerTest;

import com.group9.group09.DTO.RequestDTO.CityRequestDTO;
import com.group9.group09.DTO.RequestDTO.CountryRequestDTO;
import com.group9.group09.DTO.RequestDTO.PlaceRequestDTO;
import com.group9.group09.DTO.RequestDTO.StateRequestDTO;
import com.group9.group09.DTO.ResponseDTO.ErrorResponse;
import com.group9.group09.DTO.ResponseDTO.ResponseDTO;
import com.group9.group09.controller.AdminController;
import com.group9.group09.service.interfaces.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class AdminControllerTest {

    @Mock
    private AdminService adminServiceMock;

    @InjectMocks
    private AdminController adminController;
    @Test
    public void testAddCountry_Success() {
        // Mock AdminService
        AdminService adminServiceMock = Mockito.mock(AdminService.class);
        CountryRequestDTO countryRequest = new CountryRequestDTO();
        HttpServletRequest request = new MockHttpServletRequest();

        // Set up the mock behavior for adminService.addCountryService
        ResponseDTO successResponse = new ResponseDTO();
        Mockito.when(adminServiceMock.addCountryService(countryRequest)).thenReturn(successResponse);

        // Set up controller
        AdminController adminController = new AdminController();
       // adminController.setAdminService(adminServiceMock);

        // Execute the method
        ResponseEntity<?> responseEntity = adminController.addCountry(countryRequest, request);

        // Assert the response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(successResponse, responseEntity.getBody());
    }

    @Test
    public void testAddCountry_Exception() {
        // Mock AdminService
        AdminService adminServiceMock = Mockito.mock(AdminService.class);
        CountryRequestDTO countryRequest = new CountryRequestDTO();
        HttpServletRequest request = new MockHttpServletRequest();

        // Set up the mock behavior to throw an exception
        Mockito.when(adminServiceMock.addCountryService(countryRequest)).thenThrow(new RuntimeException());

        // Set up controller
        AdminController adminController = new AdminController();
        //adminController.setAdminService(adminServiceMock);

        // Execute the method
        ResponseEntity<?> responseEntity = adminController.addCountry(countryRequest, request);

        // Assert the response
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody() instanceof ErrorResponse);
        ErrorResponse errorResponse = (ErrorResponse) responseEntity.getBody();
        assertEquals("Add country admin api failed", errorResponse.getMessage());
    }

    @Test
    public void testAddState_Success() {
        // Mock AdminService
        AdminService adminServiceMock = Mockito.mock(AdminService.class);
        StateRequestDTO stateRequest = new StateRequestDTO();
        HttpServletRequest request = new MockHttpServletRequest();

        // Set up the mock behavior for adminService.addStateService
        ResponseDTO successResponse = new ResponseDTO();
        Mockito.when(adminServiceMock.addStateService(stateRequest)).thenReturn(successResponse);

        // Set up controller
        AdminController adminController = new AdminController();
        //adminController.setAdminService(adminServiceMock);

        // Execute the method
        ResponseEntity<?> responseEntity = adminController.addState(stateRequest, request);

        // Assert the response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(successResponse, responseEntity.getBody());
    }

    @Test
    public void testAddState_Exception() {
        // Mock AdminService
        AdminService adminServiceMock = Mockito.mock(AdminService.class);
        StateRequestDTO stateRequest = new StateRequestDTO();
        HttpServletRequest request = new MockHttpServletRequest();

        // Set up the mock behavior to throw an exception
        Mockito.when(adminServiceMock.addStateService(stateRequest)).thenThrow(new RuntimeException());

        // Set up controller
        AdminController adminController = new AdminController();
        //adminController.setAdminService(adminServiceMock);

        // Execute the method
        ResponseEntity<?> responseEntity = adminController.addState(stateRequest, request);

        // Assert the response
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody() instanceof ErrorResponse);
        ErrorResponse errorResponse = (ErrorResponse) responseEntity.getBody();
        assertEquals("Add state admin api failed", errorResponse.getMessage());
    }

    @Test
    public void testAddCity_Success() {
        // Mock AdminService
        AdminService adminServiceMock = Mockito.mock(AdminService.class);
        CityRequestDTO cityRequest = new CityRequestDTO();
        HttpServletRequest request = new MockHttpServletRequest();

        // Set up the mock behavior for adminService.addCityService
        ResponseDTO successResponse = new ResponseDTO();
        Mockito.when(adminServiceMock.addCityService(cityRequest)).thenReturn(successResponse);

        // Set up controller
        AdminController adminController = new AdminController();
        //adminController.setAdminService(adminServiceMock);

        // Execute the method
       // ResponseEntity<?> responseEntity = adminController.addCity(cityRequest, request);

        // Assert the response
        //assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        //assertEquals(successResponse, responseEntity.getBody());
    }

    @Test
    public void testAddCity_Exception() {
        // Mock AdminService
        AdminService adminServiceMock = Mockito.mock(AdminService.class);
        CityRequestDTO cityRequest = new CityRequestDTO();
        HttpServletRequest request = new MockHttpServletRequest();

        // Set up the mock behavior to throw an exception
        Mockito.when(adminServiceMock.addCityService(cityRequest)).thenThrow(new RuntimeException());

        // Set up controller
        AdminController adminController = new AdminController();
        //adminController.setAdminService(adminServiceMock);

        // Execute the method
      //  ResponseEntity<?> responseEntity = adminController.addCity(cityRequest, request);

        // Assert the response
//        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
//        assertTrue(responseEntity.getBody() instanceof ErrorResponse);
//        ErrorResponse errorResponse = (ErrorResponse) responseEntity.getBody();
//        assertEquals("Add city admin api failed", errorResponse.getMessage());
    }

    @Test
    public void testAddPlace_Success() {
        // Mock AdminService
        AdminService adminServiceMock = Mockito.mock(AdminService.class);
        PlaceRequestDTO placeRequest = new PlaceRequestDTO();
        HttpServletRequest request = new MockHttpServletRequest();

        // Set up the mock behavior for adminService.addPlaceService
        ResponseDTO successResponse = new ResponseDTO();
        Mockito.when(adminServiceMock.addPlaceService(placeRequest)).thenReturn(successResponse);

        // Set up controller
        AdminController adminController = new AdminController();
       // adminController.setAdminService(adminServiceMock);

        // Execute the method
        ResponseEntity<?> responseEntity = adminController.addPlace(placeRequest, request);

        // Assert the response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(successResponse, responseEntity.getBody());
    }

    @Test
    public void testAddPlace_Exception() {
        // Mock AdminService
        AdminService adminServiceMock = Mockito.mock(AdminService.class);
        PlaceRequestDTO placeRequest = new PlaceRequestDTO();
        HttpServletRequest request = new MockHttpServletRequest();

        // Set up the mock behavior to throw an exception
        Mockito.when(adminServiceMock.addPlaceService(placeRequest)).thenThrow(new RuntimeException());

        // Set up controller
        AdminController adminController = new AdminController();
        //adminController.setAdminService(adminServiceMock);

        // Execute the method
        ResponseEntity<?> responseEntity = adminController.addPlace(placeRequest, request);

        // Assert the response
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertTrue(responseEntity.getBody() instanceof ErrorResponse);
        ErrorResponse errorResponse = (ErrorResponse) responseEntity.getBody();
        assertEquals("Add place admin api failed", errorResponse.getMessage());
    }

}
