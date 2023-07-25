package com.group9.group09.DTO.ResponseDTO;

import com.group9.group09.model.wishList;

import java.util.List;

public class WishListResponseDTO {


    private List<wishList> wishLists;

    public List<wishList> getWishLists() {
        return wishLists;
    }

    public void setWishLists(List<wishList> wishLists) {
        this.wishLists = wishLists;
    }


}