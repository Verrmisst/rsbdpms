package cn.net.inlink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.service.PageService;
import cn.net.inlink.vo.Employee;

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
	private PageService service;

	// emp集合
	private List<Employee> employees;

	// 员工编号
	private String empCode;
	
	private String text;
	
	public PageService getService() {
		return service;
	}

	public void setService(PageService service) {
		this.service = service;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
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
	
	@Transactional(rollbackFor = Exception.class)
	public String execute() {

		this.employees = service.queryEmpByCode(this.empCode);
		
		if (employees.size()==0) {//查出来为空返回error
			
			this.text = "该员工已分配科室和职务，请重新查询";
			
			return "error";
		}

		return "success";
	}
}
