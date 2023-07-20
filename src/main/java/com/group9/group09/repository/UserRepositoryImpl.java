package com.group9.group09.repository;

import com.group9.group09.exception.UserNotFoundException;
import com.group9.group09.model.User;
import com.group9.group09.repository.interfaces.UserRepository;
import com.group9.group09.repository.rowmapper.UserRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);
    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int saveUserInfo(User user) {

        try {
            logger.info("Info Message: ");
            Integer userId = jdbcTemplate.queryForObject("SELECT MAX(USERID) FROM User", Integer.class);
            String sql = "INSERT INTO User (name, UserID, email, password,homecountry) VALUES (?, ?, ?, ?,?)";
            return jdbcTemplate.update(sql, user.getName(), userId+1, user.getEmail(), user.getPassword(),user.getHomeCountry());
        } catch (Exception e) {
            logger.error("Error Message: ");
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
            logger.info("Info Message: ");
            String sql = "SELECT * FROM User where UserID = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new UserRowMapper(), userId));
        } catch (Exception e) {
            logger.error("Error Message: ");
            throw new UserNotFoundException("Line 65 ,userimp class");
        }
    }

    @Override
    public Optional<User> findByUsermail(String email) {
        try {
            logger.info("Info Message: ");
            String sql = "SELECT * FROM User WHERE email = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new UserRowMapper(), email));
        } catch (Exception e) {
            logger.error("Error Message: ");
            throw new UserNotFoundException("Line 65 ,userimp class ");
        }
    }

    @Override
    public int deleteByUserId(String id) {
        String sql = "DELETE FROM User WHERE UserID = ?";
        return jdbcTemplate.update(sql, id);
    }
}