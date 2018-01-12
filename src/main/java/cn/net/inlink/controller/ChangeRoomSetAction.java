package cn.net.inlink.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.service.DormManaService;
import cn.net.inlink.service.StaffManaService;

/**
 * 修改房间配置的信息
 * 
 * @author Yz
 * 
 */
@Controller
@Scope("prototype")
public class ChangeRoomSetAction {

	// 日志
	private Logger log = Logger.getLogger(ChangeRoomSetAction.class);

	// 属性依赖
	@Autowired
	private DormManaService dormService;

	@Autowired
	private StaffManaService staffService;

	// 参数
	private String content1;

	private String content2;

	private String classify;

	private String roomCode;
	
	private String buildId;

	// 信息存储
	private String text;

	public DormManaService getDormService() {
		return dormService;
	}

	public void setDormService(DormManaService dormService) {
		this.dormService = dormService;
	}

	public StaffManaService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffManaService staffService) {
		this.staffService = staffService;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String getBuildId() {
		return buildId;
	}

	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public String execute() {
		
		// 更新配置表
		try {
			log.info("更新宿舍配置表");
			this.dormService
					.editRoomSet(content1, content2, classify, roomCode);

			log.info("更新宿舍表");
			this.staffService
					.editRoom(content1, content2, classify, roomCode,Integer.parseInt(buildId));

		} catch (Exception e) {
			log.error(e.toString());
			
			this.text = "更新失败，请稍后重试";
			return "update error";
		}

		log.info("更新宿舍配置表完成");
		log.info("更新宿舍表完成");

		return "update success";
	}
}
