package cn.net.inlink.controller;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.service.DormManaService;
import cn.net.inlink.vo.UploadStaff;

/**
 * 显示入住宿舍信息的
 * 
 * @author Yz
 * 
 */
@Service(value = "dormManaService")
@Transactional(rollbackFor = Exception.class)
public class DormPagingAction {

	// 属性依赖
	@Autowired
	private DormManaService service;

	// 页码，初始化为0
	private int pageNum = 0;

	// 总记录数
	private long recordCount;

	// 总页数
	private long pageCount;

	// 信息文本
	private String text;

	// 人员入住信息集合
	private List<UploadStaff> staffs;

	public DormManaService getService() {
		return service;
	}

	public void setService(DormManaService service) {
		this.service = service;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<UploadStaff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<UploadStaff> staffs) {
		this.staffs = staffs;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public String execute() {
		// 分页参数：跳过几行，
		/*
		 * offest的值和页码相关，每页记录数*页码
		 */
		int offest;

		// 分页参数：取几行，初始化为10
		int limit = 15;

		offest = limit * this.pageNum;

		// pageCount:总页数 = (总记录数+每页记录数-1)/每页的记录数
		// recordCount:总记录数

		this.recordCount = service.queryCount();

		this.pageCount = (this.recordCount + limit - 1) / limit;

		RowBounds rb = new RowBounds(offest, limit);

		this.staffs = service.queryAllStaffs(rb);

		if (recordCount == 0) {

			this.text = "暂无信息";

			return "show error";
		}
		
		return "show dorm";
	}
}
