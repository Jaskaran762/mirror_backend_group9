package com.group9.group09.repository;

import com.group9.group09.model.wishList;
import com.group9.group09.repository.interfaces.WishlistRepository;
import com.group9.group09.repository.rowmapper.WishListRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WishListRepositoryImp implements WishlistRepository {

    private final JdbcTemplate jdbcTemplate;

    private static Logger logger = LoggerFactory.getLogger(WishListRepositoryImp.class);
    public WishListRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<wishList> getWishListbyUserID(Integer userID) {

        try{
            logger.info("Info Message: ");
            String getWishListbyUserIDQuery = "Select * from Wishlist where user_id=?";
            return jdbcTemplate.query(getWishListbyUserIDQuery,new WishListRowMapper(),userID);

        }catch (Exception e){
            logger.error("Error Message: ");
            throw new RuntimeException(e.getMessage());
        }
    }
}
