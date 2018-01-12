package cn.net.inlink.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;

import cn.net.inlink.entity.User;
import cn.net.inlink.service.UserService;

/**
 * 控制用户修改密码的控制器
 * 
 * @author Yz
 * 
 */
@Controller
@Scope("prototype")
public class ChangePasswordAction extends ActionSupport {
	
	//日志
	private Logger log = Logger.getLogger(ChangePasswordAction.class);
	
	// 属性依赖
	@Autowired
	private UserService service;

	// 新密码
	private String newPassword;

	// 确认密码
	private String confirmPassword;

	// 信息
	private String information;

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public String execute(){
		
		//获取SessionMap
		// 获取到用户的sessionMap
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();

		// 当前用户
		User user = (User) session.get("user");

		Integer id = user.getId();
		
		if(!this.newPassword.equals(this.confirmPassword)){
			
			
			this.information = "修改失败，请重新进行修改！";
			
			log.error(user.getUserName()+"，密码修改失败，时间："+new SimpleDateFormat().format(new Date()));
			
			return "edit error";
			
		}else{
			
			service.editPassword(id, this.newPassword);
			
			//将用户从sessionMap中移除。
			session.remove("user");
			
			this.information = "修改成功，请重新登录！";
			
			log.info(user.getUserName()+"，密码修改成功，时间："+new SimpleDateFormat().format(new Date()));
			
			
			return "edit success";
			
		}
		
	}
	
}
