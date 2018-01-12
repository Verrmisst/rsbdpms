package cn.net.inlink.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 显示总务录入页面控制器
 * @author Yz
 *
 */
@Controller
@Scope("prototype")
public class ShowManaPageAction {
	
	public String execute(){
		
		return "show success";
	}
}
