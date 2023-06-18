package com.group9.group09;

import com.group9.group09.DTO.ResponseDTO;
import com.group9.group09.model.User;
import com.group9.group09.repository.UserRepositoryImpl;
import com.group9.group09.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

    @Mock
    private static UserRepositoryImpl userRepositoryMock;

    private static UserServiceImpl userService;

    @BeforeEach
    private void injectMockSetup(){
        userService = new UserServiceImpl(userRepositoryMock);
    }

    @Test
    public void testLoginUserService() {

        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");

        when(userRepositoryMock.findByUsermail("test@example.com")).thenReturn(user);

        ResponseDTO response = userService.loginUserService(user);

        assertTrue(response.isRespStatus());
        assertEquals("RESP001", response.getRespCde());
        assertEquals("Login successful", response.getRespMsg());
    }

    @Test
    public void testRegisterUserService(){

        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        user.setName("test");
        user.setPhone("9876543210");
        user.setUserId("12");

        when(userRepositoryMock.findByUsermail("test@example.com")).thenReturn(null);
        when(userRepositoryMock.saveUserInfo(user)).thenReturn(1);

        ResponseDTO response = userService.registerUserService(user);

        assertTrue(response.isRespStatus());
        assertEquals("RESP005", response.getRespCde());
        assertEquals("Registration successful", response.getRespMsg());
    }

}
