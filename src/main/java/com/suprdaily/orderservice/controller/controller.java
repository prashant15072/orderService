package com.suprdaily.orderservice.controller;

import com.suprdaily.orderservice.dao.FulFilOrderResponse;
import com.suprdaily.orderservice.dao.OrderRequest;
import com.suprdaily.orderservice.dao.ReserveOrderResponse;
import com.suprdaily.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    private OrderService orderService;

    @Autowired
    public controller(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/canFulfilOrder")
    FulFilOrderResponse canFulfilOrder(@RequestBody OrderRequest orderRequest){
        return orderService.canFulfilOrder(orderRequest);
    }

    @PostMapping("/reserveOrder")
    ReserveOrderResponse reserveOrder(@RequestBody OrderRequest orderRequest){
        return orderService.reserverOrder(orderRequest);
    }

}
