package com.graduationdesign.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.graduationdesign.dao.ILoginDao;
import com.graduationdesign.entity.User;

public class loginDaoImpl implements ILoginDao {

	//注入sessionFactory 然后get/set
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//封装sessionFactory.getCurrentSession()用 getSession()表示
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public User getUser(String username, String password) {
		
		//写hibernate 的sql语句     等同于select * from User where username =? and password=?
		String hql ="from User where username =? and password=?";
		
		//sessionFactory事务开始活动
		//Session session = getSession();
		//session.beginTransaction();
		
		//新建查询 查询传进来的结果只有一个是否满足
		//(User)强制把object转化为user类型
		User user = (User) getSession().createQuery(hql).setString(0, username).setString(1,password ).uniqueResult();
		
		return user;
	}

	@Override
	public String getemailPwd(String email) {
		String hql = "From User where username=?";

		User users = (User) getSession().createQuery(hql).setString(0, email).uniqueResult();
		return users.getPassword();
	}

	@Override
	public void saveRam(String email,String ram) {
		String hql = "From User where username=?";

		User users = (User) getSession().createQuery(hql).setString(0, email).uniqueResult();
		
		users.setRam(ram);
		
		getSession().save(users);
	}

	@Override
	public User getUserByPwd(String pwd,User user) {
		String hql = "From User Where (password=? or ram=?) and id=?";
		
		User users = (User) getSession().createQuery(hql).setString(0, pwd).setString(1, pwd).setInteger(2, user.getId()).uniqueResult();

		return users;
	}

	@Override
	public void updatePwd(String newPwd,User user) {
		
		user.setPassword(newPwd);
		
		getSession().saveOrUpdate(user);
	}

	@Override
	public void saveImage(User user) {
		
		getSession().saveOrUpdate(user);
		
	}
	
}
