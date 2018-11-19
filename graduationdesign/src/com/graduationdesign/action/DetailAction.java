package com.graduationdesign.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.graduationdesign.entity.Clothes;
import com.graduationdesign.entity.FootPrint;
import com.graduationdesign.entity.ShopOrder;
import com.graduationdesign.entity.ShoppingCar;
import com.graduationdesign.entity.User;
import com.graduationdesign.service.IDetailService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DetailAction extends ActionSupport implements ModelDriven<Clothes> {
	private static final long serialVersionUID = -2621444265694333160L;

	public String detail() {

		List<FootPrint> footPrintList = new ArrayList<FootPrint>();
		// 获取session中users
		User users = (User) ActionContext.getContext().getSession().get("users");
		if (users != null) {
			// 登陆的状态
			ActionContext.getContext().put("LoginState", "1");

			if (x != null && null == y) {
				// 加入浏览记录
				DetailService.saveFootPrint(clothesDetail.getId(), users.getId());
			}

			// 查出该用户最近的三条
			footPrintList = DetailService.getFootPrint(users.getId());
			
		} else {
			footPrintList = DetailService.getFootPrint();
		}

		ActionContext.getContext().put("footPrintList", footPrintList);

		// 相当于 Clothes clothes = DetailService.getDetail(clothesDetail.getId());
		// ActionContext.getContext().put("clothes", clothes);
		clothesDetail = DetailService.getDetail(clothesDetail.getId());
		
		x = null;
		y = null;
		
		// 查出评论相关表ShopOrder
		List<ShopOrder> ShopOrderList = DetailService.getCommentsList(clothesDetail.getId());
		ActionContext.getContext().put("ShopOrderList", ShopOrderList);
		
		if(ShopOrderList.size()>0){
			Integer good = 0;//好评
			Integer middle = 0;//中评
			Integer low = 0;//差评
			for(int i = 0 ; i< ShopOrderList.size();i++){
				if(ShopOrderList.get(i).getComments().getPraise().equals("100")){
					good++;
				}else if(ShopOrderList.get(i).getComments().getPraise().equals("50")){
					middle++;
				}else if(ShopOrderList.get(i).getComments().getPraise().equals("0")){
					low++;
				}
			}
			ActionContext.getContext().put("good", good);
			ActionContext.getContext().put("middle", middle);
			ActionContext.getContext().put("low", low);
			ActionContext.getContext().put("sum", good+middle+low);
			ActionContext.getContext().put("noHaveList", "1");
		}else{
			ActionContext.getContext().put("noHaveList", "0");
		}
		
		return "success";
	}

	// 加入购物车的方法
	public String addCar() throws Exception {

		System.out.println(ID + size + num + color + custom);

		// 初始化为str = "1",如果没有登陆就改变为0;
		String str = "1";
		// 获取添加购物车的session的用户
		User users = (User) ActionContext.getContext().getSession().get("users");
		if (users != null) {
			// 已登陆
			// 根据商品用户去查询购物车
			ShoppingCar shoppingCar = DetailService.getShoppingCar(ID, users.getId());
			if (shoppingCar != null) {
				// 根据衣服的ID去数据库查询衣服的详情
				// 登陆但已经添加过购物车
				str = "2";
				inputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
				return "add";
			} else {
				Clothes clothes = DetailService.getDetail(ID);
				DetailService.addShoppingCar(clothes, custom, size, num, color, users);
				inputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
				return "add";

			}

		} else {
			// 如果没有登陆的情况返回为0传到前台，再进行相应的操作
			str = "0";
			inputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
			return "add";
		}

	}

	// 模型驱动 定义格式
	Clothes clothesDetail = new Clothes();

	@Override
	public Clothes getModel() {
		// TODO Auto-generated method stub
		return clothesDetail;
	}

	// 注入IDetailService接口
	private IDetailService DetailService;

	public IDetailService getDetailService() {
		return DetailService;
	}

	public void setDetailService(IDetailService detailService) {
		DetailService = detailService;
	}

	/**
	 * 通过数据流的方式把数据封装起来，传到ajax 里面调用
	 */
	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	/**
	 * 属性驱动
	 */
	private Integer ID;
	private Integer custom;
	private String size;
	private String num;
	private String color;
	private Integer x;
	private Integer y;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getCustom() {
		return custom;
	}

	public void setCustom(Integer custom) {
		this.custom = custom;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

}
