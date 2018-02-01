package cn.net.inlink.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.service.DormManaService;
import cn.net.inlink.service.StaffManaService;
import cn.net.inlink.vo.Dictionary;
import cn.net.inlink.vo.UploadStaff;

//显示宿舍调配表单的控制器
@Controller
@Scope("prototype")
public class ShowExchangeAction {

	// 日志记录
	private Logger log = Logger.getLogger(ShowExchangeAction.class);

	// 属性依赖
	@Autowired
	private DormManaService service;

	// 参数
	private String staffCode;

	// 入住员工对象
	private UploadStaff staff;

	// 属性依赖
	@Autowired
	private StaffManaService sservice;

	// 科室集合
	List<Dictionary> depts;

	// 勤务集合
	List<Dictionary> dutys;

	public StaffManaService getSservice() {
		return sservice;
	}

	public void setService(StaffManaService sservice) {
		this.sservice = sservice;
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

	@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
	public String execute() {

		this.depts = this.sservice.queryDict("科室");

		this.dutys = this.sservice.queryDict("勤务");

		try {

			// 获取入住人员信息
			this.staff = service.queryStaffByCode(staffCode);

		} catch (Exception e) {
			log.error(e.toString());
		}
		return "show exchange";
	}
}
