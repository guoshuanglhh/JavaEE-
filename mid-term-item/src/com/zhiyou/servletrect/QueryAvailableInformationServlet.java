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
@WebServlet(description = "查询可用信息", urlPatterns = { "/user/queryAvailableInformationServlet" })
public class QueryAvailableInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RectService rectService = new RectServiceImpl();
		HttpSession session = request.getSession();
		List<Rects> notRentHouseId = rectService.getNotRentHouseId();
		session.setAttribute("notRentHouseId", notRentHouseId);
		response.sendRedirect("addrect.jsp");
	}
}
