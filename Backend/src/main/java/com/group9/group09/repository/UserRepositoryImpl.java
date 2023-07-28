package com.group9.group09.repository;

import com.group9.group09.Logger.LoggerFactoryImpl;
import com.group9.group09.exception.UserNotFoundException;
import com.group9.group09.model.User;
import com.group9.group09.repository.interfaces.UserRepository;
import com.group9.group09.repository.rowmapper.UserRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactoryImpl.getLogger();
    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int saveUserInfo(User user) {

        try {
            logger.info("Info Message: ");
            Integer userId = jdbcTemplate.queryForObject("SELECT MAX(USERID) FROM User", Integer.class);
            String sql = "INSERT INTO User (name, UserID, email, password,homecountry, interest) VALUES (?, ?, ?, ?,?,?)";
            return jdbcTemplate.update(sql, user.getName(), userId+1, user.getEmail(), user.getPassword(),user.getHomeCountry(), user.getInterest());
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new UserNotFoundException("Error in saving users in database");
        }
    }

    @Override
    public int updateUserPassword(User user,String newpassword) {
        try{
            String updateUserPasswordQuery = "UPDATE User SET password = ? WHERE UserID = ?";
            return jdbcTemplate.update(updateUserPasswordQuery ,newpassword,user.getUserId());
        }catch (DataAccessException e){
            logger.error("Error Message: ");
            throw new UserNotFoundException("Error in updating users password in database");
        }
    }

    @Override
    public int updateUserEmail(User user) {
        try {
            String sql = "UPDATE User SET email = ? WHERE UserID = ?";
            return jdbcTemplate.update(sql, user.getEmail(), user.getUserId());
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new UserNotFoundException("Error in updating users email in database");
        }

    }

    @Override
    public int updateUserName(User user) {
        try {
            String sql = "UPDATE User SET name = ? WHERE UserID = ?";
            return jdbcTemplate.update(sql, user.getName(), user.getUserId());
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new UserNotFoundException("Error in updating users name in database");
        }

    }

    @Override
    public int updateUserPhone(User user) {
        try {
            String sql = "UPDATE User SET contact_no = ? WHERE UserID = ?";
            return jdbcTemplate.update(sql, user.getPhone(), user.getUserId());
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new UserNotFoundException("Error in updating users contact in database");
        }

    }

    @Override
    public int updateUserInterests(User user) {
        try {
            String sql = "UPDATE User SET interest = ? WHERE UserID = ?";
            return jdbcTemplate.update(sql, user.getInterest(), user.getUserId());
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new UserNotFoundException("Error in updating users interests in database");
        }

    }

    @Override
    public int updateUserCountry(User user) {
        try {
            String sql = "UPDATE User SET homeCountry = ? WHERE UserID = ?";
            return jdbcTemplate.update(sql, user.getHomeCountry(), user.getUserId());
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new UserNotFoundException("Error in updating users in database");
        }
    }

    @Override
    public Optional<User> findByUserId(String userId) {
        try {
            logger.info("Info Message: ");
            String sql = "SELECT * FROM User where UserID = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new UserRowMapper(), userId));
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new UserNotFoundException("Error in fetching users data from database");
        }
    }

    @Override
    public Optional<User> findByUsermail(String email) {
        try {
            logger.info("Info Message: ");
            String sql = "SELECT * FROM User WHERE email = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new UserRowMapper(), email));
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new UserNotFoundException("Error in fetching users data from database");
        }
    }

    @Override
    public int deleteByUserId(String id) {
        try {
            String sql = "DELETE FROM User WHERE UserID = ?";
            return jdbcTemplate.update(sql, id);
        } catch (DataAccessException e) {
            logger.error("Error Message: ");
            throw new UserNotFoundException("Error in deleting users data from database");
        }

    }

    @Override
    public User getUserbyemail(String email) {
      try{
          String getUserbyIDQuery = "Select * FROM User WHERE email = ?";
          return jdbcTemplate.queryForObject(getUserbyIDQuery,new UserRowMapper() ,email);
      }catch (DataAccessException e){
          logger.error("Error Message: ");
          throw new UserNotFoundException(e.getMessage());
      }
    }
}