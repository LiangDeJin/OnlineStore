package com.graduationdesign.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.graduationdesign.dao.ISelectListClothesDao;
import com.graduationdesign.entity.Clothes;

public class SelectListClothesDaoImpl implements ISelectListClothesDao {

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Clothes> getList(List<String> arrA, List<String> arrB, List<String> arrC) {

		String str = "";
		// 假设数组 [1 , 2]的格式
		if (arrA.size() != 0) {
			str += " and ( 1=0 ";
			for (int i = 0; i < arrA.size(); i++) {
				str += " or Getmodel=" + arrA.get(i);
			}
			str += " ) ";
		}

		if (arrB.size() != 0) {
			str += " and ( 1=0 ";
			for (int j = 0; j < arrB.size(); j++) {
				str += " or Sleevelength=" + arrB.get(j);
			}
			str += " ) ";
		}

		if (arrC.size() != 0) {
			str += " and ( 1=0 ";
			for (int k = 0; k < arrC.size(); k++) {
				str += " or Skirttype=" + arrC.get(k);
			}
			str += " ) ";
		}

		String hql = "From Clothes Where 1=1 " + str;
		System.out.println("-------------hql:" + hql);

		List<Clothes> clothesList = getSession().createQuery(hql).setFirstResult(0).setMaxResults(16).list();
		System.out.println(clothesList.size());
		return clothesList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Clothes> getAllList() {
		// TODO Auto-generated method stub

		String hql = "From Clothes";

		List<Clothes> AllclothesList = getSession().createQuery(hql).list();

		return AllclothesList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Clothes> getSearch(String search) {
		String hql = "From Clothes Where title like '%"+search+"%' ";

		List<Clothes> AllclothesList = getSession().createQuery(hql).list();

		return AllclothesList;
	}

}
