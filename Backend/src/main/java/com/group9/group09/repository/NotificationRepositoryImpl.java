package com.group9.group09.repository;

import com.group9.group09.Logger.LoggerFactoryImpl;
import com.group9.group09.model.Notification;
import com.group9.group09.repository.interfaces.NotificationRepository;
import com.group9.group09.repository.rowmapper.NotificationRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NotificationRepositoryImpl implements NotificationRepository {

    private static Logger logger = LoggerFactoryImpl.getLogger();
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public NotificationRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Notification> fetchNotificationsForUser(String userId) {
        try {
            logger.info("Info Message: ");
            String getNotificationsForUser = "SELECT * FROM Notification where user_id = ?";
            return jdbcTemplate.query(getNotificationsForUser, new NotificationRowMapper(), userId);
        } catch (Exception e) {
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }
    }

    public int setNotificationsForUser(Notification notification) {
        try {
            logger.info("Info Message: ");
            Integer notifyId = jdbcTemplate.queryForObject("SELECT MAX(id) FROM Notification", Integer.class);
            String sql = "Insert into Notification (id, category, description, user_id) " +
                    "VALUES (?,?,?,?)";
            return jdbcTemplate.update(sql, notifyId + 1, notification.getCategory(),
                    notification.getDescription(), notification.getUserId());
        } catch (Exception e) {
            logger.error("Error Message: ");
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
