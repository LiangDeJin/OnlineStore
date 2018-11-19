package com.graduationdesign.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.graduationdesign.dao.IMyCarDao;
import com.graduationdesign.entity.ShoppingCar;
import com.graduationdesign.entity.User;

public class MyCarDaoImpl implements IMyCarDao {

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
	public List<ShoppingCar> getAddCar(User users) {

		String hql = "From ShoppingCar where user.id = ? and (state='1' or state='0')";
		
		List<ShoppingCar> shopingCar = getSession().createQuery(hql).setInteger(0, users.getId()).list();
		
		System.out.println("shopingCar:"+shopingCar);
		// TODO Auto-generated method stub
		return shopingCar;
	}

	@Override
	public void deleteCar(User users, Integer clothesId) {

		String hql = "delete From ShoppingCar as shcar where shcar.user.id = ? and shcar.clothes.id = ?  and (state='1' or state='0')";

		getSession().createQuery(hql).setInteger(0, users.getId()).setInteger(1, clothesId).executeUpdate();

		// TODO Auto-generated method stub
	}

	@Override
	public void updateCar(Integer clothesId, Integer selectNum, User users) {

		String hql = "update ShoppingCar as shcar set shcar.num = ? where shcar.clothes.id = ? and shcar.user.id = ?  and (state='1' or state='0')";

		getSession().createQuery(hql).setInteger(0, selectNum).setInteger(1, clothesId).setInteger(2, users.getId())
				.executeUpdate();
		// TODO Auto-generated method stub

	}

	@Override
	public void choiceCar(User users, Integer clothesId) {

		// 通过clothes.id和user.id去查购物车的数据信息
		String hqlselect = "From  ShoppingCar where clothes.id = ? and user.id = ?   and (state='1' or state='0')";

		ShoppingCar shopcar = (ShoppingCar) getSession().createQuery(hqlselect).setInteger(0, clothesId)
				.setInteger(1, users.getId()).uniqueResult();

		System.out.println("shopcar.getState():" + shopcar.getState());
		// 如果获得的数据信息 已经被选中的 点击改变状态
		if (shopcar.getState().equals("1")) {
			shopcar.setState("0");
		} else {
			shopcar.setState("1");
		}

		// 更新数据库的购物车的状态
		String hql = "update ShoppingCar as shcar set shcar.state = ? where shcar.clothes.id = ? and shcar.user.id = ?  and (state='1' or state='0')";

		getSession().createQuery(hql).setString(0, shopcar.getState()).setInteger(1, clothesId)
				.setInteger(2, users.getId()).executeUpdate();
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public void choiceALlCar(User users) {

		// 通过user.id去查购物车的所有的购物车数据信息
		String hqlselect = "From  ShoppingCar where user.id = ?  and (state='1' or state='0')";

		List<ShoppingCar> shopcar = getSession().createQuery(hqlselect).setInteger(0, users.getId()).list();

		System.out.println("shopcar:"+shopcar);
		
		// 进行两种情况的判断 全部为选中状态的时候全选变为0 其余都变为1
		int j = 0;
		for (int i = 0; i < shopcar.size(); i++) {
			if (shopcar.get(i).getState().equals("1")) {
				j++;
			}
		}

		System.out.println("j:"+j);
		System.out.println("shopcar.size():"+shopcar.size());
		if (j == shopcar.size()) {
			// 全部为1
			// 把所有购物车的状态信息全部进行更新修改
			for (int i = 0; i < shopcar.size(); i++) {

				shopcar.get(i).setState("0");

				// 更新数据库的购物车的状态
				String hql = "update ShoppingCar as shcar set shcar.state = ? where shcar.id = ? and (shcar.state='1' or shcar.state='0')";

				getSession().createQuery(hql).setString(0, shopcar.get(i).getState())
						.setInteger(1, shopcar.get(i).getId()).executeUpdate();
			}
		} else {
			// 全部为0(或者有0有1)
			for (int i = 0; i < shopcar.size(); i++) {
				//状态为0进行改变为1
				if (shopcar.get(i).getState().equals("0")) {
					shopcar.get(i).setState("1");
					// 更新数据库的购物车的状态
					String hql = "update ShoppingCar as shcar set shcar.state = ? where shcar.id = ? and (shcar.state='1' or shcar.state='0')";
					getSession().createQuery(hql).setString(0, shopcar.get(i).getState())
							.setInteger(1, shopcar.get(i).getId()).executeUpdate();
				} else {
					//状态为1的时候不进行操作
				}
			
			}

		}

		// TODO Auto-generated method stub

	}

}
