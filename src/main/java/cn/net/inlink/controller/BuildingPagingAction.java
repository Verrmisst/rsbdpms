package cn.net.inlink.controller;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.service.DormManaService;
import cn.net.inlink.service.StaffManaService;
import cn.net.inlink.vo.UploadRoom;

/**
 * 显示宿舍楼宿舍信息的控制器
 * 
 * @author Yz
 * 
 */
@Controller
@Scope("prototype")
public class BuildingPagingAction {

	// 属性依赖
	@Autowired
	private DormManaService dormService;

	// 参数：宿舍楼id
	private String buildId;

	// 信息存储
	private String text;

	// 宿舍信息集合
	private List<UploadRoom> rooms;

	// 页码，初始化为0
	private int pageNum = 0;

	// 总记录数
	private long recordCount;

	// 总页数
	private long pageCount;

	public DormManaService getDormService() {
		return dormService;
	}

	public void setDormService(DormManaService dormService) {
		this.dormService = dormService;
	}

	public String getBuildId() {
		return buildId;
	}

	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<UploadRoom> getRooms() {
		return rooms;
	}

	public void setRooms(List<UploadRoom> rooms) {
		this.rooms = rooms;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}

	public long getPageCount() {
		return pageCount;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public String execute() {

		// 获取宿舍楼名
		String buildName = null;

		if (this.buildId.equals("1")) {
			buildName = new String("闻博轩");
		} else if (this.buildId.equals("2")) {
			buildName = new String("静雅苑");
		}

		// 分页参数：跳过几行，
		/*
		 * offest的值和页码相关，每页记录数*页码
		 */
		int offest;

		// 分页参数：取几行，初始化为10
		int limit = 10;

		offest = limit * this.pageNum;

		// pageCount:总页数 = (总记录数+每页记录数-1)/每页的记录数
		// recordCount:总记录数
		
		
		this.recordCount = dormService.queryRoomCount(buildName);
		
		this.pageCount = (this.recordCount + limit - 1) / limit;

		RowBounds rb = new RowBounds(offest, limit);

		this.rooms = dormService.queryRooms(buildName, rb);
		
		if (this.recordCount == 0) {

			this.text = "暂无宿舍配置信息";

			return "build error";
		}

		if (buildName.equals("闻博轩")) {

			return "build wenbo";
		} else {

			return "build jingya";
		}
	}
}
