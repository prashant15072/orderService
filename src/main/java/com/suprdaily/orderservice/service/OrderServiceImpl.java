package com.suprdaily.orderservice.service;

import com.suprdaily.orderservice.Constants;
import com.suprdaily.orderservice.dao.FulFilOrderResponse;
import com.suprdaily.orderservice.dao.ItemsItem;
import com.suprdaily.orderservice.dao.OrderRequest;
import com.suprdaily.orderservice.dao.ReserveOrderResponse;
import com.suprdaily.orderservice.entity.Order;
import com.suprdaily.orderservice.exception.OrderFulfilmentException;
import com.suprdaily.orderservice.exception.OrderReservationException;
import com.suprdaily.orderservice.mapper.ResponseMapper;
import com.suprdaily.orderservice.repo.DailyLimit;
import com.suprdaily.orderservice.repo.OrderList;
import com.suprdaily.orderservice.repo.WareHouseMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService{
    private ValidationService validationService;
    private ResponseMapper responseMapper;

    @Autowired
    public OrderServiceImpl(ValidationService validationService, ResponseMapper responseMapper) {
        this.validationService = validationService;
        this.responseMapper = responseMapper;
    }

    @Override
    public FulFilOrderResponse canFulfilOrder(OrderRequest orderRequest) {
        if (!validationService.checkDailyLimit(orderRequest) || !validationService.checkIfOrderFulfilable(orderRequest)) {
            throw new OrderFulfilmentException();
        }

        return responseMapper.getSuccessResponseForFulfilOrder();
    }

    @Override
    public ReserveOrderResponse reserverOrder(OrderRequest orderRequest) {
        if (!validationService.checkDailyLimit(orderRequest) || !validationService.checkIfOrderFulfilable(orderRequest)) {
            throw new OrderReservationException();
        }

        //update the quantity and the daily limit
        Map<Integer,Integer> mapOfItems = WareHouseMap.getWareHouse(orderRequest.getWarehouseId()).getUnOrderedItems();

        if (DailyLimit.getCategoryToLimit(orderRequest.getDeliveryDate())==null){
            DailyLimit.addCategory(orderRequest.getDeliveryDate());
        }
        Map<String,Integer> categoryMap = DailyLimit.getCategoryToLimit(orderRequest.getDeliveryDate()).getCategoryMap();

        for (ItemsItem item: orderRequest.getItems()){
            mapOfItems.put(item.getItemId(), mapOfItems.get(item.getItemId())-item.getQuantity());
            categoryMap.put(item.getCategory(),categoryMap.getOrDefault(item.getCategory(), Constants.CATEGORY_THRESHOLD)-item.getQuantity());
        }

        //Add order to the list
        OrderList.addToList(createOrder(orderRequest));

        return responseMapper.getSuccessResponseForReserveOrder();
    }

    private Order createOrder(OrderRequest orderRequest){
        return new Order(OrderList.getList().size()+1,orderRequest.getItems(),orderRequest.getDeliveryDate());
    }
}
