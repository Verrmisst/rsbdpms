package cn.net.inlink.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.net.inlink.service.DormManaService;
import cn.net.inlink.vo.UploadStaff;

//显示宿舍调配表单的控制器
@Controller
@Scope("prototype")
public class ShowExchangeAction {
	
	//日志记录
	private Logger log = Logger.getLogger(ShowExchangeAction.class);
	
	//属性依赖
	@Autowired
	private DormManaService service;
	
	//参数
	private String staffCode;
	
	//入住员工对象
	private UploadStaff staff;
	
	public UploadStaff getStaff() {
		return staff;
	}



	public void setStaff(UploadStaff staff) {
		this.staff = staff;
	}



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



	public String execute(){
		
		try{
			
		//获取入住人员信息
		this.staff = service.queryStaffByCode(staffCode);
		
		}catch (Exception e) {
			log.error(e.toString());
		}
		return "show exchange";
	}
}
