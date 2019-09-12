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

@WebServlet(description = "删除租户信息", urlPatterns = { "/user/deleteLesseeByIdServlet" })
public class DeleteLesseeByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LesseeService lesseeService = new LesseeServiceImpl();
		//获取查看详情的house的h_id,通过id查询
		String l_id = request.getParameter("l_id");
		String pageNum = request.getParameter("pageNum");
		pageNum = pageNum==null||"".equals(pageNum)||"null".equals(pageNum)?"0":pageNum;
		String message = lesseeService.deleteLesseeByIdService(Integer.parseInt(l_id));
		//数据共享
		HttpSession session = request.getSession();
		String condition = (String) session.getAttribute("condition1");
		request.setAttribute("message", message);
		response.sendRedirect("queryLesseeInformationByConditionServlet?pageNum="+pageNum+"&"+condition);
	}
}
