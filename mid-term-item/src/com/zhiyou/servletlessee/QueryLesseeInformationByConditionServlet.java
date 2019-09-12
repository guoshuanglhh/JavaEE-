package com.zhiyou.servletlessee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhiyou.pojo.Lessee;
import com.zhiyou.pojo.Page;
import com.zhiyou.service.LesseeService;
import com.zhiyou.service.impl.LesseeServiceImpl;

@WebServlet(description = "按条件查询租户信息", urlPatterns = { "/user/queryLesseeInformationByConditionServlet" })
public class QueryLesseeInformationByConditionServlet extends HttpServlet {
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
		lessee.setL_id_card(request.getParameter("l_id_card"));
		String pageNum = request.getParameter("pageNum");
		pageNum = pageNum==null||"".equals(pageNum)||"null".equals(pageNum)?"0":pageNum;
		//获取条件
		StringBuilder condition = lesseeService.getCondition(lessee);
		//获取当前页面的page信息
		Page page = lesseeService.getLesseePageinformation(pageNum,lessee);
		//获取搜索条件的一整页的内容
		List<Lessee> lesseeList = lesseeService.lesseePaging(page,lessee);
		//将查询到的结果共享出去
		HttpSession session = request.getSession();
		session.setAttribute("condition", condition.toString());
		request.setAttribute("lesseeList", lesseeList);
		request.setAttribute("page", page);
		request.getRequestDispatcher("lessee.jsp").forward(request, response);
	}
}
