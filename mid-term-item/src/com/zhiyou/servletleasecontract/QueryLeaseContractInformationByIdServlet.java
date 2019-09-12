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

@WebServlet(description = "通过id查询该合同的所有信息", urlPatterns = { "/user/queryLeaseContractInformationByIdServlet" })
public class QueryLeaseContractInformationByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LeaseContractService contractService = new LeaseContractServiceImpl();
		String lc_id = request.getParameter("lc_id");
		String pageNum = request.getParameter("pageNum");
		HttpSession session = request.getSession();
		String condition = (String) session.getAttribute("condition");
		List<LeaseContract> UserableInforable = contractService.getUseableInformation();
		int id = Integer.parseInt(lc_id);
		LeaseContract contract = contractService.queryLeaseContractByIdService(id);
		if(contract==null){
			request.setAttribute("message", "查询出错");
			response.sendRedirect("queryLeaseContractInformationByConditionServlet?&pageNum="+pageNum+"&condition");
		}else{
			request.setAttribute("contract", contract);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("condition", condition);
			session.setAttribute("UserableInforable", UserableInforable);
			request.getRequestDispatcher("editLeaseContract.jsp").forward(request, response);
		}
	}
}
