package cn.net.inlink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.dao.UploadDao;
import cn.net.inlink.vo.UploadDeptDuty;
import cn.net.inlink.vo.UploadStaff;

@Service(value="uploadStaffService")
@Transactional(rollbackFor=Exception.class)
public class UploadStaffServiceImpl implements UploadStaffService {
	
	//属性依赖
	@Autowired
	private UploadDao dao;
	
	public UploadDao getDao() {
		return dao;
	}


	public void setDao(UploadDao dao) {
		this.dao = dao;
	}


	//插入记录，获取自上传信息
	@Override
	public void saveStaffInfo(UploadStaff staffs) {
		dao.insertStaffInfo(staffs);
	}
	
	//更新科室和职务
	@Override
	public void editDutyDept() {
		dao.uploadStaffDeptDuty();
	}
	
	//增加科室和职务信息
	@Override
	public void saveDeptDuty(UploadDeptDuty deptDuty) {
		dao.insertDeptDutyInfo(deptDuty);
	}
	
	//查询员工是否存在
	@Override
	public long queryStaff(String staffCode) {
		
		return dao.getStaffCount(staffCode);
	}
	
	//查询退宿员工是否存在
	@Override
	public long queryCOStaff(String staffCode) {
		return dao.getCOStaffCount(staffCode);
	}
	
	//删除退宿员工
	@Override
	public void deleCOStaff(String staffCode) {
		dao.deleCOStaff(staffCode);
	}
}
