package com.graduationdesign.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.graduationdesign.dao.IRegisterDao;
import com.graduationdesign.entity.User;

public class RegisterDaoImpl implements IRegisterDao {

	//注入sessionFactory 然后get/set
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//封装sessionFactory.getCurrentSession()用 getSession()表示
	public Session getSession(){
		return sessionFactory.getCurrentSession();
		
	}

//	注册插入的用户信息
	@Override
	public void insetuser(String username, String password) {
		// TODO Auto-generated method stub
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		//默认头像
		user.setImage("img/icon/1.gif");
		
		getSession().save(user);
	}

//	用户注册查数据库有没有相同的用户名
	@Override
	public User selectuser(String username) {
		// TODO Auto-generated method stub
		
		String hql = "from User where username = ? ";
		
		User user = new User();
		user = (User) getSession().createQuery(hql).setString(0, username).uniqueResult();
		
		return  user;
	}
	
	
		
}
