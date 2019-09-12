package com.zhiyou.servlethouse;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.pojo.House;
import com.zhiyou.service.HouseService;
import com.zhiyou.service.impl.HouseServiceImpl;

@WebServlet(description = "添加房屋信息", urlPatterns = { "/user/addHouseInformationServlet" })
public class AddHouseInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HouseService houseService = new HouseServiceImpl();
		//实例化House对象
		House house = new House();
		//获取输入的房屋信息
		house.setH_area(request.getParameter("h_area"));
		house.setH_estate(request.getParameter("h_estate"));
		house.setH_unitNumber(request.getParameter("h_unitNumber"));
		house.setH_floor(Integer.parseInt(request.getParameter("h_floor")));
		house.setH_roomNo(request.getParameter("h_roomNo"));
		house.setH_acreage(request.getParameter("h_acreage"));
		house.setH_direction(request.getParameter("h_direction"));
		house.setH_fitment(request.getParameter("h_fitment"));
		house.setH_isDoubleAir(request.getParameter("h_isDoubleAir"));
		house.setH_limit(Integer.parseInt(request.getParameter("h_limit")));
		house.setH_facility(request.getParameter("h_facility"));
		house.setH_price(Double.parseDouble(request.getParameter("h_price")));
		house.setH_status(request.getParameter("h_status"));
		house.setH_address(request.getParameter("h_address"));
		house.setH_addtime(new Date().toString());	
		String message = houseService.addHouseInformationService(house);
		if("房屋信息添加成功".equals(message)){
			response.sendRedirect("queryHouseInformationServlet");
		}else{
			response.sendRedirect("add.jsp");
		}
	}
}
