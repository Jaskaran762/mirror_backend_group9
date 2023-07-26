package com.group9.group09.controllerTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.group9.group09.DTO.RequestDTO.OTPRequestDTO;
import com.group9.group09.DTO.RequestDTO.UserEditRequestDTO;
import com.group9.group09.DTO.ResponseDTO.ResponseDTO;
import com.group9.group09.controller.AuthController;
import com.group9.group09.exception.UserNotFoundException;
import com.group9.group09.model.User;
import com.group9.group09.service.interfaces.OTPService;
import com.group9.group09.service.interfaces.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserControllerTest {


    @Mock
    private UserService userService;

    @InjectMocks
    private AuthController userController;
    private final OTPService otpService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    public UserControllerTest(UserService userService, AuthController userController, OTPService otpService) {
        this.userService = userService;
        this.userController = userController;
        this.otpService = otpService;
    }

    @Test
    void testUserLogin_Success() {
        User user = new User();

        // Mock userService's loginUserService method
        ResponseDTO mockResponse = new ResponseDTO();
        when(userService.loginUserService(any(User.class))).thenReturn(mockResponse);

        ResponseEntity<?> responseEntity = userController.userLogin(user);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockResponse, responseEntity.getBody());
    }

    @Test
    void testUserLogin_Exception() {
        User user = new User();

        // Mock userService's loginUserService method to throw an exception
        when(userService.loginUserService(any(User.class))).thenThrow(new RuntimeException());

        ResponseEntity<?> responseEntity = userController.userLogin(user);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        // Add assertions for the response body as needed.
    }

    @Test
    void testUserRegister_Success() {
        User user = new User();

        // Mock userService's registerUserService method
        ResponseDTO mockResponse = new ResponseDTO();
        when(userService.registerUserService(any(User.class))).thenReturn(mockResponse);

        ResponseEntity<?> responseEntity = userController.userRegister(user);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(mockResponse, responseEntity.getBody());
    }

    @Test
    void testUserRegister_UserNotFoundException() {
        User user = new User();

        // Mock userService's registerUserService method to throw UserNotFoundException
        when(userService.registerUserService(any(User.class))).thenThrow(new UserNotFoundException("User already present"));

        ResponseEntity<?> responseEntity = userController.userRegister(user);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        // Add assertions for the response body as needed.
    }

    // Add more test cases for other controller methods...

    // For instance, add test cases for:
    // - userRegister_Exception
    // - userInfoEdit_Success
    // - userInfoEdit_Exception
    // - forgotPasswordForUser_Success
    // - forgotPasswordForUser_UserNotFoundException
    // - forgotPasswordForUser_Exception
    // - verifyUser_Success
    // - verifyUser_Exception
    // - verifyUser_IncorrectOTP
}
