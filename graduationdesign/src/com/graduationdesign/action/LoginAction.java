package com.graduationdesign.action;

import com.graduationdesign.entity.User;
import com.graduationdesign.service.ILoginService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 6291214000559359171L;

	public String login() {
		System.out.println("用户名是：" + user.getUsername());

		// 去数据库匹配是否有该用户
		boolean loginSuccess = loginService.getLogin(user.getUsername(), user.getPassword());
		if (loginSuccess) {
			// 登陆成功
			User users = loginService.getUser(user.getUsername(), user.getPassword());
			ActionContext.getContext().getSession().put("users", users);
			// 登陆的状态
			ActionContext.getContext().put("LoginState", "1");
			return "success";
		}
		// 用户名或者密码错误
		ActionContext.getContext().put("loginTip", 1);
		return "flase";
	}
	
	//通过邮箱默认登录
	public String emailLogin(){
		System.out.println("用户名是：" + user.getUsername());

		// 去数据库匹配是否有该用户
		boolean loginSuccess = loginService.getLogin(user.getUsername(), user.getPassword());
		if (loginSuccess) {
			// 登陆成功
			User users = loginService.getUser(user.getUsername(), user.getPassword());
			ActionContext.getContext().getSession().put("users", users);
			// 登陆的状态
			ActionContext.getContext().put("LoginState", "1");
			
		}
		return "success";
	}

	public String remove() {

		ActionContext.getContext().getSession().remove("users");

		return SUCCESS;

	}
	
	// 跳转到首页信息
		public String index() {
			// 获取session中users
			User users = (User) ActionContext.getContext().getSession().get("users");
			if (users != null) {
				// 登陆的状态
				ActionContext.getContext().put("LoginState", "1");

			}
			return SUCCESS;
		}

	// 跳转到用户信息
	public String userMessage() {
		// 获取session中users
		User users = (User) ActionContext.getContext().getSession().get("users");
		if (users != null) {
			// 登陆的状态
			ActionContext.getContext().put("LoginState", "1");
			ActionContext.getContext().put("image", users.getImage());
			return SUCCESS;
		}
		return "false";
	}

	// 相当于private ILoginService loginService = new LoginServiceImpl();
	private ILoginService loginService;

	public ILoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	// 模型驱动 定义格式
	User user = new User();

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
