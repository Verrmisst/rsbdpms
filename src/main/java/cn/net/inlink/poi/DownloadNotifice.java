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
import cn.net.inlink.vo.StaffNotification;
import cn.net.inlink.vo.UploadStaff;

/**
 * 生成用于下载的excel文件
 * 
 * @author Yz
 * 
 */

public class DownloadNotifice {

	public static void exportStaffNotificeInfo(InputStream input,
			List<StaffNotification> notifices, ServletContext context) {

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
			for (int index = 0; index < notifices.size(); index++) {

				// 从第二行开始写
				row = sheet.getRow(1 + index);
				// 员工编号
				row.createCell(0).setCellValue(
						notifices.get(index).getStaff().getEmpCode());

				// 姓名
				row.createCell(1).setCellValue(
						notifices.get(index).getStaff().getEmpName());

				// 科室
				row.createCell(2)
						.setCellValue(
								notifices.get(index).getStaff().getDept()
										.getDictName());

				// 宿舍楼
				row.createCell(3).setCellValue(
						notifices.get(index).getStaff().getBuildingName());

				// 房间号
				row.createCell(4).setCellValue(
						notifices.get(index).getStaff().getRoomCode());

				// 通报类型
				row.createCell(5).setCellValue(
						StaffValueUtil.getStringValue(notifices.get(index)
								.getNotificeType()));

				// 通报时间
				row.createCell(6).setCellValue(
						StaffValueUtil.getStringValue(notifices.get(index)
								.getNotificeTime()));

				// 通报原因
				row.createCell(7).setCellValue(
						StaffValueUtil.getStringValue(notifices.get(index)
								.getNotificeReason()));

				// 处罚金额
				row.createCell(8).setCellValue(
						StaffValueUtil.getStringValue(notifices.get(index)
								.getNotificeMoney()));

			}

			workbook.setSheetName(0, "人员通报信息");

			// 封装写入的路径
			fos = new FileOutputStream(path + "/excel/人员通报信息.xls");

			fos.flush();

			// 写excel文件
			workbook.write(fos);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
