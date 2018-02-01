package cn.net.inlink.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.net.inlink.service.StaffManaService;
import cn.net.inlink.vo.Dictionary;

/**
 * 显示人员入住页面
 * 
 * @author Yz
 * 
 */
public class ShowDormAction {

	// 属性依赖
	@Autowired
	private StaffManaService service;

	// 科室集合
	List<Dictionary> depts;

	// 勤务集合
	List<Dictionary> dutys;
	
	private int pageNum;
	
	private long pageCount;
	
	
	public StaffManaService getService() {
		return service;
	}

	public void setService(StaffManaService service) {
		this.service = service;
	}

	public List<Dictionary> getDepts() {
		return depts;
	}

	public void setDepts(List<Dictionary> depts) {
		this.depts = depts;
	}

	public List<Dictionary> getDutys() {
		return dutys;
	}
	
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public void setDutys(List<Dictionary> dutys) {
		this.dutys = dutys;
	}
	
	public long getPageCount() {
		return pageCount;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}

	public String execute(){
	
	this.depts = this.service.queryDict("科室");
	
	this.dutys = this.service.queryDict("勤务");
	
	return "success";
	}
}
