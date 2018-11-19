package com.graduationdesign.service.impl;

import java.util.List;

import com.graduationdesign.dao.IAllLogisticsDao;
import com.graduationdesign.entity.FootPrint;
import com.graduationdesign.entity.Order;
import com.graduationdesign.entity.User;
import com.graduationdesign.service.IAllLogisticsService;

public class AllLogisticsServiceImpl implements IAllLogisticsService {

	@Override
	public List<Order> getAllLogistics(User user) {
		return allLogisticsDao.getAllLogistics(user);
	}
	
	private IAllLogisticsDao allLogisticsDao;

	public IAllLogisticsDao getAllLogisticsDao() {
		return allLogisticsDao;
	}

	public void setAllLogisticsDao(IAllLogisticsDao allLogisticsDao) {
		this.allLogisticsDao = allLogisticsDao;
	}

	@Override
	public Order getLogisticsByOrderid(Integer id) {
		Order order = allLogisticsDao.getLogisticsByOrderid(id);
		return order;
	}

	@Override
	public List<FootPrint> getFootPrint(Integer userid) {
		List<FootPrint> fpList = allLogisticsDao.getFootPrint(userid);
		return fpList;
	}
	
	

}
