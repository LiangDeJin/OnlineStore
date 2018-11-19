package com.graduationdesign.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.graduationdesign.dao.ISelectCommentsDao;
import com.graduationdesign.entity.ShopOrder;

public class SelectCommentsDaoImpl implements ISelectCommentsDao {

	// 注入sessionFactory 然后get/set
	private SessionFactory sessionfactory;

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

	// 封装sessionFactory.getCurrentSession()用 getSession()表示
	public Session getSession() {
		return this.sessionfactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopOrder> getAllComments(Integer id) {
		String hql = "From ShopOrder where shoppingCar.clothes.id=? and comments.clothes.id=?";
		List<ShopOrder> shopOrderList = getSession().createQuery(hql).setInteger(0, id).setInteger(1, id).list();
		
		return shopOrderList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopOrder> getGoodComments(Integer id) {
		String hql = "From ShopOrder where shoppingCar.clothes.id=? and comments.clothes.id=? and comments.praise='100'";
		List<ShopOrder> shopOrderList = getSession().createQuery(hql).setInteger(0, id).setInteger(1, id).list();
		
		return shopOrderList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopOrder> getMiddleComments(Integer id) {
		String hql = "From ShopOrder where shoppingCar.clothes.id=? and comments.clothes.id=? and comments.praise='50'";
		List<ShopOrder> shopOrderList = getSession().createQuery(hql).setInteger(0, id).setInteger(1, id).list();
		
		return shopOrderList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopOrder> getLowComments(Integer id) {
		String hql = "From ShopOrder where shoppingCar.clothes.id=? and comments.clothes.id=? and comments.praise='0'";
		List<ShopOrder> shopOrderList = getSession().createQuery(hql).setInteger(0, id).setInteger(1, id).list();
		
		return shopOrderList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopOrder> getCommentsList(Integer userid) {
		String hql = "From ShopOrder where comments.user.id=? and order.user.id=? and shoppingCar.user.id=?";
		List<ShopOrder> shopOrderList = getSession().createQuery(hql).setInteger(0, userid).setInteger(1, userid).setInteger(2, userid).list();
		return shopOrderList;
	}

}
