package cn.net.inlink.vo;

import java.util.Date;

/**
 * 员工借用实体类
 * @author Yz
 *
 */
public class StaffBorrow {
	//id
	private Integer id;
	
	//借用人，一对已关联关系
	private UploadStaff staff;
	
	//借用物品名称
	private String objectName;
	
	//借用日期
	private String beginDate;
	
	//归还日期
	private String endDate;
	
	//备注
	private String content;
	
	//借用记录状态
	private Integer flag;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UploadStaff getStaff() {
		return staff;
	}

	public void setStaff(UploadStaff staff) {
		this.staff = staff;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
	
}
