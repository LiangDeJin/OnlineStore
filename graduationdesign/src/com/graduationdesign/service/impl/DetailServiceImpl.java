package com.graduationdesign.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.graduationdesign.dao.IDetailDao;
import com.graduationdesign.entity.Clothes;
import com.graduationdesign.entity.Comments;
import com.graduationdesign.entity.FootPrint;
import com.graduationdesign.entity.ShopOrder;
import com.graduationdesign.entity.ShoppingCar;
import com.graduationdesign.entity.User;
import com.graduationdesign.service.IDetailService;

public class DetailServiceImpl implements IDetailService {

	@Override
	public Clothes getDetail(Integer id) {
		Clothes clothes = detailDao.getIDDetail(id);
		// TODO Auto-generated method stub
		return clothes;
	}

	/**
	 * 注入dao层接口
	 */
	private IDetailDao detailDao;

	public IDetailDao getDetailDao() {
		return detailDao;
	}

	public void setDetailDao(IDetailDao detailDao) {
		this.detailDao = detailDao;
	}

	@Override
	public void addShoppingCar(Clothes clothes, Integer custom, String size, String num, String color, User user) {

		detailDao.addShoppingCar(clothes, custom, size, num, color, user);
	}

	@Override
	public ShoppingCar getShoppingCar(Integer id, Integer usersid) {

		ShoppingCar addShoppingCar = detailDao.getShoppingCar(id, usersid);

		return addShoppingCar;
	}

	@Override
	public void saveFootPrint(Integer clothesid, Integer usersid) {

		detailDao.saveFootPrint(clothesid, usersid);
	}

	@Override
	public List<FootPrint> getFootPrint(Integer userid) {
		List<FootPrint> fpList = detailDao.getFootPrint(userid);
		return fpList;
	}

	@Override
	public List<FootPrint> getFootPrint() {
		List<FootPrint> fpList = detailDao.getFootPrint();
		return fpList;
	}


	@Override
	public boolean getComments(Integer shopCarid, Integer orderid) {
		List<ShopOrder> shopOrderList = detailDao.getComments(shopCarid, orderid);
		for(int i=0;i<shopOrderList.size();i++){
			if(shopOrderList.get(i).getComments()!=null){
				return false;
			}
		}
		return true;
	}

	@Override
	public void saveComments(Comments comments) {
		detailDao.saveComments(comments);
	}

	@Override
	public void saveComments(ShopOrder shopOrder) {
		
		detailDao.saveComments(shopOrder);
		
	}

	@Override
	public ShopOrder getShopOrder(Integer shopCarid, Integer orderid) {
		
		return detailDao.getShopOrder(shopCarid,orderid);
	}

	@Override
	public List<ShopOrder> getCommentsList(Integer id) {
		
		return detailDao.getCommentsList(id);
	}

}
