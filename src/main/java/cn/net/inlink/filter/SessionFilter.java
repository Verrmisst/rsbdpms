package cn.net.inlink.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 过滤器，没有直接访问jsp页面返回到登录页面
 * 
 * @author Yz
 * 
 */
public class SessionFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpServletResponse res = (HttpServletResponse) response;
		
		//获取项目路径
		String url = req.getContextPath();
		
		//获取session对象
		HttpSession session = req.getSession();
		
		//判断用户是否登录
		if (null == session.getAttribute("user")) {
			
			session.setAttribute("info", "请先登录!");
			
			res.sendRedirect(url + "/loginpage");
		}
		
		chain.doFilter(req, res);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
