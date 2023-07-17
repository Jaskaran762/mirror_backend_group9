package com.group9.group09.DTO;

import com.group9.group09.model.ItemstoCarry;

import java.util.List;

public class ItemsToCarryResponseDTO {
    private List<ItemstoCarry> itemstoCarryResponseList;

    public List<ItemstoCarry> getItemstoCarryResponseList() {
        return itemstoCarryResponseList;
    }

    public void setItemstoCarryResponseList(List<ItemstoCarry> itemstoCarryResponseList) {
        this.itemstoCarryResponseList = itemstoCarryResponseList;
    }
}
