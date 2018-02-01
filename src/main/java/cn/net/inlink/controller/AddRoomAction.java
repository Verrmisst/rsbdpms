package cn.net.inlink.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.service.DormManaService;
import cn.net.inlink.vo.UploadRoom;

/**
 * 增加宿舍配置信息的控制器
 * 
 * @author Yz
 * 
 */

@Controller
@Scope
public class AddRoomAction {

	// 日志
	private Logger log = Logger.getLogger(AddRoomAction.class);

	// 属性依赖
	@Autowired
	private DormManaService service;

	// 参数
	private String roomCode;

	private String size;

	private String occupy;

	private String classify;

	private String content1;

	private String content2;

	private String buildName;

	private String content3;

	// 信息存储
	private String text;
	
	private String type;

	public DormManaService getService() {
		return service;
	}

	public void setService(DormManaService service) {
		this.service = service;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getOccupy() {
		return occupy;
	}

	public void setOccupy(String occupy) {
		this.occupy = occupy;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
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

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public String getContent3() {
		return content3;
	}

	public void setContent3(String content3) {
		this.content3 = content3;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public String execute() {

		// 获取宿舍名
		String build = Integer.parseInt(buildName) == 1 ? "闻博轩" : "静雅苑";

		// 判断录入宿舍是否存在
		UploadRoom uproom = service.queryRoomByCode(roomCode, build);

		if (uproom != null) {

			this.text = build + "的" + this.roomCode + "已存在，请勿重新录入。";

			return "save error";
		}

		// 对控制赋值
		if (occupy == null) {

			occupy = "0";
		}

		if (content2 == null) {

			content2 = "";
		}

		if (content3 == null) {

			content3 = "";
		}

		try {
			// 日志记录
			log.info("增加宿舍信息");

			// 创建宿舍配置信息对象
			UploadRoom room = new UploadRoom();
			room.setSize(Integer.parseInt(size));
			room.setOccupy(Integer.parseInt(occupy));
			room.setBuildName(build);
			room.setContent1(content1);
			room.setContent2(content2);
			room.setContent3(content3);
			room.setClassify(classify);
			room.setRoomCode(roomCode);

			log.info(room.toString());
			this.service.saveRoomset(room);
			
			
			log.info("增加宿舍信息结束");

		} catch (Exception e) {

			log.error(e.toString());

			this.text = "录入失败，请稍后重试。";

			return "save error";
		}
		
		this.text = "录入成功，请返回。";
		
		return "save success";
	}
}
