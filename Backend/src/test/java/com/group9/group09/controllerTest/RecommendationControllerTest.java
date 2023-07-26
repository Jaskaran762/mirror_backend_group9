package com.group9.group09.controllerTest;

import com.group9.group09.DTO.RequestDTO.RequestDTO;
import com.group9.group09.DTO.ResponseDTO.ErrorResponse;
import com.group9.group09.DTO.ResponseDTO.RecommendationResponseDTO;
import com.group9.group09.controller.RecommendationController;
import com.group9.group09.service.interfaces.RecommendationService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class RecommendationControllerTest {/*

    @Mock
    private RecommendationService recommendationService;

    @InjectMocks
    private RecommendationController recommendationController;

    @Test
    public void testGetRecommendations_Success() {
        // Prepare the requestDTO
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setToken("some_valid_token");

        // Prepare the responseDTO
        RecommendationResponseDTO responseDTO = new RecommendationResponseDTO();

        // Mock the service method to return the responseDTO
        Mockito.when(recommendationService.getUserRecommendationsBasedOnInterests(requestDTO))
                .thenReturn(responseDTO);

        // Perform the test
        ResponseEntity<?> responseEntity = recommendationController.getRecommendations(requestDTO, new MockHttpServletRequest());

        // Assert the response
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(responseDTO, responseEntity.getBody());
    }

    @Test
    public void testGetRecommendations_Exception() {
        // Prepare the requestDTO
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setToken("some_valid_token");

        // Mock the service method to throw an exception
        Mockito.when(recommendationService.getUserRecommendationsBasedOnInterests(requestDTO))
                .thenThrow(new RuntimeException("Some error occurred."));

        // Perform the test
        ResponseEntity<?> responseEntity = recommendationController.getRecommendations(requestDTO, new MockHttpServletRequest());

        // Assert the response
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        ErrorResponse errorResponse = (ErrorResponse) responseEntity.getBody();
        assertNotNull(errorResponse);
        assertEquals("some issue", errorResponse.getMessage());
    }

    @Test
    public void testGetRecommendations_NullAuthorizationHeader() {
        // Prepare the requestDTO with a null token
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setToken(null);

        // Perform the test
        ResponseEntity<?> responseEntity = recommendationController.getRecommendations(requestDTO, new MockHttpServletRequest());

        // Assert the response
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        ErrorResponse errorResponse = (ErrorResponse) responseEntity.getBody();
        assertNotNull(errorResponse);
        assertEquals("some issue", errorResponse.getMessage());
    }

    @Test
    public void testGetRecommendations_NullResponseDTO() {
        // Prepare the requestDTO
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setToken("some_valid_token");

        // Mock the service method to return null
        Mockito.when(recommendationService.getUserRecommendationsBasedOnInterests(requestDTO))
                .thenReturn(null);

        // Perform the test
        ResponseEntity<?> responseEntity = recommendationController.getRecommendations(requestDTO, new MockHttpServletRequest());

        // Assert the response
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        ErrorResponse errorResponse = (ErrorResponse) responseEntity.getBody();
        assertNotNull(errorResponse);
        assertEquals("some issue", errorResponse.getMessage());
    }*/
}
