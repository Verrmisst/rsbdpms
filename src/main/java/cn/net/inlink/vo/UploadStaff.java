package cn.net.inlink.vo;

import java.util.Date;

/**
 * 记录上传员工信息
 * 
 * @author Yz
 * 
 */

public class UploadStaff {
	//id
	private Integer id;
	// 编号
	private String empCode;

	// 姓名
	private String empName;

	// 性别
	private String gender;

	// 宿舍楼
	private String buildingName;

	// 房间号
	private String roomCode;

	// 床号
	private String bedNum;

	// 衣柜号
	private String wardrobeNum;

	// 桌柜号
	private String deskNum;

	// 鞋柜号
	private String shopboxNum;

	// 入住时间
	private String livingDate;

	// 备注
	private String content;
	
	//职务
	private Dictionary duty;
	//科室
	private Dictionary dept;
	
	
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getBedNum() {
		return bedNum;
	}

	public void setBedNum(String bedNum) {
		this.bedNum = bedNum;
	}

	public String getWardrobeNum() {
		return wardrobeNum;
	}

	public void setWardrobeNum(String wardrobeNum) {
		this.wardrobeNum = wardrobeNum;
	}

	public String getDeskNum() {
		return deskNum;
	}

	public void setDeskNum(String deskNum) {
		this.deskNum = deskNum;
	}

	public String getShopboxNum() {
		return shopboxNum;
	}

	public void setShopboxNum(String shopboxNum) {
		this.shopboxNum = shopboxNum;
	}

	public String getLivingDate() {
		return livingDate;
	}

	public void setLivingDate(String livingDate) {
		this.livingDate = livingDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Dictionary getDuty() {
		return duty;
	}

	public void setDuty(Dictionary duty) {
		this.duty = duty;
	}

	public Dictionary getDept() {
		return dept;
	}

	public void setDept(Dictionary dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(this.empCode).append("  ").append(empName).append("  ")
				.append(gender).append("  ").append(buildingName).append("  ")
				.append(roomCode).append("  ").append(content);

		return sb.toString();
	}

}
