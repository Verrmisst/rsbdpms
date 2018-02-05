package cn.net.inlink.controller;

import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.ibatis.session.RowBounds;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.poi.DownloadBorrow;
import cn.net.inlink.poi.DownloadNotifice;
import cn.net.inlink.service.StaffBorrowService;
import cn.net.inlink.service.StaffNotificationService;
import cn.net.inlink.vo.StaffBorrow;
import cn.net.inlink.vo.StaffNotification;

/**
 * 显示通报信息（分页）
 * 
 * @author Yz
 * 
 */
@Controller
@Scope("prototype")
public class NotificationPagingAction {

	// 属性依赖
	@Autowired
	private StaffNotificationService service;

	// 页码，初始化为0
	private String pageNum = "0";

	// 总记录数
	private long recordCount;

	// 总页数
	private String pageCount;

	// 信息存储
	private String text;

	// 记录集
	private List<StaffNotification> notifices;

	public StaffNotificationService getService() {
		return service;
	}

	public void setService(StaffNotificationService service) {
		this.service = service;
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

	public List<StaffNotification> getNotifices() {
		return notifices;
	}

	public void setNotifices(List<StaffNotification> notifices) {
		this.notifices = notifices;
	}

	@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
	public String execute() {
		// 分页参数：跳过几行，
		/*
		 * offest的值和页码相关，每页记录数*页码
		 */
		int offest;

		// 分页参数：取几行，初始化为15
		int limit = 15;

		offest = limit * Integer.parseInt(this.pageNum);

		// pageCount:总页数 = (总记录数+每页记录数-1)/每页的记录数
		// recordCount:总记录数

		this.recordCount = service.queryAllCounts();

		this.pageCount = String.valueOf((this.recordCount + limit - 1) / limit);

		RowBounds rb = new RowBounds(offest, limit);

		this.notifices = service.queryAllNotifications(rb);

		// 判断是否有记录
		if (this.recordCount == 0) {

			this.text = "暂无借用信息";

			return "show error";
		}

		// 获取文件输入流
		InputStream fis = QueryCheckOutAction.class.getClassLoader()
				.getResourceAsStream("cn/net/inlink/excel/staffnotifice.xls");

		// 获取上下文对象
		ServletContext context = ServletActionContext.getServletContext();

		List<StaffNotification> notifices = service
				.queryAllNotifications(new RowBounds());

		// 生成excel文件
		try {
			DownloadNotifice.exportStaffNotificeInfo(fis, notifices, context);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "show success";
	}

}
