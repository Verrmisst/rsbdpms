package cn.net.inlink.interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import cn.net.inlink.controller.PageContentAction;
import cn.net.inlink.entity.User;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 未登录用户的请求拦截
 * 
 * @author Yz
 * 
 */
public class NoLoginInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		//获取session
		Map<String, Object> session = ServletActionContext.getContext().getSession();
		
		User user = (User) session.get("user");
		
		// 如果没有用户登录，则返回到登录页面
		if (user != null) {//通过

			String result  = invocation.invoke();

			return result;
		 }
		
		
		//获取到ActionContext对象
		ActionContext context = invocation.getInvocationContext();
		
		context.put("errormessage", "请先登录！");
		
		return "input";

	}

}
