package com.suprdaily.orderservice.repo;

import com.suprdaily.orderservice.entity.WareHouse;

import java.util.HashMap;
import java.util.Map;

public class WareHouseMap {
    private static Map<Integer, WareHouse> map;

    public static HashMap<Integer,WareHouse> getMap(){
        if(map==null){
            map = new HashMap<>();
        }
        return new HashMap<>(map);
    }

    public static WareHouse getWareHouse(int wareHouse){
        getMap();
        return map.getOrDefault(wareHouse,null);
    }

    public static void addWareHouse(int wareHouseId,WareHouse wareHouse){
        getMap();
        map.put(wareHouseId,wareHouse);
    }
}
