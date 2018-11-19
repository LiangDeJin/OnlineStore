package com.graduationdesign.service;

import java.util.List;

import com.graduationdesign.entity.ShopOrder;

public interface ISelectCommentsService {
	/**
	 * 衣服id获取评论
	 * @param id
	 * @return
	 */
	public List<ShopOrder> getAllComments(Integer id);
	
	/**
	 * 获得所有好评
	 * @param id
	 * @return
	 */
	public List<ShopOrder> getGoodComments(Integer id);
	
	/**
	 * 获得所有中评
	 * @param id
	 * @return
	 */
	public List<ShopOrder> getMiddleComments(Integer id);
	
	/**
	 * 获得所有差评
	 * @param id
	 * @return
	 */
	public List<ShopOrder> getLowComments(Integer id);
	
	/**
	 * 获得ShopOrderList
	 * @return
	 */
	public List<ShopOrder> getCommentsList(Integer userid);
}
