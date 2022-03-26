package com.suprdaily.orderservice.service;

import com.suprdaily.orderservice.dao.ItemsItem;
import com.suprdaily.orderservice.dao.OrderRequest;
import com.suprdaily.orderservice.entity.CategoryToLimit;
import com.suprdaily.orderservice.entity.WareHouse;
import com.suprdaily.orderservice.repo.DailyLimit;
import com.suprdaily.orderservice.repo.WareHouseMap;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class ValidationServiceImpl implements ValidationService{
    @Override
    public boolean checkDailyLimit(OrderRequest orderRequest) {
        boolean result = false;

        CategoryToLimit categoryToLimit = DailyLimit.getCategoryToLimit(orderRequest.getDeliveryDate());
        if(categoryToLimit==null){
            //no order received yet
            return true;
        }

        Map<String,Integer> categoryMap = categoryToLimit.getCategoryMap();
        for(ItemsItem item:orderRequest.getItems()){
            if(!categoryMap.containsKey(item.getCategory()) || categoryMap.get(item.getCategory())< item.getQuantity()){
                return false;
            }
        }

        return true;
    }

    public boolean checkIfOrderFulfilable(OrderRequest orderRequest){
        WareHouse wareHouse = WareHouseMap.getWareHouse(orderRequest.getWarehouseId());
        Map<Integer,Integer> itemsMap = wareHouse.getUnOrderedItems();
        for(ItemsItem item : orderRequest.getItems()) {
            try {
                int quant = itemsMap.get(item.getItemId());
                if(quant<item.getQuantity()){
                    return false;
                }

            }catch (RuntimeException ex){
                return false;
            }
        }

        return true;
    }
}
