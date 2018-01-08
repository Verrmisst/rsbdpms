package cn.net.inlink.dao;

import java.util.List;

import cn.net.inlink.entity.Role;
/**
 * 获取角色数据的DAO
 * @author Yz
 *
 */
public interface RoleDao {
	
	//根据角色名查询角色具有的功能
	public List<Role> getFunctionByroleName(String roleName);
	
	//查询所有的角色记录
	public List<Role> getAllRoles();
}
