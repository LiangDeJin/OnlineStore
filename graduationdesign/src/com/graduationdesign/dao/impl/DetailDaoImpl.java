package com.graduationdesign.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.graduationdesign.dao.IDetailDao;
import com.graduationdesign.entity.Clothes;
import com.graduationdesign.entity.Comments;
import com.graduationdesign.entity.FootPrint;
import com.graduationdesign.entity.ShopOrder;
import com.graduationdesign.entity.ShoppingCar;
import com.graduationdesign.entity.User;

public class DetailDaoImpl implements IDetailDao {

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
	public Clothes getIDDetail(Integer id) {

		// 写hibernate 的sql语句
		String hql = "From Clothes where id =? ";

		Clothes clothes = (Clothes) getSession().createQuery(hql).setInteger(0, id).uniqueResult();

		// TODO Auto-generated method stub
		return clothes;
	}

	@Override
	public void addShoppingCar(Clothes clothes, Integer custom, String size, String num, String color, User user) {
		// TODO Auto-generated method stub

		ShoppingCar shoppingcar = new ShoppingCar();

		shoppingcar.setClothes(clothes);
		shoppingcar.setCustom(custom);
		shoppingcar.setSize(size);
		shoppingcar.setNum(num);
		shoppingcar.setColor(color);
		shoppingcar.setUser(user);
		shoppingcar.setState("0");
		getSession().save(shoppingcar);

	}

	@Override
	public ShoppingCar getShoppingCar(Integer id, Integer usersid) {

		// 写hibernate 的sql语句
		String hql = "From ShoppingCar where clothes.id =? and user.id =? and (state='1' or state='0')";

		ShoppingCar addShoppingCar = (ShoppingCar) getSession().createQuery(hql).setInteger(0, id)
				.setInteger(1, usersid).uniqueResult();

		return addShoppingCar;
	}

	@Override
	public void saveFootPrint(Integer clothesid, Integer usersid) {
		// 初始化
		Clothes clothes = new Clothes();
		User user = new User();
		// 赋值
		clothes.setId(clothesid);
		user.setId(usersid);

		FootPrint fp = new FootPrint();

		fp.setClothes(clothes);
		fp.setUser(user);
		fp.setTime(new Date());
		// 保存
		getSession().save(fp);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FootPrint> getFootPrint(Integer userid) {

		String hql = "From FootPrint Where user.id=? order by id desc";

		List<FootPrint> footPrintList = getSession().createQuery(hql).setInteger(0, userid).setFirstResult(0)
				.setMaxResults(3).list();

		return footPrintList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FootPrint> getFootPrint() {
		String hql = "From FootPrint order by id desc";

		List<FootPrint> footPrintList = getSession().createQuery(hql).setFirstResult(0).setMaxResults(3).list();

		return footPrintList;
	}

	@Override
	public void saveComments(Comments comments) {

		getSession().save(comments);

	}

	@Override
	public void saveComments(ShopOrder shopOrder) {
		
//		String hql = "update ShopOrde set comments='"+shopOrder.getComments()+"' where shoppingCar.id="+shopOrder.getShoppingCar().getId()+" and order.id="+shopOrder.getOrder().getId()+"";
//		
//		getSession().createQuery(hql).executeUpdate();
		
		getSession().saveOrUpdate(shopOrder);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopOrder> getComments(Integer shopCarid, Integer orderid) {
		String hql = "From ShopOrder where shoppingCar.id=? and order.id=?";
		List<ShopOrder> shopOrderList =  getSession().createQuery(hql).setInteger(0, shopCarid).setInteger(1, orderid).list();

		return shopOrderList;
	}

	@Override
	public ShopOrder getShopOrder(Integer shopCarid, Integer orderid) {
		String hql = "From ShopOrder where shoppingCar.id=? and order.id=?";
		ShopOrder shopOrder = (ShopOrder) getSession().createQuery(hql).setInteger(0, shopCarid).setInteger(1, orderid).uniqueResult();
		return shopOrder;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShopOrder> getCommentsList(Integer id) {
		
		String hql = "From ShopOrder where shoppingCar.clothes.id=? and comments is not null";
		
		List<ShopOrder> shopOrderList = getSession().createQuery(hql).setInteger(0, id).list();
		
		return shopOrderList;
	}

}
