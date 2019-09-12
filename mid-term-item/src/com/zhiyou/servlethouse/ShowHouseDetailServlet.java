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

@WebServlet(description = "չʾ��������", urlPatterns = { "/user/showHouseDetailServlet" })
public class ShowHouseDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HouseService houseService = new HouseServiceImpl();
		//��ȡ�鿴�����house��h_id,ͨ��id��ѯ
		String h_id = request.getParameter("h_id");
		House house = houseService.queryHouseDetailByIdService(Integer.parseInt(h_id));
		if(house==null){
			request.setAttribute("message", "��ѯ����");
			response.sendRedirect("queryHouseInformationServlet");
		}else{
			request.setAttribute("house", house);
			request.getRequestDispatcher("detail.jsp").forward(request, response);
		}
	}
}
