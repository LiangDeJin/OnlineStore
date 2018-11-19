package com.graduationdesign.service.impl;

import com.graduationdesign.dao.ILoginDao;
import com.graduationdesign.entity.User;
import com.graduationdesign.service.ILoginService;

public class LoginServiceImpl implements ILoginService {

	@Override
	public boolean getLogin(String username, String password) {
		User user = loginDao.getUser(username, password);
		if (user != null) {
			return true;
		}
		return false;
	}

	// ApplicationContext context = new
	// ClassPathXmlApplicationContext("applicationContext.xml");
	// private ILoginDao loginDao = (ILoginDao) context.getBean("loginDao");
	// 等同于上面两句
	private ILoginDao loginDao;

	public ILoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(ILoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public User getUser(String username, String password) {

		User user = loginDao.getUser(username, password);

		return user;
	}

	@Override
	public String getemailPwd(String email) {

		return loginDao.getemailPwd(email);
	}

	@Override
	public void saveRam(String email, String ram) {

		loginDao.saveRam(email, ram);
	}

	@Override
	public User getUserByPwd(String pwd, User user) {
		return loginDao.getUserByPwd(pwd, user);
	}

	@Override
	public void updatePwd(String newPwd, User user) {
		loginDao.updatePwd(newPwd, user);
	}

	@Override
	public void saveImage(User user) {
		
		loginDao.saveImage(user);
	}

}
