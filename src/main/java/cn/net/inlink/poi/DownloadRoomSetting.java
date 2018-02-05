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
import cn.net.inlink.vo.UploadRoom;
import cn.net.inlink.vo.UploadStaff;

/**
 * 生成用于下载的excel文件
 * 
 * @author Yz
 * 
 */

public class DownloadRoomSetting {

	public static void exportRoomSettingInfo(InputStream input,
			List<UploadRoom> wbrooms, List<UploadRoom> jyrooms,
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

			// 获取第二张sheet表头
			HSSFRow row2 = sheet2.getRow(0);

			// 写入数据（闻博轩）
			for (int index = 0; index < wbrooms.size(); index++) {

				// 从第二行开始写
				row1 = sheet1.getRow(1 + index);

				// 宿舍楼
				row1.createCell(0).setCellValue(wbrooms.get(index).getBuildName());
				
				// 房间号
				row1.createCell(1).setCellValue(wbrooms.get(index).getRoomCode());
				
				// 房间人数
				row1.createCell(2).setCellValue(wbrooms.get(index).getSize());
				
				// 实际人数
				row1.createCell(3).setCellValue(wbrooms.get(index).getOccupy());
				
				// 剩余空床号
				row1.createCell(4).setCellValue(StaffValueUtil.getStringValue(wbrooms.get(index).getSurplus()));
				
				// 分类
				row1.createCell(5).setCellValue(StaffValueUtil.getStringValue(wbrooms.get(index).getClassify()));
				
				// 备注1
				row1.createCell(6).setCellValue(StaffValueUtil.getStringValue(wbrooms.get(index).getContent1()));
				
				// 备注2
				row1.createCell(7).setCellValue(StaffValueUtil.getStringValue(wbrooms.get(index).getContent2()));
		
				// 备注3
				row1.createCell(8).setCellValue(StaffValueUtil.getStringValue(wbrooms.get(index).getContent3()));

			}

			// 写入数据（闻博轩）
			for (int index = 0; index < jyrooms.size(); index++) {

				// 从第二行开始写
				row2 = sheet2.getRow(1 + index);
				
				// 宿舍楼
				row2.createCell(0).setCellValue(jyrooms.get(index).getBuildName());
				
				// 房间号
				row2.createCell(1).setCellValue(jyrooms.get(index).getRoomCode());
				
				// 房间人数
				row2.createCell(2).setCellValue(jyrooms.get(index).getSize());
				
				// 实际人数
				row2.createCell(3).setCellValue(jyrooms.get(index).getOccupy());
				
				// 剩余空床号
				row2.createCell(4).setCellValue(StaffValueUtil.getStringValue(jyrooms.get(index).getSurplus()));
				
				// 分类
				row2.createCell(5).setCellValue(StaffValueUtil.getStringValue(jyrooms.get(index).getClassify()));
				
				// 备注1
				row2.createCell(6).setCellValue(StaffValueUtil.getStringValue(jyrooms.get(index).getContent1()));
				
				// 备注2
				row2.createCell(7).setCellValue(StaffValueUtil.getStringValue(jyrooms.get(index).getContent2()));
		
				// 备注3
				row2.createCell(8).setCellValue(StaffValueUtil.getStringValue(jyrooms.get(index).getContent3()));


			}

			workbook.setSheetName(0, "闻博轩");
			workbook.setSheetName(1, "静雅苑");

			// 封装写入的路径
			fos = new FileOutputStream(path + "/excel/宿舍配置信息.xls");

			fos.flush();

			// 写excel文件
			workbook.write(fos);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
