package cn.net.inlink.service;

import cn.net.inlink.vo.UploadDeptDuty;
import cn.net.inlink.vo.UploadStaff;

/**
 * 处理上传员工信息的业务组件接口
 * @author Yz
 *
 */
public interface UploadStaffService {
	
	//增加记录
	public void saveStaffInfo(UploadStaff staffs);
	
	//更新科室和职务
	public void editDutyDept();
	
	//增加科室职务信息
	public void saveDeptDuty(UploadDeptDuty deptDuty);
	
	//查询员工是否存在
	public long queryStaff(String staffCode);
	
	//查询退宿员工是否存在
	public long queryCOStaff(String staffCode);
	
	//删除退宿员工
	public void deleCOStaff(String staffCode);
}
