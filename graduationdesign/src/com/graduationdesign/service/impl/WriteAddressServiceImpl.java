package com.graduationdesign.service.impl;

import java.util.List;

import com.graduationdesign.dao.IWriteAddressDao;
import com.graduationdesign.entity.Address;
import com.graduationdesign.entity.China;
import com.graduationdesign.entity.Order;
import com.graduationdesign.entity.ShoppingCar;
import com.graduationdesign.entity.User;
import com.graduationdesign.service.IWriteAddressService;

public class WriteAddressServiceImpl implements IWriteAddressService {
	/**
	 * 注入
	 */
	private IWriteAddressDao writeAddressdao;

	public IWriteAddressDao getWriteAddressdao() {
		return writeAddressdao;
	}

	public void setWriteAddressdao(IWriteAddressDao writeAddressdao) {
		this.writeAddressdao = writeAddressdao;
	}

	@Override
	public Address saveAddress(String name, String phone, China province, China city, China country, String detailaddress,User user) {

		Address address = writeAddressdao.saveAddress(name, phone, province, city, country, detailaddress, user);
		
		return address;
	}

	@Override
	public List<ShoppingCar> updateShopCarState(User user) {
		List<ShoppingCar> shoppingCar = writeAddressdao.updateShopCarState(user);
		
		return shoppingCar;
	}

	@Override
	public Order saveOrder(Address address, User user) {
		
		Order order = writeAddressdao.saveOrder(address, user);
		
		return order;
	}

	@Override
	public void saveShopOrder(List<ShoppingCar> shoppingCar, Order order) {
		
		writeAddressdao.saveShopOrder(shoppingCar, order);
		
	}

	@Override
	public void updateState(Integer id) {
		// TODO Auto-generated method stub
		writeAddressdao.updateState(id);
	}

}
