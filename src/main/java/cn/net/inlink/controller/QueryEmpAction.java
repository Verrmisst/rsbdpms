package cn.net.inlink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.service.DormManaService;
import cn.net.inlink.service.StaffManaService;
import cn.net.inlink.vo.Dictionary;
import cn.net.inlink.vo.UploadStaff;

/**
 * 精确查询员工的控制器
 * 
 * @author Yz
 * 
 */
@Controller
@Scope("prototype")
public class QueryEmpAction {

	// 属性依赖
	@Autowired
	private DormManaService service;
	
	@Autowired
	private StaffManaService staffService;

	// emp集合
	private UploadStaff employee;

	// 员工编号
	private String empCode;
	
	private String text;
	
	//职务
	private List<Dictionary> dutys;
	
	//科室
	private List<Dictionary> depts;

	public DormManaService getService() {
		return service;
	}

	public void setService(DormManaService service) {
		this.service = service;
	}


	public UploadStaff getEmployee() {
		return employee;
	}

	public void setEmployee(UploadStaff employee) {
		this.employee = employee;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	public StaffManaService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffManaService staffService) {
		this.staffService = staffService;
	}
	

	public List<Dictionary> getDutys() {
		return dutys;
	}

	public void setDutys(List<Dictionary> dutys) {
		this.dutys = dutys;
	}

	public List<Dictionary> getDepts() {
		return depts;
	}

	public void setDepts(List<Dictionary> depts) {
		this.depts = depts;
	}

	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public String execute() {

		this.employee =  service.queryStaffByCode(this.empCode.trim());
		
		this.depts = staffService.queryDict("科室");
		
		this.dutys = staffService.queryDict("勤务");
		
		if (employee.getDept()!=null&&employee.getDuty()!=null) {//查出来为空返回error
			
			this.text = "该员工已分配科室和职务，请重新查询";
			
			return "error";
		}

		return "success";
	}
}
