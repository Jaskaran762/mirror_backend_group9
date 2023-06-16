package com.group9.group09.service.interfaces;

import com.group9.group09.DTO.ResponseDTO;
import com.group9.group09.model.User;

public interface UserService {

    ResponseDTO loginUserService(User user);

    ResponseDTO registerUserService(User user);

    ResponseDTO updateUserpasswordService(User user);

    ResponseDTO updateUserphoneNumberService(User user);
}
