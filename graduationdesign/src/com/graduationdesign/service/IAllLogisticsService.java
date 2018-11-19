package com.graduationdesign.service;

import java.util.List;

import com.graduationdesign.entity.FootPrint;
import com.graduationdesign.entity.Order;
import com.graduationdesign.entity.User;

public interface IAllLogisticsService {

	/**
	 * 根据用户查有物流的所有订单
	 * @param user
	 * @return
	 */
	public List<Order> getAllLogistics(User user);
	
	/**
	 * 根据订单id查物流
	 * @param user
	 * @return
	 */
	public Order getLogisticsByOrderid(Integer id);
	
	/**
	 * 当前用户查当前用户浏览
	 * @param userid
	 * @return
	 */
	public List<FootPrint> getFootPrint(Integer userid);
}
