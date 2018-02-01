package cn.net.inlink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.service.DormManaService;
import cn.net.inlink.vo.RoomGoods;
import cn.net.inlink.vo.UploadRoom;

/**
 * 条件查询显示宿舍配置信息
 * 
 * @author Yz
 * 
 */
@Controller
@Scope("prototype")
public class QueryRoomSetAction {

	// 属性依赖
	@Autowired
	private DormManaService service;

	// 配置信息对象
	private UploadRoom room;
	
	//房间内物品信息
	private List<RoomGoods> rm;

	// 信息存储
	private String text;

	// 房间号
	private String roomCode;

	// 宿舍楼id
	private String buildId;
	
	//剩余空床信息
	private String surplusGoods;

	public DormManaService getService() {
		return service;
	}

	public void setService(DormManaService service) {
		this.service = service;
	}

	public UploadRoom getRoom() {
		return room;
	}

	public void setRoom(UploadRoom room) {
		this.room = room;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getBuildId() {
		return buildId;
	}

	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}
	
	
	public String getSurplusGoods() {
		return surplusGoods;
	}

	public void setSurplusGoods(String surplusGoods) {
		this.surplusGoods = surplusGoods;
	}
	
	
	public List<RoomGoods> getRm() {
		return rm;
	}

	public void setRm(List<RoomGoods> rm) {
		this.rm = rm;
	}

	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public String execute() {
		
		StringBuilder sb = new StringBuilder();
		
		// 获取宿舍楼名称
		// 获取宿舍楼名
		String buildName = null;

		if (this.buildId.equals("1")) {
			buildName = new String("闻博轩");
		} else if (this.buildId.equals("2")) {
			buildName = new String("静雅苑");
		}
		
		this.room = service.queryRoomByCode(roomCode.trim(),buildName);
		
		this.rm = service.querySurplusGoods(buildName, roomCode);
		
		//遍历物品集合
		for (int i = 0; i < rm.size(); i++) {
			
			if(i==rm.size()-1){
				
				sb.append(rm.get(i).getBedNum());
				
			}else{
			sb.append(rm.get(i).getBedNum()+", ");
			}
		}
		
		this.surplusGoods = sb.toString();
		
		if (this.room == null) {

			this.text = "暂无该宿舍配置信息，请稍后查询";

			return "show error";
		}
		
		if (buildName.equals("闻博轩")) {
			
			return "show roomset_wenbo";
		} else {

			return "show roomset_jingya";
		}

	}
}
