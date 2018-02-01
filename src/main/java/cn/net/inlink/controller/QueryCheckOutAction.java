package cn.net.inlink.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.net.inlink.poi.DownloadCheckout;
import cn.net.inlink.service.BlurSearchService;
import cn.net.inlink.vo.UploadStaff;

/**
 * 多条件查询退宿人员并实现导出筛选后的数据的控制器
 * @author Yz
 *
 */

@Controller
@Scope("prototype")
public class QueryCheckOutAction extends ActionSupport{
	
	//属性依赖
	@Autowired
	private BlurSearchService service;
	
	//参数
	private String roomCode;
	
	private String buildName;
	
	private String beginDate;
	
	private String endDate;
	
	private String livingbegin;
	
	private String livingend;
	
	private String exchangebegin;
	
	private String exchangeend;
	
	//信息存储
	private String text;
	
	//退宿人员信息记录
	private List<UploadStaff> staffs;
	
	
	public BlurSearchService getService() {
		return service;
	}

	public void setService(BlurSearchService service) {
		this.service = service;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
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

	public List<UploadStaff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<UploadStaff> staffs) {
		this.staffs = staffs;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
	public String getLivingbegin() {
		return livingbegin;
	}

	public void setLivingbegin(String livingbegin) {
		this.livingbegin = livingbegin;
	}

	public String getLivingend() {
		return livingend;
	}

	public void setLivingend(String livingend) {
		this.livingend = livingend;
	}

	public String getExchangebegin() {
		return exchangebegin;
	}

	public void setExchangebegin(String exchangebegin) {
		this.exchangebegin = exchangebegin;
	}

	public String getExchangeend() {
		return exchangeend;
	}

	public void setExchangeend(String exchangeend) {
		this.exchangeend = exchangeend;
	}
	
	public String execute(){
		
		//获取文件输入流
		InputStream fis = QueryCheckOutAction.class.getClassLoader().getResourceAsStream("cn/net/inlink/excel/checkout.xls");
		
		//获取上下文对象
		ServletContext context = ServletActionContext.getServletContext();
		
		if(this.buildName.equals("1")){
			
			this.buildName = "闻博轩";
		}else if(this.buildName.equals("2")){
			
			this.buildName = "静雅苑";
		}
		
		this.staffs = service.queryCheckOuts(roomCode, buildName, beginDate, endDate, livingbegin, livingend, exchangebegin, exchangeend);
		
		if(this.staffs.size()==0){
			
			this.text = "暂无记录，请重新搜索";
			
			return "error";
		}
		
		//生成下载文件
		DownloadCheckout.exportCheckoutInfo(fis, staffs, context);
		
		return "success";
	}
	
}
