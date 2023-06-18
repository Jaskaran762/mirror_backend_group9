package com.group9.group09.repository.interfaces;

import com.group9.group09.model.User;

public interface UserRepository {

	int saveUserInfo(User user);
	
	int updateUserPassword(User user);
	
	int updateUserEmail(User user);
	
	User findByUserId(String userId);
	
	int deleteByUserId(String userId);

	User findByUsermail(String email);
}
