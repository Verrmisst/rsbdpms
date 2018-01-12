package cn.net.inlink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.service.DormManaService;
import cn.net.inlink.vo.UploadStaff;

/**
 * 查询单个入住人员信息的控制器
 * @author Yz
 *
 */
@Controller
@Scope("prototype")
public class QueryStaffAction {
	
	//属性依赖
	@Autowired
	private DormManaService service;
	
	//入住人员信息
	private UploadStaff staff;
	
	//信息存储
	private String text;
	
	//员工编号
	private String staffCode;

	public DormManaService getService() {
		return service;
	}

	public void setService(DormManaService service) {
		this.service = service;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public UploadStaff getStaff() {
		return staff;
	}

	public void setStaff(UploadStaff staff) {
		this.staff = staff;
	}
	
	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public String execute(){
		 
		this.staff = service.queryStaffByCode(staffCode);
		
		if(this.staff==null){
			
			this.text = "该员工不存在，请尝试重新搜索";
			
			return "show error";
		}
		
		return "show success";
	 }
}
