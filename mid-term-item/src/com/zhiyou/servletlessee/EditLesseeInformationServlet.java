package com.zhiyou.servletlessee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhiyou.pojo.Lessee;
import com.zhiyou.service.LesseeService;
import com.zhiyou.service.impl.LesseeServiceImpl;

@WebServlet(description = "修改租户信息", urlPatterns = { "/user/editLesseeInformationServlet" })
public class EditLesseeInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LesseeService lesseeService = new LesseeServiceImpl();
		//获取当前页码
		String num = request.getParameter("pageNum");
		HttpSession session = request.getSession();
		String condition = (String) session.getAttribute("condition2");
		//实例化House对象
		Lessee lessee = new Lessee();
		//获取输入的房屋信息
		lessee.setL_id(Integer.parseInt(request.getParameter("l_id")));
		lessee.setL_name(request.getParameter("l_name"));
		lessee.setL_tel(request.getParameter("l_tel"));
		lessee.setL_sex(request.getParameter("l_sex"));
		lessee.setL_native_place(request.getParameter("l_native_place"));
		lessee.setL_id_card(request.getParameter("l_id_card"));
		lessee.setL_create_time(request.getParameter("l_create_time"));
		String message = lesseeService.editlesseeInformationService(lessee);
		if("数据更新成功".equals(message)){
			response.sendRedirect("queryLesseeInformationByConditionServlet?pageNum="+num+"&"+condition);
		}else{
			request.getRequestDispatcher("editLessee.jsp").forward(request, response);;
		}
	}
}
