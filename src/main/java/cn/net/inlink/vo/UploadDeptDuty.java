package cn.net.inlink.vo;

/**
 * 人事上传的excel实体类
 * @author Yz
 *
 */
public class UploadDeptDuty {
	
	//序号id
	private Integer id;
	
	//员工编号
	private String empCode;
	
	//员工姓名
	private String empName;
	
	//科室
	private String depart;
	
	//职务
	private String duty;

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

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}
	
}
