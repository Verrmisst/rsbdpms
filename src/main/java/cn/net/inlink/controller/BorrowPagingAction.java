package cn.net.inlink.controller;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.service.StaffBorrowService;
import cn.net.inlink.vo.StaffBorrow;

/**
 * 显示借用总信息的控制器 包含已归还和未归还的信息
 * 
 * @author Yz
 * 
 */
@Controller
@Scope("prototype")
public class BorrowPagingAction {

	// 属性依赖
	@Autowired
	private StaffBorrowService service;

	// 已归还借用记录集合
	private List<StaffBorrow> giveBacks;

	// 未归还借用记录集合
	private List<StaffBorrow> noGiveBacks;

	// 页码，初始化为0
	private String pageNum = "0";

	// 总记录数
	private long recordCount;

	// 总页数
	private String pageCount;

	// 页码，初始化为0
	private String pageNumg = "0";

	// 总记录数
	private long recordCountg;

	// 总页数
	private String pageCountg;

	// 信息存储
	private String text;
	
	private String text2;
	

	public StaffBorrowService getService() {
		return service;
	}

	public void setService(StaffBorrowService service) {
		this.service = service;
	}

	public List<StaffBorrow> getGiveBacks() {
		return giveBacks;
	}

	public void setGiveBacks(List<StaffBorrow> giveBacks) {
		this.giveBacks = giveBacks;
	}

	public List<StaffBorrow> getNoGiveBacks() {
		return noGiveBacks;
	}

	public void setNoGiveBacks(List<StaffBorrow> noGiveBacks) {
		this.noGiveBacks = noGiveBacks;
	}

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}

	public String getPageCount() {
		return pageCount;
	}

	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	public String getPageNumg() {
		return pageNumg;
	}

	public void setPageNumg(String pageNumg) {
		this.pageNumg = pageNumg;
	}

	public long getRecordCountg() {
		return recordCountg;
	}

	public void setRecordCountg(long recordCountg) {
		this.recordCountg = recordCountg;
	}

	public String getPageCountg() {
		return pageCountg;
	}

	public void setPageCountg(String pageCountg) {
		this.pageCountg = pageCountg;
	}
	
	public String getText2() {
		return text2;
	}

	public void setText2(String text2) {
		this.text2 = text2;
	}

	// 未归还
	@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
	public String noGiveBack() {
		// 分页参数：跳过几行，
		/*
		 * offest的值和页码相关，每页记录数*页码
		 */
		int offest;

		// 分页参数：取几行，初始化为5
		int limit = 5;

		offest = limit * Integer.parseInt(this.pageNum);

		// pageCount:总页数 = (总记录数+每页记录数-1)/每页的记录数
		// recordCount:总记录数

		this.recordCount = service.queryNoGiveBackCount();

		this.pageCount = String.valueOf((this.recordCount + limit - 1) / limit);

		RowBounds rb = new RowBounds(offest, 5);

		this.noGiveBacks = service.queryStaffNoGiveBackBorrows(rb);

		// 判断是否有记录
		if (this.recordCount == 0) {

			this.text = "暂无借用信息";

			return "show error";
		}

		return "show success";
	}

	// 已归还
	@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
	public String giveBack() {
		// 分页参数：跳过几行，
		/*
		 * offest的值和页码相关，每页记录数*页码
		 */
		int offest;

		// 分页参数：取几行，初始化为5
		int limit = 5;

		offest = limit * Integer.parseInt(this.pageNumg);

		// pageCount:总页数 = (总记录数+每页记录数-1)/每页的记录数
		// recordCount:总记录数

		this.recordCountg = service.queryGiveBackCount();
		
		this.pageCountg = String.valueOf((this.recordCountg + limit - 1) / limit);
		
		RowBounds rb = new RowBounds(offest, limit);

		this.giveBacks = service.queryStaffGiveBackBorrows(rb);

		// 判断是否有记录
		if (this.recordCountg == 0) {

			this.text2 = "暂无归还信息";

			return "show error";
		}

		return "show success";
	}
}
