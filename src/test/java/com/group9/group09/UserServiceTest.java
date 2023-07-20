package com.group9.group09;

import com.group9.group09.DTO.ResponseDTO;
import com.group9.group09.config.JwtService;
import com.group9.group09.model.User;
import com.group9.group09.repository.UserRepositoryImpl;
import com.group9.group09.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private static UserRepositoryImpl userRepositoryMock;
    @Mock
    private static AuthenticationManager authenticationManager;
    private static UserServiceImpl userService;
    @Mock
    private JwtService jwtService;
    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    private void injectMockSetup() {
        userService = new UserServiceImpl(userRepositoryMock, passwordEncoder, jwtService, authenticationManager);
    }

    @Test
    public void testLoginUserService() {

        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");

        when(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getEmail(),
                user.getPassword()
        ))).thenReturn(null);
        when(userRepositoryMock.findByUsermail("test@example.com")).thenReturn(Optional.of(user));
        when(jwtService.generateToken(user)).thenReturn("mockToken");

        ResponseDTO response = userService.loginUserService(user);

        assertNotNull(response);
        assertEquals("mockToken", response.getToken());
    }

    /*@Test
    public void testRegisterUserService() {

        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        user.setName("test");
        user.setPhone("9876543210");
        user.setHomeCountry(1);
        user.setUserId("12");

        when(userRepositoryMock.findByUsermail("test@example.com")).thenReturn(Optional.of(user));
        when(userRepositoryMock.saveUserInfo(user)).thenReturn(1);
        when(jwtService.generateToken(user)).thenReturn("mockToken");

        ResponseDTO response = userService.registerUserService(user);

        assertNotNull(response);
        assertEquals("mockToken", response.getToken());
    }*/
}
