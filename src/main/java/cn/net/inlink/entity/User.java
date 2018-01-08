package cn.net.inlink.entity;

import java.util.List;

/**
 * 用户实体类，提供账户，包含id，用户名，密码 。密码不采用MD5加密
 * 
 * @author Yz
 * 
 */
public class User {
	// 主键id
	private Integer id;

	// 用户名
	private String userName;

	// 密码
	private String password;
	
	//描述
	private String description;

	// 关联多对多关系：多个用户对应多个角色
	private List<Role> roleList;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(id).append("  ").append(userName).append("  ")
				.append(password).append("  ").append(description);

		return sb.toString();
	}
}
