package cn.net.inlink.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.service.DormManaService;
import cn.net.inlink.service.StaffNotificationService;
import cn.net.inlink.vo.StaffNotification;
import cn.net.inlink.vo.UploadStaff;

/**
 * 处理员工通报记录的控制器
 * 
 * @author Yz
 * 
 */
@Controller
@Scope("prototype")
public class AddNotificationRecordAction {
	// 属性依赖
	@Autowired
	private DormManaService dormService;

	@Autowired
	private StaffNotificationService staffService;

	// 参数
	private String staffCode;

	private String type;

	private String time;

	private String reason;

	private String money;

	// 信息存储
	private String text;

	public DormManaService getDormService() {
		return dormService;
	}

	public void setDormService(DormManaService dormService) {
		this.dormService = dormService;
	}

	public StaffNotificationService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffNotificationService staffService) {
		this.staffService = staffService;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Transactional(rollbackFor = Exception.class)
	public String execute() {

		// 判断员工是否入住
		if (dormService.queryStaffByCode(staffCode.trim()) == null) {

			this.text = "编号是：" + staffCode + "的员工不存在，请重新录入。";

			return "insert error";
		}
		
		//查询员工对象
		UploadStaff staff =  dormService.queryStaffByCode(staffCode.trim());
		
		//创建通报对象
		StaffNotification notifice = new StaffNotification();
		
		notifice.setStaff(staff);
		notifice.setNotificeMoney(money);
		notifice.setNotificeReason(reason);
		notifice.setNotificeTime(this.time==null?new SimpleDateFormat("yyyy/MM/dd").format(new Date()):this.time);
		notifice.setNotificeType(type);
		
		//注入值
		this.staffService.saveNotification(notifice);
		
		this.text= "添加成功。";
		
		return "insert success";
	}
}
