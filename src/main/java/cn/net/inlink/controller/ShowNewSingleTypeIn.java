package cn.net.inlink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.net.inlink.service.StaffManaService;
import cn.net.inlink.vo.Dictionary;

/**
 * 显示新员工入住表单
 * 
 * @author Yz
 * 
 */
@Controller
@Scope("prototype")
public class ShowNewSingleTypeIn {

	// 属性依赖
	@Autowired
	private StaffManaService service;

	// 科室集合
	List<Dictionary> depts;

	// 勤务集合
	List<Dictionary> dutys;

	public StaffManaService getService() {
		return service;
	}

	public void setService(StaffManaService service) {
		this.service = service;
	}

	public List<Dictionary> getDepts() {
		return depts;
	}

	public void setDepts(List<Dictionary> depts) {
		this.depts = depts;
	}

	public List<Dictionary> getDutys() {
		return dutys;
	}

	public void setDutys(List<Dictionary> dutys) {
		this.dutys = dutys;
	}

	public String execute() {

		this.depts = this.service.queryDict("科室");

		this.dutys = this.service.queryDict("勤务");

		return "success";
	}
}
