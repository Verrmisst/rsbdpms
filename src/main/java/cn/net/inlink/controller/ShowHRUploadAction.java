package cn.net.inlink.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 控制显示人事批量上传页面的控制器
 * @author Yz
 *
 */
@Controller
@Scope("prototype")
public class ShowHRUploadAction {
	
	public String execute(){
		
		
		return "show excel";
	}
}
