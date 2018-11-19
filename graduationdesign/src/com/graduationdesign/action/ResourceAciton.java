package com.graduationdesign.action;

import java.util.List;

import com.graduationdesign.entity.Address;
import com.graduationdesign.entity.China;
import com.graduationdesign.entity.User;
import com.graduationdesign.service.IResourceService;
import com.graduationdesign.service.ISortOutService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ResourceAciton extends ActionSupport {
	private static final long serialVersionUID = 7364623395521840347L;
	// 注入
	private IResourceService ResourceService;

	public IResourceService getResourceService() {
		return ResourceService;
	}

	public void setResourceService(IResourceService resourceService) {
		ResourceService = resourceService;
	}

	public String Resources() {

		// 获取session中users
		User users = (User) ActionContext.getContext().getSession().get("users");
		if (users != null) {
			// 登陆的状态
			ActionContext.getContext().put("LoginState", "1");

			resource = ResourceService.selectResource(users);

			List<Address> addressList = ResourceService.selectResourceList(users);

			ActionContext.getContext().put("addressList", addressList);

			// 查出省份
			List<China> provinceList = sortOutService.getprovince();
			ActionContext.getContext().put("provinceList", provinceList);
		}

		System.out.println("---------------------------------------------changepsw---------------:"+changepsw);
		return SUCCESS;
	}

	private Address resource;
	private ISortOutService sortOutService;

	public ISortOutService getSortOutService() {
		return sortOutService;
	}

	public void setSortOutService(ISortOutService sortOutService) {
		this.sortOutService = sortOutService;
	}

	public Address getResource() {
		return resource;
	}

	public void setResource(Address resource) {
		this.resource = resource;
	}

	//把确定修改密码传出去
	public String changepsw;

	public String getChangepsw() {
		return changepsw;
	}

	public void setChangepsw(String changepsw) {
		this.changepsw = changepsw;
	}
	
}
