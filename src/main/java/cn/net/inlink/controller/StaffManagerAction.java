package cn.net.inlink.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.service.StaffManaService;
import cn.net.inlink.service.UploadStaffService;

/**
 * 更新员工的职务和部门字段
 * 
 * @author Yz
 * 
 */
@Controller
@Scope("prototype")
public class StaffManagerAction {

	// 日志记录
	private Logger log = Logger.getLogger(StaffManagerAction.class);

	// 属性依赖
	@Autowired
	private StaffManaService service;

	@Autowired
	private UploadStaffService uploadService;

	// 科室
	private String dept;

	// 职务
	private String duty;

	// 信息存储
	private String text;

	private String empcodes;

	public StaffManaService getService() {
		return service;
	}

	public void setService(StaffManaService service) {
		this.service = service;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getEmpcodes() {
		return empcodes;
	}

	public void setEmpcodes(String empcodes) {
		this.empcodes = empcodes;
	}

	public UploadStaffService getUploadService() {
		return uploadService;
	}

	public void setUploadService(UploadStaffService uploadService) {
		this.uploadService = uploadService;
	}
	
	@Transactional(rollbackFor={RuntimeException.class, Exception.class})
	public String execute() {

		// 判断部门和职务的内容是否为空，为空返回error
		if (dept == null || dept.equals("") || duty == null || duty.equals("")) {

			this.text = "部门和职务不能为空，请重新输入。";

			return "update error";
		}

		try {
			// 由于是批量操作返获取到的部门和职务的值都相同，取数组第一个元素即可
			// 获取部门字典表id

			// 判断字典表中是否有所需的值
			if (service.queryIdByDictName(this.dept) == null
					|| service.queryIdByDictName(this.duty) == null) {

				this.text = "请检查勤务或者部门是否有误！";

				return "update error";
			}

			Integer deptId = service.queryIdByDictName(this.dept).getId();

			// 获取职务字典表id
			Integer dutyId = service.queryIdByDictName(this.duty).getId();

			log.info("开始更新员工表部门和职务字段");

			// 更新员工表字段信息

			this.service.editEmpDutyDept(deptId, dutyId, empcodes);

			// 更新完之后更新上传记录表
			log.info("更新上传记录表");

			this.uploadService.editDutyDept();

		} catch (Exception e) {

			this.text = "更新失败，请重新录入！";

			log.error("更新失败，请重新录入！");

			return "update error";
		}

		return "update success";
	}
}
