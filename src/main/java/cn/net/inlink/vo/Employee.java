package cn.net.inlink.vo;

import java.util.List;


/***
 * 住宿员工的实体类，包含员工ID，员工编号，员工姓名，科室，职务
 * 
 * @author Yz
 * 
 */
public class Employee {
	// id
	private Integer id;

	// 编号
	private String empCode;

	// 姓名
	private String empName;

	// 科室
	private Dictionary dept;

	// 职务
	private Dictionary duty;
	
	//性别
	private Dictionary gender;
	
	//拥有的物品
	//一对多关联关系
	private List<Goods> goods;
	
	//备注
	private String content;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	

	public Dictionary getDept() {
		return dept;
	}

	public void setDept(Dictionary dept) {
		this.dept = dept;
	}

	public Dictionary getDuty() {
		return duty;
	}

	public void setDuty(Dictionary duty) {
		this.duty = duty;
	}
	
	public Dictionary getGender() {
		return gender;
	}

	public void setGender(Dictionary gender) {
		this.gender = gender;
	}
	
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append(id).append("  ").append(empCode).append("  ").append(empName)
				.append("  ");

		return sb.toString();
	}
}
