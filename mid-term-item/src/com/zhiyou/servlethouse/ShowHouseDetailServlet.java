package com.zhiyou.servlethouse;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.pojo.House;
import com.zhiyou.service.HouseService;
import com.zhiyou.service.impl.HouseServiceImpl;

@WebServlet(description = "展示房屋详情", urlPatterns = { "/user/showHouseDetailServlet" })
public class ShowHouseDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HouseService houseService = new HouseServiceImpl();
		//获取查看详情的house的h_id,通过id查询
		String h_id = request.getParameter("h_id");
		House house = houseService.queryHouseDetailByIdService(Integer.parseInt(h_id));
		if(house==null){
			request.setAttribute("message", "查询出错");
			response.sendRedirect("queryHouseInformationServlet");
		}else{
			request.setAttribute("house", house);
			request.getRequestDispatcher("detail.jsp").forward(request, response);
		}
	}
}
