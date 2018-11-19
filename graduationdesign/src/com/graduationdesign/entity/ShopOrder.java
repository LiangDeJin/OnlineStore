package com.graduationdesign.entity;

import java.io.Serializable;

public class ShopOrder implements Serializable {

	private static final long serialVersionUID = 6132411661200673611L;

	private Integer id;

	private ShoppingCar shoppingCar;// 购物

	private Order order;// 订单

	private Comments comments;// 评论

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ShoppingCar getShoppingCar() {
		return shoppingCar;
	}

	public void setShoppingCar(ShoppingCar shoppingCar) {
		this.shoppingCar = shoppingCar;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Comments getComments() {
		return comments;
	}

	public void setComments(Comments comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "ShopOrder [id=" + id + ", shoppingCar=" + shoppingCar + ", order=" + order + "]";
	}

}
