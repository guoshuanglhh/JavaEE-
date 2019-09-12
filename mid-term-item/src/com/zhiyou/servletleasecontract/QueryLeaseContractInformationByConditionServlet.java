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
import com.zhiyou.pojo.Page;
import com.zhiyou.service.LeaseContractService;
import com.zhiyou.service.impl.LeaseContractServiceImpl;

@WebServlet(description = "条件分页查询", urlPatterns = { "/user/queryLeaseContractInformationByConditionServlet" })
public class QueryLeaseContractInformationByConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LeaseContractService contractService = new LeaseContractServiceImpl();
		LeaseContract contract = new LeaseContract();
		contract.setLc_contract_number(request.getParameter("lc_contract_number"));
		contract.setLc_contract_date(request.getParameter("lc_contract_date"));
		contract.setLc_contract_state(request.getParameter("lc_contract_state"));
		String pageNum = request.getParameter("pageNum");
		pageNum = pageNum==null||"".equals(pageNum)||"null".equals(pageNum)?"0":pageNum;
		//获取条件
		String condition = contractService.getCondition(contract);
		//获取当前页面的page信息
		Page page = contractService.getLeaseContractPageinformation(pageNum, contract);
		//获取搜索条件的一整页的内容
		List<LeaseContract> contractList = contractService.leaseContractPaging(page, contract);
		//将查询到的结果共享出去
		HttpSession session = request.getSession();
		session.setAttribute("condition", condition);
		request.setAttribute("contractList", contractList);
		request.setAttribute("page", page);
		request.getRequestDispatcher("leaseContract.jsp").forward(request, response);
	}
}
