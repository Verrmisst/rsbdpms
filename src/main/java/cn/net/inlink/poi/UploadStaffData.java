package cn.net.inlink.poi;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import cn.net.inlink.exceptions.UploadException;
import cn.net.inlink.utils.CellUtil;
import cn.net.inlink.vo.UploadStaff;

/**
 * 处理总务导入的excel文件
 * 
 * @author Yz
 * 
 */

public class UploadStaffData {

	// 读取导入的excel文件
	public List<UploadStaff> readExcel(FileInputStream fis) throws IOException,
			UploadException {

		// 创建上传数据对象及集合
		List<UploadStaff> staffData = new ArrayList<UploadStaff>();

		// 创建读取文件对象
		POIFSFileSystem poi = new POIFSFileSystem(fis);

		// 创建工作簿对象
		HSSFWorkbook wb = new HSSFWorkbook(poi);

		// 创建sheet对象
		HSSFSheet sheet = wb.getSheetAt(0);

		// 遍历sheet页
		for (int i = 0; i < sheet.getLastRowNum(); i++) {

			// 获取每一行，第二行开始
			HSSFRow row = sheet.getRow(i + 1);

			// 判断row的值是否为null
			if (row != null) {

				// 创建单元格对象
				HSSFCell empCodeCell = row.getCell(0);
				HSSFCell empNameCell = row.getCell(1);
				HSSFCell genderCell = row.getCell(2);
				HSSFCell buildingNameCell = row.getCell(3);
				HSSFCell roomCodeCell = row.getCell(4);
				HSSFCell bedNumCell = row.getCell(5);
				HSSFCell wardrobeNumCell = row.getCell(6);
				HSSFCell deskNumCell = row.getCell(7);
				HSSFCell shopboxNumCell = row.getCell(8);
				HSSFCell livingDateCell = row.getCell(9);
				HSSFCell contentCell = row.getCell(10);

				// 创建员工对象
				UploadStaff staff = new UploadStaff();

				// 给对象注入值
				staff.setEmpCode(CellUtil.getStringCellValue(empCodeCell));
				staff.setEmpName(CellUtil.getStringCellValue(empNameCell));
				staff.setGender(CellUtil.getStringCellValue(genderCell));
				staff.setBuildingName(CellUtil
						.getStringCellValue(buildingNameCell));
				staff.setRoomCode(CellUtil.getStringCellValue(roomCodeCell));
				staff.setBedNum(CellUtil.getStringCellValue(bedNumCell));
				staff.setWardrobeNum(CellUtil
						.getStringCellValue(wardrobeNumCell));
				staff.setDeskNum(CellUtil.getStringCellValue(deskNumCell));
				staff.setShopboxNum(CellUtil.getStringCellValue(shopboxNumCell));
				staff.setLivingDate(CellUtil.getStringCellValue(livingDateCell));
				staff.setContent(CellUtil.getStringCellValue(contentCell));

				// 集合中添加对象
				staffData.add(staff);

			}
		}

		return staffData;

	}
}
