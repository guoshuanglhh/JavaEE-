package com.zhiyou.servletuser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhiyou.pojo.User;
import com.zhiyou.service.UserService;
import com.zhiyou.service.impl.UserServiceImpl;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户输入的账号密码信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//定义封装User对象
		User user = new User();
		user.setU_name(username);
		user.setU_password(password);
		UserService us = new UserServiceImpl();
		boolean isLoginsucess = us.isLoginSuccess(user);
		//添加cookie
		Cookie cookie1 = null;
		Cookie cookie2 = null;
		if(isLoginsucess){//账号密码匹配成功
			//共享user对象
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(900);
			//把账号和密码,以及状态写入客户端
			cookie1 = new Cookie("username", username);
			cookie2 = new Cookie("password", password);
			//设置cookie的实效时间,单位是秒
			cookie1.setMaxAge(2592000);
			cookie2.setMaxAge(2592000);
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			//重定向到管理界面
			response.sendRedirect("user/admin.jsp");
		}else{//账号密码匹配失败
			//重定向到登录界面
			request.getSession().setAttribute("errorMessage", "您输入的账号或密码不正确");
			response.sendRedirect("login.jsp");
		}
	}
}
