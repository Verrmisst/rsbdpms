package cn.net.inlink.controller;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.net.inlink.service.StaffNotificationService;
import cn.net.inlink.vo.StaffNotification;

/**
 * 显示通报信息的控制器
 * @author Yz
 *
 */
@Controller
@Scope("prototype")
public class ShowNotificationAction {
	
	//属性依赖
	@Autowired
	private StaffNotificationService notificeService;
	
	//通报信息集合
	private List<StaffNotification> notifices;
	
	//信息存储
	private String text;
	
	// 页码，初始化为0
	private int pageNum = 0;

	// 总记录数
	private long recordCount;

	// 总页数
	private int pageCount;

	public StaffNotificationService getNotificeService() {
		return notificeService;
	}

	public void setNotificeService(StaffNotificationService notificeService) {
		this.notificeService = notificeService;
	}

	public List<StaffNotification> getNotifices() {
		return notifices;
	}

	public void setNotifices(List<StaffNotification> notifices) {
		this.notifices = notifices;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String execute(){
		
		return "success";
	}
}
