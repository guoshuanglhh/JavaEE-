package com.zhiyou.servlethouse;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.pojo.House;
import com.zhiyou.pojo.Page;
import com.zhiyou.service.HouseService;
import com.zhiyou.service.impl.HouseServiceImpl;

@WebServlet(description = "查询房屋信息", urlPatterns = { "/user/queryHouseInformationServlet" })
public class QueryHouseInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HouseService houseService = new HouseServiceImpl();
		//获取jsp页面传来的pagenum值
		String pageNum = request.getParameter("pageNum");
		pageNum = pageNum==null||"".equals(pageNum)||"null".equals(pageNum)?"0":pageNum;
		//获取当前页面的page信息
		Page page = houseService.getHousePageInformation(pageNum);
		//获取一整页的内容
		List<House> houseList = houseService.housePaging(page);
		//将查询到的结果共享出去
		request.setAttribute("houseList", houseList);
		request.setAttribute("page", page);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
}
