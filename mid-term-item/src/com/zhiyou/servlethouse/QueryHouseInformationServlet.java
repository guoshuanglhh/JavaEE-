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

@WebServlet(description = "��ѯ������Ϣ", urlPatterns = { "/user/queryHouseInformationServlet" })
public class QueryHouseInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HouseService houseService = new HouseServiceImpl();
		//��ȡjspҳ�洫����pagenumֵ
		String pageNum = request.getParameter("pageNum");
		pageNum = pageNum==null||"".equals(pageNum)||"null".equals(pageNum)?"0":pageNum;
		//��ȡ��ǰҳ���page��Ϣ
		Page page = houseService.getHousePageInformation(pageNum);
		//��ȡһ��ҳ������
		List<House> houseList = houseService.housePaging(page);
		//����ѯ���Ľ�������ȥ
		request.setAttribute("houseList", houseList);
		request.setAttribute("page", page);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
}
