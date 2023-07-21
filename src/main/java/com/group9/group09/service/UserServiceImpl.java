package com.group9.group09.service;

import com.group9.group09.DTO.ResponseDTO;
import com.group9.group09.DTO.UserEditRequestDTO;
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

/**
 * Service implementation class for user-related operations.
 */
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

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

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

        Optional<User> userInfo;

        try {
            userRepository.findByUsermail(user.getEmail());
            registerStatus.setSuccess("User already present");
            return registerStatus;
        } catch (RuntimeException e) {
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
     * @param
     * @return the ResponseDTO object
     */
 /*   @Override
    public ResponseDTO updateUserpasswordService(UserEditRequestDTO userEditRequestDTO) {
        if (isNullOrEmpty(userEditRequestDTO.getUser().getEmail()) || isNullOrEmpty(userEditRequestDTO.getUser().getPassword())) {
            throw new UserNotFoundException("Fill in user name and password for updating password");
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userEditRequestDTO.getUser().getEmail(),
                        userEditRequestDTO.getUser().getPassword()
                )
        );

        ResponseDTO updatedUserResponsedDTO = new ResponseDTO();

        Optional<User> userInfo = userRepository.findByUsermail(userEditRequestDTO.getUser().getEmail());

        if (userInfo != null) {
          //  var jwtToken = jwtService.generateToken(userInfo.get());

            int success = userRepository.updateUserPassword(userEditRequestDTO.getUser(), userEditRequestDTO.getNewpassword());

            if(success == 1){
                updatedUserResponsedDTO.setSuccess("Successfully Updated");
                updatedUserResponsedDTO.setEmail(userEditRequestDTO.getUser().getEmail());
               // updatedUserResponsedDTO.setToken(jwtToken);
            }else {
                updatedUserResponsedDTO.setSuccess("Error while updating the User password");
                updatedUserResponsedDTO.setEmail(userEditRequestDTO.getUser().getEmail());
             //   updatedUserResponsedDTO.setToken(jwtToken);
            }
        }

        return updatedUserResponsedDTO;
    }*/
    @Override
    public ResponseDTO updateUserpasswordService(UserEditRequestDTO userEditRequestDTO) {
        ResponseDTO responseDTO = new ResponseDTO();

        if (isNullOrEmpty(userEditRequestDTO.getUser().getUserId()) || isNullOrEmpty(userEditRequestDTO.getNewpassword())) {
            throw new UserNotFoundException("Empty fields");
        }

        // Find the user by ID from the database
        Optional<User> userPresent = userRepository.findByUsermail(userEditRequestDTO.getEmail());

        if (userPresent.isPresent()) {
            User user = userPresent.get();
            // Set the new password after encoding it
            //  user.setPassword(passwordEncoder.encode(userEditRequestDTO.getNewpassword()));
            // Save the updated user to the database
            //   userRepository.updateUserPassword(userEditRequestDTO.getUser(), userEditRequestDTO.getNewpassword());

            userRepository.updateUserPassword(userEditRequestDTO.getUser(), passwordEncoder.encode(userEditRequestDTO.getNewpassword()));

            responseDTO.setSuccess("Password updated successfully");
        } else {
            throw new UserNotFoundException("User not found");
        }

        return responseDTO;

    }

    /**
     * Retrieves the user by email.
     *
     * @param userEditRequestDTO the UserEditRequestDTO object containing user email
     * @return the User object
     */
    @Override
    public User getUserbyEmail(UserEditRequestDTO userEditRequestDTO) {

        User user;
        user = userRepository.getUserbyemail(userEditRequestDTO.getEmail());
        if (user == null) throw new UserNotFoundException("User not found");
        return user;
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
