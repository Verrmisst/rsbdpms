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
import cn.net.inlink.vo.RoomGoods;

/**
 * 生成用于下载的excel文件
 * 
 * @author Yz
 * 
 */

public class DownloadAllStaffs {

	public static void exportAllStaffInfo(InputStream input,
			List<RoomGoods> staffs, ServletContext context) {

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
			for (int i = 0; i < staffs.size(); i++) {
				
				// 从第二行开始写
				row = sheet.getRow(1+i);
				
				//System.out.println(sheet);
				
				//System.out.println(row);
				
				/*// 房间号
				row.createCell(0).setCellValue(
						StaffValueUtil.getStringValue(staffs.get(i)
								.getBuildName())
								+ " "
								+ StaffValueUtil.getStringValue(staffs.get(i)
										.getRoomCode()));
				// 床号
				row.createCell(1).setCellValue(
						StaffValueUtil
								.getStringValue(staffs.get(i).getBedNum()));
				// 员工编号
				row.createCell(2).setCellValue(
						StaffValueUtil.getStringValue(StaffValueUtil.getStaff(
								staffs.get(i).getStaff()).getEmpCode()));
				// 姓名
				row.createCell(3).setCellValue(
						StaffValueUtil.getStringValue(StaffValueUtil.getStaff(
								staffs.get(i).getStaff()).getEmpName()));
				// 科室
				row.createCell(4).setCellValue(
						StaffValueUtil.getStringValue(StaffValueUtil.getObject(
								StaffValueUtil.getStaff(
										staffs.get(i).getStaff()).getDept())
								.getDictName()));
				// 勤务
				row.createCell(5).setCellValue(
						StaffValueUtil.getStringValue(StaffValueUtil.getObject(
								StaffValueUtil.getStaff(
										staffs.get(i).getStaff()).getDuty())
								.getDictName()));
				// 入住日期
				row.createCell(6).setCellValue(
						StaffValueUtil.getStringValue(StaffValueUtil.getStaff(
								staffs.get(i).getStaff()).getLivingDate()));
				// 衣柜号
				row.createCell(7).setCellValue(
						StaffValueUtil.getStringValue(staffs.get(i)
								.getWardrobeNum()));
				// 桌柜号
				row.createCell(8).setCellValue(
						StaffValueUtil.getStringValue(staffs.get(i)
								.getDeskNum()));
				// 鞋柜号
				row.createCell(9).setCellValue(
						StaffValueUtil.getStringValue(StaffValueUtil.getStaff(
								staffs.get(i).getStaff()).getShopboxNum()));
				// 房间人数
				row.createCell(10).setCellValue(
						StaffValueUtil.getIntegerValue(StaffValueUtil.getRoom(
								staffs.get(i).getRoom()).getSize()));
				// 实际人数
				row.createCell(11).setCellValue(
						StaffValueUtil.getIntegerValue(StaffValueUtil.getRoom(
								staffs.get(i).getRoom()).getOccupy()));
				// 分类
				row.createCell(12).setCellValue(
						StaffValueUtil.getStringValue(StaffValueUtil.getRoom(
								staffs.get(i).getRoom()).getClassify()));
				// 备注1
				row.createCell(13).setCellValue(
						StaffValueUtil.getStringValue(StaffValueUtil.getRoom(
								staffs.get(i).getRoom()).getContent1()));
				// 备注2
				row.createCell(14).setCellValue(
						StaffValueUtil.getStringValue(StaffValueUtil.getRoom(
								staffs.get(i).getRoom()).getContent2()));
				// 备注3
				row.createCell(15).setCellValue(
						StaffValueUtil.getStringValue(StaffValueUtil.getRoom(
								staffs.get(i).getRoom()).getContent3()));
*/
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
