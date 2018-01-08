package cn.net.inlink.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

//显示主页的控制器
@Controller
@Scope("prototype")
public class ShowHomePageAction {
	
	public String execute(){
		
		return "show homepage";
	}
}
