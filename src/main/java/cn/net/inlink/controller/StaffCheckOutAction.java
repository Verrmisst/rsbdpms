package cn.net.inlink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.net.inlink.service.DormManaService;

/**
 * 处理员工退宿的控制器
 * @author Yz
 *
 */

@Controller
@Scope("prototype")
public class StaffCheckOutAction {
	
	//属性依赖
	@Autowired
	private DormManaService service;
	
	//员工编号
	private String staffCode;
	
	//信息存储
	private String text;

	public DormManaService getService() {
		return service;
	}

	public void setService(DormManaService service) {
		this.service = service;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String execute(){
		
		try {
			
			service.staffCheckOut(this.staffCode);
			
			//this.text = "办理成功";
			
			return "checkout success";
		} catch (Exception e) {
			
			this.text = "办理退宿失败，请会重新办理";
			return "checkout error";
		}
	}
}
