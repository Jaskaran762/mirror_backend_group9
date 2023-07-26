package com.group9.group09.controllerTest;


public class UserControllerTest {/*
    @Mock
    private UserService userService;

    @InjectMocks
    private AuthController userController;
    private final OTPService otpService;

    public UserControllerTest(UserService userService, AuthController userController, OTPService otpService) {
        this.userService = userService;
        this.userController = userController;
        this.otpService = otpService;
    }

    @Test
    public void testUserLogin_Success() {
        // Prepare the user object with login credentials
        User user = new User();
        user.setUserId("10004");
        user.setPassword("test_password");

        // Prepare the service response
        ResponseDTO serviceResponse = new ResponseDTO();

        // Mock the userService method to return the service response
        Mockito.when(userService.loginUserService(user))
                .thenReturn(serviceResponse);

        // Perform the test
        ResponseEntity<?> responseEntity = userController.userLogin(user);

        // Assert the response
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals(serviceResponse, responseEntity.getBody());
    }

    @Test
    public void testUserLogin_Failure() {
        // Prepare the user object with login credentials
        User user = new User();
        user.setUserId("10004");
        user.setPassword("test_password");

        // Mock the userService method to throw an exception or return null (login failure)
        Mockito.when(userService.loginUserService(user))
                .thenReturn(null);

        // Perform the test
        ResponseEntity<?> responseEntity = userController.userLogin(user);

        // Assert the response
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        ErrorResponse errorResponse = (ErrorResponse) responseEntity.getBody();
        Assertions.assertNotNull(errorResponse);
        Assertions.assertEquals("Login Issue", errorResponse.getMessage());
    }

    @Test
    public void testUserRegister_UserAlreadyPresent() {
        // Prepare the user object with registration details
        User user = new User();
        user.setUserId("10004");
        user.setPassword("test_password");

        // Prepare the service response with "User already present" message
        ResponseDTO serviceResponse = new ResponseDTO();
        serviceResponse.setSuccess("User already present");

        // Mock the userService method to return the service response
        Mockito.when(userService.registerUserService(user))
                .thenReturn(serviceResponse);

        // Perform the test
        ResponseEntity<?> responseEntity = userController.userRegister(user);

        // Assert the response
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        ErrorResponse errorResponse = (ErrorResponse) responseEntity.getBody();
        Assertions.assertNotNull(errorResponse);
        Assertions.assertEquals("User already present", errorResponse.getMessage());
    }

    @Test
    public void testUserInfoEdit_UserNotFound() {
        // Prepare the user edit request DTO with a null email (user not found)
        UserEditRequestDTO userEditRequestDTO = new UserEditRequestDTO();

        // Mock the userService method to return null (user not found)
        Mockito.when(userService.getUserbyEmail(userEditRequestDTO))
                .thenReturn(null);

        // Perform the test
        ResponseEntity<?> responseEntity = userController.userInfoEdit(userEditRequestDTO);

        // Assert the response
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        ErrorResponse errorResponse = (ErrorResponse) responseEntity.getBody();
        Assertions.assertNotNull(errorResponse);
        Assertions.assertEquals("User edit api failed", errorResponse.getMessage());
    }

    @Test
    public void testForgotPasswordForUser_OTPGenerationSuccess() {
        // Prepare the user object with email
        User user = new User();
        user.setEmail("test@example.com");

        // Prepare the user edit request DTO
        UserEditRequestDTO userEditRequestDTO = new UserEditRequestDTO();
        userEditRequestDTO.setEmail(user.getEmail());

        // Prepare the user object to be returned by getUserbyEmail method
        User userFromDb = new User();
        userFromDb.setUserId("10004");
        userFromDb.setPassword("test_password");

        // Mock the userService method to return the user object
        Mockito.when(userService.getUserbyEmail(userEditRequestDTO))
                .thenReturn(userFromDb);

        // Mock the OTPService method to return true (OTP generation success)
        Mockito.when(otpService.generateOTP(userFromDb.getEmail()))
                .thenReturn(true);

        // Perform the test
        ResponseEntity<?> responseEntity = userController.forgotPasswordForUser(user);

        // Assert the response
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        ResponseDTO responseDTO = (ResponseDTO) responseEntity.getBody();
        Assertions.assertNotNull(responseDTO);
        Assertions.assertEquals("OTP Generated", responseDTO.getMessage());
    }

    @Test
    public void testForgotPasswordForUser_UserNotFound() {
        // Prepare the user object with email
        User user = new User();
        user.setEmail("non_existent_user@example.com");

        // Prepare the user edit request DTO
        UserEditRequestDTO userEditRequestDTO = new UserEditRequestDTO();
        userEditRequestDTO.setEmail(user.getEmail());

        // Mock the userService method to return null (user not found)
        Mockito.when(userService.getUserbyEmail(userEditRequestDTO))
                .thenReturn(null);

        // Perform the test
        ResponseEntity<?> responseEntity = userController.forgotPasswordForUser(user);

        // Assert the response
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        ErrorResponse errorResponse = (ErrorResponse) responseEntity.getBody();
        Assertions.assertNotNull(errorResponse);
        Assertions.assertEquals("User Not Found", errorResponse.getMessage());
    }

    @Test
    public void testVerifyUser_Success() {
        // Prepare the OTPRequestDTO with a valid OTP
        OTPRequestDTO otpRequestDTO = new OTPRequestDTO();
        otpRequestDTO.setOtp("1234"); // Replace "1234" with the valid OTP generated during the test

        // Mock the OTPService method to return true (successful OTP verification)
        Mockito.when(otpService.verifyUserUsingOTP(otpRequestDTO))
                .thenReturn(true);

        // Perform the test
        ResponseEntity<?> responseEntity = userController.verifyUser(otpRequestDTO);

        // Assert the response
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        ResponseDTO responseDTO = (ResponseDTO) responseEntity.getBody();
        Assertions.assertNotNull(responseDTO);
        Assertions.assertEquals("success", responseDTO.getMessage());
    }

    @Test
    public void testVerifyUser_IncorrectOTP() {
        // Prepare the OTPRequestDTO with an incorrect OTP
        OTPRequestDTO otpRequestDTO = new OTPRequestDTO();
        otpRequestDTO.setOtp("0000"); // Set an incorrect OTP

        // Mock the OTPService method to return false (incorrect OTP)
        Mockito.when(otpService.verifyUserUsingOTP(otpRequestDTO))
                .thenReturn(false);

        // Perform the test
        ResponseEntity<?> responseEntity = userController.verifyUser(otpRequestDTO);

        // Assert the response
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        ResponseDTO responseDTO = (ResponseDTO) responseEntity.getBody();
        Assertions.assertNotNull(responseDTO);
        Assertions.assertEquals("Incorrect OTP", responseDTO.getMessage());
    }*/
}