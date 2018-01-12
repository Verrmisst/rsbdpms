package cn.net.inlink.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import cn.net.inlink.vo.Employee;

/**
 * 页面业务组件接口
 * @author Yz
 *
 */

public interface PageService {
	
	//分页查询
	public List<Employee> pagingEmp(RowBounds rb);
	
	//查询总记录数
	public long queryCount();
	
	//根据员工编号查询员工
	public List<Employee> queryEmpByCode(String empCode);
}
