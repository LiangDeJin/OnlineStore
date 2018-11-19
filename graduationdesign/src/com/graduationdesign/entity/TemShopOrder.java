package com.graduationdesign.entity;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class TemShopOrder implements Serializable{

	private Order order;

	private List<ShoppingCar> ShoppingCarList;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<ShoppingCar> getShoppingCarList() {
		return ShoppingCarList;
	}

	public void setShoppingCarList(List<ShoppingCar> shoppingCarList) {
		ShoppingCarList = shoppingCarList;
	}

}
