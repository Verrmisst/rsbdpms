package cn.net.inlink.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.net.inlink.service.BlurSearchService;
import cn.net.inlink.service.StaffManaService;
import cn.net.inlink.vo.Dictionary;
import cn.net.inlink.vo.UploadStaff;

/**
 * 多条件模糊查询的控制器
 * 
 * @author Yz
 * 
 */
@Controller
@Scope("prototype")
public class BlurSearchStaffAction {

	// 属性依赖
	@Autowired
	private BlurSearchService service;

	@Autowired
	private StaffManaService staffservice;

	// 参数
	private String staffCode;

	private String staffName;

	private String roomCode;

	private String buildName;

	private String department;

	private String duty;

	private String beginDate;

	private String endDate;

	// 信息存储
	private String text;

	// 页码，初始化为0
	private String pageNum = "0";
	
	private String pageNumg = "0";

	// 总记录数
	private long recordCount;
	
	private long recordCountg;

	// 总页数
	private String pageCount;
	
	private String pageCountg;

	// 查询结果集合
	private List<UploadStaff> staffs;
	
	private List<UploadStaff> uploadStaffs;
	
	// 职务
	private List<Dictionary> depts;

	// 科室
	private List<Dictionary> dutys;

	public BlurSearchService getService() {
		return service;
	}

	public void setService(BlurSearchService service) {
		this.service = service;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public List<UploadStaff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<UploadStaff> staffs) {
		this.staffs = staffs;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public StaffManaService getStaffservice() {
		return staffservice;
	}

	public void setStaffservice(StaffManaService staffservice) {
		this.staffservice = staffservice;
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

	public void setDutys(List<Dictionary> dutys) {
		this.dutys = dutys;
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

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
	public List<UploadStaff> getUploadStaffs() {
		return uploadStaffs;
	}

	public void setUploadStaffs(List<UploadStaff> uploadStaffs) {
		this.uploadStaffs = uploadStaffs;
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

	public String search() throws UnsupportedEncodingException {

		// 获取sessionMap对象
		Map paramMap = ServletActionContext.getContext().getSession();

		// 分页参数：跳过几行，
		/*
		 * offest的值和页码相关，每页记录数*页码
		 */
		int offest;

		// 分页参数：取几行，初始化为15
		int limit = 13;

		offest = limit * Integer.parseInt(this.pageNum);

		RowBounds rb = new RowBounds(offest, limit);

		this.depts = staffservice.queryDict("科室");
		this.dutys = staffservice.queryDict("勤务");

		// 创建字典职务和科室对象
		Dictionary dict_dept = new Dictionary();
		Dictionary dict_duty = new Dictionary();

		// 创建员工对象
		UploadStaff staff = new UploadStaff();

		dict_dept.setDictName(department.trim());
		dict_duty.setDictName(duty.trim());

		staff.setDept(dict_dept);
		staff.setDuty(dict_duty);
		staff.setEmpCode(staffCode.trim());
		staff.setEmpName(staffName.trim());
		staff.setBuildingName(buildName.trim());
		staff.setRoomCode(roomCode.trim());
		staff.setBeginDate(beginDate.trim());
		staff.setEndDate(endDate.trim());

		this.staffs = service.queryByBlur(staff, rb);

		this.recordCount = service.queryCountByBlur(staff).size();

		this.pageCount = String.valueOf((this.recordCount + limit - 1) / limit);

		if (this.staffs.size() == 0) {// 查询无结果

			this.text = "暂无结果，请重新输入您的查询条件";

			return "error";
		}

		// 将参数放到sessionMap中
		paramMap.put("staff", staff);

		return "success";
	}

	public String pageDorm() {

		// 获取sessionMap对象
		Map paramMap = ServletActionContext.getContext().getSession();
		
		// 分页参数：跳过几行，
		/*
		 * offest的值和页码相关，每页记录数*页码
		 */
		int offest;

		// 分页参数：取几行，初始化为15
		int limit = 13;

		offest = limit * Integer.parseInt(this.pageNumg);

		RowBounds rb = new RowBounds(offest, limit);

		this.uploadStaffs = service.queryByBlur((UploadStaff)paramMap.get("staff"), rb);

		this.recordCountg = service.queryCountByBlur((UploadStaff)paramMap.get("staff")).size();

		this.pageCountg = String.valueOf((this.recordCountg + limit - 1) / limit);
		
		if (this.uploadStaffs.size() == 0) {// 查询无结果

			this.text = "暂无结果，请重新输入您的查询条件";

			return "error";
		}

		return "success";
	}
}
