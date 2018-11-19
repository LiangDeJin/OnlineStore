package com.graduationdesign.action;

import java.util.ArrayList;
import java.util.List;

import com.graduationdesign.entity.Address;
import com.graduationdesign.entity.Clothes;
import com.graduationdesign.entity.Order;
import com.graduationdesign.entity.ShopOrder;
import com.graduationdesign.entity.ShoppingCar;
import com.graduationdesign.entity.TemShopOrder;
import com.graduationdesign.entity.User;
import com.graduationdesign.service.IMyOrderService;
import com.graduationdesign.util.ListSubUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MyOrderAction extends ActionSupport {
	private static final long serialVersionUID = -4177590643068095312L;
	
	private IMyOrderService MyOrderService;

	public IMyOrderService getMyOrderService() {
		return MyOrderService;
	}

	public void setMyOrderService(IMyOrderService myOrderService) {
		MyOrderService = myOrderService;
	}

	@SuppressWarnings("static-access")
	public String MyOrder() {

		// 获取session中users
		User users = (User) ActionContext.getContext().getSession().get("users");
		if (users != null) {
			// 登陆的状态
			ActionContext.getContext().put("LoginState", "1");

			List<Order> myOrderList = MyOrderService.selectMyOrder(users);

			System.out.println("myOrderList.size：" + myOrderList.size());

			// 清空临时列表list
			temShopOrderList1.clear();
			for (int i = 0; i < myOrderList.size(); i++) {
				// 初始化
				TemShopOrder temShopOrder = new TemShopOrder();
				List<ShoppingCar> ShoppingCarList = new ArrayList<ShoppingCar>();

				// 查出这个订单对应的一条或多条ShopOrder
				List<ShopOrder> shopOrderList = MyOrderService.selectShopOrder(myOrderList.get(i).getId());

				System.out.println("shopOrderList.size：" + shopOrderList.size());
				for (int j = 0; j < shopOrderList.size(); j++) {
					// 将每条ShopOrder对应的ShoppingCar添加到list中
					ShoppingCarList.add(shopOrderList.get(j).getShoppingCar());
				}

				// 将订单和订单对应的一条或多条ShoppingCar存到临时的表
				temShopOrder.setOrder(myOrderList.get(i));
				temShopOrder.setShoppingCarList(ShoppingCarList);

				// 将这些每条存到列表list
				temShopOrderList1.add(temShopOrder);

				System.out.println("temShopOrderList.sizs:" + temShopOrderList1.size());

			}

			// 假分页
			ListSubUtil lsu = new ListSubUtil();
			// 每4个一组切割temShopOrderList
			List<List<TemShopOrder>> allTemShopOrder = lsu.subList(temShopOrderList1, 4);
			// 总页数
			ActionContext.getContext().put("pages", allTemShopOrder.size());
			// 如果当前页没有传过来或者当前页为第一页
			System.out.println(crrpage);
			if (null == crrpage) {
				// 当第一次进入给个第一页（默认）
				crrpage = 1;
			}
			System.out.println("当前页：" + crrpage);
			System.out.println("allTemShopOrder.size:" + allTemShopOrder.size());

			// 当前页
			ActionContext.getContext().put("crrpage", crrpage);
			if (allTemShopOrder.size() >= (crrpage - 1)) {
				System.out.println(allTemShopOrder.size());
				System.out.println(crrpage - 1);
				// 当前页所有订单+商品列表
				ActionContext.getContext().put("temShopOrderList", allTemShopOrder.get(crrpage - 1));
			}

			// 传当前action
			ActionContext.getContext().put("Action", "MyOrderAction");
		}
		crrpage = 1;

		return SUCCESS;
	}

	// 当前页
	private Integer crrpage;
	private List<TemShopOrder> temShopOrderList1 = new ArrayList<TemShopOrder>();

	public List<TemShopOrder> getTemShopOrderList1() {
		return temShopOrderList1;
	}

	public void setTemShopOrderList1(List<TemShopOrder> temShopOrderList1) {
		this.temShopOrderList1 = temShopOrderList1;
	}

	public void setCrrpage(Integer crrpage) {
		this.crrpage = crrpage;
	}

	public String getState1() {
		// 获取session中users
		User users = (User) ActionContext.getContext().getSession().get("users");
		if (users != null) {
			// 登陆的状态
			ActionContext.getContext().put("LoginState", "1");

			List<Order> myOrderList = MyOrderService.selectMyOrder1(users);

			// 清空临时列表list
			temShopOrderList1.clear();
			for (int i = 0; i < myOrderList.size(); i++) {
				// 初始化
				TemShopOrder temShopOrder = new TemShopOrder();
				List<ShoppingCar> ShoppingCarList = new ArrayList<ShoppingCar>();

				// 查出这个订单对应的一条或多条ShopOrder
				List<ShopOrder> shopOrderList = MyOrderService.selectShopOrder1(myOrderList.get(i).getId());

				for (int j = 0; j < shopOrderList.size(); j++) {
					// 将每条ShopOrder对应的ShoppingCar添加到list中
					ShoppingCarList.add(shopOrderList.get(j).getShoppingCar());
				}

				// 将订单和订单对应的一条或多条ShoppingCar存到临时的表
				temShopOrder.setOrder(myOrderList.get(i));
				temShopOrder.setShoppingCarList(ShoppingCarList);

				// 将这些每条存到列表list
				temShopOrderList1.add(temShopOrder);

			}
			System.out.println("temShopOrderList1.size:" + temShopOrderList1.size());
			// 假分页
			ListSubUtil lsu = new ListSubUtil();
			// 每4个一组切割allClothes
			List<List<TemShopOrder>> allTemShopOrder = lsu.subList(temShopOrderList1, 4);
			// 总页数
			ActionContext.getContext().put("pages", allTemShopOrder.size());
			// 如果当前页没有传过来或者当前页为第一页

			if (null == crrpage) {
				// 当第一次进入给个第一页（默认）
				crrpage = 1;
			}
			// 当前页
			ActionContext.getContext().put("crrpage", crrpage);
			// 当前页所有订单+商品列表
			ActionContext.getContext().put("temShopOrderList", allTemShopOrder.get(crrpage - 1));

			// 传当前action
			ActionContext.getContext().put("Action", "getState1Action");
		}
		crrpage = 1;
		return SUCCESS;

	}

	public String getState2() {
		// 获取session中users
		User users = (User) ActionContext.getContext().getSession().get("users");
		if (users != null) {
			// 登陆的状态
			ActionContext.getContext().put("LoginState", "1");

			List<Order> myOrderList = MyOrderService.selectMyOrder2(users);

			// 清空临时列表list
			temShopOrderList1.clear();
			for (int i = 0; i < myOrderList.size(); i++) {
				// 初始化
				TemShopOrder temShopOrder = new TemShopOrder();
				List<ShoppingCar> ShoppingCarList = new ArrayList<ShoppingCar>();

				// 查出这个订单对应的一条或多条ShopOrder
				List<ShopOrder> shopOrderList = MyOrderService.selectShopOrder2(myOrderList.get(i).getId());

				for (int j = 0; j < shopOrderList.size(); j++) {
					// 将每条ShopOrder对应的ShoppingCar添加到list中
					ShoppingCarList.add(shopOrderList.get(j).getShoppingCar());
				}

				// 将订单和订单对应的一条或多条ShoppingCar存到临时的表
				temShopOrder.setOrder(myOrderList.get(i));
				temShopOrder.setShoppingCarList(ShoppingCarList);

				// 将这些每条存到列表list
				temShopOrderList1.add(temShopOrder);

			}
			// 假分页
			ListSubUtil lsu = new ListSubUtil();
			// 每4个一组切割allClothes
			List<List<TemShopOrder>> allTemShopOrder = lsu.subList(temShopOrderList1, 4);
			// 总页数
			ActionContext.getContext().put("pages", allTemShopOrder.size());
			// 如果当前页没有传过来或者当前页为第一页

			if (null == crrpage) {
				// 当第一次进入给个第一页（默认）
				crrpage = 1;
			}
			// 当前页
			ActionContext.getContext().put("crrpage", crrpage);
			// 当前页所有订单+商品列表
			ActionContext.getContext().put("temShopOrderList", allTemShopOrder.get(crrpage - 1));

			// 传当前action
			ActionContext.getContext().put("Action", "getState2Action");
		}
		crrpage = 1;
		return SUCCESS;

	}

	public String getState3() {
		// 获取session中users
		User users = (User) ActionContext.getContext().getSession().get("users");
		if (users != null) {
			// 登陆的状态
			ActionContext.getContext().put("LoginState", "1");

			List<Order> myOrderList = MyOrderService.selectMyOrder3(users);

			// 清空临时列表list
			temShopOrderList1.clear();
			for (int i = 0; i < myOrderList.size(); i++) {
				// 初始化
				TemShopOrder temShopOrder = new TemShopOrder();
				List<ShoppingCar> ShoppingCarList = new ArrayList<ShoppingCar>();

				// 查出这个订单对应的一条或多条ShopOrder
				List<ShopOrder> shopOrderList = MyOrderService.selectShopOrder3(myOrderList.get(i).getId());

				for (int j = 0; j < shopOrderList.size(); j++) {
					// 将每条ShopOrder对应的ShoppingCar添加到list中
					ShoppingCarList.add(shopOrderList.get(j).getShoppingCar());
				}

				// 将订单和订单对应的一条或多条ShoppingCar存到临时的表
				temShopOrder.setOrder(myOrderList.get(i));
				temShopOrder.setShoppingCarList(ShoppingCarList);

				// 将这些每条存到列表list
				temShopOrderList1.add(temShopOrder);

			}
			// 假分页
			ListSubUtil lsu = new ListSubUtil();
			// 每4个一组切割allClothes
			List<List<TemShopOrder>> allTemShopOrder = lsu.subList(temShopOrderList1, 4);
			// 总页数
			ActionContext.getContext().put("pages", allTemShopOrder.size());
			// 如果当前页没有传过来或者当前页为第一页

			if (null == crrpage) {
				// 当第一次进入给个第一页（默认）
				crrpage = 1;
			}
			// 当前页
			ActionContext.getContext().put("crrpage", crrpage);
			// 当前页所有订单+商品列表
			ActionContext.getContext().put("temShopOrderList", allTemShopOrder.get(crrpage - 1));

			// 传当前action
			ActionContext.getContext().put("Action", "getState3Action");
		}
		crrpage = 1;
		return SUCCESS;

	}

	public String getState4() {
		// 获取session中users
		User users = (User) ActionContext.getContext().getSession().get("users");
		if (users != null) {
			// 登陆的状态
			ActionContext.getContext().put("LoginState", "1");

			List<Order> myOrderList = MyOrderService.selectMyOrder4(users);

			// 清空临时列表list
			temShopOrderList1.clear();
			for (int i = 0; i < myOrderList.size(); i++) {
				// 初始化
				TemShopOrder temShopOrder = new TemShopOrder();
				List<ShoppingCar> ShoppingCarList = new ArrayList<ShoppingCar>();

				// 查出这个订单对应的一条或多条ShopOrder
				List<ShopOrder> shopOrderList = MyOrderService.selectShopOrder4(myOrderList.get(i).getId());

				for (int j = 0; j < shopOrderList.size(); j++) {
					// 将每条ShopOrder对应的ShoppingCar添加到list中
					ShoppingCarList.add(shopOrderList.get(j).getShoppingCar());
				}

				// 将订单和订单对应的一条或多条ShoppingCar存到临时的表
				temShopOrder.setOrder(myOrderList.get(i));
				temShopOrder.setShoppingCarList(ShoppingCarList);

				// 将这些每条存到列表list
				temShopOrderList1.add(temShopOrder);

			}
			// 假分页
			ListSubUtil lsu = new ListSubUtil();
			// 每4个一组切割allClothes
			List<List<TemShopOrder>> allTemShopOrder = lsu.subList(temShopOrderList1, 4);
			// 总页数
			ActionContext.getContext().put("pages", allTemShopOrder.size());
			// 如果当前页没有传过来或者当前页为第一页

			if (null == crrpage) {
				// 当第一次进入给个第一页（默认）
				crrpage = 1;
			}
			// 当前页
			ActionContext.getContext().put("crrpage", crrpage);
			// 当前页所有订单+商品列表
			ActionContext.getContext().put("temShopOrderList", allTemShopOrder.get(crrpage - 1));

			// 传当前action
			ActionContext.getContext().put("Action", "getState4Action");
		}
		crrpage = 1;
		return SUCCESS;

	}

	public String getState5() {
		// 获取session中users
		User users = (User) ActionContext.getContext().getSession().get("users");
		if (users != null) {
			// 登陆的状态
			ActionContext.getContext().put("LoginState", "1");

			List<Order> myOrderList = MyOrderService.selectMyOrder5(users);

			// 清空临时列表list
			temShopOrderList1.clear();
			for (int i = 0; i < myOrderList.size(); i++) {
				// 初始化
				TemShopOrder temShopOrder = new TemShopOrder();
				List<ShoppingCar> ShoppingCarList = new ArrayList<ShoppingCar>();

				// 查出这个订单对应的一条或多条ShopOrder
				List<ShopOrder> shopOrderList = MyOrderService.selectShopOrder5(myOrderList.get(i).getId());

				for (int j = 0; j < shopOrderList.size(); j++) {
					// 将每条ShopOrder对应的ShoppingCar添加到list中
					ShoppingCarList.add(shopOrderList.get(j).getShoppingCar());
				}

				// 将订单和订单对应的一条或多条ShoppingCar存到临时的表
				temShopOrder.setOrder(myOrderList.get(i));
				temShopOrder.setShoppingCarList(ShoppingCarList);

				// 将这些每条存到列表list
				temShopOrderList1.add(temShopOrder);

			}
			// 假分页
			ListSubUtil lsu = new ListSubUtil();
			// 每4个一组切割allClothes
			List<List<TemShopOrder>> allTemShopOrder = lsu.subList(temShopOrderList1, 4);
			// 总页数
			ActionContext.getContext().put("pages", allTemShopOrder.size());
			// 如果当前页没有传过来或者当前页为第一页

			if (null == crrpage) {
				// 当第一次进入给个第一页（默认）
				crrpage = 1;
			}
			// 当前页
			ActionContext.getContext().put("crrpage", crrpage);

			if (allTemShopOrder.size() >= (crrpage - 1)) {
				System.out.println(allTemShopOrder.size());
				System.out.println(crrpage - 1);
				// 当前页所有订单+商品列表
				ActionContext.getContext().put("temShopOrderList", allTemShopOrder.get(crrpage - 1));
			}

			// 传当前action
			ActionContext.getContext().put("Action", "getState5Action");
		}
		crrpage = 1;
		return SUCCESS;

	}

	// 退换货的时候把状态更新为5
	public String updateState5() {

		// 传过来的订单id号
		System.out.println(orderid);
		MyOrderService.updateState5(orderid);
		return SUCCESS;
	}

	// 退换货的时候把状态更新为5
	public String updateState3() {

		// 传过来的订单id号
		System.out.println(orderid);
		MyOrderService.updateState3(orderid);
		return SUCCESS;
	}

	private Integer orderid;

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

}
