package cn.net.inlink.vo;
/**
 * 上传的宿舍配置信息
 * @author Yz
 *
 */
public class UploadRoom {
	//id
	private Integer id;
	
	//宿舍楼
	private String buildName;
	
	//房间号
	private String roomCode;
	
	//可住人数
	private Integer size;
	
	//实住人数
	private Integer occupy;
	
	//分类
	private String classify;
	
	//备注1
	private String content1;
	
	//备注2
	private String content2;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getOccupy() {
		return occupy;
	}

	public void setOccupy(Integer occupy) {
		this.occupy = occupy;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}
	
}
