package com.zhiyou.servletlessee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.pojo.Lessee;
import com.zhiyou.service.LesseeService;
import com.zhiyou.service.impl.LesseeServiceImpl;

@WebServlet(description = "添加租户信息", urlPatterns = { "/user/addLesseeInformationServlet" })
public class AddLesseeInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LesseeService lesseeService = new LesseeServiceImpl();
		Lessee lessee = new Lessee();
		lessee.setL_name(request.getParameter("l_name"));
		lessee.setL_tel(request.getParameter("l_tel"));
		lessee.setL_sex(request.getParameter("l_sex"));
		lessee.setL_native_place(request.getParameter("l_native_place"));
		lessee.setL_id_card(request.getParameter("l_id_card"));
		String message = lesseeService.addLesseeInformationService(lessee);
		if("租户信息添加成功".equals(message)){
			response.sendRedirect("queryLesseeInformationByConditionServlet");
		}else{
			response.sendRedirect("addLessee.jsp");
		}
	}
}
