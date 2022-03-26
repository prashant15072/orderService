package com.suprdaily.orderservice.mapper;

import com.suprdaily.orderservice.Constants;
import com.suprdaily.orderservice.dao.DataResp;
import com.suprdaily.orderservice.dao.FulFilOrderResponse;
import com.suprdaily.orderservice.dao.ReserveOrderResponse;
import org.springframework.stereotype.Component;

@Component
public class ResponseMapper {
    public FulFilOrderResponse getFailureResponseForFulfilOrder() {
        FulFilOrderResponse fulFilOrderResponse = new FulFilOrderResponse();
        fulFilOrderResponse.setCanFulfil(false);
        return fulFilOrderResponse;
    }

    public FulFilOrderResponse getSuccessResponseForFulfilOrder() {
        FulFilOrderResponse fulFilOrderResponse = new FulFilOrderResponse();
        fulFilOrderResponse.setCanFulfil(true);
        return fulFilOrderResponse;
    }

    public ReserveOrderResponse getSuccessResponseForReserveOrder() {
        ReserveOrderResponse reserveOrderResponse = new ReserveOrderResponse();
        DataResp dataResp = new DataResp();

        reserveOrderResponse.setCode(Constants.SUCCESS_CODE);
        dataResp.setReserved(true);
        dataResp.setMessage(Constants.SUCCESS_CODE);
        reserveOrderResponse.setData(dataResp);

        return reserveOrderResponse;
    }
}
