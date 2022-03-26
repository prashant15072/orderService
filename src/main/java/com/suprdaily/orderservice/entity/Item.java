package com.suprdaily.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Item {
    private final int itemId;
    private final String itemName;
    private final String category;
}
