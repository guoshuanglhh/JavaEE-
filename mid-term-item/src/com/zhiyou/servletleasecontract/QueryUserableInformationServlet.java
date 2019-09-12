package com.zhiyou.servletleasecontract;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhiyou.pojo.LeaseContract;
import com.zhiyou.service.LeaseContractService;
import com.zhiyou.service.impl.LeaseContractServiceImpl;

@WebServlet(description = "查询有用信息", urlPatterns = { "/user/queryUserableInformationServlet" })
public class QueryUserableInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LeaseContractService contractService = new LeaseContractServiceImpl();
		List<LeaseContract> useableInformation = contractService.getUseableInformation();
		HttpSession session = request.getSession();
		session.setAttribute("userableInformation", useableInformation);
		response.sendRedirect("addLeaseContract.jsp");
	}
}
