package com.group9.group09.repositoryTest;

import com.group9.group09.DTO.RequestDTO.ItineraryRequestDTO;
import com.group9.group09.repository.ItineraryRespositoryImp;
import com.group9.group09.repository.interfaces.ItineraryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class ItineraryRespositoryImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private ItineraryRepository itineraryRepository = new ItineraryRespositoryImp(jdbcTemplate);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


//    @Test
//    void testAddtoItinerary() {
//        // Create a mock ItineraryRequestDTO object
//        ItineraryRequestDTO requestDTO = mock(ItineraryRequestDTO.class);
//
//        // Mock the jdbcTemplate update method to return the number of affected rows (1)
//        when(jdbcTemplate.update(anyString(), anyInt(), any(), any(), anyInt(), anyInt()))
//                .thenReturn(1);
//
//        // Call the method under test
//        int result = itineraryRepository.addtoItinerary(requestDTO);
//
//        // Verify the jdbcTemplate.update method was called with the correct SQL query and parameters
//        verify(jdbcTemplate, times(1)).update(anyString(), anyInt(), any(), any(), anyInt(), anyInt());
//
//        // Verify the result
//        assertEquals(1, result);
//    }
//
//    @Test
//    void testAddtoItineraryFailure() {
//        // Create a mock ItineraryRequestDTO object
//        ItineraryRequestDTO requestDTO = mock(ItineraryRequestDTO.class);
//
//        // Mock the jdbcTemplate update method to return the number of affected rows (0)
//        when(jdbcTemplate.update(anyString(), anyInt(), any(), any(), anyInt(), anyInt()))
//                .thenReturn(0);
//
//        // Call the method under test and verify that it throws a RuntimeException
//        assertThrows(RuntimeException.class, () -> itineraryRepository.addtoItinerary(requestDTO));
//
//        // Verify the jdbcTemplate.update method was called with the correct SQL query and parameters
//        verify(jdbcTemplate, times(1)).update(anyString(), anyInt(), any(), any(), anyInt(), anyInt());
//    }
//
//    @Test
//    void testDeleteitinerarybyid() {
//        // Mock the jdbcTemplate update method to return the number of affected rows (1)
//        when(jdbcTemplate.update(anyString(), anyInt()))
//                .thenReturn(1);
//
//        // Call the method under test
//        int result = itineraryRepository.deleteitinerarybyid(1);
//
//        // Verify the jdbcTemplate.update method was called with the correct SQL query and parameter
//        verify(jdbcTemplate, times(1)).update(anyString(), anyInt());
//
//        // Verify the result
//        assertEquals(1, result);
//    }
//
//    @Test
//    void testDeleteitinerarybyidFailure() {
//        // Mock the jdbcTemplate update method to return the number of affected rows (0)
//        when(jdbcTemplate.update(anyString(), anyInt()))
//                .thenReturn(0);
//
//        // Call the method under test and verify that it throws a RuntimeException
//        assertThrows(RuntimeException.class, () -> itineraryRepository.deleteitinerarybyid(1));
//
//        // Verify the jdbcTemplate.update method was called with the correct SQL query and parameter
//        verify(jdbcTemplate, times(1)).update(anyString(), anyInt());
//    }
}