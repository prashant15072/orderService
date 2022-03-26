package com.suprdaily.orderservice.service;

import com.suprdaily.orderservice.dao.OrderRequest;

public interface ValidationService {
    boolean checkDailyLimit(OrderRequest orderRequest);
    boolean checkIfOrderFulfilable(OrderRequest orderRequest);
}
