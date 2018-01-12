package cn.net.inlink.controller;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.entity.Function;
import cn.net.inlink.entity.Role;
import cn.net.inlink.entity.User;
import cn.net.inlink.service.RoleService;
import cn.net.inlink.service.UserService;
import cn.net.inlink.utils.JSONUtil;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 请求首页内容的控制器
 * 
 * @author Yz
 * 
 */
@Controller
public class PageContentAction extends ActionSupport {

	// 属性依赖
	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	// 页面内容
	private String pageContent;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public String getPageContent() {
		return pageContent;
	}

	public void setPageContent(String pageContent) {
		this.pageContent = pageContent;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public String execute() {
		// 获取到用户的sessionMap
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();

		// 当前用户
		User user = (User) session.get("user");

		// 获取当前用户的角色集合
		List<Role> roleList = userService.getRoles(user.getUserName());

		List<Function> funcList = null;
		

		// 获取角色集合中的每个角色对应的功能集合

		for (Role role : roleList) {

			funcList = roleService.pageContent(role.getRoleName());
			
			
		}

		// 返回json字符串
		this.pageContent = JSONUtil.ListToJSON(funcList);

		return "show pagecontent";
	}
}
