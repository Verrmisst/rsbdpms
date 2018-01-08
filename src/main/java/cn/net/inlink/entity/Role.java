package cn.net.inlink.entity;

import java.util.List;

/**
 * 角色实体类，提供角色信息，包括：角色的名称，角色的具体描述
 * 
 * @author Yz
 * 
 */
public class Role {
	// 主键id
	private Integer id;

	// 角色名称
	private String roleName;

	// 具体描述
	private String description;
	
	//角色排序
	private Integer Order;

	// 一对多关联关系：一个角色对应多个用户
	private List<User> userList;

	//一对多关联关系：一个角色对应多个功能
	private List<Function> functionList;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Integer getOrder() {
		return Order;
	}

	public void setOrder(Integer order) {
		Order = order;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public List<Function> getFunctionList() {
		return functionList;
	}

	public void setFunctionList(List<Function> functionList) {
		this.functionList = functionList;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(id).append("  ").append(roleName).append("  ")
				.append(description).append("  ").append(Order);

		return sb.toString();
	}
}
