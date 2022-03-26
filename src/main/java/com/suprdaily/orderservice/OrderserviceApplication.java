package com.suprdaily.orderservice;

import com.suprdaily.orderservice.entity.Item;
import com.suprdaily.orderservice.entity.WareHouse;
import com.suprdaily.orderservice.repo.ItemList;
import com.suprdaily.orderservice.repo.WareHouseMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class OrderserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderserviceApplication.class, args);

		Item item = new Item(1,"i1","F_N_A");
		Item item2 = new Item(2,"i2","F_N_V");
		Item item3 = new Item(3,"i3","F_N_V");
		Item item4 = new Item(4,"i4","F_N_V");

		ItemList.addToMap(1,item);
		ItemList.addToMap(2,item2);
		ItemList.addToMap(3,item3);
		ItemList.addToMap(4,item4);

		WareHouse wareHouse = new WareHouse();
		Map<Integer,Integer> wareHouseDetails = new HashMap<>();
		wareHouseDetails.put(1,200);
		wareHouseDetails.put(2,100);
		wareHouseDetails.put(3,200);
		wareHouse.setUnOrderedItems(wareHouseDetails);

		WareHouseMap.addWareHouse(100,wareHouse);
	}

}
