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
@WebServlet(description = "编辑房屋信息", urlPatterns = { "/user/editHouseInformationServlet" })
public class EditHouseInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HouseService houseService = new HouseServiceImpl();
		//获取当前页码
		String num = request.getParameter("pageNum");
		//实例化House对象
		House house = new House();
		//获取输入的房屋信息
		house.setH_id(Integer.parseInt(request.getParameter("h_id")));
		house.setH_area(request.getParameter("h_area1"));
		house.setH_estate(request.getParameter("h_estate1"));
		house.setH_unitNumber(request.getParameter("h_unitNumber1"));
		house.setH_floor(Integer.parseInt(request.getParameter("h_floor1")));
		house.setH_roomNo(request.getParameter("h_roomNo1"));
		house.setH_acreage(request.getParameter("h_acreage1"));
		house.setH_direction(request.getParameter("h_direction1"));
		house.setH_fitment(request.getParameter("h_fitment1"));
		house.setH_isDoubleAir(request.getParameter("h_isDoubleAir1"));
		house.setH_limit(Integer.parseInt(request.getParameter("h_limit1")));
		house.setH_facility(request.getParameter("h_facility1"));
		house.setH_price(Double.parseDouble(request.getParameter("h_price1")));
		house.setH_status(request.getParameter("h_status1"));
		house.setH_address(request.getParameter("h_address1"));
		house.setH_updateTime(new Date().toString());	
		int pageNum = houseService.editHouseInformationService(house,Integer.parseInt(num));
		if(pageNum>0){
			request.getRequestDispatcher("queryHouseInformationServlet").forward(request, response);
		}else{
			request.getRequestDispatcher("queryHouseInformationByIdServlet").forward(request, response);
		}
	}
}
