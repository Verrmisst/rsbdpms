package cn.net.inlink.poi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import cn.net.inlink.utils.StaffValueUtil;
import cn.net.inlink.vo.UploadStaff;

/**
 * 生成用于下载的excel文件
 * 
 * @author Yz
 * 
 */

public class DownloadAllStaffs {

	public static void exportAllStaffInfo(InputStream input,
			List<UploadStaff> staffs, ServletContext context) {

		// 获取项目webroot路径
		String path = context.getRealPath("/");

		FileOutputStream fos = null;

		try {
			// 获取poi对象
			POIFSFileSystem poi = new POIFSFileSystem(input);

			// 新建工作簿
			HSSFWorkbook workbook = new HSSFWorkbook(poi);

			// 获取第一张sheet
			HSSFSheet sheet = workbook.getSheetAt(0);

			// 获取第一张sheet表头
			HSSFRow row = sheet.getRow(0);
			
			
			// 写入数据
			for (int index = 0; index < staffs.size(); index++) {

				// 从第二行开始写
				 row = sheet.getRow(1+index);
				
				// 员工编号
				
				row.getCell(0).setCellValue(StaffValueUtil.getStringValue(staffs.get(index).getEmpCode()));
				
				// 姓名
				row.getCell(1).setCellValue(StaffValueUtil.getStringValue(staffs.get(index).getEmpName()));

				// 性别
				row.getCell(2).setCellValue(StaffValueUtil.getStringValue(staffs.get(index).getGender()));
				
				// 科室
				row.getCell(3).setCellValue(StaffValueUtil.getStringValue(staffs.get(index).getDept().getDictName()));
				
				// 勤务
				row.getCell(4).setCellValue(StaffValueUtil.getStringValue(staffs.get(index).getDuty().getDictName()));
				
				// 宿舍楼
				row.getCell(5).setCellValue(StaffValueUtil.getStringValue(staffs.get(index).getBuildingName()));
				
				// 房间号
				row.getCell(6).setCellValue(StaffValueUtil.getStringValue(staffs.get(index).getRoomCode()));
				
				// 床号
				row.getCell(7).setCellValue(StaffValueUtil.getStringValue(staffs.get(index).getBedNum()));
				
				// 衣柜号
				row.getCell(8).setCellValue(StaffValueUtil.getStringValue(staffs.get(index).getWardrobeNum()));
				
				// 桌柜号
				row.getCell(9).setCellValue(StaffValueUtil.getStringValue(staffs.get(index).getDeskNum()));

				// 鞋柜号
				row.getCell(10).setCellValue(StaffValueUtil.getStringValue(staffs.get(index).getShopboxNum()));

				// 入住时间
				row.getCell(11).setCellValue(StaffValueUtil.getStringValue(staffs.get(index).getLivingDate()));

				// 调宿时间
				row.getCell(12).setCellValue(StaffValueUtil.getStringValue(staffs.get(index).getExchangeDate()));

			}

			workbook.setSheetName(0, "入住人员信息");

			// 封装写入的路径
			fos = new FileOutputStream(path + "/excel/入住人员信息.xls");

			fos.flush();

			// 写excel文件
			workbook.write(fos);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
