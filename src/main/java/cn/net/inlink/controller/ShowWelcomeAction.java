package cn.net.inlink.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 显示欢迎页的控制器
 * @author Yz
 *
 */
@Controller
@Scope("prototype")
public class ShowWelcomeAction {
	
	public String execute(){
		
		return "show welcome";
	}
}
