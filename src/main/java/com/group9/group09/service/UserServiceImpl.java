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

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

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
        }

        return loginStatus;
    }

    @Override
    public ResponseDTO registerUserService(User user) {

        ResponseDTO registerStatus = new ResponseDTO();

        if (isNullOrEmpty(user.getEmail()) || isNullOrEmpty(user.getPassword()) || isNullOrEmpty(user.getName())) {
            throw new RuntimeException();
        }

        Optional<User> userInfo = userRepository.findByUsermail(user.getEmail());
        if (userInfo != null && !userInfo.get().getUserId().isEmpty()) {
            throw new RuntimeException();
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (userRepository.saveUserInfo(user) == 1) {
            var jwtToken = jwtService.generateToken(user);
            registerStatus.setToken(jwtToken);
        } else {
            throw new RuntimeException();
        }

        return registerStatus;
    }

    @Override
    public ResponseDTO updateUserpasswordService(User user) {
        return null;
    }

    @Override
    public ResponseDTO updateUserphoneNumberService(User user) {
        return null;
    }

    private boolean isNullOrEmpty(String value) {
        return value == null || value.isEmpty();
    }
}
