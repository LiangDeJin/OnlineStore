package com.graduationdesign.service;

import java.util.List;

import com.graduationdesign.entity.Address;
import com.graduationdesign.entity.China;
import com.graduationdesign.entity.Order;
import com.graduationdesign.entity.ShoppingCar;
import com.graduationdesign.entity.User;

public interface IWriteAddressService {

	/**
	 * 将信息存入地址表
	 * @param name
	 * @param phone
	 * @param province
	 * @param city
	 * @param country
	 * @param detailaddress
	 * @param user
	 */
	public Address saveAddress(String name,String phone,China province,China city,China country,String detailaddress,User user);
	
	/**
	 * 将该用户购物车中的选中项都状态改为2
	 * @param user
	 */
	public List<ShoppingCar> updateShopCarState(User user);
	
	/**
	 * 下单
	 * @param address
	 * @param user
	 */
	public Order saveOrder(Address address,User user);
	
	/**
	 * 关联商品与订单
	 * 
	 * @param shoppingCar
	 * @param order
	 */
	public void saveShopOrder(List<ShoppingCar> shoppingCar, Order order);
	
	/**
	 * 通过订单的id更改是否支付的状态
	 */
	public void updateState(Integer id);
}
