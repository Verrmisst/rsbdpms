package cn.net.inlink.entity;

import java.util.List;

/**
 * 功能实体类，和角色相对应，包含id，名称，url
 * @author Yz
 *
 */
public class Function {
	//id
	private Integer id;
	
	//名称
	private String funcName;
	
	//url
	private String url;
	
	//父级id
	private Integer parentId;
	
	//一对多关联关系：一个功能对应多个用户
	private List<Role> roleList;
	
	//一对过关联关系：一个功能对应多个子功能
	private List<ChildFunction> funList;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}
	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	public List<ChildFunction> getFunList() {
		return funList;
	}

	public void setFunList(List<ChildFunction> funList) {
		this.funList = funList;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(id).append("  ").append(funcName).append("  ").append(url).append("  ");
		
		return sb.toString();
	}
	
	
	
	
	
	
	
	
	
	
}
