package cn.net.inlink.vo;

/**
 * 宿舍房间实体类
 * @author Yz
 *
 */
public class Room {
	//id
	private Integer id;
	
	//编号
	private String roomCode;
	
	//所属宿舍楼
	//一对一关联关系
	private Building building;
	
	
	//备注
	private String content;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getRoomCode() {
		return roomCode;
	}


	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}


	public Building getBuilding() {
		return building;
	}


	public void setBuilding(Building building) {
		this.building = building;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
