package com.graduationdesign.action;

import java.util.List;

import com.graduationdesign.entity.ShoppingCar;
import com.graduationdesign.entity.User;
import com.graduationdesign.service.IMyCarService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class myCarAction extends ActionSupport {

	private static final long serialVersionUID = 4632682651870458366L;

	public String myCar() {
		
		User users = (User) ActionContext.getContext().getSession().get("users");
		if (users != null) {	
			//用户已经登录
			List<ShoppingCar>  carList  =	myCarService.getAddCar(users);		
			ActionContext.getContext().put("carList", carList);
			ActionContext.getContext().put("LoginState", "1");
			
		} else {
			//用户没有登录不操作
		}

		return "success";

	}

	
	private IMyCarService myCarService;

	public IMyCarService getMyCarService() {
		return myCarService;
	}

	public void setMyCarService(IMyCarService myCarService) {
		this.myCarService = myCarService;
	}
	
	
	

//	删除购物车的操作
	public String deleteCar(){
		//当前购物车需要删除的那衣服购物车
		System.out.println(clothesId);
		//已经知道的用户
		User users = (User) ActionContext.getContext().getSession().get("users");
		
		myCarService.deleteCar(users, clothesId);
		
		return  null;
	}
	
	private Integer clothesId;

	public Integer getClothesId() {
		return clothesId;
	}

	public void setClothesId(Integer clothesId) {
		this.clothesId = clothesId;
	}
	
	//更新数据库里面的购物车被选泽数量
	public String updateCar(){
		System.out.println(clothesId+ "+" +selectNum);
		//已经知道的用户
		User users = (User) ActionContext.getContext().getSession().get("users");
		 
		myCarService.updateCar(clothesId, selectNum, users);
		return null;
	}
	
	private Integer selectNum;

	public Integer getSelectNum() {
		return selectNum;
	}

	public void setSelectNum(Integer selectNum) {
		this.selectNum = selectNum;
	}
	
	
	////更新数据库里面的购物车状态是否被选中
	public String choiceCar(){
		System.out.println(clothesId);
		//已经知道的用户
		User users = (User) ActionContext.getContext().getSession().get("users");
		
		myCarService.choiceCar(users, clothesId);
		return null;
	}
	
	//更新数据库里面的购物车状态是否为全选
	public String choiceALlCar(){
		
		//已经知道的用户
		User users = (User) ActionContext.getContext().getSession().get("users");
		
		myCarService.choiceALlCar(users);
		return null;
	}
}
