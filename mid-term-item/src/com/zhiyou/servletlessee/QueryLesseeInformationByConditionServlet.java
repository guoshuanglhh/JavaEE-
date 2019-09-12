package com.zhiyou.servletlessee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhiyou.pojo.Lessee;
import com.zhiyou.pojo.Page;
import com.zhiyou.service.LesseeService;
import com.zhiyou.service.impl.LesseeServiceImpl;

@WebServlet(description = "��������ѯ�⻧��Ϣ", urlPatterns = { "/user/queryLesseeInformationByConditionServlet" })
public class QueryLesseeInformationByConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LesseeService lesseeService = new LesseeServiceImpl();
		Lessee lessee = new Lessee();
		lessee.setL_name(request.getParameter("l_name"));
		lessee.setL_tel(request.getParameter("l_tel"));
		lessee.setL_sex(request.getParameter("l_sex"));
		lessee.setL_id_card(request.getParameter("l_id_card"));
		String pageNum = request.getParameter("pageNum");
		pageNum = pageNum==null||"".equals(pageNum)||"null".equals(pageNum)?"0":pageNum;
		//��ȡ����
		StringBuilder condition = lesseeService.getCondition(lessee);
		//��ȡ��ǰҳ���page��Ϣ
		Page page = lesseeService.getLesseePageinformation(pageNum,lessee);
		//��ȡ����������һ��ҳ������
		List<Lessee> lesseeList = lesseeService.lesseePaging(page,lessee);
		//����ѯ���Ľ�������ȥ
		HttpSession session = request.getSession();
		session.setAttribute("condition", condition.toString());
		request.setAttribute("lesseeList", lesseeList);
		request.setAttribute("page", page);
		request.getRequestDispatcher("lessee.jsp").forward(request, response);
	}
}
