package cn.net.inlink.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.service.DormManaService;
import cn.net.inlink.service.StaffBorrowService;
import cn.net.inlink.vo.StaffBorrow;
import cn.net.inlink.vo.UploadStaff;

/**
 * 处理员工借用记录的控制器
 * @author Yz
 *
 */

@Controller
@Scope("prototype")
public class AddBorrowRecordAction {
	
	//属性依赖
	@Autowired
	private StaffBorrowService borrowService;
	
	@Autowired
	private DormManaService dormService;
	
	//参数
	private String staffCode;
	
	private String staffName;
	
	private String objectName;
	
	private String beginDate;
	
	//信息存储
	private String text;

	public StaffBorrowService getBorrowService() {
		return borrowService;
	}

	public void setBorrowService(StaffBorrowService borrowService) {
		this.borrowService = borrowService;
	}

	public DormManaService getDormService() {
		return dormService;
	}

	public void setDormService(DormManaService dormService) {
		this.dormService = dormService;
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


	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Transactional(rollbackFor={RuntimeException.class, Exception.class})
	public String execute(){
		
		
		
		//判断该员工是否存在，不存在返回至错误页面
		if(dormService.queryStaffByCode(staffCode.trim())==null){
			
			this.text="编号是："+staffCode+"的员工不存在，请返回重新录入。";
			
			return "insert error";
		}
		
		
		//查询员工对象
		UploadStaff staff =  dormService.queryStaffByCode(staffCode.trim());
		
		//创建借用记录对象
		StaffBorrow borrow = new StaffBorrow();
		
		borrow.setStaff(staff);
		borrow.setObjectName(objectName.trim());
		borrow.setBeginDate(this.beginDate.equals("")?new SimpleDateFormat("yyyy/MM/dd").format(new Date()):beginDate);
		borrow.setEndDate("");
		borrow.setContent("未归还");
		borrow.setFlag(0);
		
		this.borrowService.saveBorrow(borrow);
		
		this.text="添加成功";
		
		return "insert success";
	}
}
