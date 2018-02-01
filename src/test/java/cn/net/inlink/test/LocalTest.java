package cn.net.inlink.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.RowBounds;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.net.inlink.exceptions.UploadException;
import cn.net.inlink.poi.DownloadCheckout;
import cn.net.inlink.service.BlurSearchService;
import cn.net.inlink.service.DormManaService;
import cn.net.inlink.service.StaffManaService;
import cn.net.inlink.service.StaffNotificationService;
import cn.net.inlink.service.UploadStaffService;
import cn.net.inlink.vo.Dictionary;
import cn.net.inlink.vo.RoomGoods;
import cn.net.inlink.vo.StaffNotification;
import cn.net.inlink.vo.UploadStaff;

public class LocalTest {

	private static final String LOCATION = "cn/net/inlink/config/applicationContext.xml";

	public static void main(String[] args) throws IOException, UploadException {

		ApplicationContext ioc = new ClassPathXmlApplicationContext(LOCATION);

		/* UserService service = (UserService) ioc.getBean("userService");

		
		 User user = service.login("rsbadmin");
		 
		 System.out.println(user.toString());*/
		 

		/*
		 * for (Role role : service.getRoles("rsbadmin")) {
		 * System.out.println(role.toString()); }
		 */

		/*
		 * List<User> userList = service.test("rsbadmin");
		 * 
		 * for (User user : userList) {
		 * 
		 * for (Role role : user.getRoleList()) {
		 * System.out.println(role.toString()); } }
		 */

		/*
		 * UserService userservice = (UserService) ioc.getBean("userService");
		 * 
		 * userservice.editPassword(1, "1234");
		 */
		// StaffManaService service = (StaffManaService)
		// ioc.getBean("staffManaService");

		/*
		 * Employee emp = new Employee();
		 * 
		 * emp.setEmpCode("1111"); emp.setEmpName("2222");
		 * 
		 * service.saveEmp(emp);
		 */
		/*
		 * 
		 * //
		 * 
		 * //System.out.println(service.queryIdByBuildName("闻博轩").getId());
		 * 
		 * /*Room room = new Room();
		 * 
		 * room.setRoomCode("1111");
		 * 
		 * service.saveRoom(room);
		 */

		/*
		 * service.saveGoods(1, "1", 2, 8, new SimpleDateFormat().format(new
		 * Date()));
		 */

		/*
		 * UploadStaffData data = new UploadStaffData();
		 * 
		 * FileInputStream fis = new FileInputStream(new
		 * File("C:\\Users\\Yz\\Desktop\\1.xls"));
		 * 
		 * List<UploadStaff> staffs = data.readExcel(fis);
		 * 
		 * for (UploadStaff uploadStaff : staffs) {
		 * System.out.println(uploadStaff
		 * .toString()+"  "+uploadStaff.getLivingDate()); }
		 */

		// PageService service = (PageService) ioc.getBean("pageService");
		/*
		 * RowBounds rb = new RowBounds(10, 10);
		 * 
		 * List<Employee> emps = service.pagingEmp(rb);
		 * 
		 * for (Employee employee : emps) {
		 * System.out.println(employee.toString()); }
		 */

		/*
		 * long count = service.queryCount();
		 * 
		 * System.out.println(count);
		 */

		/*
		 * UploadStaffService service = (UploadStaffService)
		 * ioc.getBean("uploadStaffService");
		 * 
		 * UploadStaff staffs = new UploadStaff();
		 * 
		 * staffs.setEmpCode("1"); staffs.setEmpName("a");
		 * staffs.setGender("男"); staffs.setBuildingName("闻博轩");
		 * staffs.setRoomCode("201"); staffs.setBedNum("1");
		 * staffs.setWardrobeNum("1"); staffs.setDeskNum("1");
		 * staffs.setShopboxNum("1"); staffs.setContent("test");
		 * 
		 * service.saveStaffInfo(staffs);
		 */

		/*
		 * DormManaService service = (DormManaService)
		 * ioc.getBean("dormManaService");
		 * 
		 * RowBounds rb = new RowBounds(0, 10);
		 * 
		 * List<UploadStaff> staffs = service.queryAllStaffs(rb);
		 * 
		 * for (UploadStaff uploadStaff : staffs) {
		 * 
		 * if(uploadStaff.getDept()==null||uploadStaff.getDuty()==null){
		 * 
		 * uploadStaff.setDept(new Dictionary(null, "", ""));
		 * uploadStaff.setDuty(new Dictionary(null, "", ""));
		 * 
		 * }
		 * 
		 * System.out.println(uploadStaff.getDept().getDictName()+"  "+uploadStaff
		 * .getDuty().getDictName());
		 * 
		 * }
		 */

		/*
		 * StaffManaService service = (StaffManaService)
		 * ioc.getBean("staffManaService"); service.saveGoods(3, "2", 514, 520);
		 */

		// DormManaService service = (DormManaService)
		// ioc.getBean("dormManaService");

		// buildName=闻博轩, roomCode=999, size=8, occupy=4, classify=test,
		// content1=test, content2=, content3=
		/*
		 * UploadRoom room = new UploadRoom();
		 * room.setSize(Integer.parseInt("8"));
		 * room.setOccupy(Integer.parseInt("4")); room.setBuildName("闻博轩");
		 * room.setContent1("test"); room.setContent2(""); room.setContent3("");
		 * room.setClassify("test"); room.setRoomCode("999");
		 * 
		 * service.saveRoomset(room);
		 */

		/*
		 * List<UploadStaff> staffs = service.queryEmpRomeSet("静雅苑", "20");
		 * 
		 * System.out.println(staffs==null);
		 * 
		 * System.out.println(service.queryRoomByCode("20", "静雅苑")==null);
		 * 
		 * for (UploadStaff uploadStaff : staffs) {
		 * System.out.println(uploadStaff
		 * .getBedNum()+" "+uploadStaff.getDeskNum()); }
		 */

		// service.editOccupycut("201", "闻博轩");

		/*DormManaService dservice = (DormManaService) ioc
				.getBean("dormManaService");

		StaffBorrowService service = (StaffBorrowService) ioc
				.getBean("staffBorrowService");

		UploadStaff staff = dservice.queryStaffByCode("110001".trim());

		StaffBorrow borrow = new StaffBorrow();

		borrow.setStaff(staff);
		borrow.setObjectName("卡23".trim());
		borrow.setBeginDate( new SimpleDateFormat(
				"yyyy/MM/dd").format(new Date()) 
				);
		borrow.setEndDate("");
		borrow.setContent("未归还");
		borrow.setFlag(0);

		service.saveBorrow(borrow);
		*/
		//dservice.editOccupy("201", "静雅苑");
		
		//service.editBorrowFlag(new SimpleDateFormat("yyyy/MM/dd").format(new Date()), 3);
		
		/*System.out.println(service.queryGiveBackCount());
		System.out.println(service.queryNoGiveBackCount());*/
		
		StaffManaService sservice = (StaffManaService)
				  ioc.getBean("staffManaService");
		
		DormManaService dservice = (DormManaService)
				 ioc.getBean("dormManaService");
		
		StaffNotificationService stservice = (StaffNotificationService) ioc.getBean("staffNotificationService");
		
		UploadStaffService upservice = (UploadStaffService) ioc.getBean("uploadStaffService");
		
		BlurSearchService bservice = (BlurSearchService) ioc.getBean("blurSearchService");
		
		/*StaffNotification notification = new StaffNotification();
		notification.setNotificeMoney("100");
		notification.setNotificeReason("test");
		notification.setNotificeTime(new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
		notification.setNotificeType("test");
		
		UploadStaff staff = dservice.queryStaffByCode("217100615");
		
		notification.setStaff(staff);
		
		stservice.saveNotification(notification);*/
		
		/*List<StaffNotification> no = stservice.queryAllNotifications(new RowBounds(0, 5));
		
		
		for (StaffNotification ss : no) {
			
			System.out.println(ss.toString());
			
		}*/
		
		//System.out.println(stservice.queryAllCounts());
		
	/*	List<StaffNotification> nos = stservice.queryNotificationByCode("217100615");
		
		for (StaffNotification ss : nos) {
			System.out.println(ss.toString());
		}*/
		
		//dservice.staffCheckOut("110001");
		
		/*sservice.editEmpFlag("110001");	
		
		dservice.editOccupycut("201", "静雅苑");*/
		
		
		//System.out.println(dservice.queryRoomByCode("202", "静雅苑").getSize());
		
		//upservice.deleCOStaff("110001");
		
	/*	List<Dictionary> dicts = sservice.queryDict("科室");
		
		System.out.println(dicts.size());
		
		System.out.println(dicts.toString());*/
		
		//System.out.println(dicts.get(0).getDictName());
		/*
		for (Dictionary dict : dicts) {
			
			System.out.println(dict.toString());
		}*/
		
		/*Dictionary dept = new Dictionary();
		
		dept.setDictName("");
		
		Dictionary duty = new Dictionary();
		
		duty.setDictName("");
		
		UploadStaff staff = new UploadStaff();
		
		staff.setDuty(duty);
		staff.setDept(dept);
		staff.setBuildingName("闻博轩");
		staff.setEmpCode("");
		staff.setEmpName("");
		staff.setRoomCode("");
		
		
		List<UploadStaff> staffs = bservice.queryByBlur(staff);
		
		
		
		for (UploadStaff us : staffs) {
			System.out.println(us.toString());
		}*/
		
		/*RoomGoods rd = new RoomGoods();
		
		rd.setBuildName("");
		rd.setRoomCode("238");
		
		UploadStaff staff = new UploadStaff();
		
		Dictionary dict_dept = new Dictionary();
		
		Dictionary dict_duty = new Dictionary();
		
		dict_dept.setDictName("");
		dict_duty.setDictName("");
		
		staff.setDept(dict_dept);
		staff.setDuty(dict_duty);
		
		rd.setStaff(staff);
		
		List<RoomGoods> rds = bservice.queryRoomSutiation(rd);
		
		Map<String , List<RoomGoods>> map = new HashMap<String, List<RoomGoods>>();
		
		List<RoomGoods> rds2 = new ArrayList<RoomGoods>();
		
		
		UploadStaff staff2 = new UploadStaff();
		
		Dictionary dict_dept2 = new Dictionary();
		
		Dictionary dict_duty2 = new Dictionary();
		
		RoomGoods rd2 = new RoomGoods();
		
		for (RoomGoods r : rds) {
			
			dict_dept2.setDictName("");
			dict_duty2.setDictName("");
			staff.setDept(dict_dept2);
			staff.setDuty(dict_duty2);
			
			String roomCode2 = r.getRoomCode();
			
			rd2.setRoomCode(roomCode2);
			rd2.setStaff(staff2);
			rds2  = bservice.queryRoomSutiation(rd2);
			
			map.put(roomCode2, rds2);
			
			//System.out.println(r.toString());
		}
		
		Set<String> keys = map.keySet();
		
		//System.out.println(keys.size());
		
		for (String s : keys) {
			
			System.out.println("房间号："+s);
			
			List<RoomGoods> rr = map.get(s);
			
			
			for (RoomGoods gg : rr) {
				
				
				System.out.println(gg.toString());
				
				System.out.println("=================");
			}
			
			
		}*/
		
		/*List<String> roomCodes = new ArrayList<String>();
		
		List<String> buildNames = new ArrayList<String>();
		
		roomCodes.add("518");
		roomCodes.add("418");
		roomCodes.add("342");
		roomCodes.add("103");
		
		roomCodes.add("330");
		roomCodes.add("330");
		roomCodes.add("334");
		
		buildNames.add("静雅苑");
		
		//List<RoomGoods> sets = bservice.queryRoomSutiationByJY(roomCodes);
		
		List<RoomGoods> sets = bservice.queryRoomSutiationByWB(roomCodes);
		for (RoomGoods roomGoods : sets) {
			System.out.println(roomGoods.toString());
		}*/
		
		/*List<UploadStaff> staffs = dservice.queryAllCheckouts(new RowBounds(0, 5));
		
		System.out.println(dservice.queryCheckoutCounts());
		
		for (UploadStaff uploadStaff : staffs) {
			System.out.println(uploadStaff.toString());
		}*/
		
		/*List<RoomGoods> goods = bservice.queryAllStaffs();
		
		//System.out.println(goods.size());
		
		for (RoomGoods roomGoods : goods) {
			
			System.out.println(roomGoods.toString());
		}*/
		
		/*UploadStaff staff = new UploadStaff();
		Dictionary dict = new Dictionary();*/
		/*dict.setDictName("CSR科");
		staff.setDept(dict);*/
		/*staff.setBuildingName("静雅苑");
		
		List<UploadStaff> staffs = bservice.queryByBlur(staff, new RowBounds(0, 5));
		
		System.out.println(bservice.queryCountByBlur(staff).size());
		*/
		/*for (UploadStaff us : staffs) {
			System.out.println(us.toString());
		}*/
		
		UploadStaff staff = new UploadStaff();
		
		staff.setBeginDate("2017/02/01");
		staff.setEndDate("2017/09/30");
		
		List<UploadStaff> staffs = bservice.queryByBlur(staff, new RowBounds(0, 5));
		
		
		for (UploadStaff us : staffs) {
			System.out.println(us.toString());
		}
	}
}
