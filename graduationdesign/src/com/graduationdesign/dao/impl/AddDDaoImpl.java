package com.graduationdesign.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.graduationdesign.dao.IAddDDao;
import com.graduationdesign.entity.Address;
import com.graduationdesign.entity.China;
import com.graduationdesign.entity.User;
import com.opensymphony.xwork2.ActionContext;

public class AddDDaoImpl implements IAddDDao{

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
	
	@Override
	public void updateAddD(String personName, String personPhone, String province, String city, String country,
			String detailAddress) {
		// TODO Auto-generated method stub
		
		Address address =new Address();
		
		China province1 = new China();
		int province2 = Integer.parseInt(province);
		province1.setId(province2);
		
		China city1 = new China();
		int city2 = Integer.parseInt(city);
		city1.setId(city2);
		
		China country1 = new China();
		int country2 = Integer.parseInt(country);
		country1.setId(country2);
		
		User users = (User) ActionContext.getContext().getSession().get("users");
		
		address.setName(personName);
		address.setPhone(personPhone);
		address.setProvince(province1);
		address.setCity(city1);
		address.setCountry(country1);
		address.setDetailaddress(detailAddress);
		address.setUser(users);
		address.setState("0");
		
		System.out.println(address);
		
		getSession().save(address);
		
		
	}

	@Override
	public void deleteAddress(Integer id) {

		String hql ="delete From Address where id = ?";
		
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}

}
