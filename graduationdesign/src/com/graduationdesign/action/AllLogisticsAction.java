package com.graduationdesign.action;

import java.util.ArrayList;
import java.util.List;

import com.graduationdesign.entity.FootPrint;
import com.graduationdesign.entity.Order;
import com.graduationdesign.entity.User;
import com.graduationdesign.service.IAllLogisticsService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AllLogisticsAction extends ActionSupport {
	private static final long serialVersionUID = -1491871232217100692L;

	public String allLogistics() {
		// 获取session中users
		User users = (User) ActionContext.getContext().getSession().get("users");

		if (users != null) {

			List<Order> allLogisticsList = allLogisticsService.getAllLogistics(users);
			ActionContext.getContext().put("allLogisticsList", allLogisticsList);
		}

		return SUCCESS;
	}

	public String getLogisticsByOrderid() {

		if (orderid != null) {
			Order order = allLogisticsService.getLogisticsByOrderid(orderid);

			if (order != null) {

				List<Order> allLogisticsList = new ArrayList<Order>();

				allLogisticsList.add(order);

				ActionContext.getContext().put("allLogisticsList", allLogisticsList);

				return SUCCESS;
			}
		}
		ActionContext.getContext().put("noLogistics", "暂无物流");
		return "false";
	}
	
	public String footPrintAll(){
		
		// 获取session中users
		User users = (User) ActionContext.getContext().getSession().get("users");
		
		List<FootPrint> footPrintList = allLogisticsService.getFootPrint(users.getId());
		
		ActionContext.getContext().put("footPrintList", footPrintList);
		
		return SUCCESS;
	}

	/**
	 * 属性驱动
	 */
	private Integer orderid;

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	/**
	 * 注入
	 */
	private IAllLogisticsService allLogisticsService;

	public IAllLogisticsService getAllLogisticsService() {
		return allLogisticsService;
	}

	public void setAllLogisticsService(IAllLogisticsService allLogisticsService) {
		this.allLogisticsService = allLogisticsService;
	}

}
