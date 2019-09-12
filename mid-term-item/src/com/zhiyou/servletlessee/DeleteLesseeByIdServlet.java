package com.zhiyou.servletlessee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhiyou.service.LesseeService;
import com.zhiyou.service.impl.LesseeServiceImpl;

@WebServlet(description = "ɾ���⻧��Ϣ", urlPatterns = { "/user/deleteLesseeByIdServlet" })
public class DeleteLesseeByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LesseeService lesseeService = new LesseeServiceImpl();
		//��ȡ�鿴�����house��h_id,ͨ��id��ѯ
		String l_id = request.getParameter("l_id");
		String pageNum = request.getParameter("pageNum");
		pageNum = pageNum==null||"".equals(pageNum)||"null".equals(pageNum)?"0":pageNum;
		String message = lesseeService.deleteLesseeByIdService(Integer.parseInt(l_id));
		//���ݹ���
		HttpSession session = request.getSession();
		String condition = (String) session.getAttribute("condition1");
		request.setAttribute("message", message);
		response.sendRedirect("queryLesseeInformationByConditionServlet?pageNum="+pageNum+"&"+condition);
	}
}
