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

@WebServlet(description = "根据id查询lessee的所有信息", urlPatterns = { "/user/queryLesseeInformationByIdServlet" })
public class QueryLesseeInformationByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LesseeService lesseeService = new LesseeServiceImpl();
		String l_id = request.getParameter("l_id");
		String pageNum = request.getParameter("pageNum");
		HttpSession session = request.getSession();
		String condition = (String) session.getAttribute("condition");
		int id = Integer.parseInt(l_id);
		Lessee lessee = lesseeService.queryLesseeByIdService(id);
		if(lessee==null){
			request.setAttribute("message", "查询出错");
			response.sendRedirect("queryLesseeInformationByConditionServlet?&pageNum="+pageNum+"&condition");
		}else{
			request.setAttribute("lessee", lessee);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("condition", condition);
			request.getRequestDispatcher("editLessee.jsp").forward(request, response);
		}
	}
}
