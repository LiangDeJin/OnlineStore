package com.graduationdesign.service;

import java.util.List;

import com.graduationdesign.entity.Order;
import com.graduationdesign.entity.ShopOrder;
import com.graduationdesign.entity.User;

public interface IMyOrderService {
	/**
	 * 通过用户名去搜索我的订单（所有的）
	 * 
	 * @param user
	 * @return
	 */
	public List<Order> selectMyOrder(User user);

	/**
	 * 通过用户名去搜索我的订单（只取状态为1 ）
	 * 
	 * @param user
	 * @return
	 */
	public List<Order> selectMyOrder1(User user);

	/**
	 * 根据订单id 查 这个订单(只取状态为2)
	 * 
	 * @param id
	 * @return
	 */
	public List<Order> selectMyOrder2(User user);
	

	/**
	 * 通过用户名去搜索我的订单（只取状态为3）
	 * @param user
	 * @return
	 */
	public List<Order> selectMyOrder3(User user);
	
	
	/**
	 * 通过用户名去搜索我的订单（只取状态为4）
	 * @param user
	 * @return
	 */
	public List<Order> selectMyOrder4(User user);
	
	/**
	 * 通过用户名去搜索我的订单退换货（只取状态为5）
	 * @param user
	 * @return
	 */
	public List<Order> selectMyOrder5(User user);

	/**
	 * 根据订单id 查 这个订单（所有的）
	 * 
	 * @param id
	 * @return
	 */
	public List<ShopOrder> selectShopOrder(Integer id);

	/**
	 * 根据订单id 查 这个订单(只取状态为1)
	 * 
	 * @param id
	 * @return
	 */
	public List<ShopOrder> selectShopOrder1(Integer id);

	/**
	 * 根据订单id 查 这个订单(只取状态为2)
	 * 
	 * @param id
	 * @return
	 */
	public List<ShopOrder> selectShopOrder2(Integer id);
	/**
	 * 根据订单id 查 这个订单（只取状态为3）
	 * @param id
	 * @return
	 */
	public List<ShopOrder> selectShopOrder3(Integer id);
	
	/**
	 * 根据订单id 查 这个订单（只取状态为4）
	 * @param id
	 * @return
	 */
	public List<ShopOrder> selectShopOrder4(Integer id);
	
	/**
	 * 根据订单id 查 这个订单（只取状态为5）
	 * @param id
	 * @return
	 */
	public List<ShopOrder> selectShopOrder5(Integer id);
	
	/**
	 * 根据订单id去更新状态变为5（点击退换货的时候）
	 * @param id
	 * 
	 */
	public void updateState5(Integer id);
	

	/**
	 * 根据订单id去更新状态变为4（点击确认订单）
	 * @param id
	 * 
	 */
	public void updateState3(Integer id);
	
	/**
	 * 根据订单id去更新状态变为7（评论订单后改状态）
	 * @param id
	 * 
	 */
	public void updateState7(Integer id);
	
	
}
