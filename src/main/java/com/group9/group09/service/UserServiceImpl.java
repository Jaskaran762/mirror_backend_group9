package com.group9.group09.service;

import com.group9.group09.DTO.ResponseDTO;
import com.group9.group09.exception.UserNotFoundException;
import com.group9.group09.model.User;
import com.group9.group09.repository.interfaces.UserRepository;
import com.group9.group09.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseDTO loginUserService(User user) {

        ResponseDTO loginStatus = new ResponseDTO();

        try {
            if (isNullOrEmpty(user.getEmail()) || isNullOrEmpty(user.getPassword())) {
                throw new UserNotFoundException("RESP003");
            }

            User userInfo = userRepository.findByUsermail(user.getEmail());
            if (userInfo != null) {
                int passwordCmp = user.getPassword().compareTo(userInfo.getPassword());
                if (passwordCmp == 0) {
                    loginStatus.setRespStatus(true);
                    loginStatus.setRespMsg("Login successful");
                    loginStatus.setRespCde("RESP001");
                } else {
                    loginStatus.setRespStatus(false);
                    loginStatus.setRespMsg("Password incorrect");
                    loginStatus.setRespCde("RESP002");
                }
            } else {
                throw new UserNotFoundException("RESP003");
            }
        } catch (UserNotFoundException exception) {
            loginStatus.setRespStatus(false);
            loginStatus.setRespMsg("User not found. Enter a valid email address");
            loginStatus.setRespCde(exception.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginStatus;
    }

    @Override
    public ResponseDTO registerUserService(User user) {

        ResponseDTO registerStatus = new ResponseDTO();

        try {
            if (isNullOrEmpty(user.getEmail()) || isNullOrEmpty(user.getPassword()) || isNullOrEmpty(user.getName())) {
                throw new RuntimeException("RESP004");
            }

            User userInfo = userRepository.findByUsermail(user.getEmail());
            if (userInfo != null && !userInfo.getUserId().isEmpty()) {
                throw new RuntimeException("RESP004");
            }

            if (userRepository.saveUserInfo(user) == 1) {
                registerStatus.setRespCde("RESP005");
                registerStatus.setRespStatus(true);
                registerStatus.setRespMsg("Registration successful");
            } else {
                throw new RuntimeException("RESP006");
            }
        } catch (Exception e) {
            if (e.getMessage().equals("RESP004")) {
                registerStatus.setRespCde(e.getMessage());
                registerStatus.setRespMsg("User already exists");
            } else if (e.getMessage().equals("RESP006")) {
                registerStatus.setRespCde(e.getMessage());
                registerStatus.setRespMsg("Database error");
            }
            registerStatus.setRespStatus(false);
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
