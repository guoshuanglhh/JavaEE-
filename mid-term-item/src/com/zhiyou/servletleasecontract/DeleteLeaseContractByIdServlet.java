package com.zhiyou.servletleasecontract;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhiyou.service.LeaseContractService;
import com.zhiyou.service.impl.LeaseContractServiceImpl;

@WebServlet(description = "ɾ����ͬ", urlPatterns = { "/user/deleteLeaseContractByIdServlet" })
public class DeleteLeaseContractByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LeaseContractService contractService = new LeaseContractServiceImpl();
		//��ȡ�鿴�����house��h_id,ͨ��id��ѯ
		String lc_id = request.getParameter("lc_id");
		String pageNum = request.getParameter("pageNum");
		pageNum = pageNum==null||"".equals(pageNum)||"null".equals(pageNum)?"0":pageNum;
		String message = contractService.deleteLeaseContractByIdService(Integer.parseInt(lc_id));
		//���ݹ���
		HttpSession session = request.getSession();
		String condition = (String) session.getAttribute("contractCondition");
		request.setAttribute("message", message);
		response.sendRedirect("queryLeaseContractInformationByConditionServlet?pageNum="+pageNum+"&"+condition);
	}
}
