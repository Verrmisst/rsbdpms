package cn.net.inlink.controller;

import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.RowBounds;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.poi.DownloadAllStaffs;
import cn.net.inlink.service.BlurSearchService;
import cn.net.inlink.service.DormManaService;
import cn.net.inlink.service.StaffManaService;
import cn.net.inlink.vo.Dictionary;
import cn.net.inlink.vo.RoomGoods;
import cn.net.inlink.vo.UploadStaff;

/**
 * 显示入住宿舍信息的
 * 
 * @author Yz
 * 
 */
@Service(value = "dormManaService")
@Scope("prototype")
public class DormPagingAction {

	// 属性依赖
	@Autowired
	private DormManaService service;

	@Autowired
	private StaffManaService staffService;

	@Autowired
	private BlurSearchService blurService;

	// 页码，初始化为0
	private int pageNum = 0;

	// 总记录数
	private long recordCount;

	// 总页数
	private long pageCount;

	// 信息文本
	private String text;

	// 职务
	private List<Dictionary> dutys;

	// 科室
	private List<Dictionary> depts;

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

	public List<Dictionary> getDutys() {
		return dutys;
	}

	public void setDutys(List<Dictionary> dutys) {
		this.dutys = dutys;
	}

	public List<Dictionary> getDepts() {
		return depts;
	}

	public void setDepts(List<Dictionary> depts) {
		this.depts = depts;
	}

	public StaffManaService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffManaService staffService) {
		this.staffService = staffService;
	}

	public BlurSearchService getBlurService() {
		return blurService;
	}

	public void setBlurService(BlurSearchService blurService) {
		this.blurService = blurService;
	}

	@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
	public String execute() {

		// 获取科室和职务集合
		this.depts = this.staffService.queryDict("科室");

		this.dutys = this.staffService.queryDict("勤务");

		// 分页参数：跳过几行，
		/*
		 * offest的值和页码相关，每页记录数*页码
		 */
		int offest;

		// 分页参数：取几行，初始化为10
		int limit = 13;

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

		// 获取文件输入流
		InputStream fis = QueryCheckOutAction.class.getClassLoader()
				.getResourceAsStream("cn/net/inlink/excel/allstaffs.xls");

		// 获取上下文对象
		ServletContext context = ServletActionContext.getServletContext();
		
		List<UploadStaff> goods_staffs = service.queryAllStaffs(new RowBounds());
		
		// 生成excel文件
		try {
			DownloadAllStaffs.exportAllStaffInfo(fis, goods_staffs, context);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "show dorm";
	}
}
