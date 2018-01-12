package cn.net.inlink.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 控制显示人事单独录入页面的控制器
 * @author Yz
 *
 */
@Controller
@Scope("prototype")
public class ShowHRSingleTypeinAction {
	
	public String execute(){
		
		
		return "show single";
	}
}
