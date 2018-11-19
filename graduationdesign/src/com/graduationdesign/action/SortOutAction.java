package com.graduationdesign.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.graduationdesign.entity.Address;
import com.graduationdesign.entity.China;
import com.graduationdesign.entity.Clothes;
import com.graduationdesign.entity.ShoppingCar;
import com.graduationdesign.entity.User;
import com.graduationdesign.service.ISortOutService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SortOutAction extends ActionSupport {

	// 注入
	private ISortOutService sortOutService;

	public ISortOutService getSortOutService() {
		return sortOutService;
	}

	public void setSortOutService(ISortOutService sortOutService) {
		this.sortOutService = sortOutService;
	}

	public String sortOut() {

		// 获取session中users
		User users = (User) ActionContext.getContext().getSession().get("users");
		if (users != null) {
			// 登陆的状态
			ActionContext.getContext().put("LoginState", "1");
			List<ShoppingCar> UserShoppingCar = sortOutService.seleteSortOut(users);
			ActionContext.getContext().put("UserShoppingCar", UserShoppingCar);

			// 查省列表
			List<China> provinceList = sortOutService.getprovince();
			
			//默认的地址
			address = sortOutService.getdefalt(users);
			
			if(address!=null){
				provinceList.get(0).setId(address.getProvince().getId());
				provinceList.get(0).setName(address.getProvince().getName());
				provinceList.get(0).setChina(address.getProvince().getChina());
			}
			
			ActionContext.getContext().put("provinceList", provinceList);
			
		}

		return SUCCESS;
	}

	public String selectCity() throws IOException {
		System.out.println("省份id："+pid);
		// 查城市列表
		List<China> cityList = sortOutService.getCity(pid);

		//-------------------------------------------------------
		// ajax 传前台
				// json数组
				JSONArray json = new JSONArray();
				for (China c : cityList) {
					// json对象
					JSONObject jo = new JSONObject();
					jo.put("id", c.getId());
					jo.put("name", c.getName());

					// 添加数组
					json.add(jo);
				}
				System.out.println(json.toString());

				HttpServletResponse hsr = ServletActionContext.getResponse();
				hsr.setCharacterEncoding("UTF-8");
				// 将json 数组转 String 传出
				hsr.getWriter().write(json.toString());
		//-------------------------------------------------------
		return null;
	}

	private Integer pid;
	private Address address;
	
	
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}	
	
	
	

}
