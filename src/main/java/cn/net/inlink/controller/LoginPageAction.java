package cn.net.inlink.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 访问登录页面的控制器
 * @author Yz
 *
 */
@Controller
@Scope("prototype")
public class LoginPageAction {
	
	public String login(){
		
		return "show login";
	}
}
