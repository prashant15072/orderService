package com.suprdaily.orderservice.dao;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderRequest{
	@JsonProperty("delivery_date")
	private String deliveryDate;
	@JsonProperty("customer_id")
	private int customerId;
	private List<ItemsItem> items;
	@JsonProperty("warehouse_id")
	private int warehouseId;
}