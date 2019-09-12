package com.zhiyou.servletrect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhiyou.pojo.Rects;
import com.zhiyou.service.RectService;
import com.zhiyou.service.impl.RectServiceImpl;

@WebServlet(description = "修改房租信息", urlPatterns = { "/user/editRectInformationServlet" })
public class EditRectInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RectService rectService = new RectServiceImpl();
		//获取当前页码
		String num = request.getParameter("pageNum");
		HttpSession session = request.getSession();
		String condition = (String) session.getAttribute("condition3");
		//实例化rect对象
		Rects rects = new Rects();
		//获取输入的房屋信息
		rects.setR_id(Integer.parseInt(request.getParameter("r_id")));
		rects.setH_id(Integer.parseInt(request.getParameter("h_id")));
		rects.setL_id(Integer.parseInt(request.getParameter("l_id")));
		rects.setR_money(Double.parseDouble(request.getParameter("r_money")));
		rects.setR_time(request.getParameter("r_time"));
		rects.setR_remark(request.getParameter("r_remark"));
		
		String message = rectService.editRectInformationService(rects);
		if("数据更新成功".equals(message)){
			response.sendRedirect("queryRectInformationByConditionServlet?pageNum="+num+"&"+condition);
		}else{
			request.getRequestDispatcher("editRect.jsp").forward(request, response);;
		}
	}
}
