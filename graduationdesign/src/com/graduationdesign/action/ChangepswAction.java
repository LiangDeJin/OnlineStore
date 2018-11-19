package com.graduationdesign.action;

import com.graduationdesign.entity.User;
import com.graduationdesign.service.ILoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ChangepswAction extends ActionSupport {
	private static final long serialVersionUID = -3745160889527588287L;

	public String changepsw() {
		System.out.println(psw);
		System.out.println(newPsw);

		User users = (User) ActionContext.getContext().getSession().get("users");
		// 查psw是否符合原密码或者验证码
		User user = loginService.getUserByPwd(psw, users);
		if (null == user) {
			// 验证码错误或者原密码错误
		} else {
			loginService.updatePwd(newPsw, users);
			ActionContext.getContext().put("changepsw", "1");
		}
		return SUCCESS;
	}

	private String psw;
	private String newPsw;

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getNewPsw() {
		return newPsw;
	}

	public void setNewPsw(String newPsw) {
		this.newPsw = newPsw;
	}

	/**
	 * 注入
	 */
	private ILoginService loginService;

	public ILoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

}
