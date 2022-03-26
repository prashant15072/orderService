package com.suprdaily.orderservice.repo;

import com.suprdaily.orderservice.entity.CategoryToLimit;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DailyLimit {
    private static Map<String, CategoryToLimit> dailyLimit;

    public static HashMap<String,CategoryToLimit> getMap(){
        if(dailyLimit==null){
            dailyLimit = new HashMap<>();
        }
        return new HashMap<>(dailyLimit);
    }

    public static CategoryToLimit getCategoryToLimit(String date){
        getMap();
        return dailyLimit.getOrDefault(date,null);
    }

    public static void addCategory(String date){
        getMap();
        dailyLimit.put(date,new CategoryToLimit());
    }
}
