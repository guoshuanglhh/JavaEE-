package com.zhiyou.servletrect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhiyou.service.RectService;
import com.zhiyou.service.impl.RectServiceImpl;

@WebServlet(description = "����idɾ��������Ϣ", urlPatterns = { "/user/deleteRectByIdServlet" })
public class DeleteRectByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RectService lesseeService = new RectServiceImpl();
		//��ȡ�鿴�����house��h_id,ͨ��id��ѯ
		String r_id = request.getParameter("r_id");
		String pageNum = request.getParameter("pageNum");
		pageNum = pageNum==null||"".equals(pageNum)||"null".equals(pageNum)?"0":pageNum;
		String message = lesseeService.deleteRectByIdService(Integer.parseInt(r_id));
		//���ݹ���
		HttpSession session = request.getSession();
		String condition = (String) session.getAttribute("condition2");
		request.setAttribute("message", message);
		response.sendRedirect("queryLesseeInformationByConditionServlet?pageNum="+pageNum+"&"+condition);
	}
}
