package cn.net.inlink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.net.inlink.service.StaffNotificationService;
import cn.net.inlink.vo.StaffNotification;

/**
 * 精确查询通报信息的控制器
 * @author Yz
 *
 */
@Controller
@Scope("prototype")
public class SearchNotificeInfoAction {
	
	//属性依赖
	@Autowired
	private StaffNotificationService service;
	
	//参数
	private String staffCode;
	
	//通报信息集合
	private List<StaffNotification> notifices;
	
	//信息存储
	private String text;

	public StaffNotificationService getService() {
		return service;
	}

	public void setService(StaffNotificationService service) {
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
	
	
	public List<StaffNotification> getNotifices() {
		return notifices;
	}

	public void setNotifices(List<StaffNotification> notifices) {
		this.notifices = notifices;
	}

	public String execute(){
		
		this.notifices = this.service.queryNotificationByCode(staffCode.trim());
		
		if(this.notifices.size() == 0){
			
			this.text = "暂无该员工通报信息。";
			
			return "error";
		}
		
		return "success";
	}
}
