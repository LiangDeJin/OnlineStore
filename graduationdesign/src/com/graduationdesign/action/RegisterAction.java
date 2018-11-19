package com.graduationdesign.action;

import com.graduationdesign.entity.User;
import com.graduationdesign.service.IRegisterService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends ActionSupport implements ModelDriven<User> {
	private static final long serialVersionUID = -6240333702352987761L;

	// 返回的方法method=registerAction
	public String registerAction() {
		System.out.println("用户名" + user.getUsername());
		if(user.getUsername()!=null || user.getPassword()!= null){
			if(registerService.register(user.getUsername(), user.getPassword())){
				//注册成功
				return SUCCESS;
			}else{
				//用户名已存在
				ActionContext.getContext().put("registerTip", "1");
				return "false";
			}
		}
		//账号或密码为空
		ActionContext.getContext().put("registerTip", "0");
		return "false";
	}

	// 将IRegisterService注入进来
	private IRegisterService registerService;

	public IRegisterService getRegisterService() {
		return registerService;
	}

	public void setRegisterService(IRegisterService registerService) {
		this.registerService = registerService;
	}

	// 用了ModelDriven的接口
	// 要用到实体类的对象
	User user = new User();

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
}
