package cn.net.inlink.service;

import java.util.List;

import cn.net.inlink.entity.Function;
import cn.net.inlink.entity.Role;

/**
 * 角色业务组件接口
 * @author Yz
 *
 */
public interface RoleService {
	
	
	//根据角色查找页面需显示的内容
	public List<Function> pageContent(String roleName);
	
	//查询所有角色
	public List<Role> queryAllRoles ();
}
