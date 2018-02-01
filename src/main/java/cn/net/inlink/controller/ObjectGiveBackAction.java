package cn.net.inlink.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.service.StaffBorrowService;

/**
 * 处理借用物品归还的控制器
 * 
 * @author Yz
 * 
 */
@Controller
@Scope("prototype")
public class ObjectGiveBackAction {
	
	//日志
	private Logger log = Logger.getLogger(ObjectGiveBackAction.class);
	
	// 属性依赖
	@Autowired
	private StaffBorrowService service;

	// 参数
	private Date endDate;

	private String borrowId;

	// 信息存储
	private String text;

	public StaffBorrowService getService() {
		return service;
	}

	public void setService(StaffBorrowService service) {
		this.service = service;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getBorrowId() {
		return borrowId;
	}

	public void setBorrowId(String borrowId) {
		this.borrowId = borrowId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
	public String execute() {
		
		try {
			//归还
			service.editBorrowFlag(this.endDate == null ? new SimpleDateFormat(
					"yyyy/MM/dd").format(new Date()) : new SimpleDateFormat(
					"yyyy/MM/dd").format(this.endDate), Integer
					.parseInt(borrowId));

		} catch (Exception e) {
			
			log.error(e.toString());
			
			this.text = "归还失败，请稍后重试";
			
			return "giveback error";
			
		}
			this.text = "归还成功！";
			
		return "giveback success";
	}
}
