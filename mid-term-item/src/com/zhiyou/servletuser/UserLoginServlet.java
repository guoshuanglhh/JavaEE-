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
		//��ȡ�û�������˺�������Ϣ
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//�����װUser����
		User user = new User();
		user.setU_name(username);
		user.setU_password(password);
		UserService us = new UserServiceImpl();
		boolean isLoginsucess = us.isLoginSuccess(user);
		//���cookie
		Cookie cookie1 = null;
		Cookie cookie2 = null;
		if(isLoginsucess){//�˺�����ƥ��ɹ�
			//����user����
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(900);
			//���˺ź�����,�Լ�״̬д��ͻ���
			cookie1 = new Cookie("username", username);
			cookie2 = new Cookie("password", password);
			//����cookie��ʵЧʱ��,��λ����
			cookie1.setMaxAge(2592000);
			cookie2.setMaxAge(2592000);
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			//�ض��򵽹������
			response.sendRedirect("user/admin.jsp");
		}else{//�˺�����ƥ��ʧ��
			//�ض��򵽵�¼����
			request.getSession().setAttribute("errorMessage", "��������˺Ż����벻��ȷ");
			response.sendRedirect("login.jsp");
		}
	}
}
