package com.group9.group09.repository.interfaces;

import com.group9.group09.model.User;

import java.util.Optional;

public interface UserRepository {

	int saveUserInfo(User user);
	
	int updateUserPassword(User user,String newpassword);
	
	int updateUserEmail(User user);

	Optional<User> findByUserId(String userId);
	
	int deleteByUserId(String userId);

	Optional<User> findByUsermail(String email);

	User getUserbyemail(String email);
}
