package cn.net.inlink.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 显示人事调配页面的控制器
 * @author Yz
 *
 */
@Controller
@Scope("prototype")
public class ShowHRExchangeAction {
	
	public String execute(){
		
		return "success";
	}
}
