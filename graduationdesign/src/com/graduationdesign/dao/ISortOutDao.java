package com.graduationdesign.dao;

import java.util.List;

import com.graduationdesign.entity.Address;
import com.graduationdesign.entity.China;
import com.graduationdesign.entity.ShoppingCar;
import com.graduationdesign.entity.User;

public interface ISortOutDao {

	/**
	 * 通过登录的用户去查该用户的购物车ShoppingCar
	 * @param users
	 * @return
	 */
	public List<ShoppingCar> seleteSortOut(User users);
	

	/**
	 * 查出省的内容
	 * @return
	 */
	public List<China> getprovince();
	
	/**
	 * 查城市
	 * @param pid
	 * @return
	 */
	public List<China> getCity(Integer pid);
	

	/**
	 * 查询默认的地址
	 * @param user
	 * @return
	 */
	public Address getdefalt(User user);
}
