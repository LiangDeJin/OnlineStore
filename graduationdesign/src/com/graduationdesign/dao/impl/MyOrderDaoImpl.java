package com.graduationdesign.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.graduationdesign.dao.IMyOrderDao;
import com.graduationdesign.entity.Order;
import com.graduationdesign.entity.ShopOrder;
import com.graduationdesign.entity.User;

public class MyOrderDaoImpl implements IMyOrderDao {

	// 注入sessionFactory 然后get/set
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 封装sessionFactory.getCurrentSession()用 getSession()表示
	public Session getSession() {
		return sessionFactory.getCurrentSession();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> selectMyOrder(User user) {
		// TODO Auto-generated method stub

		String hql = "From Order where user.id=? and state<>'5' and state<>'6'";

		List<Order> myOrderList = getSession().createQuery(hql).setInteger(0, user.getId()).list();

		return myOrderList;
	}

	@Override
	public List<Order> selectMyOrder1(User user) {
		// TODO Auto-generated method stub
		String hql = "From Order where user.id=? and state='1'";

		List<Order> myOrderList = getSession().createQuery(hql).setInteger(0, user.getId()).list();

		return myOrderList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopOrder> selectShopOrder(Integer id) {
		String hql = "From ShopOrder where order.id=? and order.state<>'5' and order.state<>'6'";

		List<ShopOrder> shopOrderList = getSession().createQuery(hql).setInteger(0, id).list();

		return shopOrderList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopOrder> selectShopOrder1(Integer id) {
		String hql = "From ShopOrder where order.id=? and order.state='1'";

		List<ShopOrder> shopOrderList = getSession().createQuery(hql).setInteger(0, id).list();
		return shopOrderList;
	}

	@Override
	public List<Order> selectMyOrder2(User user) {
		String hql = "From Order where user.id=? and state='2'";

		List<Order> myOrderList = getSession().createQuery(hql).setInteger(0, user.getId()).list();

		return myOrderList;
	}

	@Override
	public List<ShopOrder> selectShopOrder2(Integer id) {
		String hql = "From ShopOrder where order.id=? and order.state='2'";

		List<ShopOrder> shopOrderList = getSession().createQuery(hql).setInteger(0, id).list();
		return shopOrderList;
	}

	@Override
	public List<Order> selectMyOrder3(User user) {
		String hql = "From Order where user.id=? and state='3'";

		List<Order> myOrderList = getSession().createQuery(hql).setInteger(0, user.getId()).list();

		return myOrderList;
	}


	@Override
	public List<ShopOrder> selectShopOrder3(Integer id) {
		String hql = "From ShopOrder where order.id=? and order.state='3'";

		List<ShopOrder> shopOrderList = getSession().createQuery(hql).setInteger(0, id).list();
		return shopOrderList;
	}
	
	@Override
	public List<Order> selectMyOrder4(User user) {
		String hql = "From Order where user.id=? and state='4'";

		List<Order> myOrderList = getSession().createQuery(hql).setInteger(0, user.getId()).list();

		return myOrderList;
	}


	@Override
	public List<ShopOrder> selectShopOrder4(Integer id) {
		String hql = "From ShopOrder where order.id=? and order.state='4'";

		List<ShopOrder> shopOrderList = getSession().createQuery(hql).setInteger(0, id).list();
		return shopOrderList;
	}

	@Override
	public List<Order> selectMyOrder5(User user) {
		String hql = "From Order where user.id=? and (state='5' or state='6')";

		List<Order> myOrderList = getSession().createQuery(hql).setInteger(0, user.getId()).list();

		return myOrderList;
	}

	@Override
	public List<ShopOrder> selectShopOrder5(Integer id) {
		String hql = "From ShopOrder as so where so.order.id=? and (so.order.state='5' or so.order.state='6')";

		List<ShopOrder> shopOrderList = getSession().createQuery(hql).setInteger(0, id).list();
		return shopOrderList;
	}

	@Override
	public void updateState5(Integer id) {
		
		String hql = "update Order set state='5' where id=? order by id desc";

		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}

	@Override
	public void updateState3(Integer id) {
		String hql = "update Order set state='4' where id=? order by id desc";

		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}

	@Override
	public void updateState7(Integer id) {
		String hql = "update Order set state='7' where id=? order by id desc";

		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
		
	}

}
