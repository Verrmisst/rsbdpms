package cn.net.inlink.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.dao.UserDao;
import cn.net.inlink.entity.Role;
import cn.net.inlink.entity.User;

/**
 * 用户业务组件实现类
 * 
 * @author Yz
 * 
 */
@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

	// 设置属性依赖
	@Autowired
	private UserDao dao;

	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	// 登录方法
	@Override
	public User login(String userName) {

		return dao.getUserByuserName(userName);
	}
	
	//得到 角色
	@Override
	public List<Role> getRoles(String userName) {
		List<Role> roleList = new ArrayList<Role>();
		
		//用户集合
		List<User> userList = dao.getRoleByuserName(userName);
		
		//遍历
		for (User user : userList) {
			
			for (Role role : user.getRoleList()) {
				roleList.add(role);
			}
		}
		
		return roleList;
	}
	
	//修改用户密码
	@Override
	public void editPassword(Integer id, String newPassword) {
		
		dao.editUserPassword(newPassword,id);
		
	}
}
