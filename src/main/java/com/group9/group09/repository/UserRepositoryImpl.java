package com.group9.group09.repository;

import com.group9.group09.model.User;
import com.group9.group09.repository.interfaces.UserRepository;
import com.group9.group09.repository.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int saveUserInfo(User user) {

        try {
            Integer userId = jdbcTemplate.queryForObject("SELECT MAX(USERID) FROM User", Integer.class);

            String sql = "INSERT INTO User (name, UserID, email, password) VALUES (?, ?, ?, ?)";
            return jdbcTemplate.update(sql, user.getName(), userId+1, user.getEmail(), user.getPassword());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Override
    public int updateUserPassword(User user) {
        String sql = "UPDATE User SET password = ? WHERE UserID = ?";
        return jdbcTemplate.update(sql, user.getPassword(), user.getUserId());
    }

    @Override
    public int updateUserEmail(User user) {
        String sql = "UPDATE User SET email = ? WHERE UserID = ?";
        return jdbcTemplate.update(sql, user.getEmail(), user.getUserId());
    }

    @Override
    public Optional<User> findByUserId(String userId) {
        try {
            String sql = "SELECT * FROM User where UserID = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new UserRowMapper(), userId));
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Optional<User> findByUsermail(String email) {
        try {
            String sql = "SELECT * FROM User WHERE email = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new UserRowMapper(), email));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int deleteByUserId(String id) {
        String sql = "DELETE FROM User WHERE UserID = ?";
        return jdbcTemplate.update(sql, id);
    }
}