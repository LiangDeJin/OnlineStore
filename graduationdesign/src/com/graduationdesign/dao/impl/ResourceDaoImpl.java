package com.graduationdesign.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.graduationdesign.dao.IResourceDao;
import com.graduationdesign.entity.Address;
import com.graduationdesign.entity.User;
import com.opensymphony.xwork2.ActionContext;

public class ResourceDaoImpl implements IResourceDao {

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

	@Override
	public Address selectResource(User user) {
		// TODO Auto-generated method stub

		String hql = "From Address where user.id = ? and state = '1'";

 		Address resource = (Address) getSession().createQuery(hql).setInteger(0, user.getId()).uniqueResult();

		return resource;
	}

	@Override
	public List<Address> selectResourceList(User user) {
		// TODO Auto-generated method stub
		
		String hql = "From Address where user.id = ? ";

		List<Address> selectResourceList = getSession().createQuery(hql).setInteger(0, user.getId()).list();
		
		return selectResourceList;
	}

}
