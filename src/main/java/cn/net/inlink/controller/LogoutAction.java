package cn.net.inlink.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.entity.User;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户登出的控制器
 * 
 * @author Yz
 * 
 */
@Controller
@Scope("prototype")
public class LogoutAction extends ActionSupport {

	// 日志记录
	private Logger log = Logger.getLogger(LogoutAction.class);
	
	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public String execute() {

		// 获取session对象
		Map<String, Object> session = ServletActionContext.getContext()
				.getSession();

		User user = (User) session.get("user");

		if (user != null) {

			String username = user.getUserName();

			// 将用户从sessionMap中移除
			session.remove("user");

			log.info(username + "，退出登录。时间是："
					+ new SimpleDateFormat().format(new Date()));

			return "logout success";
		}
		return "logout success";
	}
}
