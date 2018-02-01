package cn.net.inlink.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.service.BlurSearchService;
import cn.net.inlink.utils.ListTools;
import cn.net.inlink.vo.Dictionary;
import cn.net.inlink.vo.RoomGoods;
import cn.net.inlink.vo.UploadStaff;

/**
 * 查询宿舍床位情况，参数宿舍楼名，房间号
 * 
 * @author Yz
 * 
 */
@Controller
@Scope("prototype")
public class QueryEmpRoomSetAction {

	// 属性依赖
	@Autowired
	private BlurSearchService service;

	private String dept;

	private String duty;

	// 信息集合
	private List<RoomGoods> roomGoods;

	//两个宿舍楼的信息集合
	private List<RoomGoods> objectJY;
	
	private List<RoomGoods> objectWB;
	
	// 信息存储
	private String info;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public BlurSearchService getService() {
		return service;
	}

	public void setService(BlurSearchService service) {
		this.service = service;
	}

	public List<RoomGoods> getRoomGoods() {
		return roomGoods;
	}

	public void setRoomGoods(List<RoomGoods> roomGoods) {
		this.roomGoods = roomGoods;
	}
	

	public List<RoomGoods> getObjectJY() {
		return objectJY;
	}

	public void setObjectJY(List<RoomGoods> objectJY) {
		this.objectJY = objectJY;
	}

	public List<RoomGoods> getObjectWB() {
		return objectWB;
	}

	public void setObjectWB(List<RoomGoods> objectWB) {
		this.objectWB = objectWB;
	}

	@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
	public String execute() throws UnsupportedEncodingException {

		// 转码处理
		this.dept = new String(this.dept.getBytes("iso-8859-1"), "utf-8");
		this.duty = new String(this.duty.getBytes("iso-8859-1"), "utf-8");

		// System.out.println(buildName+" | "+roomCode+" | "+dept+" | "+duty);

		// 创建屋内情况对象
		RoomGoods rd = new RoomGoods();

		// 创建人员对象
		UploadStaff staff = new UploadStaff();

		// 创建字典对象（职务和科室）
		Dictionary dict_dept = new Dictionary();
		Dictionary dict_duty = new Dictionary();

		// 注入科室和职务的值
		dict_dept.setDictName(dept);
		dict_duty.setDictName(duty);

		// 将科室和职务注入员工对象
		staff.setDept(dict_dept);
		staff.setDuty(dict_duty);

		rd.setStaff(staff);

		// 获取集合对象
		this.roomGoods = service.queryRoomSutiation(rd);
		
		//定义两个集合分别存储两个宿舍楼的房间号
		List<String> roomCodesJY = new ArrayList<String>();
		List<String> roomCodesWB = new ArrayList<String>();
		
		// 遍历查询出的List集合，获取集合中的房间号
		for (RoomGoods rg : this.roomGoods) {

			String rgCode = rg.getRoomCode();
			String buildCode = rg.getBuildName();
			
			if(buildCode.equals("闻博轩")){
				
				roomCodesWB.add(rgCode);
			}else if(buildCode.equals("静雅苑")){
				
				roomCodesJY.add(rgCode);
			}
			
		}
		
		if(roomCodesJY.size()!=0){
			this.objectJY = service.queryRoomSutiationByJY(roomCodesJY);
		}else{
			
			this.objectJY = new ArrayList<RoomGoods>();
		}
		
		if(roomCodesWB.size()!=0){
			this.objectWB = service.queryRoomSutiationByWB(roomCodesWB);
		}else{
			
			this.objectWB = new ArrayList<RoomGoods>();
		}
		
		
		if (this.objectJY.size()==0&&this.objectWB.size()==0) {// 集合中无记录

			this.info = "暂无记录，请重新查询";
			return "show error";
		}

		return "show success";

	}
}
