package com.zhiyou.servletrect;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhiyou.pojo.Rects;
import com.zhiyou.service.RectService;
import com.zhiyou.service.impl.RectServiceImpl;

@WebServlet(description = "根据id查询rect所有信息", urlPatterns = { "/user/queryRectInformationByIdServlet" })
public class QueryRectInformationByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RectService rectService = new RectServiceImpl();
		String r_id = request.getParameter("r_id");
		String pageNum = request.getParameter("pageNum");
		HttpSession session = request.getSession();
		String condition = (String) session.getAttribute("condition");
		
		List<Rects> notRentHouseId = rectService.getNotRentHouseId();
		
		int id = Integer.parseInt(r_id);
		Rects rects = rectService.queryRectByIdService(id);
		if(rects==null){
			request.setAttribute("message", "查询出错");
			response.sendRedirect("queryRectInformationByConditionServlet?&pageNum="+pageNum+"&condition");
		}else{
			request.setAttribute("rects", rects);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("condition", condition);
			session.setAttribute("notRentHouseId", notRentHouseId);
			request.getRequestDispatcher("editRect.jsp").forward(request, response);
		}
	}
}
