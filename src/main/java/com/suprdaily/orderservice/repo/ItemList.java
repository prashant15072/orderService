package com.suprdaily.orderservice.repo;

import com.suprdaily.orderservice.entity.Item;

import java.util.HashMap;
import java.util.Map;

public class ItemList {
    private static Map<Integer,Item> itemList;

    public static Map<Integer,Item> getItemMap(){
        if(itemList==null){
            itemList = new HashMap<>();
        }
        return new HashMap<>(itemList);
    }

    public static void addToMap(int itemId,Item item){
        getItemMap();
        itemList.put(itemId,item);
    }

}
