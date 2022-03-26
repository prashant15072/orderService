package com.suprdaily.orderservice.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class CategoryToLimit {
    private Map<String,Integer> categoryMap;

    public CategoryToLimit(){
        categoryMap= new HashMap<>();
    }

}
