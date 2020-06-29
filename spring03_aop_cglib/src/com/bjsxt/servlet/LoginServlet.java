package com.bjsxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.bjsxt.pojo.Users;
import com.bjsxt.service.UsersService;
import com.bjsxt.service.impl.UsersServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private UsersService usersService;
	@Override
	public void init() throws ServletException {
		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		// spring使用aop时，底层使用动态代理技术，默认是使用JDK动态代理
		// 但是JDK动态代理在将代理对象强转成原始对象时，是不支持的。因此，需要配置spring使用cglib动态代理
		// cglib配置方式：xml配置 <aop:aspectj-autoproxy proxy-target-class="true"></aop:aspectj-autoproxy> 即可
		usersService = wac.getBean("usersService",UsersServiceImpl.class);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Users users = new Users();
		users.setUsername(req.getParameter("username"));
		users.setPassword(req.getParameter("password"));
		Users user = usersService.login(users);
		if(user!=null){
			resp.sendRedirect("main.jsp");
		}else{
			resp.sendRedirect("login.jsp");
		}
	}
}
