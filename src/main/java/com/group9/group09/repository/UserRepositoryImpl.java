package com.group9.group09.repository;

import com.group9.group09.exception.UserNotFoundException;
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

            String sql = "INSERT INTO User (name, UserID, email, password,homecountry) VALUES (?, ?, ?, ?,?)";
            return jdbcTemplate.update(sql, user.getName(), userId+1, user.getEmail(), user.getPassword(),user.getHomeCountry());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1 ;
        }
    }

    @Override
    public int updateUserPassword(User user,String newpassword) {
        try{

            String updateUserPasswordQuery = "UPDATE User SET password = ? WHERE UserID = ?";

            return jdbcTemplate.update(updateUserPasswordQuery ,newpassword,user.getUserId());

        }catch (Exception e){
            throw new UserNotFoundException("User update failed");
        }
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
            throw new UserNotFoundException("Line 65 ,userimp class");
        }
    }

    @Override
    public Optional<User> findByUsermail(String email) {
        try {
            String sql = "SELECT * FROM User WHERE email = ?";
            return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new UserRowMapper(), email));
        } catch (Exception e) {
            throw new UserNotFoundException("Line 65 ,userimp class ");
        }
    }

    @Override
    public int deleteByUserId(String id) {
        String sql = "DELETE FROM User WHERE UserID = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public User getUserbyemail(String email) {
      try{
          String getUserbyIDQuery = "Select * FROM User WHERE email = ?";
            return jdbcTemplate.queryForObject(getUserbyIDQuery,new UserRowMapper() ,email);
      }catch (Exception e){
          throw new UserNotFoundException(e.getMessage());
      }
    }
}