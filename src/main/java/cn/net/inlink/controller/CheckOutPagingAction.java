package cn.net.inlink.controller;

import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.RowBounds;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.net.inlink.poi.DownloadCheckout;
import cn.net.inlink.service.DormManaService;
import cn.net.inlink.vo.UploadStaff;

/**
 * 显示已退宿人员的控制器
 * 
 * @author Yz
 * 
 */
@Controller
@Scope("prototype")
public class CheckOutPagingAction {

	// 属性依赖
	@Autowired
	private DormManaService service;

	// 信息存储
	private String text;

	// 已退宿人员记录集合
	private List<UploadStaff> staffs;

	// 页码，初始化为0
	private int pageNum = 0;

	// 总记录数
	private long recordCount;

	// 总页数
	private long pageCount;

	public DormManaService getService() {
		return service;
	}

	public void setService(DormManaService service) {
		this.service = service;
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

	public String execute() {

		// 获取文件输入流
		InputStream fis = QueryCheckOutAction.class.getClassLoader()
				.getResourceAsStream("cn/net/inlink/excel/checkout.xls");

		// 获取上下文对象
		ServletContext context = ServletActionContext.getServletContext();

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
		this.recordCount = service.queryCheckoutCounts();

		this.pageCount = (this.recordCount + limit - 1) / limit;

		RowBounds rb = new RowBounds(offest, limit);

		this.staffs = service.queryAllCheckouts(rb);

		if (this.staffs.size() == 0) {

			this.text = "暂无退宿人员信息，请稍候查询";

			return "error";
		}
		
		//获取不分页人员信息
		List<UploadStaff> noPages = service.queryAllCheckoutsNoPaging();

		// 生成所有退宿人员信息的excel文件
		DownloadCheckout.exportCheckoutInfo(fis, noPages, context);

		return "success";
	}
}
