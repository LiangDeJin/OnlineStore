package com.graduationdesign.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.graduationdesign.dao.IAllLogisticsDao;
import com.graduationdesign.entity.FootPrint;
import com.graduationdesign.entity.Order;
import com.graduationdesign.entity.User;

public class AllLogisticsDaoImpl implements IAllLogisticsDao {
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

	@Override
	public List<Order> getAllLogistics(User user) {
		
		String hql = "From Order Where user.id=? and logistics is not null";
		
		List<Order> orderList = getSession().createQuery(hql).setInteger(0, user.getId()).list();
		
		return orderList;
	}

	@Override
	public Order getLogisticsByOrderid(Integer id) {
		
		String hql = "From Order Where id=? and logistics is not null";
		
		Order order = (Order) getSession().createQuery(hql).setInteger(0, id).uniqueResult();
		
		return order;
	}

	@Override
	public List<FootPrint> getFootPrint(Integer userid) {
		
		String hql = "From FootPrint Where user.id=? order by id desc";
		
		@SuppressWarnings("unchecked")
		List<FootPrint> footPrintList = getSession().createQuery(hql).setInteger(0, userid).setFirstResult(0).setMaxResults(10).list();
		
		return footPrintList;
	}

}
