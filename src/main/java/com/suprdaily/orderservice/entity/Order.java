package com.suprdaily.orderservice.entity;

import com.suprdaily.orderservice.dao.ItemsItem;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Order {
    private final int orderId;
    private List<ItemsItem> items;
    private final String orderDate;
}
