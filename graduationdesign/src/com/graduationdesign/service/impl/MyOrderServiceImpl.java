package com.graduationdesign.service.impl;

import java.util.List;

import com.graduationdesign.dao.IMyOrderDao;
import com.graduationdesign.entity.Order;
import com.graduationdesign.entity.ShopOrder;
import com.graduationdesign.entity.User;
import com.graduationdesign.service.IMyOrderService;

public class MyOrderServiceImpl implements IMyOrderService {

	private IMyOrderDao MyOrderDao;

	public IMyOrderDao getMyOrderDao() {
		return MyOrderDao;
	}

	public void setMyOrderDao(IMyOrderDao myOrderDao) {
		MyOrderDao = myOrderDao;
	}

	@Override
	public List<Order> selectMyOrder(User user) {
		// TODO Auto-generated method stub

		List<Order> myOrderList = MyOrderDao.selectMyOrder(user);

		return myOrderList;
	}

	@Override
	public List<Order> selectMyOrder1(User user) {
		List<Order> myOrderList = MyOrderDao.selectMyOrder1(user);

		return myOrderList;
	}

	@Override
	public List<ShopOrder> selectShopOrder(Integer id) {
		List<ShopOrder> shopOrderList = MyOrderDao.selectShopOrder(id);
		return shopOrderList;
	}

	@Override
	public List<ShopOrder> selectShopOrder1(Integer id) {
		List<ShopOrder> shopOrderList = MyOrderDao.selectShopOrder1(id);
		return shopOrderList;
	}

	@Override
	public List<Order> selectMyOrder2(User user) {
		List<Order> myOrderList = MyOrderDao.selectMyOrder2(user);
		return myOrderList;
	}

	@Override
	public List<ShopOrder> selectShopOrder2(Integer id) {
		List<ShopOrder> shopOrderList = MyOrderDao.selectShopOrder2(id);
		return shopOrderList;
	}

	@Override
	public List<Order> selectMyOrder3(User user) {
		List<Order> myOrderList = MyOrderDao.selectMyOrder3(user);
		return myOrderList;
	}


	@Override
	public List<ShopOrder> selectShopOrder3(Integer id) {
		List<ShopOrder> shopOrderList = MyOrderDao.selectShopOrder3(id);
		return shopOrderList;
	}
	
	@Override
	public List<Order> selectMyOrder4(User user) {
		List<Order> myOrderList = MyOrderDao.selectMyOrder4(user);
		return myOrderList;
	}


	@Override
	public List<ShopOrder> selectShopOrder4(Integer id) {
		List<ShopOrder> shopOrderList = MyOrderDao.selectShopOrder4(id);
		return shopOrderList;
	}

	@Override
	public List<Order> selectMyOrder5(User user) {
		List<Order> myOrderList = MyOrderDao.selectMyOrder5(user);
		return myOrderList;
	}

	@Override
	public List<ShopOrder> selectShopOrder5(Integer id) {
		List<ShopOrder> shopOrderList = MyOrderDao.selectShopOrder5(id);
		return shopOrderList;
	}

	@Override
	public void updateState5(Integer id) {
		
		MyOrderDao.updateState5(id);
		
	}

	@Override
	public void updateState3(Integer id) {
		
		MyOrderDao.updateState3(id);
		
	}

	@Override
	public void updateState7(Integer id) {
		MyOrderDao.updateState7(id);
		
	}
	

}
