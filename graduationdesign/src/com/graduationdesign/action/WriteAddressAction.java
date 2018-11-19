package com.graduationdesign.action;

import java.util.List;

import com.graduationdesign.entity.Address;
import com.graduationdesign.entity.China;
import com.graduationdesign.entity.Order;
import com.graduationdesign.entity.ShoppingCar;
import com.graduationdesign.entity.User;
import com.graduationdesign.service.IWriteAddressService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class WriteAddressAction extends ActionSupport {

	private static final long serialVersionUID = 7873004192067886547L;

	public String pay() {

		User users = (User) ActionContext.getContext().getSession().get("users");

		if (users != null) {
			// 登陆的状态
			ActionContext.getContext().put("LoginState", "1");

			writeAddressService.updateState(orderid);
			if(null==mark||mark==""){
				
				return SUCCESS;
				
			}
		}
		mark = null;
		return "topaymentsuccess";
		
	}

	// 属性驱动

	private Integer orderid;
	private String mark;

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String writeAddress() {
		System.out.println(allMoney);

		User users = (User) ActionContext.getContext().getSession().get("users");
		if (users != null) {
			// 登陆的状态
			ActionContext.getContext().put("LoginState", "1");

			China chinaprovince = new China();
			China chinacity = new China();
			China chinacountry = new China();

			int province1 = Integer.parseInt(province);

			int city1 = Integer.parseInt(city);

			int country1 = Integer.parseInt(country);

			chinaprovince.setId(province1);
			chinacity.setId(city1);
			chinacountry.setId(country1);

			// 存入地址表
			Address address = writeAddressService.saveAddress(address_name, phone, chinaprovince, chinacity,
					chinacountry, detail_address, users);

			// 将该用户购物车表中状态为选中（即 ‘1’的）改变为2
			List<ShoppingCar> shoppingCar = writeAddressService.updateShopCarState(users);

			// 生成订单
			Order order = writeAddressService.saveOrder(address, users);
			orderid = order.getId();
			// 把订单号传出去ordernumber
			ActionContext.getContext().put("ordernumber", order.getOrdernumber());

			// 将刚下单的那些商品与订单表关联
			writeAddressService.saveShopOrder(shoppingCar, order);

		}

		return SUCCESS;
	}

	/**
	 * 属性驱动
	 */
	private String address_name;// 收货人
	private String phone;// 手机号码
	private String province;// 省
	private String city;// 市
	private String country;// 区
	private String detail_address;// 详细

	private String allMoney;// 总价

	public String getAllMoney() {
		return allMoney;
	}

	public void setAllMoney(String allMoney) {
		this.allMoney = allMoney;
	}

	public String getAddress_name() {
		return address_name;
	}

	public void setAddress_name(String address_name) {
		this.address_name = address_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDetail_address() {
		return detail_address;
	}

	public void setDetail_address(String detail_address) {
		this.detail_address = detail_address;
	}

	/**
	 * 注入
	 */
	private IWriteAddressService writeAddressService;

	public IWriteAddressService getWriteAddressService() {
		return writeAddressService;
	}

	public void setWriteAddressService(IWriteAddressService writeAddressService) {
		this.writeAddressService = writeAddressService;
	}

}
