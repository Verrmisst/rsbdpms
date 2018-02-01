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
 * 处理借用信息精确查询的控制器
 * 
 * @author Yz
 * 
 */

@Controller
@Scope("prototype")
public class SearchBorrowInfoAction {

	// 属性依赖
	@Autowired
	private StaffBorrowService service;

	// 参数
	private String staffCode;

	// 借用信息集合
	private List<StaffBorrow> borrows;

	// 信息存储
	private String text;


	public StaffBorrowService getService() {
		return service;
	}

	public void setService(StaffBorrowService service) {
		this.service = service;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public List<StaffBorrow> getBorrows() {
		return borrows;
	}

	public void setBorrows(List<StaffBorrow> borrows) {
		this.borrows = borrows;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	@Transactional(rollbackFor = Exception.class)
	public String execute() {

		this.borrows = this.service.queryBorrowByCode(this.staffCode.trim());
		
		if (borrows.size() == 0) {

			this.text = "暂无该员工的借用信息";

			return "error";
		}

		return "success";
	}
}
