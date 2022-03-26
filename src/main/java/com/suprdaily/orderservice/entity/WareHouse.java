package com.suprdaily.orderservice.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class WareHouse {
    private Map<Integer,Integer> unOrderedItems;

    public WareHouse() {
        this.unOrderedItems = new HashMap<>();
    }
}
