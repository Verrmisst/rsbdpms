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

import cn.net.inlink.entity.User;
import cn.net.inlink.service.UserService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 登录控制器,校验用户名密码是否正确
 * 
 * @author Yz
 * 
 */
@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport {

	// 日志记录
	private Logger log = Logger.getLogger(LoginAction.class);

	// 属性依赖
	@Autowired
	private UserService service;

	private String username;

	private String password;

	// 反馈信息
	private String message;

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public String execute(){
		
		if (this.username != null && this.password != null) {
			// 判断表中是否有该用户存在
			if (service.login(username.trim()) != null && !this.username.equals("")
					&& this.username != null) {
				
				log.info(this.username + "，开始登录。时间："
						+ new SimpleDateFormat().format(new Date()));

				// 判断输入的密码是否正确
				if (this.password.equals(service.login(username.trim()).getPassword())) {
					// 用户对象
					User user = service.login(username.trim());

					// 获取会话对象map
					Map<String, Object> session = ServletActionContext
							.getContext().getSession();

					// 将登录用户放入sessionMap中
					session.put("user", user);

					return "login success";

				} else {

					this.message = "密码错误";

					log.error(this.username + "，密码填写错误");

					return "login error";
				}
			} else {

				this.message = "用户名或者密码有误";

				return "login error";
			}
		}else{
			
			return "login error";
			}
		}
		
	}
