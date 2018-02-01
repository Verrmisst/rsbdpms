package cn.net.inlink.vo;


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
	
	//退宿时间
	private String checkOutDate;
	
	//调宿时间
	private String exchangeDate;
	
	private String beginDate;
	
	private String endDate;
	
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
	

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
	public String getExchangeDate() {
		return exchangeDate;
	}

	public void setExchangeDate(String exchangeDate) {
		this.exchangeDate = exchangeDate;
	}
	
	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "UploadStaff [id=" + id + ", empCode=" + empCode + ", empName="
				+ empName + ", gender=" + gender + ", buildingName="
				+ buildingName + ", roomCode=" + roomCode + ", bedNum="
				+ bedNum + ", wardrobeNum=" + wardrobeNum + ", deskNum="
				+ deskNum + ", shopboxNum=" + shopboxNum + ", livingDate="
				+ livingDate + ", checkOutDate=" + checkOutDate
				+ ", exchangeDate=" + exchangeDate + ", content=" + content
				+ ", duty=" + duty + ", dept=" + dept + "]";
	}
	



	
}
