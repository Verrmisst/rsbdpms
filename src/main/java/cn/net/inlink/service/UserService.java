package cn.net.inlink.service;

import java.util.List;

import cn.net.inlink.entity.Role;
import cn.net.inlink.entity.User;


/**
 * 用户业务组件接口
 * @author Yz
 *
 */
public interface UserService {
	
	//登录业务方法
	public User login(String userName);
	
	//得到用户对应的角色业务方法
	public List<Role> getRoles(String userName);
	
	//修改用户密码的业务方法
	public void editPassword(Integer id,String newPassword);
	
}	
