package com.graduationdesign.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.graduationdesign.dao.ISortOutDao;
import com.graduationdesign.entity.Address;
import com.graduationdesign.entity.China;
import com.graduationdesign.entity.ShoppingCar;
import com.graduationdesign.entity.User;

public class SortOutDaoImpl implements ISortOutDao{

	// 注入sessionFactory 然后get/set
		private SessionFactory sessionFactory;

		public SessionFactory getSessionFactory() {
			return sessionFactory;
		}

		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

		// 封装sessionFactory.getCurrentSession()用 getSession()表示
		private Session getSession() {
			return sessionFactory.getCurrentSession();
		}
			
	@Override
	public List<ShoppingCar> seleteSortOut(User users) {
		
		String hql ="from ShoppingCar where user.id = ? and state = '1'";
		
		List<ShoppingCar> UserShoppingCar = getSession().createQuery(hql).setInteger(0, users.getId()).list();		
		// TODO Auto-generated method stub
		return UserShoppingCar;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<China> getprovince() {
		
		String hql="from China where china.id=0";
		
		List<China> provinceList = getSession().createQuery(hql).list();
		// TODO Auto-generated method stub
		
		return provinceList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<China> getCity(Integer pid) {
		// TODO Auto-generated method stub
		
		String hql="from China where china.id = ?";
		
		List<China> cityList = getSession().createQuery(hql).setInteger(0, pid).list();
		
		return cityList;
	}

	@Override
	public Address getdefalt(User user) {
		// TODO Auto-generated method stub
		
		String hql ="from Address where user.id = ? and state = 1";
		
		Address address = (Address) getSession().createQuery(hql).setInteger(0, user.getId()).uniqueResult();
		
		return address;
	}

}
