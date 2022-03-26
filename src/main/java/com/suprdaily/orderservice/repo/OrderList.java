package com.suprdaily.orderservice.repo;

import com.suprdaily.orderservice.entity.Order;

import java.util.*;

public class OrderList {
    private static List<Order> orderList;

    public static List<Order> getList(){
        if(orderList ==null){
            orderList = new ArrayList<>();
        }
        return new ArrayList<>(orderList);
    }

    public static void addToList(Order order){
        getList();
        orderList.add(order);
    }
}
