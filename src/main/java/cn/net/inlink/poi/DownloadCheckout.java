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

public class DownloadCheckout {

	public static void exportCheckoutInfo(InputStream input,
			List<UploadStaff> staffs, ServletContext context) {

		// 获取项目webroot路径
		String path = context.getRealPath("/");

		FileOutputStream fos = null;

		// 下载路径
		String downloadPath = null;

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
			for (int i = 0; i < staffs.size(); i++) {

				// 从第二行开始写
				row = sheet.getRow(1 + i);
				
				// 编号
				row.createCell(0).setCellValue(i + 1);
				// 工号
				row.createCell(1).setCellValue(
						StaffValueUtil.getStringValue(staffs.get(i)
								.getEmpCode()));
				// 姓名
				row.createCell(2).setCellValue(
						StaffValueUtil.getStringValue(staffs.get(i)
								.getEmpName()));
				// 性别
				row.createCell(3).setCellValue(
						StaffValueUtil
								.getStringValue(staffs.get(i).getGender()));
				// 科室
				row.createCell(4).setCellValue(
						StaffValueUtil.getStringValue((StaffValueUtil
								.getObject(staffs.get(i).getDept()))
								.getDictName()));
				// 勤务
				row.createCell(5).setCellValue(
						StaffValueUtil.getStringValue((StaffValueUtil
								.getObject(staffs.get(i).getDuty()))
								.getDictName()));
				// 宿舍楼
				row.createCell(6).setCellValue(
						StaffValueUtil.getStringValue(staffs.get(i)
								.getBuildingName()));
				// 房间号
				row.createCell(7).setCellValue(
						StaffValueUtil.getStringValue(staffs.get(i)
								.getRoomCode()));
				// 床号
				row.createCell(8).setCellValue(
						StaffValueUtil
								.getStringValue(staffs.get(i).getBedNum()));
				// 衣柜号
				row.createCell(9).setCellValue(
						StaffValueUtil.getStringValue(staffs.get(i)
								.getWardrobeNum()));
				// 桌柜号
				row.createCell(10).setCellValue(
						StaffValueUtil.getStringValue(staffs.get(i)
								.getDeskNum()));
				// 鞋柜号
				row.createCell(11).setCellValue(
						StaffValueUtil.getStringValue(staffs.get(i)
								.getShopboxNum()));
				// 入住日期
				row.createCell(12).setCellValue(
						StaffValueUtil.getStringValue(staffs.get(i)
								.getLivingDate()));
				// 退宿日期
				row.createCell(13).setCellValue(
						StaffValueUtil.getStringValue(staffs.get(i)
								.getCheckOutDate()));

			}
			
			workbook.setSheetName(0, "退宿人员信息");
			
			// 封装写入的路径
			fos = new FileOutputStream(path + "/excel/退宿人员信息.xls");

			fos.flush();

			// 写excel文件
			workbook.write(fos);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
