package com.group9.group09.service;

import com.group9.group09.DTO.ResponseDTO;
import com.group9.group09.config.JwtService;
import com.group9.group09.exception.UserNotFoundException;
import com.group9.group09.model.User;
import com.group9.group09.repository.interfaces.UserRepository;
import com.group9.group09.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Handles the user login service.
     *
     * @param user the User object containing login credentials
     * @return the ResponseDTO object
     */
    @Override
    public ResponseDTO loginUserService(User user) {

        if (isNullOrEmpty(user.getEmail()) || isNullOrEmpty(user.getPassword())) {
            throw new UserNotFoundException("Empty fields");
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(),
                        user.getPassword()
                )
        );

        ResponseDTO loginStatus = new ResponseDTO();

        Optional<User> userInfo = userRepository.findByUsermail(user.getEmail());

        if (userInfo != null) {
            var jwtToken = jwtService.generateToken(userInfo.get());
            loginStatus.setToken(jwtToken);
            loginStatus.setEmail(user.getEmail());
            loginStatus.setSuccess("ok");
        }

        return loginStatus;
    }

    /**
     * Handles the user registration service.
     *
     * @param user the User object containing registration details
     * @return the ResponseDTO object
     */
    @Override
    public ResponseDTO registerUserService(User user) {

        ResponseDTO registerStatus = new ResponseDTO();

        if (isNullOrEmpty(user.getEmail()) || isNullOrEmpty(user.getPassword()) || isNullOrEmpty(user.getName())) {
            throw new RuntimeException();
        }

        Optional<User> userInfo ;

        try{
            userRepository.findByUsermail(user.getEmail());
            registerStatus.setSuccess("User already present");
            return registerStatus;
        }catch (RuntimeException e){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            if (userRepository.saveUserInfo(user) == 1) {
                var jwtToken = jwtService.generateToken(user);
                registerStatus.setToken(jwtToken);
                registerStatus.setEmail(user.getEmail());
                registerStatus.setSuccess("ok");

            } else {
                throw new RuntimeException();
            }
            return registerStatus;
        }
    }

    /**
     * Handles the update user password service.
     *
     * @param user the User object containing updated password
     * @return the ResponseDTO object
     */
    @Override
    public ResponseDTO updateUserpasswordService(User user) {
        return null;
    }

    /**
     * Handles the update user phone number service.
     *
     * @param user the User object containing updated phone number
     * @return the ResponseDTO object
     */
    @Override
    public ResponseDTO updateUserphoneNumberService(User user) {
        return null;
    }

    private boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }
}
