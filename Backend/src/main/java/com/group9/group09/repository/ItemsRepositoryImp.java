package com.group9.group09.repository;

import com.group9.group09.model.ItemstoCarry;
import com.group9.group09.repository.interfaces.ItemsRepository;
import com.group9.group09.repository.rowmapper.ActivityRowMapper;
import com.group9.group09.repository.rowmapper.ItemstoCarryRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemsRepositoryImp implements ItemsRepository{

    private final JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactory.getLogger(ItemsRepositoryImp.class);

    public ItemsRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ItemstoCarry> getAllItems() {

        try {
            logger.info("Info Message: ");
            String getAllItemstoCarryQuery = "SELECT * FROM Itemstocarry";
            return jdbcTemplate.query(getAllItemstoCarryQuery, new ItemstoCarryRowMapper(), null);
        } catch (Exception e) {
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }
    }
}