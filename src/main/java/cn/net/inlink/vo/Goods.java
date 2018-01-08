package cn.net.inlink.vo;

/**
 * 物品实体类，包含id，物品类别，物品编号，房间号，人员id，使用时间，物品状态
 * @author Yz
 *
 */
public class Goods {
	
	//id
	private Integer id;
	
	//物品名称
	//一对一关联关系
	private Dictionary goodsName;
	
	
	//物品编号
	private String goodsCode;
	
	//房间
	//一对一关联关系
	private Room room;
	
	//使用人
	//一对一关联关系
	private Employee emp;
	
	//使用时间
	private String useDate;
	
	//使用状态
	//一对一关联关系
	private Dictionary goodsStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Dictionary getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(Dictionary goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public String getUseDate() {
		return useDate;
	}

	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}

	public Dictionary getGoodsStatus() {
		return goodsStatus;
	}

	public void setGoodsStatus(Dictionary goodsStatus) {
		this.goodsStatus = goodsStatus;
	}
	
	

}
