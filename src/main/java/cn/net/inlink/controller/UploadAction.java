package cn.net.inlink.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import cn.net.inlink.poi.UploadDeptDutyInfo;
import cn.net.inlink.poi.UploadStaffData;
import cn.net.inlink.service.StaffManaService;
import cn.net.inlink.service.UploadStaffService;
import cn.net.inlink.vo.Dictionary;
import cn.net.inlink.vo.Employee;
import cn.net.inlink.vo.Goods;
import cn.net.inlink.vo.Room;
import cn.net.inlink.vo.UploadDeptDuty;
import cn.net.inlink.vo.UploadStaff;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 控制上传文件
 * 
 * @author Yz
 * 
 */
@Controller
@Scope("prototype")
public class UploadAction extends ActionSupport {

	// 日志
	private Logger log = Logger.getLogger(UploadAction.class);

	// 属性依赖
	@Autowired
	private StaffManaService service;

	@Autowired
	private UploadStaffService uservice;

	private String savePath;// 配置文件

	// 错误信息
	private String text;

	// 类型
	private String uploadtype;

	/* 针对上传的临时文件 */
	private File upload;
	private String uploadContentType;
	private String uploadFileName;

	/* 确定输出流的在web服务器硬盘上的具体位置 */
	public String getSavePath() {
		/*
		 * (1)ServletActionContext是ActionContext的子类，目的是 在Action中提供jsp的内置对象
		 * (2)利用ServletContext对象获得指定长传路径的真实路径
		 */
		ServletContext application = ServletActionContext.getServletContext();
		String path = application.getRealPath(savePath);
		return path;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
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

	public UploadStaffService getUservice() {
		return uservice;
	}

	public void setUservice(UploadStaffService uservice) {
		this.uservice = uservice;
	}

	public String getUploadtype() {
		return uploadtype;
	}

	public void setUploadtype(String uploadtype) {
		this.uploadtype = uploadtype;
	}
	
	@Transactional(rollbackFor={RuntimeException.class, Exception.class})
	public String execute() {

		// 日志记录
		log.info("开始上传文件------------------");
		log.info("savePath=" + getSavePath());
		log.info("uploadFileName=" + getUploadFileName());
		log.info("uploadContentType=" + getUploadContentType());
		log.info("upload=" + this.getUpload());

		try {
			// 目标文件（服务器存储位置）
			FileOutputStream fos = new FileOutputStream(getSavePath()
					+ File.separator + getUploadFileName());
			// 上传文件的输入流
			FileInputStream fis = new FileInputStream(getUpload());

			if (this.uploadtype.equals("1")) {// 总务上传

				UploadStaffData staff = new UploadStaffData();

				// 员工对象
				Employee emp = new Employee();

				// 房间对象
				Room room = new Room();

				// 物品对象
				// Goods good = new Goods();

				// 得到读取的员工信息集合
				List<UploadStaff> staffDatas = staff.readExcel(fis);

				// 遍历集合获取到每个参数
				for (UploadStaff datas : staffDatas) {
					
					//判断表中是否存在该员工(并未入住)
					if(uservice.queryStaff(datas.getEmpCode())==0){
					
					
					// 判断是否为空
					if (datas.getLivingDate().equals("")) {

						datas.setLivingDate(new SimpleDateFormat("yyyy/MM/dd")
								.format(new Date()));

					}
					
					// 向上传记录表中插入记录
					log.info("处理上传记录表");
					
					uservice.saveStaffInfo(datas);
					
					}else if(uservice.queryCOStaff(datas.getEmpCode())!=0){//该员工已退宿
						
						//删除处理
						uservice.deleCOStaff(datas.getEmpCode());
					
					}else{//已存在
						
						log.info("编号为："+datas.getEmpCode()+"的员工已存在");
					}
					// 向员工表中插入记录
					
					//判断并未入住过的人员
				if(service.queryIdByEmpCode(datas.getEmpCode())==null){
					
					log.info("处理员工表");
					
					

					emp.setEmpCode(datas.getEmpCode());

					emp.setEmpName(datas.getEmpName());

					emp.setContent(datas.getContent());

					service.saveEmp(emp);

					// 更新性别字段
					service.saveEmpGender(
							service.queryIdByDictName(datas.getGender())
									.getId(), datas.getEmpCode());
				
				
					// 向房间表插入记录

					log.info("处理房间表");

					room.setRoomCode(datas.getRoomCode());

					service.saveRoom(room);

					// 更新room表宿舍楼字段
					service.editRommBuildId(
							service.queryIdByBuildName(datas.getBuildingName())
									.getId(), datas.getRoomCode());
					//入住过的退宿员工
				}else if(service.queryCOEmpByEmpCode(datas.getEmpCode())!=null){
					//删除操作
					service.deleCOEmpByCode(datas.getEmpCode());
					
				}
					// 向物品表中更新数据

					/* 一次更新四条，分别是床，衣柜，鞋柜，桌柜 */

					//log.info("处理物品表");

				/*	// 床
					service.saveGoods(service.queryIdByDictName("床").getId(),
							datas.getBedNum(),
							service.queryIdByRoomCode(datas.getRoomCode())
									.getId(),
							service.queryIdByEmpCode(datas.getEmpCode())
									.getId());

					// 衣柜
					service.saveGoods(service.queryIdByDictName("衣柜").getId(),
							datas.getWardrobeNum(),
							service.queryIdByRoomCode(datas.getRoomCode())
									.getId(),
							service.queryIdByEmpCode(datas.getEmpCode())
									.getId());

					// 鞋柜
					service.saveGoods(service.queryIdByDictName("鞋柜").getId(),
							datas.getShopboxNum(),
							service.queryIdByRoomCode(datas.getRoomCode())
									.getId(),
							service.queryIdByEmpCode(datas.getEmpCode())
									.getId());

					// 桌柜
					service.saveGoods(service.queryIdByDictName("桌柜").getId(),
							datas.getDeskNum(),
							service.queryIdByRoomCode(datas.getRoomCode())
									.getId(),
							service.queryIdByEmpCode(datas.getEmpCode())
									.getId());
*/
				}
				this.text = "上传成功！";

				return "upload success";
				
			} else if (this.uploadtype.equals("2")) {// 人事上传
				
				//获取上传的职务和部门集合
				UploadDeptDutyInfo info = new UploadDeptDutyInfo();
				
				List<UploadDeptDuty> deptDuty = info.readExcel(fis);
				
				//向部门和职务信息表中插入数据
				for (UploadDeptDuty uploadDeptDuty : deptDuty) {
					
					log.info("部门和职务信息表中插入数据");
					this.uservice.saveDeptDuty(uploadDeptDuty);
				
					//获取职务和部门在字典表中的id
					Integer deptId = service.queryIdByDictName(uploadDeptDuty.getDepart()).getId();
					Integer dutyId = service.queryIdByDictName(uploadDeptDuty.getDuty()).getId();
					
					//获取员工编号
					String empCode = uploadDeptDuty.getEmpCode();
					
					log.info("员工编号："+empCode);
					
					log.info("更新员工表");
					//更新员工表
					this.service.editEmpDutyDept(deptId, dutyId, empCode);
					
					log.info("入住人员信息表");
					//更新入住人员信息表
					this.uservice.editDutyDept();
					
				}
				
				this.text = "上传成功！";
				
				return "hrupload success";
				
			}
		} catch (Exception e) {

			this.text = "上传失败请重新上传！";
			
			
			
			log.error(e.toString());
			
			return "upload error";
		}
		
		this.text = "请检查上传类型";
		
		return "upload error";

	}

}
