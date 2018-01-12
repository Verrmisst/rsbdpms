package cn.net.inlink.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * 控制显示总务批量上传页面的控制器
 * @author Yz
 *
 */
@Controller
@Scope("prototype")
public class ShowExcelUploadAction {
	
	public String execute(){
		
		
		return "show excel";
	}
}
