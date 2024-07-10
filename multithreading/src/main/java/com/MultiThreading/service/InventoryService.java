package com.MultiThreading.service;

import com.MultiThreading.domain.Inventory;
import com.MultiThreading.domain.ProductOption;

import static com.MultiThreading.util.CommonUtil.delay;

public class InventoryService {
    public Inventory retrieveInventory(ProductOption productOption) {
        delay(500);
        return Inventory.builder()
                .count(2).build();

    }
}
