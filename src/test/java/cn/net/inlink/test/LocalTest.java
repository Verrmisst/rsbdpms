package cn.net.inlink.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.net.inlink.entity.Function;
import cn.net.inlink.entity.Role;
import cn.net.inlink.service.RoleService;
import cn.net.inlink.service.UserService;

public class LocalTest {
	
	private static final String LOCATION = "cn/net/inlink/config/applicationContext.xml";

	public static void main(String[] args) {
		
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
		
		
		UserService userservice = (UserService) ioc.getBean("userService");
		
		userservice.editPassword(1, "1234");
	
	}	
		
	
}
