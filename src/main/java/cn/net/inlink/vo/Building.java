package cn.net.inlink.vo;

import java.util.List;

/**
 * 宿舍楼实体类，包含宿舍楼id，宿舍楼名称，性别区分，备注
 * @author Yz
 *
 */
public class Building {
	//id
	private Integer id;
	
	//名称
	private String buildingName;
	
	//性别区分
	private Dictionary gender;
	
	//所有房间
	//一对多关联关系
	List<Room> rooms ;
	
	//备注
	private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
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

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	
	
}
