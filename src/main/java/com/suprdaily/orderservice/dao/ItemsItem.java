package com.suprdaily.orderservice.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemsItem{
	@JsonProperty("quantity")
	private int quantity;
	@JsonProperty("item_id")
	private int itemId;
	@JsonProperty("item_name")
	private String itemName;
	@JsonProperty("category")
	private String category;
}