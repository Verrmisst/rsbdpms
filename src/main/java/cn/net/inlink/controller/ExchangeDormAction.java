package cn.net.inlink.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.service.DormManaService;
import cn.net.inlink.service.StaffManaService;
import cn.net.inlink.vo.UploadRoom;
import cn.net.inlink.vo.UploadStaff;

/**
 * 入住人员调宿的控制器
 * 
 * @author Yz
 * 
 */
@Controller
@Scope("prototype")
public class ExchangeDormAction {

	// 日志记录
	private Logger log = Logger.getLogger(ExchangeDormAction.class);

	// 属性依赖
	@Autowired
	private DormManaService service;

	@Autowired
	private StaffManaService staffService;

	@Autowired
	private DormManaService dormService;
	// 参数
	private String staffCode;

	private String build;

	private String roomCode;

	private String bedNum;

	private String wardrobeNum;

	private String deskNum;

	private String shopboxNum;
	
	private String livingDate;
	// 信息存储
	private String text;

	public DormManaService getService() {
		return service;
	}

	public void setService(DormManaService service) {
		this.service = service;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getBuild() {
		return build;
	}

	public void setBuild(String build) {
		this.build = build;
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public StaffManaService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffManaService staffService) {
		this.staffService = staffService;
	}

	public DormManaService getDormService() {
		return dormService;
	}

	public void setDormService(DormManaService dormService) {
		this.dormService = dormService;
	}
	
	
	public String getLivingDate() {
		return livingDate;
	}

	public void setLivingDate(String livingDate) {
		this.livingDate = livingDate;
	}

	@Transactional(rollbackFor = {RuntimeException.class, Exception.class})
	public String execute()  {
		
		System.out.println(livingDate);
		
		//判断调宿时间是否为null
		if(this.livingDate==null){//为null,赋值为系统时间
			
			this.livingDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
			
		}
		
		if(this.livingDate.equals("")){//为""
			this.livingDate += new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		}
		
		log.info("调宿员工:"+staffCode+"执行时间：" + new SimpleDateFormat().format(new Date()));
		
		
		//this.build = new String(this.build.getBytes("iso-8859-1"), "utf-8");
		
		// 获取宿舍配置对象
		
		if(this.roomCode==null||this.roomCode.equals("")){
			
			this.text="请输入房间号";
			
			return "exchange error";
		}
		
		UploadRoom roomset = dormService.queryRoomByCode(roomCode,
				build);
		
		
		// 判断已住人数和可住人数是否符合输入
		if (roomset.getSize() == roomset.getOccupy()) {

			this.text = "房间号为：" + roomCode + "，已满。请重新选择房间";
			
			log.error("房间已满");
			
			return "exchange error";
		}

		try {
			
			//获取到原来住宿的房间号和楼号
			UploadStaff staff = service.queryStaffByCode(staffCode);
			
			String rc = staff.getRoomCode();
			
			String bn = staff.getBuildingName();
			
			//原宿舍已住人数-1
			this.dormService.editOccupycut(rc, bn);
			
			
			log.info("更新上传表");

			this.service.staffExchange(staffCode, build, roomCode, bedNum,
					wardrobeNum, deskNum, shopboxNum,livingDate);
			
			//更新宿舍配置表入住人数调换后
			this.dormService.editOccupy(roomCode, build);
			
			log.info("上传表更新完毕");

		} catch (Exception e) {

			log.error(e.toString());

			log.info("更新失败");

			this.text = "调宿失败，请稍后重试";

			return "exchange error";
		}

		
		 /* // 更新物品表，宿舍表 // 获取人员id Integer staffId =
		 * staffService.queryIdByEmpCode(staffCode).getId();
		 * 
		 * // 获取宿舍id Integer roomId =
		 * staffService.queryIdByRoomCode(roomCode).getId();
		 * 
		 * // 获取宿舍楼id Integer buildId =
		 * staffService.queryIdByBuildName(build).getId();
		 * 
		 * // 更新宿舍表宿舍号对应的宿舍楼 staffService.editRommBuildId(buildId, roomCode);
		 * 
		 * // 获取字典表中床的id int bedId =
		 * staffService.queryIdByDictName("床").getId(); // 获取字典表中衣柜的id int
		 * wardrobeId = staffService.queryIdByDictName("衣柜").getId(); //
		 * 获取字典表中桌柜的id int deskId =
		 * staffService.queryIdByDictName("桌柜").getId(); // 获取字典表中鞋柜的id int
		 * shoeboxId = staffService.queryIdByDictName("鞋柜").getId();
		 * 
		 * 
		 * 更新床号，衣柜号，鞋柜号，桌柜号
		 * 
		 * staffService.editGoods(roomId, bedNum, staffId, bedId);
		 * staffService.editGoods(roomId, wardrobeNum, staffId, wardrobeId);
		 * staffService.editGoods(roomId, deskNum, staffId, deskId);
		 * staffService.editGoods(roomId, shopboxNum, staffId, shoeboxId);
		 */
		return "exchange success";
		
	}

	
	
}
