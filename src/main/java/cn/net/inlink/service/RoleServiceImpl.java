package cn.net.inlink.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.dao.RoleDao;
import cn.net.inlink.entity.Function;
import cn.net.inlink.entity.Role;

/**
 * 角色业务组件实现类
 * @author Yz
 *
 */
@Service(value="roleService")
@Transactional
public class RoleServiceImpl implements RoleService{
	
	//属性依赖
	@Autowired
	private RoleDao dao;

	public RoleDao getDao() {
		return dao;
	}

	public void setDao(RoleDao dao) {
		this.dao = dao;
	}
	
	//显示当前角色拥有的功能
	@Override
	public List<Function> pageContent(String roleName) {
		
		List<Function> funcList = new ArrayList<Function>();
		
		//获取到角色集合
		List<Role> roleList = dao.getFunctionByroleName(roleName);
		
		//遍历
		for (Role role : roleList) {
			
			for (Function func : role.getFunctionList()) {
				funcList.add(func);
			}
			
		}
		return funcList;
	}
	
	//查询所有角色
	@Override
	public List<Role> queryAllRoles() {
		
		return dao.getAllRoles();
	}
}
