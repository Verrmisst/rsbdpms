package cn.net.inlink.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 显示通报信息的控制器
 * @author Yz
 *
 */
@Controller
@Scope("prototype")
public class ShowNotificationAction {
	
	public String execute(){
		
		return "show success";
	}
}
