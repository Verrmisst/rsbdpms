package cn.net.inlink.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;


public class DownloadBorrowAction {
	
	private Logger log = Logger.getLogger(DownloadBorrowAction.class);
	
	//定义文件名
	private String fileName;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getInputStream() throws UnsupportedEncodingException,
			FileNotFoundException {

		/*HttpServletResponse response = ServletActionContext.getResponse();
		// attachment,以附件的方式下载文件,会打开保存文件对话框;inline,以内联的方式下载,浏览器会直接打开文件
		response.setHeader("Content-Disposition", "attachment;fileName="
				+department);*/// java.net.URLEncoder.encode(fileName,"UTF-8")
																	// 编码转换，解决乱码

		// 如果fileName是相对路径
		
		
		//return ServletActionContext.getServletContext().getResourceAsStream(fileName);
		
		log.info(ServletActionContext.getServletContext().getRealPath("/"+"excel/人员借用信息.xls"));
		
		return new FileInputStream(ServletActionContext.getServletContext().getRealPath("/"+"excel/人员借用信息.xls"));
		// 如果fileName是绝对路径
		
		 //return new BufferedInputStream(new FileInputStream(fileName));
	}

	public String execute() {
		
        
		return "downloadborrow";
	}

}
