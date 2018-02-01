package cn.net.inlink.controller;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.service.DormManaService;
import cn.net.inlink.service.StaffBorrowServiceImpl;
import cn.net.inlink.service.StaffManaService;
import cn.net.inlink.service.StaffManaServiceImpl;

/**
 * 处理员工退宿的控制器
 * 
 * @author Yz
 * 
 */

@Controller
@Scope("prototype")
public class StaffCheckOutAction {

	// 日志记录
	private Logger log = Logger.getLogger(StaffCheckOutAction.class);

	// 属性依赖
	@Autowired
	private DormManaService service;
	
	// 员工编号
	private String staffCode;

	// 房间号
	private String roomCode;

	// 楼名
	private String buildName;

	// 信息存储
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

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
	public String execute() throws Exception {

		 service.staffCheckOut(this.staffCode.trim());
		 
		 service.editEmpFlag(this.staffCode.trim());
		 
		// 字符转码
		 String build = new String(this.buildName.getBytes("iso-8859-1"),
		 "utf-8").trim();
		 
		// 该房间已住人数-1
		 service.editOccupycut(this.roomCode, build);

		this.text = "办理成功";

		return "checkout success";

	}
}
