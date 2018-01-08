package cn.net.inlink.entity;

import java.util.List;

/**
 * 功能实体类，和角色相对应，包含id，名称，url
 * @author Yz
 *
 */
public class ChildFunction {
	//id
	private Integer childId;
	
	//名称
	private String childFuncName;
	
	//url
	private String childUrl;
	
	
	//一对多关联关系：一个功能对应多个用户
	private List<Role> roleList;
	
	
	public Integer getChildId() {
		return childId;
	}



	public void setChildId(Integer childId) {
		this.childId = childId;
	}



	public String getChildFuncName() {
		return childFuncName;
	}



	public void setChildFuncName(String childFuncName) {
		this.childFuncName = childFuncName;
	}



	public String getChildUrl() {
		return childUrl;
	}



	public void setChildUrl(String childUrl) {
		this.childUrl = childUrl;
	}






	public List<Role> getRoleList() {
		return roleList;
	}



	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}



	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(childId).append("  ").append(childFuncName).append("  ").append(childUrl);
		
		return sb.toString();
	}
	
	
	
	
	
	
	
	
	
	
}
