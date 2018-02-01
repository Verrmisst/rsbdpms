package cn.net.inlink.vo;

/**
 * 房间床，柜，桌情况实体类
 * @author Yz
 *
 */


public class RoomGoods {
	
	//id
	private String id;
	
	//宿舍楼名
	private String buildName;
	
	//房间号
	private String roomCode;
	
	//床号
	private String bedNum;
	
	//衣柜号
	private String wardrobeNum;
	
	//桌柜号
	private String deskNum;
	
	//一对一关联关系
	private UploadStaff staff;
	
	//一对一关联关系
	private UploadRoom room;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public UploadStaff getStaff() {
		return staff;
	}

	public void setStaff(UploadStaff staff) {
		this.staff = staff;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	

	public UploadRoom getRoom() {
		return room;
	}

	public void setRoom(UploadRoom room) {
		this.room = room;
	}
	

	@Override
	public String toString() {
		return "RoomGoods [id=" + id + ", buildName=" + buildName
				+ ", roomCode=" + roomCode + ", bedNum=" + bedNum
				+ ", wardrobeNum=" + wardrobeNum + ", deskNum=" + deskNum
				+ ", staff=" + staff + ", room=" + room +"]";
	}

	
	
	
}
