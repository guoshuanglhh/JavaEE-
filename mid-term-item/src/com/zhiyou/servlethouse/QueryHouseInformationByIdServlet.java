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

@WebServlet(description = "通过id查询得到房屋的所有信息", urlPatterns = { "/user/queryHouseInformationByIdServlet" })
public class QueryHouseInformationByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HouseService houseService = new HouseServiceImpl();
		String h_id = request.getParameter("h_id");
		String pageNum = request.getParameter("pageNum");
		int id = Integer.parseInt(h_id);
		House house = houseService.queryHouseDetailByIdService(id);
		if(house==null){
			request.setAttribute("message", "查询出错");
			response.sendRedirect("queryHouseInformationServlet");
		}else{
			request.setAttribute("house", house);
			request.setAttribute("pageNum", pageNum);
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		}
	}
}
