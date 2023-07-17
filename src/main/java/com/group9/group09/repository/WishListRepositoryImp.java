package com.group9.group09.repository;

import com.group9.group09.model.wishList;
import com.group9.group09.repository.interfaces.WishlistRepository;
import com.group9.group09.repository.rowmapper.WishListRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WishListRepositoryImp implements WishlistRepository {

    private final JdbcTemplate jdbcTemplate;

    public WishListRepositoryImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<wishList> getWishListbyUserID(Integer userID) {

        try{
                String getWishListbyUserIDQuery = "Select * from Wishlist where user_id=?";
                return jdbcTemplate.query(getWishListbyUserIDQuery,new WishListRowMapper(),userID);

        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
