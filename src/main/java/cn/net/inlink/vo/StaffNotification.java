package cn.net.inlink.vo;

/**
 * 员工通报实体类
 * @author Yz
 *
 */

public class StaffNotification {
	
	//id
	private Integer id;
	
	//类型
	private String notificeType;
	
	//通报时间
	private String notificeTime;
	
	//通报原因
	private String notificeReason;
	
	//处罚金额
	private String notificeMoney;
	
	//被通报人员
	//一对一关联关系
	private UploadStaff staff;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNotificeType() {
		return notificeType;
	}

	public void setNotificeType(String notificeType) {
		this.notificeType = notificeType;
	}

	public String getNotificeTime() {
		return notificeTime;
	}

	public void setNotificeTime(String notificeTime) {
		this.notificeTime = notificeTime;
	}

	public String getNotificeReason() {
		return notificeReason;
	}

	public void setNotificeReason(String notificeReason) {
		this.notificeReason = notificeReason;
	}

	public String getNotificeMoney() {
		return notificeMoney;
	}

	public void setNotificeMoney(String notificeMoney) {
		this.notificeMoney = notificeMoney;
	}

	public UploadStaff getStaff() {
		return staff;
	}

	public void setStaff(UploadStaff staff) {
		this.staff = staff;
	}

	@Override
	public String toString() {
		return "StaffNotification [id=" + id + ", notificeType=" + notificeType
				+ ", notificeTime=" + notificeTime + ", notificeReason="
				+ notificeReason + ", notificeMoney=" + notificeMoney
				+ ", staff=" + staff + "]";
	}
	
	
}
