package com.graduationdesign.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.graduationdesign.dao.IWriteAddressDao;
import com.graduationdesign.entity.Address;
import com.graduationdesign.entity.China;
import com.graduationdesign.entity.Order;
import com.graduationdesign.entity.ShopOrder;
import com.graduationdesign.entity.ShoppingCar;
import com.graduationdesign.entity.User;

public class WriteAddressDaoImpl implements IWriteAddressDao {

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
	public Address saveAddress(String name, String phone, China province, China city, China country,
			String detailaddress, User user) {

		Address address = new Address();
		
		address.setName(name);
		address.setPhone(phone);
		address.setProvince(province);
		address.setCity(city);
		address.setCountry(country);
		address.setDetailaddress(detailaddress);
		address.setUser(user);
		
		//查有没有相同的地址
		String hqlselectsame = "From Address where name=? and phone=? and province.id=? and city.id=? and country.id=? and detailaddress=? and user.id=?";
		
		
		List<Address> addr = getSession().createQuery(hqlselectsame).setString(0, name).setString(1, phone)
								.setInteger(2, province.getId()).setInteger(3, city.getId()).setInteger(4, country.getId())
								.setString(5, detailaddress).setInteger(6, user.getId()).list();
		
		if(addr.size()<1){
			
			String hqlselect = "From Address Where user.id=?";
			List<Address> add = getSession().createQuery(hqlselect).setInteger(0, user.getId()).list();
			if (add.size() < 1) {
				address.setState("1");// 设置为默认地址
			} else {
				address.setState("0");
			}
			
			getSession().save(address);
			
			return address;
		}else{
			//否则什么都不操作
			return addr.get(0);
		}
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShoppingCar> updateShopCarState(User user) {

		// 查出该用户为1的项
		String hql = "From ShoppingCar as shopcar Where shopcar.user.id=? and shopcar.state='1'";
		List<ShoppingCar> shoppingCarList = getSession().createQuery(hql).setInteger(0, user.getId()).list();

		// 更改为2
		String hqlupdate = "update ShoppingCar as shopcar set shopcar.state='2' Where shopcar.id=?";

		for (int i = 0; i < shoppingCarList.size(); i++) {

			shoppingCarList.get(i).setState("2");

			getSession().createQuery(hqlupdate).setInteger(0, shoppingCarList.get(i).getId()).executeUpdate();

		}

		return shoppingCarList;

	}

	@Override
	public Order saveOrder(Address address, User user) {

		// 生成订单号：
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String time = format.format(new Date());
		// 随机订单
		int random = (int) (Math.random() * 1000);
		String ordernumber = time + random;

		Order order = new Order();

		order.setState("1");// 下单未付款
		order.setOrdernumber(ordernumber);// 订单号
		order.setTime(new Date());// 下单时间
		order.setAddress(address);
		order.setUser(user);

		getSession().save(order);

		return order;

	}

	@Override
	public void saveShopOrder(List<ShoppingCar> shoppingCar, Order order) {

		for (int i = 0; i < shoppingCar.size(); i++) {

			ShopOrder shopOrder = new ShopOrder();

			shopOrder.setShoppingCar(shoppingCar.get(i));
			shopOrder.setOrder(order);

			getSession().save(shopOrder);

		}

	}

	@Override
	public void updateState(Integer id) {
		// TODO Auto-generated method stub
		String hql = "update Order set state='2' Where id=?";
		
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
		
	}

}
