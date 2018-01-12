package cn.net.inlink.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import cn.net.inlink.poi.UploadDeptDutyInfo;
import cn.net.inlink.vo.UploadDeptDuty;
import cn.net.inlink.vo.UploadStaff;

/**
 * 上传的员工信息持久化到数据库
 * @author Yz
 *
 */
public interface UploadDao {
	
	//向人员表中插入记录
	public void insertStaffInfo(UploadStaff staffs);
	
	//更新科室和职务字段
	@Update("UPDATE SSH_STAFFINFO SET staff_flddept =(SELECT person_flddepart FROM ssh_person WHERE staff_fldpersoncode = person_fldcode),staff_fldduty = (SELECT person_fldduty FROM ssh_person WHERE staff_fldpersoncode = person_fldcode)")
	public void uploadStaffDeptDuty();
	
	//向职务科室信息表中插入记录
	@Insert("insert into ssh_newempinfo values(seq_newempinfo.nextval,#{empCode},#{empName},#{depart},#{duty})")
	public void insertDeptDutyInfo(UploadDeptDuty deptDuty);
	
}
