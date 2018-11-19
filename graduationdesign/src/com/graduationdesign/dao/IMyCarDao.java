package com.graduationdesign.dao;

import java.util.List;

import com.graduationdesign.entity.ShoppingCar;
import com.graduationdesign.entity.User;

public interface IMyCarDao {

	/**
	 * 通过用户查询购物车的多条信息ShoppingCar
	 * @param users
	 * @return
	 */
	public List<ShoppingCar> getAddCar(User users);
	/**
	 * 通过当前的登录的用户和该购物车的要删除的这一条购物车记录
	 * @param users
	 * @param clothesId
	 *
	 */
	public void deleteCar(User users, Integer clothesId);
	
	/**
	 * 通过当前的登录的用户和该购物车的数量改变要更新的这一条购物车记录
	 * @param clothesId
	 * @param selectNum
	 */
	public void updateCar(Integer clothesId,Integer selectNum,User users);
	
	/**
	 * 通过当前的登录的用户和衣服的ID更改该购物车是否选中的状态
	 * @param clothesId
	 * @param selectNum
	 */
	public void choiceCar(User users,Integer clothesId);
	
	/**
	 * 通过当前的登录的用户和衣服的ID更改该购物车是否全部选中的 
	 * @param clothesId
	 * @param selectNum
	 */
	public void choiceALlCar(User users);
}
