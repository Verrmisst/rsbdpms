package cn.net.inlink.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.service.DormManaService;
import cn.net.inlink.service.StaffManaService;
import cn.net.inlink.service.UploadStaffService;
import cn.net.inlink.vo.Building;
import cn.net.inlink.vo.Dictionary;
import cn.net.inlink.vo.Employee;
import cn.net.inlink.vo.Room;
import cn.net.inlink.vo.UploadRoom;
import cn.net.inlink.vo.UploadStaff;

/**
 * 总务单独录入的控制器
 * 
 * @author Yz
 * 
 */
@Controller
@Scope("prototype")
public class SingleTypeinAction {

	// 日志
	private Logger log = Logger.getLogger(SingleTypeinAction.class);

	// 属性依赖
	@Autowired
	private StaffManaService service;

	@Autowired
	private UploadStaffService uploadService;

	@Autowired
	private DormManaService dormService;

	// 宿舍楼名：1 是闻博轩，2是 静雅苑
	private int buildingName;

	// 房间号
	private String roomCode;

	// 员工编号
	private String empCode;

	// 员工姓名
	private String empName;

	// 床号
	private String bedNum;

	// 衣柜号
	private String wardrobeNum;

	// 桌柜号
	private String deskNum;

	// 鞋柜号
	private String shoeboxNum;

	// 床垫领取 0 领取，1没领
	private int mattressNum;

	// 员工性别 0男 ，1女
	private int empGender;

	// 入住时间，默认系统时间
	private Date livingDate;

	// 错误信息
	private String text;

	public int getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(int buildingName) {
		this.buildingName = buildingName;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
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

	public String getShoeboxNum() {
		return shoeboxNum;
	}

	public void setShoeboxNum(String shoeboxNum) {
		this.shoeboxNum = shoeboxNum;
	}

	public int getMattressNum() {
		return mattressNum;
	}

	public void setMattressNum(int mattressNum) {
		this.mattressNum = mattressNum;
	}

	public Date getLivingDate() {
		return livingDate;
	}

	public void setLivingDate(Date livingDate) {

		if (livingDate == null) {// 不填默认系统时间
			this.livingDate = new Date();
		}

		this.livingDate = livingDate;
	}

	public int getEmpGender() {
		return empGender;
	}

	public void setEmpGender(int empGender) {
		this.empGender = empGender;
	}

	public StaffManaService getService() {
		return service;
	}

	public void setService(StaffManaService service) {
		this.service = service;
	}


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public UploadStaffService getUploadService() {
		return uploadService;
	}

	public void setUploadService(UploadStaffService uploadService) {
		this.uploadService = uploadService;
	}

	public DormManaService getDormService() {
		return dormService;
	}

	public void setDormService(DormManaService dormService) {
		this.dormService = dormService;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public String execute() {

		// 获取宿舍配置对象
		UploadRoom roomset = dormService.queryRoomByCode(roomCode,
				buildingName == 1 ? "闻博轩" : "静雅苑");

		// 判断已住人数和可住人数是否符合输入
		if (roomset.getSize() < roomset.getOccupy() + 1) {

			this.text = "房间号为：" + roomCode + "，已满。请重新选择房间";

			return "insert error";
		}

		// 获取员工对象
		Employee empCreated = service.queryIdByEmpCode(empCode);

		// 判断员工是否存在
		if (empCreated != null) {// 存在则返回至错误页面

			this.text = "编号为：" + this.empCode + " 的员工已入住，请重新录入！";

			return "insert error";

		} else {// 不存在进行下一步操作

			try {
				// 创建员工对象
				Employee emp = new Employee();

				// 备注
				String content = null;

				emp.setEmpCode(this.empCode);
				emp.setEmpName(this.empName);

				if (this.mattressNum == 0) {

					content = "床垫已领取";

				} else {

					content = "床垫未领取";
				}

				emp.setContent(content);

				// 创建字典对象
				Dictionary dict = null;

				// 获取性别
				switch (this.empGender) {
				case 0:// 性别为男
					dict = service.queryIdByDictName("男");
					break;
				case 1:// 性别为女
					dict = service.queryIdByDictName("女");
					break;
				default:// 默认为男
					dict = service.queryIdByDictName("男");
					break;
				}

				Integer genderId = dict.getId();

				// 持久化人员表

				log.info("持久化人员信息");

				try {
					service.saveEmp(emp);
				} catch (Exception e) {

					this.text = "录入人员基本信息失败";

					return "insert error";
				}

				try {
					service.saveEmpGender(genderId, this.empCode);
				} catch (Exception e) {

					this.text = "录入人员性别失败";

					return "insert error";

				}

				log.info("持久化人员信息完成");

				// 宿舍楼对象
				Building build = null;

				// 宿舍对象
				Room room = new Room();

				room.setRoomCode(this.roomCode);

				// 获取宿舍楼id

				Integer buildId = null;

				switch (this.buildingName) {
				case 1:// 闻博轩

					build = service.queryIdByBuildName("闻博轩");
					break;

				case 2:// 静雅苑

					build = service.queryIdByBuildName("静雅苑");
					break;

				default:// 默认闻博轩
					build = service.queryIdByBuildName("闻博轩");
					break;
				}

				buildId = build.getId();

				// 持久化宿舍数据

				log.info("持久化宿舍数据");

				try {
					service.saveRoom(room);
				} catch (Exception e) {
					this.text = "录入宿舍信息失败";

					return "insert error";

				}

				try {
					service.editRommBuildId(buildId, this.roomCode);
				} catch (Exception e) {
					this.text = "录入宿舍信息失败";

					return "insert error";
				}

				log.info("持久化宿舍数据完成");

				log.info("更新上传表");

				// 插入记录到上传记录表
				UploadStaff staff = new UploadStaff();

				staff.setEmpCode(empCode);
				staff.setEmpName(empName);
				staff.setGender(empGender == 0 ? "男" : "女");
				staff.setBuildingName(buildingName == 1 ? "闻博轩" : "静雅苑");
				staff.setRoomCode(roomCode);
				staff.setBedNum(bedNum);
				staff.setWardrobeNum(wardrobeNum);
				staff.setDeskNum(deskNum);
				staff.setShopboxNum(shoeboxNum);
				staff.setContent(mattressNum == 0 ? "床垫已领" : "床垫未领取");
				staff.setLivingDate(new SimpleDateFormat("yyyy/MM/dd")
						.format(livingDate == null ? new Date() : livingDate));
				uploadService.saveStaffInfo(staff);

				log.info("更新上传表完成");
				
				
				//更新宿舍配置表，每录入一次可住人数+1
				dormService.editOccupy(roomCode, buildingName == 1 ? "闻博轩" : "静雅苑");

				/*// 持久化物品信息
				*//**
				 * 每次请求该控制器需要插入四条数据 分别是：床，衣柜，鞋柜，桌柜
				 *//*

				// 获取房间id
				int roomId = service.queryIdByRoomCode(this.roomCode).getId();

				// 获取人员id
				int empId = service.queryIdByEmpCode(this.empCode).getId();

				// 获取字典表中床的id
				int bedId = service.queryIdByDictName("床").getId();
				// 获取字典表中衣柜的id
				int wardrobeId = service.queryIdByDictName("衣柜").getId();
				// 获取字典表中桌柜的id
				int deskId = service.queryIdByDictName("桌柜").getId();
				// 获取字典表中鞋柜的id
				int shoeboxId = service.queryIdByDictName("鞋柜").getId();

				log.info("持久化物品数据");

				try {
					// 床
					service.saveGoods(bedId, this.bedNum, roomId, empId);
					// 衣柜
					service.saveGoods(wardrobeId, this.wardrobeNum, roomId,
							empId);
					// 桌柜
					service.saveGoods(deskId, this.deskNum, roomId, empId);
					// 鞋柜
					service.saveGoods(shoeboxId, this.shoeboxNum, roomId, empId);
				} catch (Exception e) {
					
					e.printStackTrace();
					this.errors = "录入失败。";

					return "insert error";

				}

				log.info("持久化物品数据完成");
*/
			} catch (Exception e) {
				e.printStackTrace();

				log.error("单个录入失败。时间："
						+ new SimpleDateFormat().format(new Date()));

				this.text = "操作失败，请重新录入";

				return "insert error";
			}

			return "insert success";
		}
	}
}