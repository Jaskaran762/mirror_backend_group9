package com.group9.group09.repository;

import com.group9.group09.model.User;
import com.group9.group09.repository.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int saveUserInfo(User user) {
		String sql = "INSERT INTO USER (name, username, email, password) VALUES (?, ?, ?, ?)";
		return jdbcTemplate.update(sql, user.getName(), user.getUserId(), user.getEmail(), user.getPassword());
	}

	@Override
	public int updateUserPassword(User user) {
		String sql = "UPDATE USER SET password = ? WHERE id = ?";
		return jdbcTemplate.update(sql, user.getPassword(), user.getUserId());
	}

	@Override
	public int updateUserEmail(User user) {
		String sql = "UPDATE USER SET email = ? WHERE id = ?";
		return jdbcTemplate.update(sql, user.getEmail(), user.getUserId());
	}

	@Override
	public User findByUserId(String userId) {
		try {
			String sql = "SELECT * FROM USER WHERE id = ?";
			return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class), userId);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public User findByUsermail(String email) {
		try {
			String sql = "SELECT * FROM USER WHERE email = ?";
			return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class), email);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public int deleteByUserId(String id) {
		String sql = "DELETE FROM USER WHERE id = ?";
		return jdbcTemplate.update(sql, id);
	}
}