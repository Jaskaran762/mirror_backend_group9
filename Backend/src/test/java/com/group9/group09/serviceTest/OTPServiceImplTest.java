package com.group9.group09.serviceTest;


import com.group9.group09.DTO.RequestDTO.OTPRequestDTO;
import com.group9.group09.config.interfaces.EmailConfig;
import com.group9.group09.model.EmailDetails;
import com.group9.group09.service.OTPServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class OTPServiceImplTest {

    @Mock
    private EmailConfig emailConfig;

    @InjectMocks
    private OTPServiceImpl otpService;

    private String testEmail = "test@example.com";

    @Test
    public void testGenerateOTP() {
        String email = "test@example.com";
        OTPServiceImpl otpService = new OTPServiceImpl();
        boolean result = otpService.generateOTP(email);

        // Assert that OTP generation is successful
        assertTrue(result);

        // Get the generated OTP and verify its length
        String otp = OTPServiceImpl.getOtp();
        assertNotNull(otp);
        assertEquals(4, otp.length());
    }

    @Test
    public void testVerifyUserUsingValidOTP() {
        OTPRequestDTO requestDTO = new OTPRequestDTO();
        requestDTO.setOtp("1234"); // Replace "1234" with the valid OTP generated during the test

        OTPServiceImpl otpService = new OTPServiceImpl();

        // Set a startTime in the past (within allowed time difference) for testing
        //long startTime = System.currentTimeMillis() - OTPServiceImpl.ALLOWED_TIME_DIFFERENCE;
        // OTPServiceImpl.setStartTime(startTime);

        // Call the method and verify the result
        boolean result = otpService.verifyUserUsingOTP(requestDTO);
        assertTrue(result);
    }

    @Test
    public void testVerifyUserUsingInvalidOTP() {
        OTPRequestDTO requestDTO = new OTPRequestDTO();
        requestDTO.setOtp("0000"); // Set an invalid OTP

        OTPServiceImpl otpService = new OTPServiceImpl();

        // Set a startTime in the past (within allowed time difference)
//        long startTime = System.currentTimeMillis() - OTPServiceImpl.allowedTimeDifference;
//        OTPServiceImpl.startTime = startTime;

        // Call the method and verify the result
        boolean result = otpService.verifyUserUsingOTP(requestDTO);
        assertFalse(result);
    }

    @Test
    public void testVerifyUserWithExpiredOTP() {
        OTPRequestDTO requestDTO = new OTPRequestDTO();
        requestDTO.setOtp("1234"); // Replace "1234" with the valid OTP generated during the test

        OTPServiceImpl otpService = new OTPServiceImpl();

        // Set a startTime in the past (beyond allowed time difference)
//        long startTime = System.currentTimeMillis() - (OTPServiceImpl.allowedTimeDifference + 1000); // Adding an extra 1000 ms to make it expired
//        OTPServiceImpl.startTime = startTime;

        // Call the method and expect a RuntimeException
        assertThrows(RuntimeException.class, () -> otpService.verifyUserUsingOTP(requestDTO));
    }

    @Test
    public void testVerifyUserWithNoOTPGenerated() {
        OTPRequestDTO requestDTO = new OTPRequestDTO();
        requestDTO.setOtp("1234"); // Replace "1234" with the valid OTP generated during the test

        OTPServiceImpl otpService = new OTPServiceImpl();

        // Set the startTime to 0 to simulate no OTP generation
//        OTPServiceImpl.startTime = 0;

        // Call the method and expect a RuntimeException
        assertThrows(RuntimeException.class, () -> otpService.verifyUserUsingOTP(requestDTO));
    }
}