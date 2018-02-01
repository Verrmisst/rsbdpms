package cn.net.inlink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.net.inlink.service.StaffBorrowService;

/**
 * 显示借用信息的控制器
 * 
 * @author Yz
 * 
 */
@Controller
@Scope("prototype")
public class ShowBorrowAction {

	// 属性依赖
	@Autowired
	private StaffBorrowService service;

	// 页码，初始化为0
	private int pageNum;

	// 总记录数
	private long recordCount;

	// 总页数
	private long pageCount;

	// 页码，初始化为0
	private int pageNumg;

	// 总记录数
	private long recordCountg;

	// 总页数
	private long pageCountg;

	// 类型
	private String type;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public StaffBorrowService getService() {
		return service;
	}

	public void setService(StaffBorrowService service) {
		this.service = service;
	}

	public int getPageNumg() {
		return pageNumg;
	}

	public void setPageNumg(int pageNumg) {
		this.pageNumg = pageNumg;
	}

	public long getRecordCountg() {
		return recordCountg;
	}

	public void setRecordCountg(long recordCountg) {
		this.recordCountg = recordCountg;
	}

	public long getPageCountg() {
		return pageCountg;
	}

	public void setPageCountg(long pageCountg) {
		this.pageCountg = pageCountg;
	}

	public String execute() {

		return "show success";
	}
}
