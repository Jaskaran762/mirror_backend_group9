package com.group9.group09.repository.interfaces;

import com.group9.group09.model.wishList;

import java.util.ArrayList;
import java.util.List;

public interface WishlistRepository {

    List<wishList> getWishListbyUserID(Integer userID);

}
