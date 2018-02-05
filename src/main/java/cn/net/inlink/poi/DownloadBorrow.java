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

import cn.net.inlink.utils.CellUtil;
import cn.net.inlink.utils.StaffValueUtil;
import cn.net.inlink.vo.StaffBorrow;

/**
 * 生成用于下载的excel文件
 * 
 * @author Yz
 * 
 */

public class DownloadBorrow {

	public static void exportStaffBorrowInfo(InputStream input,
			List<StaffBorrow> giveBacks, List<StaffBorrow> noGiveBacks,
			ServletContext context) {

		// 获取项目webroot路径
		String path = context.getRealPath("/");

		FileOutputStream fos = null;

		try {
			// 获取poi对象
			POIFSFileSystem poi = new POIFSFileSystem(input);

			// 新建工作簿
			HSSFWorkbook workbook = new HSSFWorkbook(poi);

			// 获取第一张sheet
			HSSFSheet sheet1 = workbook.getSheetAt(0);

			// 获取第二张sheet
			HSSFSheet sheet2 = workbook.getSheetAt(1);

			// 获取第一张sheet表头
			HSSFRow row1 = sheet1.getRow(0);

			// 获取第一张sheet表头
			HSSFRow row2 = sheet2.getRow(0);

			// 写入数据 第一张sheet
			for (int index = 0; index < giveBacks.size(); index++) {

				// 从第二行开始写
				row1 = sheet1.getRow(1 + index);

				// 员工编号
				row1.createCell(0).setCellValue(
						StaffValueUtil.getStringValue(giveBacks.get(index)
								.getStaff().getEmpCode()));
				// 姓名
				row1.createCell(1).setCellValue(
						StaffValueUtil.getStringValue(giveBacks.get(index)
								.getStaff().getEmpName()));
				// 科室
				row1.createCell(2).setCellValue(
						StaffValueUtil.getStringValue(giveBacks.get(index)
								.getStaff().getDept().getDictName()));
				
				// 宿舍楼
				row1.createCell(3).setCellValue(
						StaffValueUtil.getStringValue(giveBacks.get(index)
								.getStaff().getBuildingName()));
				// 房间号
				row1.createCell(4).setCellValue(
						StaffValueUtil.getStringValue(giveBacks.get(index)
								.getStaff().getRoomCode()));
				// 借用物品
				row1.createCell(5).setCellValue(
						StaffValueUtil.getStringValue(giveBacks.get(index)
								.getObjectName()));

				// 借用时间
				row1.createCell(6).setCellValue(
						StaffValueUtil.getStringValue(giveBacks.get(index)
								.getBeginDate()));
				// 归还日期
				row1.createCell(7).setCellValue(
						giveBacks.get(index)
								.getEndDate());
			}

			// 写入数据 第二张sheet
			for (int index = 0; index < noGiveBacks.size(); index++) {

				// 从第二行开始写
				row2 = sheet2.getRow(1 + index);

				// 员工编号
				row2.createCell(0).setCellValue(
						StaffValueUtil.getStringValue(noGiveBacks.get(index)
								.getStaff().getEmpCode()));
				// 姓名
				row2.createCell(1).setCellValue(
						StaffValueUtil.getStringValue(noGiveBacks.get(index)
								.getStaff().getEmpName()));
				// 科室
				row2.createCell(2).setCellValue(
						StaffValueUtil.getStringValue(noGiveBacks.get(index)
								.getStaff().getDept().getDictName()));
				
				// 宿舍楼
				row2.createCell(3).setCellValue(
						StaffValueUtil.getStringValue(noGiveBacks.get(index)
								.getStaff().getBuildingName()));
				// 房间号
				row2.createCell(4).setCellValue(
						StaffValueUtil.getStringValue(noGiveBacks.get(index)
								.getStaff().getRoomCode()));
				// 借用物品
				row2.createCell(5).setCellValue(
						StaffValueUtil.getStringValue(noGiveBacks.get(index)
								.getObjectName()));

				// 借用时间
				row2.createCell(6).setCellValue(
						StaffValueUtil.getStringValue(noGiveBacks.get(index)
								.getBeginDate()));


			}

			workbook.setSheetName(0, "员工物品归还信息");
			workbook.setSheetName(1, "员工物品借用信息");

			// 封装写入的路径
			fos = new FileOutputStream(path + "/excel/人员借用信息.xls");

			fos.flush();

			// 写excel文件
			workbook.write(fos);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
