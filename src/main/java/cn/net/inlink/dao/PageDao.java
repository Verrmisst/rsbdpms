package cn.net.inlink.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import cn.net.inlink.vo.Employee;

/**
 * 处理页面的DAO
 */
public interface PageDao {
	
	//分页查询
	public List<Employee> getAllEmp(RowBounds rb);
	
	//总记录
	@Select("select count(*) from ssh_person where person_flddepart is null or person_fldduty is null")
	public long getSum();
	
	//根据员工编号查询员工
	public List<Employee> getEmpByCode(String empCode);
	
	
}
