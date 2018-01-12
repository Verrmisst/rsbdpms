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
import cn.net.inlink.vo.UploadDeptDuty;
import cn.net.inlink.vo.UploadStaff;

/**
 * 处理人事上传的员工职务和部门的poi
 * 
 * @author Yz
 * 
 */
public class UploadDeptDutyInfo {

	// 读取导入的excel文件
	public List<UploadDeptDuty> readExcel(FileInputStream fis)
			throws IOException, UploadException {

		// 创建上传数据对象及集合
		List<UploadDeptDuty> deptDutyInfo = new ArrayList<UploadDeptDuty>();

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
				// 创建单元格对象，获取单元格值
				HSSFCell empCodeCell = row.getCell(0);
				HSSFCell empNameCell = row.getCell(1);
				HSSFCell deptCell = row.getCell(2);
				HSSFCell dutyCell = row.getCell(3);

				// 创建科室职务信息对象
				UploadDeptDuty deptDuty = new UploadDeptDuty();

				// 给对象注入值
				deptDuty.setEmpCode(CellUtil.getStringCellValue(empCodeCell));
				deptDuty.setEmpName(CellUtil.getStringCellValue(empNameCell));
				deptDuty.setDepart(CellUtil.getStringCellValue(deptCell));
				deptDuty.setDuty(CellUtil.getStringCellValue(dutyCell));

				// 往集合中添加对象
				deptDutyInfo.add(deptDuty);
			}
		}

		return deptDutyInfo;
	}
}
