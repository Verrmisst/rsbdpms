package cn.net.inlink.dao;

import java.util.List;

import org.apache.ibatis.annotations.Update;

import cn.net.inlink.entity.Function;
import cn.net.inlink.entity.Role;
import cn.net.inlink.entity.User;
/**
 * 获取用户数据的DAO
 * @author Yz
 *
 */
public interface UserDao {
	
	//根据用户名查询用户
	public User getUserByuserName(String userName);
	
	//根据用户名查询该用户的角色
	public List<User> getRoleByuserName(String userName);
	
	//根据用户id修改用户的密码
	@Update("update sys_user set user_fldpass = #{param1} where user_fldid = #{param2}")
	public void editUserPassword(String newPassword,Integer id);
}
