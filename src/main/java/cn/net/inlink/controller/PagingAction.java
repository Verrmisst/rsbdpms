package cn.net.inlink.controller;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.service.PageService;
import cn.net.inlink.service.StaffManaService;
import cn.net.inlink.vo.Employee;

/**
 * 处理分页的控制器
 * 
 * @author Yz
 * 
 */
@Controller
@Scope("prototype")
public class PagingAction {
	// 属性依赖
	@Autowired
	private PageService service;
	
	// 页码，初始化为0
	private int pageNum = 0;

	// 总记录数
	private long recordCount;

	// 总页数
	private long pageCount;
	
	//信息文本
	private String text;
	
	private List<Employee> emps;
	

	public PageService getService() {
		return service;
	}

	public void setService(PageService service) {
		this.service = service;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
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

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public String execute() {

		// 分页参数：跳过几行，
		/*
		 * offest的值和页码相关，每页记录数*页码
		 */
		int offest;

		// 分页参数：取几行，初始化为10
		int limit = 10;

		offest = limit*this.pageNum;

		// pageCount:总页数 = (总记录数+每页记录数-1)/每页的记录数
		// recordCount:总记录数

		this.recordCount = service.queryCount();

		this.pageCount = (this.recordCount + limit - 1) / limit;

		RowBounds rb = new RowBounds(offest, limit);

		this.emps = service.pagingEmp(rb);
		
		if(recordCount==0){
			
			this.text = "暂无未分配科室和勤务员工信息";
			
			return "show error";
		}
		
		return "show paging";
	}
}
