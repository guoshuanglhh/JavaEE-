package com.zhiyou.servletrect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.pojo.Rects;
import com.zhiyou.service.RectService;
import com.zhiyou.service.impl.RectServiceImpl;

@WebServlet(description = "添加房租信息", urlPatterns = { "/user/addRectInformationServlet" })
public class AddRectInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RectService rectService = new RectServiceImpl();
		Rects rects = new Rects();
		rects.setH_id(Integer.parseInt(request.getParameter("h_id")));
		rects.setL_id(Integer.parseInt(request.getParameter("l_id")));
		rects.setR_money(Double.parseDouble(request.getParameter("r_money")));
		rects.setR_time(request.getParameter("r_time"));
		rects.setR_remark(request.getParameter("r_remark"));
		String message = rectService.addRectInformationService(rects);
		if("房租信息添加成功".equals(message)){
			response.sendRedirect("queryRectInformationByConditionServlet");
		}else{
			response.sendRedirect("addrect.jsp");
		}
	}
}
