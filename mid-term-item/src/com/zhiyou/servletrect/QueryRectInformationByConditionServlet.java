package com.zhiyou.servletrect;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhiyou.pojo.Page;
import com.zhiyou.pojo.Rects;
import com.zhiyou.service.RectService;
import com.zhiyou.service.impl.RectServiceImpl;

@WebServlet(description = "条件查询分页显示房租信息", urlPatterns = { "/user/queryRectInformationByConditionServlet" })
public class QueryRectInformationByConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RectService rectService = new RectServiceImpl();
		Rects rect = new Rects();
		rect.setL_name(request.getParameter("l_name"));
		rect.setL_tel(request.getParameter("l_tel"));
		rect.setR_time(request.getParameter("r_time"));
		String pageNum = request.getParameter("pageNum");
		pageNum = pageNum==null||"".equals(pageNum)||"null".equals(pageNum)?"0":pageNum;
		//获取条件
		String condition = rectService.getCondition(rect);
		//获取当前页面的page信息
		Page page = rectService.getRectPageinformation(pageNum,rect);
		//获取搜索条件的一整页的内容
		List<Rects> rectList = rectService.RectPaging(page,rect);
		//将查询到的结果共享出去
		HttpSession session = request.getSession();
		session.setAttribute("condition", condition);
		request.setAttribute("rectList", rectList);
		request.setAttribute("page", page);
		request.getRequestDispatcher("rect.jsp").forward(request, response);
	}
}
