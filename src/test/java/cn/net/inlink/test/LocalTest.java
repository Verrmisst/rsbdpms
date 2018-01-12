package cn.net.inlink.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.net.inlink.exceptions.UploadException;
import cn.net.inlink.poi.UploadStaffData;
import cn.net.inlink.service.DormManaService;
import cn.net.inlink.service.PageService;
import cn.net.inlink.service.StaffManaService;
import cn.net.inlink.service.UploadStaffService;
import cn.net.inlink.vo.Dictionary;
import cn.net.inlink.vo.Employee;
import cn.net.inlink.vo.UploadStaff;

public class LocalTest {
	
	private static final String LOCATION = "cn/net/inlink/config/applicationContext.xml";

	public static void main(String[] args) throws IOException, UploadException {
		
		ApplicationContext ioc = new ClassPathXmlApplicationContext(LOCATION);

		//UserService service = (UserService) ioc.getBean("userService");
		
		/*User user = service.login("rsbadmin");
		
		System.out.println(user.toString());*/
		
		
		/*for (Role role : service.getRoles("rsbadmin")) {
			System.out.println(role.toString());
		}*/
		
		/*List<User> userList = service.test("rsbadmin");
		
		for (User user : userList) {
			
			for (Role role : user.getRoleList()) {
				System.out.println(role.toString());
			}
		}*/
		
		
		/*UserService userservice = (UserService) ioc.getBean("userService");
		
		userservice.editPassword(1, "1234");
		
*/	
		//StaffManaService service = (StaffManaService) ioc.getBean("staffManaService");
		
		/*Employee emp = new Employee();
		
		emp.setEmpCode("1111");
		emp.setEmpName("2222");
		
		service.saveEmp(emp);*/
		/*
		
//		
		
		//System.out.println(service.queryIdByBuildName("闻博轩").getId());
	
		/*Room room = new Room();
		
		room.setRoomCode("1111");
		
		service.saveRoom(room);*/
		
		
		
		/*service.saveGoods(1, "1", 2, 8,
				new SimpleDateFormat().format(new Date()));*/
		
		/*UploadStaffData data = new UploadStaffData();
		
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\Yz\\Desktop\\1.xls"));
	
		List<UploadStaff> staffs = data.readExcel(fis);
		
		for (UploadStaff uploadStaff : staffs) {
			System.out.println(uploadStaff.toString()+"  "+uploadStaff.getLivingDate());
		}*/
		
		//PageService service = (PageService) ioc.getBean("pageService");
		/*
		RowBounds rb = new RowBounds(10, 10);
		
		List<Employee> emps = service.pagingEmp(rb);
		
		for (Employee employee : emps) {
			System.out.println(employee.toString());
		}*/
		
		/*long count = service.queryCount();
		
		System.out.println(count);*/
		
		/*UploadStaffService service = (UploadStaffService) ioc.getBean("uploadStaffService");
		
		UploadStaff staffs = new UploadStaff();
		
		staffs.setEmpCode("1");
		staffs.setEmpName("a");
		staffs.setGender("男");
		staffs.setBuildingName("闻博轩");
		staffs.setRoomCode("201");
		staffs.setBedNum("1");
		staffs.setWardrobeNum("1");
		staffs.setDeskNum("1");
		staffs.setShopboxNum("1");
		staffs.setContent("test");
		
		service.saveStaffInfo(staffs);*/
		
		/*DormManaService service = (DormManaService) ioc.getBean("dormManaService");
		
		RowBounds rb = new RowBounds(0, 10);
		
		List<UploadStaff> staffs = service.queryAllStaffs(rb);
		
		for (UploadStaff uploadStaff : staffs) {
			
			if(uploadStaff.getDept()==null||uploadStaff.getDuty()==null){
				
				uploadStaff.setDept(new Dictionary(null, "", ""));
				uploadStaff.setDuty(new Dictionary(null, "", ""));
				
			}
			
			System.out.println(uploadStaff.getDept().getDictName()+"  "+uploadStaff.getDuty().getDictName());
			
		}
		*/
		
		/*StaffManaService service = (StaffManaService) ioc.getBean("staffManaService");
		service.saveGoods(3, "2", 514, 520);*/
		
		DormManaService service = (DormManaService) ioc.getBean("dormManaService");
		
		System.out.println(service.queryRoomByCode("101", "闻博轩").getBuildName());
	}	
		
	
}
