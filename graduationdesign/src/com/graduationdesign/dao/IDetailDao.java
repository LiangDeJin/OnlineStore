package com.graduationdesign.dao;

import java.util.List;

import com.graduationdesign.entity.Clothes;
import com.graduationdesign.entity.Comments;
import com.graduationdesign.entity.FootPrint;
import com.graduationdesign.entity.ShopOrder;
import com.graduationdesign.entity.ShoppingCar;
import com.graduationdesign.entity.User;

public interface IDetailDao {
	/**
	 * 根据ID 获取详细信息
	 * @param id
	 * @return
	 * 返回该id的详细信息
	 */
	public Clothes getIDDetail(Integer id);
	
	/**
	 * 插入购物车
	 * @param clothesid
	 * @param custom
	 * @param size
	 * @param num
	 * @param color
	 * @param user
	 */
	public void addShoppingCar(Clothes clothes,Integer custom,String size,String num,String color,User user);
	

	/**
	 * 通过id 和  userid 获取购物车的信息 
	 * @param id
	 * @param usersid
	 * @return
	 */
	public ShoppingCar getShoppingCar(Integer id, Integer usersid);
	
	/**
	 * 保存浏览记录
	 * @param clothesid
	 * @param usersid
	 */
	public void saveFootPrint(Integer clothesid,Integer usersid);
	
	/**
	 * 根据用户查最新的三条浏览记录
	 * @param userid
	 * @return
	 */
	public List<FootPrint> getFootPrint(Integer userid); 
	
	/**
	 * 查最新的三条浏览记录
	 * @param userid
	 * @return
	 */
	public List<FootPrint> getFootPrint(); 
	
	/**
	 * 保存评论
	 * @param comments
	 */
	public void saveComments(Comments comments);
	/**
	 * 保存shopOrder
	 * @param comments
	 */
	public void saveComments(ShopOrder shopOrder);
	
	/**
	 * 通过衣服id 用户id查评论
	 * @param clothesid
	 * @param usersid
	 * @return
	 */
	public List<ShopOrder> getComments(Integer shopCarid,Integer orderid);
	
	/**
	 * 通过订单id 购物车id 查ShopOrder
	 * @param shopCarid
	 * @param orderid
	 * @return
	 */
	public ShopOrder getShopOrder(Integer shopCarid,Integer orderid);
	
	/**
	 * 根据衣服id查衣服评论
	 * @param id
	 * @return
	 */
	public List<ShopOrder> getCommentsList(Integer id);

}
