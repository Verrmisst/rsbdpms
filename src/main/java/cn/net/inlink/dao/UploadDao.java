package cn.net.inlink.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	@Update("UPDATE SSH_STAFFINFO SET staff_flddept =(SELECT person_flddepart FROM ssh_person WHERE staff_fldpersoncode = person_fldcode and person_fldflag=0 and rownum =1),staff_fldduty = (SELECT person_fldduty FROM ssh_person WHERE staff_fldpersoncode = person_fldcode and person_fldflag=0 and rownum =1 )  ")
	public void uploadStaffDeptDuty();
	
	//向职务科室信息表中插入记录
	@Insert("insert into ssh_newempinfo values(seq_newempinfo.nextval,#{empCode},#{empName},#{depart},#{duty})")
	public void insertDeptDutyInfo(UploadDeptDuty deptDuty);
	
	//查询人员是否存在
	@Select("select count(*) from ssh_staffinfo where staff_fldpersoncode = #{param} and staff_fldflag=0")
	public long getStaffCount(String staffCode);
	
	//查询是否是退宿人员
	@Select("select count(*) from ssh_staffinfo where staff_fldpersoncode =#{param} and staff_fldflag=1")
	public long getCOStaffCount(String staffCode);
	
	//删除退宿人员
	@Delete("delete from ssh_staffinfo where staff_fldpersoncode = #{param} and staff_fldflag=1")
	public void deleCOStaff(String staffCode);
}
