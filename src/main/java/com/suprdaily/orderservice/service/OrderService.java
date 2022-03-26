package com.suprdaily.orderservice.service;

import com.suprdaily.orderservice.dao.FulFilOrderResponse;
import com.suprdaily.orderservice.dao.OrderRequest;
import com.suprdaily.orderservice.dao.ReserveOrderResponse;

public interface OrderService {
    FulFilOrderResponse canFulfilOrder(OrderRequest orderRequest);
    ReserveOrderResponse reserverOrder(OrderRequest orderRequest);
}
