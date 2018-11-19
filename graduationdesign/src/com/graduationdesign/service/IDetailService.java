package com.graduationdesign.service;

import java.util.List;

import com.graduationdesign.entity.Clothes;
import com.graduationdesign.entity.Comments;
import com.graduationdesign.entity.FootPrint;
import com.graduationdesign.entity.ShopOrder;
import com.graduationdesign.entity.ShoppingCar;
import com.graduationdesign.entity.User;

public interface IDetailService {
	/**
	 * 获取一行数据通过id
	 * @param id
	 * @return
	 */
	public Clothes getDetail(Integer id);
	/**
	 * 插入到购物车
	 * @param clothesid
	 * @param custom
	 * @param size
	 * @param num
	 * @param color
	 * @param user
	 */
	public void addShoppingCar(Clothes clothes,Integer custom,String size,String num,String color,User user);
	
	/**
	 * 通过id 和  userid获取购物车的信息 
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
	 * 保存到shopOrder
	 * @param comments
	 */
	public void saveComments(ShopOrder shopOrder);
	
	/**
	 * 通过衣服id 订单id查是否可以评论
	 * @param clothesid
	 * @param usersid
	 * @return
	 */
	public boolean getComments(Integer shopCarid,Integer orderid);
	
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
